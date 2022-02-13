package com.github.elenaAeternaNox.itFinlandProject.ui.tests;

import annotations.Layer;
import annotations.Microservice;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Layer("web")
@Owner("ekomarova")
@Story("ItFinland")
@Tags({@Tag("all_tests"), @Tag("top_menu")})
@Feature("MAIN_PAGE_NAVIGATION")
public class TopMenuTests extends TestBase {

    private static String
            forCompanies = "For companies",
            forItProfessionals = "For IT professionals",
            contactUs = "Contact us";

    @Microservice("For companies")
    @Test
    @DisplayName("Check the 'For companies' item")
    void checkForCompaniesItem() {
        mainPage.openMainPage()
                .clickTopMenuItem(forCompanies, forCompanies)
                .checkContactUsSectionIsDisplayed()
                .checkContactUsSectionHasTextOnFirstPlace("Looking for IT employee, please contact");
    }

    @Microservice("For IT professionals")
    @Test
    @DisplayName("Check the 'For IT professionals' item")
    void checkForItProfessionalsItem() {
        mainPage.openMainPage()
                .clickTopMenuItem(forCompanies, forItProfessionals)
                .checkContactUsSectionIsDisplayed()
                .checkContactUsSectionHasText("Looking for IT job opportunities in Finland, please contact");
    }

    @Microservice("Contact us")
    @Test
    @DisplayName("Check the 'Contact us' item")
    void checkContactUsItem() {
        mainPage.openMainPage()
                .clickTopMenuItem(forCompanies, contactUs)
                .checkContactUsSectionIsDisplayed()
                .checkContactUsTitleIsDisplayed();
    }
}