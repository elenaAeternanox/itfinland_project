package com.itFinland.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.itFinland.config.ProjectConfig;
import com.itFinland.helpers.AllureAttachments;
import com.itFinland.helpers.DriverSettings;
import com.itFinland.pages.MainPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static java.lang.String.format;

public class TestBase {

    MainPage mainPage = new MainPage();
    private static ProjectConfig credentials = ConfigFactory.create(ProjectConfig.class);

    private static String login = credentials.login(),
            environment = credentials.environment(),
            message = format("The build is run on %s. You are login as %s.", environment, login);

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();

        System.out.println(message);
        System.out.println("Build includes tests with tag '" + System.getProperty("tag") + "'");
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
