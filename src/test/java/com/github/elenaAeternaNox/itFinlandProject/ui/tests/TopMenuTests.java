package com.github.elenaAeternaNox.itFinlandProject.ui.tests;

import annotations.Layer;
import annotations.Microservice;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Owner("ekomarova")
@Story("ItFinland")
@Tags({@Tag("all_tests"), @Tag("top_menu")})
@Feature("MAIN_PAGE_NAVIGATION")
public class TopMenuTests extends TestBase {

    private SelenideElement contactUsSection = $(".t525__container");

    @Microservice("For companies")
    @Test
    @DisplayName("Check the 'For companies' item")
    void checkForCompaniesItem() {
        itFinlandSteps.openMainPage();
        checkItemExists("For companies").$(byText("For companies")).click();

        step("Check: the 'Contact Us' section is displayed", () ->
                contactUsSection.shouldBe(visible)
        );

        step("Check: the the 'Contact Us' section contains 'Looking for IT employee, please contact' on the first place", () ->
                contactUsSection.$$(".t525__col").first().shouldHave(text("Looking for IT employee, please contact"))
        );
    }

    @Microservice("For IT professionals")
    @Test
    @DisplayName("Check the 'For IT professionals' item")
    void checkForItProfessionalsItem() {
        itFinlandSteps.openMainPage();
        checkItemExists("For companies").$(byText("For IT professionals")).click();

        step("Check: the 'Contact Us' section is displayed", () ->
                contactUsSection.shouldBe(visible)
        );

        step("Check: the the 'Contact Us' section contains 'Looking for IT employee, please contact' on the first place", () ->
                contactUsSection.$$(".t525__col").findBy(text("Looking for IT job opportunities in Finland, please contact"))
        );
    }

    @Microservice("Contact us")
    @Test
    @DisplayName("Check the 'Contact us' item")
    void checkContactUsItem() {
        itFinlandSteps.openMainPage();
        checkItemExists("For companies").$(byText("Contact us")).click();

        step("Check: the 'Contact Us' title is displayed", () ->
                $$(".t-section__title").findBy(text("CONTACT US")).shouldBe(visible)
        );
    }

    @DisplayName("Check: the {item} exists")
    private SelenideElement checkItemExists(String itemName) {
        ElementsCollection topMenuList = $(".t446__maincontainer").$$(".t446__list");

        SelenideElement item = topMenuList.findBy(text(itemName));
        item.shouldBe(visible);
        return item;
    }
}