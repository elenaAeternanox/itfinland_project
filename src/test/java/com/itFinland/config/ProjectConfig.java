package com.itFinland.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${environment}.properties"
})
public interface ProjectConfig extends Config {
    String login();

    String password();

    String environment();

    String mainUrl();

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("91.0")
    String browserVersion();

    @DefaultValue("1920x1080")
    String browserSize();

    String browserMobileView();

    String URL();

    String videoStorage();
}
