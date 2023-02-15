import com.bluep.mock.MockDevFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class UnitTests extends BaseTest {
    @ParameterizedTest
    @CsvFileSource(resources = "data/common/dev-feature-data.csv", numLinesToSkip = 1)
    @DisplayName("Dev Feature Test")
    public void devFeatureTest(String testID, String expectedResult) {
        MockDevFeature mockDevFeature = new MockDevFeature();
        assertEquals(expectedResult, mockDevFeature.getStr());
    }
}
