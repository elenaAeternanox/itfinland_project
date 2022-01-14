package com.github.elenaAeternaNox.itFinlandProject.ui.tests;

import annotations.Layer;
import annotations.Microservice;
import com.github.elenaAeternaNox.itFinlandProject.ui.config.ProjectConfig;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

@Layer("web")
@Owner("ekomarova")
@Story("ItFinland")
@Feature("Environment info")
@Tags({@Tag("all_tests"), @Tag("top_menu"), @Tag("main_page")})
public class EnvironmentTest {

    public ProjectConfig credentials = ConfigFactory.create(ProjectConfig.class);

    @Microservice("Environment")
    @Test
    void environmentTest() {
        String login = credentials.login();
        String password = credentials.password();
        String environment = credentials.environment();

        String message = format("The build is run on %s. You are login as %s with password %s", environment, login, password);
        System.out.println(message);

        step("Print info about environment", () -> {
        switch (System.getProperty("tag")) {
            case "all_tests":
                System.out.println("Build includes all tests in the project");
                break;
            case "main_page":
                System.out.println("Build includes only smoke tests for Main page");
                break;
            case "top_menu":
                System.out.println("Build includes only tests for top menu items");
                break;
            default:
                System.out.println("No one existed test suite was chosen");
        }
        });
    }
}
