import api.steps.ApiSteps;
import api.steps.ApiStepsParamResolver;
import com.bluep.DevFeature;
import com.bluep.managers.FileManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import web.steps.WebSteps;
import web.steps.WebStepsParamResolver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import static com.bluep.constants.FileLocations.POKEMON_LIST_EXPECTED_RESULT_FILE;
import static com.bluep.managers.SeleniumManager.seleniumExecution;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(ApiStepsParamResolver.class)
@ExtendWith(WebStepsParamResolver.class)
public class AllTests extends BaseTest {
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

    @ParameterizedTest
    @CsvFileSource(resources = "data/common/dev-feature-data.csv", numLinesToSkip = 1)
    @DisplayName("Dev Feature Test")
    public void devFeatureTest(String testID, String expectedResult) {
        DevFeature devFeature = new DevFeature();
        assertEquals(expectedResult, devFeature.getStr());
    }

    @Test
    @DisplayName("PokeAPI Test")
    public void apiPokemonListTest(ApiSteps apiSteps) throws IOException {
        String actualJSON = apiSteps.getPokes();

        String expectedJSON = FileManager.readFile(POKEMON_LIST_EXPECTED_RESULT_FILE, StandardCharsets.UTF_8);
        expectedJSON = expectedJSON.replaceAll("\\s", "");

        assumeTrue(actualJSON != null, "Response code is not 200");
        assertEquals(expectedJSON, actualJSON);
    }

    @Test
    @DisplayName("PokeAPI Speed Test")
    public void apiPokemonSpeedTest(ApiSteps apiSteps) {
        assertTimeout(Duration.ofSeconds(1), apiSteps::getPokes);
    }

    @Disabled
    @Test
    @DisplayName("Disabled Test")
    void disabledTest() {
        assertTrue(true);
    }

    @Test
    @DisplayName("Failed Test")
    void failedTest() {
        fail();
    }

    @Nested
    class NestedTests {
        @Test
        @DisplayName("Nested Test")
        public void nestedTest() {
            assertTrue(true);
        }
    }
}
