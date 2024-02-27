package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import report.ExtentReport;
import testbase.DriverFactory;
import testbase.ExtentFactory;
import utils.FileReader;
import utils.JiraDefectCreation;


public class Report implements ITestListener {

    static ExtentReports extentReports;
    ExtentTest extentTest;
    private String snapshotCategory = null;

    JiraDefectCreation jiraDefectCreation = new JiraDefectCreation();

    @Override
    public void onFinish(ITestContext context) {
        try {
            Reporter.log("The " + context.getName() + " Execution Finished");
            extentReports.flush();
        } catch (Exception ex) {
            System.out.println("Exception occurred while finish of the TEST" + "\n" + ex);
            Assert.fail();
        }
    }

    @Override
    public void onStart(ITestContext context) {
        try {
            Reporter.log("The " + context.getName() + " Execution started");
            extentReports = ExtentReport.setupExtentReport();
        } catch (Exception ex) {
            System.out.println("Exception occurred while start of the TEST" + "\n" + ex);
            Assert.fail();
        }
    }

    @Override
    public void onTestStart(ITestResult testResult) {
        try {
            Reporter.log("The " + testResult.getMethod().getMethodName() + " Test Started");
            extentTest = extentReports.createTest(testResult.getMethod().getMethodName());
            ExtentFactory.getInstance().setExtentTestThreadLocal(extentTest);
        } catch (Exception ex) {
            System.out.println("Exception occurred while test start" + "\n" + ex);
            Assert.fail();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        snapshotCategory = "failure/";
        String screenToAttach = null;
        try {
            if (!result.isSuccess()) {
                // ReportNG Report Code - NOT WORKING
                screenToAttach = captureSnapShot(snapshotCategory);
                Reporter.log("<br>");
                Reporter.log("The " + result.getMethod().getMethodName() + " Test Failed..!!" + "\n"
                        + result.getThrowable());
                Reporter.log("<br>");
                Reporter.log("<a target='_blank' href='" + screenToAttach + "'><img src= '" + screenToAttach
                        + "' height='100' width='100' /></a>");
                System.out.println("The test failure screenshot is captured to attach in report and testNG report");
                ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "The " + result.getMethod().getMethodName() + " Test Failed..!!" + "\n"
                        + result.getThrowable());
                //ExtentFactory.getInstance().getDriverThreadLocal().log(Status.FAIL, result.getThrowable());
                ExtentFactory.getInstance().getExtentTestThreadLocal().addScreenCaptureFromPath(screenToAttach);
                ExtentFactory.getInstance().closeExtentTest();

            }
        } catch (Exception ex) {
            System.out.println("Exception occurred while capture screenshot on test failure" + "\n" + ex);
            Assert.fail();
        }
        @SuppressWarnings("unchecked")
        HashMap<String, String> testData = (HashMap<String, String>) result.getTestContext().getAttribute("testDataMap");
        String summary = "Automation Test Failed - " + result.getMethod().getMethodName();
        String exception = String.valueOf(result.getThrowable());
        String description = "***** Test Data Used: ***** \n" + testData + "\n ***** Exception: *****\n" + exception;
        String defectId = jiraDefectCreation.createDefectThruAPI(summary, description, "Bug", "AutomationDefect", "QDPM-1", "UAT", FileReader.getDataFromPropFile("jiraId"));
        System.out.println("Defect Created: " + defectId);
        assert screenToAttach != null;
        jiraDefectCreation.addAttachmentToDefect(defectId, new File(screenToAttach));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        snapshotCategory = "success/";
        try {
            if (result.isSuccess()) {
                // ReportNG Report Code - NOT WORKING
                String screenToAttach = captureSnapShot(snapshotCategory);
                Reporter.log("<br>");
                Reporter.log("The " + result.getMethod().getMethodName() + " Test Passed..!!");
                Reporter.log("<br>");
                Reporter.log("<a target='_blank' href='" + screenToAttach + "'><img src= '" + screenToAttach
                        + "' height='100' width='100' /></a>");
                System.out.println("The test success screenshot is captured to attach in report and testNG report");
                ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "The " + result.getMethod().getMethodName() + " Test Passed..!!");
                ExtentFactory.getInstance().getExtentTestThreadLocal().addScreenCaptureFromPath(screenToAttach);
                ExtentFactory.getInstance().closeExtentTest();
            }
        } catch (Exception ex) {
            System.out.println("Exception occurred while capture screenshot on test success" + "\n" + ex);
            Assert.fail();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        try {
            Reporter.log("The " + result.getMethod().getMethodName() + " Test Skipped" + "\n" + result.getThrowable());
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.SKIP, "The " + result.getMethod().getMethodName() + " Test Skipped..!!");
            ExtentFactory.getInstance().closeExtentTest();
        } catch (Exception ex) {
            System.out.println("Exception occurred while test skip of the test" + "\n" + ex);
            Assert.fail();
        }
    }

    public String captureSnapShot(String snapshotCategory) {
        var calendar = Calendar.getInstance();
        var simpleDateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        var source = ((TakesScreenshot) DriverFactory.getInstance().getDriverThreadLocal()).getScreenshotAs(OutputType.FILE);
        var destination = new File(System.getProperty("user.dir") + "/reports/"+ snapshotCategory
                + simpleDateFormat.format(calendar.getTime()) + ".png");
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return destination.getAbsolutePath();
    }

}