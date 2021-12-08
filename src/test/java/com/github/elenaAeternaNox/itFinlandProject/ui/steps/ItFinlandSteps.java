package com.github.elenaAeternaNox.itFinlandProject.ui.steps;

import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.open;

public class ItFinlandSteps {

    @DisplayName("Open main page")
    public ItFinlandSteps openManePage() {
        open("https://itfinland.com/");
        return this;
    }
}
