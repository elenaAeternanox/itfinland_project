package com.itFinland.tests;

import com.itFinland.annotations.Layer;
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

    @Test
    @DisplayName("Check the 'For companies' item")
    void checkForCompaniesItem() {
        mainPage.openPage()
                .clickTopMenuItem(forCompanies, forCompanies)
                .checkContactUsSectionIsDisplayed()
                .checkContactUsSectionHasTextOnFirstPlace("Looking for IT employee, please contact");
    }

    @Test
    @DisplayName("Check the 'For IT professionals' item")
    void checkForItProfessionalsItem() {
        mainPage.openPage()
                .clickTopMenuItem(forCompanies, forItProfessionals)
                .checkContactUsSectionIsDisplayed()
                .checkContactUsSectionHasText("Looking for IT job opportunities in Finland, please contact");
    }

    @Test
    @DisplayName("Check the 'Contact us' item")
    void checkContactUsItem() {
        mainPage.openPage()
                .clickTopMenuItem(forCompanies, contactUs)
                .checkContactUsSectionIsDisplayed()
                .checkContactUsTitleIsDisplayed();
    }
}