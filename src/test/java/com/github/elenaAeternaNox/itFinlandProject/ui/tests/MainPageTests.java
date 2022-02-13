package com.github.elenaAeternaNox.itFinlandProject.ui.tests;

import annotations.Layer;
import annotations.Microservice;
import com.github.elenaAeternaNox.itFinlandProject.ui.helpers.DriverUtils;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Layer("web")
@Owner("ekomarova")
@Story("ItFinland")
@Tags({@Tag("all_tests"), @Tag("main_page")})
@Feature("MAIN_PAGE_COMMON")
public class MainPageTests extends TestBase {

    @Microservice("Main page title")
    @Test
    @DisplayName("Page title should have header 'ITFinland'")
    void titleTest() {
        mainPage.openMainPage();

        step("Page title should have text 'IT Finland'", () -> {
            String expectedTitle = "IT Finland";
            String actualTitle = title();

            assertEquals(expectedTitle, actualTitle);
        });
    }

    @Microservice("Main page")
    @Test
    @DisplayName("Check Main page is displayed")
    void checkMainPageIsDisplayed() {
        mainPage.openMainPage();

        step("Check: top menu contains title 'NERDSBAY'", () -> {
                    mainPage
                            .checkTopMenuIsVisible()
                            .checkLogoTitleHasText("NERDSBAY");
                }
        );
    }

    @Microservice("Top menu")
    @Test
    @DisplayName("Check the top menu contains 3 items")
    void checkTopMenuContains3Items() {
        mainPage.openMainPage();

        step("Check the top menu contains 3 items", () -> {
                    int topMenuActualSize = mainPage.getTopMenuItemsListSize();
                    int topMenuExpectedSize = 2;

                    assertEquals(topMenuExpectedSize, topMenuActualSize);
                }
        );
    }

    @Microservice("Main page")
    @Feature("MAIN_PAGE_NAVIGATION")
    @Test
    @DisplayName("Check the button for opening the Application form")
    void checkApplicationFormButton() {
        mainPage.openMainPage();

        step("Check the button for opening the Application form exists on the page", () -> {
                    mainPage
                            .scrollToOpenApplicationButton()
                            .checkRegistrationButton();
                }
        );

        step("Check the button opens the registration form", () -> {
                    String expectedTitle = "Job application";

                    mainPage.clickRegistrationButton();
                    switchTo().window(1);

                    String actualTitle = title();

                    assertEquals(expectedTitle, actualTitle);
                }
        );
    }

    @Microservice("Main page errors")
    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        mainPage.openMainPage();

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}