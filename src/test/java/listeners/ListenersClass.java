package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.extentReporter;

import java.io.IOException;


public class ListenersClass extends BaseClass implements ITestListener {
    WebDriver driver = null;
    ExtentReports extentReport = extentReporter.getExtentReport();
    ExtentTest extendTest;
    //Threadlocal<ExtentTest> extentTestThread = new Threadlocal<ExtentTest>();
    private static ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getName();
        extendTest = extentReport.createTest(testName);
        extentTestThread.set(extendTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getName();
        extentTestThread.get().log(Status.PASS,testName+" got passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testNameMethod = result.getName();
        extentTestThread.get().fail(result.getThrowable());
        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String screenshotFilePath = takeScreenshot(testNameMethod,driver);
            extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath,testNameMethod);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getName();
        extentTestThread.get().skip(result.getThrowable());

        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {
           e.printStackTrace();
        }
        try {
            String screenshotFilePath2 = takeScreenshot(testName,driver);
            extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath2,testName) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

        extentReport.flush();
    }
}
