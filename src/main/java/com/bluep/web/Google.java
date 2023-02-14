package com.bluep.web;

import com.bluep.managers.SeleniumManager;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

public class Google {
    private final RemoteWebDriver driver;

    public Google() throws IOException {
        this.driver = SeleniumManager.getDriver();
    }

    public RemoteWebDriver getDriver() {
        return this.driver;
    }

    public void open() {
        this.driver.get("https://google.com");
    }
}
