package TestReporter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    ExtentReporter report = new ExtentReporter();

    @Override
    public void onTestStart(ITestResult result) {
        report.testName(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            report.addScreenShot(result.getName() + " - Test Passed", "PASS");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            report.addScreenShot(result.getName() + " - Test Failed", "FAIL");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        try {
            report.addScreenShot(result.getName() + " - Test Skipped", "INFO");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Do nothing
    }

    @Override
    public void onStart(ITestContext context) {
        // Do nothing
    }

    @Override
    public void onFinish(ITestContext context) {
        try {
            report.flushReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
