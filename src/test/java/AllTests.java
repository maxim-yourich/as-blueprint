import com.bluep.Function;
import com.bluep.managers.FileManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static com.bluep.constants.FileLocations.POKEMON_LIST_EXPECTED_RESULT_FILE;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class AllTests extends BaseTest {
    Function function = new Function();

    @Test
    public void functionTest() {
        assertEquals("hi ma", function.getStr());
    }

    @Test
    public void apiPokemonListTest() throws IOException {
        String expectedJSON = FileManager.readFile(POKEMON_LIST_EXPECTED_RESULT_FILE, StandardCharsets.UTF_8);
        expectedJSON = expectedJSON.replaceAll("\\s", "");
        HashMap<String, String> queryParams = new HashMap<String, String>() {{
            put("limit", "2");
            put("offset", "0");
        }};

        String actualJSON = given().queryParams(queryParams).when().get(pokeAPI.pokemonList()).asString();
        assertEquals(expectedJSON, actualJSON);
    }

    @Disabled
    @Test
    void disabledTest() {
        assertTrue(true);
    }

    @Test
    void failedTest() {
        fail();
    }
}
