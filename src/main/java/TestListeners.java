import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        Reporter.log(BaseClass.messageString(iTestResult.getName() + " started"));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Reporter.log(BaseClass.messageString(iTestResult.getName() + " Passed"), true);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try{
            Reporter.log(BaseClass.messageString(iTestResult.getName() + " failed"), true);
            BaseClass.getScreenshot(Constants.SCREENSHOTS_DIR + iTestResult.getName() + "_" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).toString());
        }catch(Exception ex){
            Reporter.log(BaseClass.messageString("Error saving screenshot to location " + Constants.SCREENSHOTS_DIR), true);
            Reporter.log(BaseClass.messageString(ex.getMessage()), true);
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Reporter.log(BaseClass.messageString("Starting execution"), true);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
