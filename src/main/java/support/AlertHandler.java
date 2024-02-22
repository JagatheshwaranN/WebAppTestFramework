package support;


import com.aventstack.extentreports.Status;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import testbase.DriverFactory;
import testbase.ExtentFactory;


public class AlertHandler {

    public Alert getAlert() {
        try {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Switch to the alert popup is successful.");
            return DriverFactory.getInstance().getDriverThreadLocal().switchTo().alert();
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to switch to the alert popup. Exception " + ex);
            ex.printStackTrace();
            return null;
        }
    }

    public void acceptAlert() {
        try {
            getAlert().accept();
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Alert popup accept is successful.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to accept the alert popup. Exception: " + ex);
            ex.printStackTrace();
        }
    }

    public void dismissAlert() {
        try {
            getAlert().accept();
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Alert popup dismiss is successful.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to dismiss the alert popup. Exception: " + ex);
            ex.printStackTrace();
        }
    }

    public String getAlertText() {
        String text = null;
        try {
            Alert alert = getAlert();
            if (alert != null) {
                text = alert.getText();
                ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Alert popup content is: " + text);
            }
        } catch (NoAlertPresentException noAlertEx) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Alert popup is NOT present. Exception: " + noAlertEx);
            noAlertEx.printStackTrace();
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to retrieve the content of the alert popup. Exception: " + ex);
            ex.printStackTrace();
        }
        return text;
    }

    public boolean isAlertPresent() {
        try {
            DriverFactory.getInstance().getDriverThreadLocal().switchTo().alert();
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Alert popup is present.");
            return true;
        } catch (NoAlertPresentException ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Alert popup is NOT present. Exception: " + ex);
            return false;
        }
    }

    public void acceptAlertIfPresent() {
        try {
            if (!isAlertPresent()) {
                ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Alert popup is not present.");
                return;
            }
            acceptAlert();
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to check presence of the alert popup. Exception: " + ex);
            ex.printStackTrace();
        }
    }

    public void dismissAlertIfPresent() {
        try {
            if (!isAlertPresent()) {
                ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Alert popup is not present.");
                return;
            }
            dismissAlert();
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to check presence of the alert popup. Exception: " + ex);
            ex.printStackTrace();
        }
    }

    public void acceptPrompt(String text) {
        try {
            if (!isAlertPresent()) {
                ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Alert popup is not present.");
                return;
            }
            Alert alert = getAlert();
            alert.sendKeys(text);
            alert.accept();
			ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS,"Alert is present - alert prompt popup accept is successful.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to accept the prompt alert popup. Exception: " + ex);
            ex.printStackTrace();
        }
    }

}
