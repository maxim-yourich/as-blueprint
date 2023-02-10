import com.bluep.config.ConfigManager;
import com.bluep.config.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Map;

import static com.bluep.lib.GlobalLogger.logInfo;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class BaseTest {
    static Configuration pokeAPI;

    @BeforeAll
    public static void beforeAllTests() {
        pokeAPI = ConfigManager.getConfiguration();

        baseURI = pokeAPI.baseURI();
        basePath = pokeAPI.basePath();

        Map<String, String> envMap = System.getenv();

        for (String envName : envMap.keySet()) {
            System.out.format("%s = %s%n", envName, envMap.get(envName));
        }
    }

    @BeforeEach
    public void beforeTest() {
        logInfo("hi ma");
    }
}
