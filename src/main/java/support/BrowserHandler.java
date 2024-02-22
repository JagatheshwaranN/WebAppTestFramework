package support;

import com.aventstack.extentreports.Status;
import testbase.DriverFactory;
import testbase.ExtentFactory;

public class BrowserHandler {
    
    public void goBack() {
        try {
            DriverFactory.getInstance().getDriverThreadLocal().navigate().back();
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Browser navigated back to the previous page.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to navigate the browser back to the previous page.");
            ex.printStackTrace();
        }
    }

    public void goForward() {
        try {
            DriverFactory.getInstance().getDriverThreadLocal().navigate().forward();
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Browser navigated to the front page.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to navigate the browser to the front page.");
            ex.printStackTrace();
        }
    }

    public void refresh() {
        try {
            DriverFactory.getInstance().getDriverThreadLocal().navigate().refresh();
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Browser refreshed the current page.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Browser unable to refresh the current page.");
            ex.printStackTrace();
        }
    }

    public String getCurrentPageUrl() {
        String url = null;
        try {
            url = DriverFactory.getInstance().getDriverThreadLocal().getCurrentUrl();
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS,"Browser current page URL is: " + url);
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL,"Unable to get the browser current page URL. Exception: "+ex);
            ex.printStackTrace();
        }
        return url;
    }

}
