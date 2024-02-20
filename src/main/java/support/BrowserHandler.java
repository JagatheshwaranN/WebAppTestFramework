package support;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import testbase.ExtentFactory;

public class BrowserHandler {

    private WebDriver driver;

    public BrowserHandler(WebDriver driver) {
        this.driver = driver;
    }

    public void goBack() {
        try {
            driver.navigate().back();
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Browser navigated back to the previous page.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to navigate the browser back to the previous page.");
            ex.printStackTrace();
        }
    }

    public void goForward() {
        try {
            driver.navigate().forward();
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Browser navigated to the front page.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to navigate the browser to the front page.");
            ex.printStackTrace();
        }
    }

    public void refresh() {
        try {
            driver.navigate().refresh();
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Browser refreshed the current page.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Browser unable to refresh the current page.");
            ex.printStackTrace();
        }
    }

    public String getCurrentPageUrl() {
        String url = null;
        try {
            url = driver.getCurrentUrl();
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS,"Browser current page URL is: " + url);
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL,"Unable to get the browser current page URL. Exception: "+ex);
            ex.printStackTrace();
        }
        return url;
    }

}
