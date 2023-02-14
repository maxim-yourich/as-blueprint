import com.bluep.web.steps.WebSteps;
import com.bluep.web.steps.WebStepsParamResolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static com.bluep.managers.SeleniumManager.seleniumExecution;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(WebStepsParamResolver.class)
public class WebTests extends BaseTest {
    @Test
    @DisplayName("Selenium Test")
    public void seleniumTest(WebSteps webSteps) {
        seleniumExecution(
                () -> {
                    webSteps.openGoogle();
                    assertEquals("https://www.google.com/", webSteps.getDriver().getCurrentUrl());
                },
                webSteps.getDriver()
        );
    }

    @Test
    @DisplayName("Selenium Test 2")
    public void seleniumTest2(WebSteps webSteps) {
        seleniumExecution(
                () -> {
                    webSteps.openGoogle();
                    assertEquals("https://www.bing.com/", webSteps.getDriver().getCurrentUrl());
                },
                webSteps.getDriver()
        );
    }
}
