package com.bluep.bricks.managers;

import com.bluep.bricks.constants.DriverType;
import com.bluep.bricks.interfaces.ISeleniumExecution;
import com.bluep.config.ConfigSelenium;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;

import static com.bluep.config.ConfigManager.getSeleniumConfiguration;

public class SeleniumManager {
    private static ConfigSelenium configSelenium;

    private static DriverType getDriverType() {
        DriverType driverType = DriverType.CHROME;
        configSelenium = getSeleniumConfiguration();
        String browser = configSelenium.browser().toUpperCase();

        try {
            driverType = DriverType.valueOf(browser);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Unknown driver specified, defaulting to '" + driverType + "'...");
        } catch (NullPointerException ignored) {
            System.err.println("No driver specified, defaulting to '" + driverType + "'...");
        }

        return driverType;
    }

    public static RemoteWebDriver getDriver() throws IOException {
        DriverType driverType = getDriverType();

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        boolean useRemoteWebDriver = Boolean.parseBoolean(configSelenium.remote());

        if (useRemoteWebDriver) {
            URL seleniumGridURL = new URL(configSelenium.seleniumGridURL());
            String desiredBrowserVersion = configSelenium.browserVersion();
            String desiredPlatform = configSelenium.platform();

            if (null != desiredPlatform && !desiredPlatform.isEmpty()) {
                desiredCapabilities.setPlatform(Platform.valueOf(desiredPlatform.toUpperCase()));
            }

            if (null != desiredBrowserVersion && !desiredBrowserVersion.isEmpty()) {
                desiredCapabilities.setVersion(desiredBrowserVersion);
            }

            desiredCapabilities.setBrowserName(driverType.toString());
            return new RemoteWebDriver(seleniumGridURL, desiredCapabilities);
        } else {
            boolean headless = Boolean.parseBoolean(configSelenium.headless());

            desiredCapabilities.setCapability("headless", headless);
            System.out.println("Selected Browser: " + driverType + ", headless mode? " + headless);

            return driverType.getWebDriverObject(desiredCapabilities);
        }
    }

    public static void seleniumExecution(ISeleniumExecution execution, RemoteWebDriver driver) {
        try {
            execution.execute();
        } finally {
            driver.quit();
        }
    }
}
