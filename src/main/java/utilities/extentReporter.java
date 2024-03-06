package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReporter {
    static ExtentReports extent;
    public static  ExtentReports getExtentReport(){
        String reportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Automation results");
        reporter.config().setDocumentTitle("TestResults");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("operating system","Windows10");
        extent.setSystemInfo("Tested by","Suguru Harika");
        return extent;
    }
}

