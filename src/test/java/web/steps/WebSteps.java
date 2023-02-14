package web.steps;

import com.bluep.web.Google;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

public class WebSteps {
    private final Google google;
    private final RemoteWebDriver driver;

    public WebSteps() throws IOException {
        this.google = new Google();
        this.driver = this.google.getDriver();
    }

    public RemoteWebDriver getDriver() {
        return driver;
    }

    public void openGoogle() {
        google.open();
    }
}
