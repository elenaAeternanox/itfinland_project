package com.github.elenaAeternaNox.itFinlandProject.ui.tests;

import com.github.elenaAeternaNox.itFinlandProject.ui.steps.ItFinlandSteps;
import com.github.elenaAeternaNox.itFinlandProject.ui.config.Project;
import com.github.elenaAeternaNox.itFinlandProject.ui.helpers.AllureAttachments;
import com.github.elenaAeternaNox.itFinlandProject.ui.helpers.DriverSettings;
import com.github.elenaAeternaNox.itFinlandProject.ui.helpers.DriverUtils;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    ItFinlandSteps itFinlandSteps = new ItFinlandSteps();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}
