package com.bluep.bricks.managers;

import com.bluep.lib.GLogger;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestResultCollector implements TestWatcher, AfterAllCallback {
    private final ArrayList<TestResultStatus> testResultsStatus = new ArrayList<>();

    private enum TestResultStatus {
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        GLogger.logFormatInfo("Test Disabled. Test name - %s. Reason - %s.", context.getDisplayName(), reason.orElse("No reason"));
        testResultsStatus.add(TestResultStatus.DISABLED);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        GLogger.logFormatInfo("Test Successful. Test name - %s.", context.getDisplayName());
        testResultsStatus.add(TestResultStatus.SUCCESSFUL);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        GLogger.logFormatInfo("Test Aborted. Test name - %s.", context.getDisplayName());
        testResultsStatus.add(TestResultStatus.ABORTED);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        GLogger.logFormatInfo("Test Failed. Test name - %s.", context.getDisplayName());
        testResultsStatus.add(TestResultStatus.FAILED);
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        Map<TestResultStatus, Long> summary = testResultsStatus.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        GLogger.logFormatInfo("Test result summary for %s %s", context.getDisplayName(), summary.toString());
    }
}
