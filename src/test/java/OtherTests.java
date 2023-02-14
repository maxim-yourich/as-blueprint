import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class OtherTests extends BaseTest {
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
