import com.bluep.constants.Env;
import com.bluep.lib.TestResultCollector;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.util.Map;

import static com.bluep.lib.GLog.logInfo;

@ExtendWith(TestResultCollector.class)
public class BaseTest {
    @BeforeAll
    public static void beforeAllTests() throws IOException {
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
