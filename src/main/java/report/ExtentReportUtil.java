package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utils.FileReaderUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportUtil {

    static ExtentReports extentReports;

    public static ExtentReports setupExtentReport() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        Date date = new Date();
        String actualDate = simpleDateFormat.format(date);
        String reportPath = System.getProperty("user.dir")+"/reports/ExtentReport_"+actualDate+".html";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentSparkReporter.config().setDocumentTitle("QDPM Execution Report");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("QDPM Test Automation");
        extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
        extentReports.setSystemInfo("Test Browser", FileReaderUtil.getDataFromPropFile("browser"));
        extentReports.setSystemInfo("Test App URL", FileReaderUtil.getDataFromPropFile("appURL"));
        return extentReports;
    }

}
