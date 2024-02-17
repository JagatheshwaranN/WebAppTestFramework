package testbase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.FileReaderUtil;

public class TestBase {

    @BeforeMethod
    public void setUp(){
        BrowserFactory browserFactory = new BrowserFactory();
        FileReaderUtil.loadPropertyFile();
        String browser = FileReaderUtil.getDataFromPropFile("browser");
        String appURL = FileReaderUtil.getDataFromPropFile("appURL");
        WebDriver driverInstance = browserFactory.createBrowserInstance(browser);
        DriverFactory.getInstance().setDriverThreadLocal(driverInstance);
        driverInstance.manage().window().maximize();
        driverInstance.get(appURL);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.getInstance().closeBrowser();
    }

}
