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

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import static com.bluep.constants.FileLocations.POKEMON_LIST_EXPECTED_RESULT_FILE;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(AllStepsParamResolver.class)
public class AllTests extends BaseTest {
    //    Dev features
    DevFeature devFeature = new DevFeature();

    @ParameterizedTest
    @CsvFileSource(resources = "data/common/dev-feature-data.csv", numLinesToSkip = 1)
    @DisplayName("Dev Feature Test")
    public void devFeatureTest(String testID, String expectedResult) {
        assertEquals(expectedResult, devFeature.getStr());
    }

    @Test
    @DisplayName("PokeAPI Test")
    public void apiPokemonListTest(AllSteps allSteps) throws IOException {
        String actualJSON = allSteps.getPokes();

        String expectedJSON = FileManager.readFile(POKEMON_LIST_EXPECTED_RESULT_FILE, StandardCharsets.UTF_8);
        expectedJSON = expectedJSON.replaceAll("\\s", "");

        assumeTrue(actualJSON != null, "Response code is not 200");
        assertEquals(expectedJSON, actualJSON);
    }

    @Test
    @DisplayName("PokeAPI Speed Test")
    public void apiPokemonSpeedTest(AllSteps allSteps) {
        assertTimeout(Duration.ofSeconds(1), allSteps::getPokes);
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
