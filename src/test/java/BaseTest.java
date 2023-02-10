import com.bluep.config.ConfigManager;
import com.bluep.config.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class BaseTest {
    static Configuration pokeAPI;

    @BeforeAll
    public static void beforeAllTests() {
        pokeAPI = ConfigManager.getConfiguration();

        baseURI = pokeAPI.baseURI();
        basePath = pokeAPI.basePath();
    }
}
