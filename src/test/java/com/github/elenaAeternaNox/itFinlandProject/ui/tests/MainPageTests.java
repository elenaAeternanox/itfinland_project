package com.github.elenaAeternaNox.itFinlandProject.ui.tests;

import com.github.elenaAeternaNox.itFinlandProject.ui.helpers.DriverUtils;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Tags({@Tag("all_tests"), @Tag("main_page")})
@Feature("MAIN_PAGE_COMMON")
public class MainPageTests extends TestBase {

    private SelenideElement topMenu = $(".t446__maincontainer");

    @Test
    @DisplayName("Page title should have header 'ITFinland'")
    void titleTest() {
        itFinlandSteps.openManePage();

        step("Page title should have text 'IT Finland'", () -> {
            String expectedTitle = "IT Finland";
            String actualTitle = title();

            assertEquals(expectedTitle, actualTitle);
        });
    }

    @Test
    @DisplayName("Check Main page is displayed")
    void checkMainPageIsDisplayed() {
        itFinlandSteps.openManePage();

        step("Check: top menu contains title 'NERDSBAY'", () -> {
                    topMenu.shouldBe(visible);
                    topMenu.$(".t446__logo").shouldHave(text("NERDSBAY"));
                }
        );
    }

    @Test
    @DisplayName("Check the top menu contains 3 items")
    void checkTopMenuContains3Items() {
        itFinlandSteps.openManePage();

        step("Check the top menu contains 3 items", () -> {
                    int topMenuActualSize = topMenu.$$(".t446__list").size();
                    int topMenuExpectedSize = 2;

                    assertEquals(topMenuExpectedSize, topMenuActualSize);
                }
        );
    }

    @Feature("MAIN_PAGE_NAVIGATION")
    @Test
    @DisplayName("Check the button for opening the Application form")
    void checkApplicationFormButton() {
        SelenideElement bottomWrapper = $(".t-section__bottomwrapper");
        SelenideElement button = bottomWrapper.$(".t-btn");

        itFinlandSteps.openManePage();

        step("Check the button for opening the Application form exists on the page", () -> {
                    bottomWrapper.scrollIntoView(true);
                    button.shouldBe(visible);
                    button.shouldHave(href("/registration"));
                }
        );

        step("Check the button opens the registration form", () -> {
                    String expectedTitle = "Job application";

                    button.click();
                    switchTo().window(1);

                    String actualTitle = title();

                    assertEquals(expectedTitle, actualTitle);
                }
        );
    }

    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        itFinlandSteps.openManePage();

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}