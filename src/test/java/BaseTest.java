import com.bluep.config.ConfigManager;
import com.bluep.config.Configuration;
import com.bluep.constants.Env;
import com.bluep.lib.TestResultCollector;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

import static com.bluep.lib.GLog.logInfo;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

@ExtendWith(TestResultCollector.class)
public class BaseTest {
    static Configuration pokeAPI;

    @BeforeAll
    public static void beforeAllTests() {
        pokeAPI = ConfigManager.getConfiguration();

        baseURI = pokeAPI.baseURI();
        basePath = pokeAPI.basePath();

        Map<String, String> envMap = System.getenv();

        for (String envName : envMap.keySet()) {
            if (envName.equals("JENKINS_HOME")) {
                Env.isJenkinsEnv = true;
                break;
            }
        }
    }

    @AfterEach
    public void afterTest() {
        logInfo("bye ma");
    }
}
