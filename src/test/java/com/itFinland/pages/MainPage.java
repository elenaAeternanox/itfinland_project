package com.itFinland.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.itFinland.config.ProjectConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    ProjectConfig credentials = ConfigFactory.create(ProjectConfig.class);

    private SelenideElement
            topMenu = $(".t446__maincontainer"),
            logoTitleText = topMenu.$(".t446__logo"),
            bottomWrapper = $(".t-section__bottomwrapper"),
            button = bottomWrapper.$(".t-btn"),
            contactUsSection = $(".t525__container");

    private ElementsCollection
            topMenuList = topMenu.$$(".t446__list"),
            contactUsSectionItemsList = contactUsSection.$$(".t525__col"),
            topMenuSectionItems = $$(".t-section__title");

    @Step("Open main page")
    public MainPage openPage() {
        open(credentials.mainUrl());
        return this;
    }

    @Step("Check top menu is visible")
    public MainPage checkTopMenuIsVisible() {
        topMenu.shouldBe(visible);
        return this;
    }

    @Step("Get top menu items list size")
    public Integer getTopMenuItemsListSize() {
        return topMenuList.size();
    }

    @Step("Check top logo title should have {text}")
    public MainPage checkLogoTitleHasText(String text) {
        logoTitleText.shouldHave(text(text));
        return this;
    }

    @Step("Scroll to the registration button")
    public MainPage scrollToOpenApplicationButton() {
        bottomWrapper.scrollIntoView(true);
        return this;
    }

    @Step("Check registration button")
    public MainPage checkRegistrationButton() {
        button.shouldBe(visible);
        button.shouldHave(href("/registration"));
        return this;
    }

    @Step("Click registration button")
    public MainPage clickRegistrationButton() {
        button.click();
        return this;
    }

    @Step("Click the {item}")
    public MainPage clickTopMenuItem(String items, String item) {
        SelenideElement itemList = topMenuList.findBy(text(items));
        itemList.shouldBe(visible);
        itemList.$(byText(item)).click();
        return this;
    }

    @Step("Check Contact Us section is displayed")
    public MainPage checkContactUsSectionIsDisplayed() {
        contactUsSection.shouldBe(visible);
        return this;
    }

    @Step("Check: the 'Contact Us' title is displayed")
    public MainPage checkContactUsTitleIsDisplayed() {
        topMenuSectionItems.findBy(text("CONTACT US")).shouldBe(visible);
        return this;
    }

    @Step("Check Contact Us section firstly has {text}")
    public MainPage checkContactUsSectionHasTextOnFirstPlace(String text) {
        contactUsSectionItemsList.first().shouldHave(text(text));
        return this;
    }

    @Step("Check Contact Us section has {text}")
    public MainPage checkContactUsSectionHasText(String text) {
        contactUsSectionItemsList.findBy(text(text));
        return this;
    }
}
