import com.bluep.bricks.constants.Env;
import com.bluep.bricks.managers.TestResultCollector;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.util.Map;

import static com.bluep.lib.GLogger.logInfo;

@ExtendWith(TestResultCollector.class)
public class BaseTest {
    @BeforeAll
    public static void beforeAllTests() throws IOException {
        Map<String, String> envMap = System.getenv();

        for (String envName : envMap.keySet()) {
            if (envName.equals("JENKINS_HOME")) {
                Env.IS_JENKINS_ENV = true;
                break;
            }
        }
    }

    @AfterEach
    public void afterTest() {
        logInfo("bye ma");
    }
}
