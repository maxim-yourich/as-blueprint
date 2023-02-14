package com.bluep.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:selenium.properties"})
public interface ConfigSelenium extends Config {

    @Key("browser")
    String browser();

    @Key("headless")
    String headless();

    @Key("remote")
    String remote();

    @Key("seleniumGridURL")
    String seleniumGridURL();

    @Key("platform")
    String platform();

    @Key("browserVersion")
    String browserVersion();
}
