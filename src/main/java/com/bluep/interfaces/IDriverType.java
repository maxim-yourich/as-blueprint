package com.bluep.interfaces;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@FunctionalInterface
public interface IDriverType {
    RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities);
}
