package support;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import testbase.ExtentFactory;


public class VerificationHandler {

    public boolean verifyElementPresent(WebElement element) {
        boolean elementPresent = false;
        try {
            elementPresent = isDisplayed(element);
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Element is present on the page.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Element is not present on the page. Exception: " + ex);
            ex.printStackTrace();
        }
        return elementPresent;
    }

    public boolean verifyTextEquals(WebElement element, String text) {
        try {
            String actualText = element.getText();
            if (actualText.equals(text)) {
                ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Element text and given text are equal.");
                return true;
            } else {
                ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Element text and given text are not equal.");
                return false;
            }
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to get the element text. Exception: " + ex);
            ex.printStackTrace();
            return false;
        }
    }

	public String readTextValueFromElement(WebElement element) {
		String text = null;
		try {
			if (!isDisplayed(element)) {
				ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL,"Element is not displayed.");
				return null;
			}
			text = element.getText();
			ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS,"Element text is: " + text);
		} catch (Exception ex) {
			ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to get the element text. Exception: " + ex);
			ex.printStackTrace();
		}
		return text;
	}

    public String readValueFromInput(WebElement element) {
        String value = null;
        try {
            if (!isDisplayed(element)) {
				ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Element is not displayed.");
				return null;
			}
            value = element.getAttribute("value");
			ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS,"Element value is: " + value);
        } catch (Exception ex) {
			ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to get the element value. Exception: " + ex);
            ex.printStackTrace();
        }
        return value;
    }

    private boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

}
