import com.bluep.api.steps.ApiSteps;
import com.bluep.api.steps.ApiStepsParamResolver;
import com.bluep.managers.FileManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import static com.bluep.constants.FileLocations.POKEMON_LIST_EXPECTED_RESULT_FILE_LOCATION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(ApiStepsParamResolver.class)
public class ApiTests extends BaseTest {
    @Test
    @DisplayName("PokeAPI Test")
    public void apiPokemonListTest(ApiSteps apiSteps) throws IOException {
        String actualJSON = apiSteps.getPokes();

        String expectedJSON = FileManager.readFile(POKEMON_LIST_EXPECTED_RESULT_FILE_LOCATION, StandardCharsets.UTF_8);
        expectedJSON = expectedJSON.replaceAll("\\s", "");

        assumeTrue(actualJSON != null, "Response code is not 200");
        assertEquals(expectedJSON, actualJSON);
    }

    @Test
    @DisplayName("PokeAPI Speed Test")
    public void apiPokemonSpeedTest(ApiSteps apiSteps) {
        assertTimeout(Duration.ofSeconds(1), apiSteps::getPokes);
    }
}
