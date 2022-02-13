package com.github.elenaAeternaNox.itFinlandProject.ui.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.elenaAeternaNox.itFinlandProject.ui.helpers.AllureAttachments;
import com.github.elenaAeternaNox.itFinlandProject.ui.helpers.DriverSettings;
import com.github.elenaAeternaNox.itFinlandProject.ui.pages.MainPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    MainPage mainPage = new MainPage();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }

    @AfterEach
    public void addAttachments() {
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        AllureAttachments.addVideo();
        Selenide.closeWebDriver();
    }
}
