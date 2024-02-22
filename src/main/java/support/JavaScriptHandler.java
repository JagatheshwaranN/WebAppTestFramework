package support;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import testbase.DriverFactory;
import testbase.ExtentFactory;

public class JavaScriptHandler {


    private JavascriptExecutor getExecutor() {
        return (JavascriptExecutor) DriverFactory.getInstance().getDriverThreadLocal();
    }

    public Object executeScript(String script) {
        try {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Executed script is: " + script);
            return getExecutor().executeAsyncScript(script);
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Unable to execute the script. Exception:" + ex);
            ex.printStackTrace();
            return null;
        }
    }

    public Object executeScript(String script, Object... arguments) {
        try {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Executed script is: " + script);
            return getExecutor().executeAsyncScript(script, arguments);
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Unable to execute the script. Exception:" + ex);
            ex.printStackTrace();
            return null;
        }
    }

    public void elementClick(WebElement element) {
        try {
            getExecutor().executeScript("arguments[0].click();", element);
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Element click by JS executor is successful.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to click the element by JS executor. Exception: " + ex);
            ex.printStackTrace();
        }
    }

    public void scrollToElement(WebElement element) {
        try {
            executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x,
                    element.getLocation().y);
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Scroll to the element by JS executor is successful.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to scroll to the element by JS executor. Exception: " + ex);
            ex.printStackTrace();
        }
    }

    public void scrollToElementAndClick(WebElement element) {
        try {
            scrollToElement(element);
            element.click();
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Scroll to element and click by JS executor is successful.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to scroll to the element and click by JS executor. Exception: " + ex);
            ex.printStackTrace();
        }
    }

    public void scrollIntoView(WebElement element) {
        try {
            executeScript("arguments[0].scrollIntoView()", element);
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Scroll to view by JS executor is successful.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to scroll to view by JS executor. Exception: " + ex);
            ex.printStackTrace();
        }
    }

    public void scrollIntoViewAndClick(WebElement element) {
        try {
            scrollIntoView(element);
            element.click();
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Scroll to view and click by JS executor is successful.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to scroll to view and click by JS executor. Exception: " + ex);
            ex.printStackTrace();
        }
    }

    public void scrollUpVertical() {
        try {
            executeScript("window.scrollTo(0, -document.body.scrollHeight)");
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Scroll to the top of the page by JS executor is successful.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to scroll to the top of the page by JS executor. Exception: " + ex);
            ex.printStackTrace();
        }
    }

    public void scrollDownVertical() {
        try {
            executeScript("window.scrollTo(0, document.body.scrollHeight)");
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Scroll to the bottom of the page by JS executor is successful.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to scroll to the bottom of the page by JS executor. Exception: " + ex);
            ex.printStackTrace();
        }
    }

    public void scrollUpByPixel(String pixel) {
        try {
            executeScript("window.scrollBy(0, -'" + pixel + "')");
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Scroll the page up with pixel by JS executor is successful.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to scroll the page up with pixel by JS executor. Exception: " + ex);
            ex.printStackTrace();
        }
    }

    public void scrollDownByPixel(String pixel) {
        try {
            executeScript("window.scrollBy(0, '" + pixel + "')");
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Scroll the page down with pixel by JS executor is successful.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to scroll the down up with pixel by JS executor. Exception: " + ex);
            ex.printStackTrace();
        }
    }

    public void zoomInByPercentage(String percent) {
        try {
            executeScript("document.body.style.zoom='" + percent + "'");
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Zoom in the page by JS executor is successful.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to zoom in the page by JS executor. Exception: " + ex);
            ex.printStackTrace();
        }
    }

}
