package action;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testbase.ExtentFactory;

public class ReusableComponent {

    private final WebDriver driver;

    public ReusableComponent(WebDriver driver) {
        this.driver = driver;
    }

    public static void waitForSomeTime() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void clearElement(WebElement element, String elementLabel) {
        if (element != null) {
            element.clear();
            System.out.println("The " + "'" + elementLabel + "'" + " element's content is cleared");
        }
    }

    public void clickElement(WebElement element, String elementLabel) {
        if (element != null) {
            element.click();
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "The " + "'" + elementLabel + "'" + " element is clicked");
        }
    }

    public void clickElement(By locator, String value, String elementLabel) {
        String locatorToString = null;
        String updatedLocatorToString = null;
        WebElement element;
        locatorToString = locator.toString();
        if (locatorToString.contains("@1@")) {
            updatedLocatorToString = locatorToString.replaceAll("@1@", value);
        }
        assert updatedLocatorToString != null;
        updatedLocatorToString = updatedLocatorToString.split(":")[1].trim();
        System.out.println("The locator string replaced with the value ==> " + updatedLocatorToString);
        element = generateElement(updatedLocatorToString, elementLabel);
        element.click();
    }

    public void typeElement(WebElement element, String text, String elementLabel) {
        if (element != null) {
            element.sendKeys(text);
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "The text " + "'" + text + "'" + " is entered into the " + "'" + elementLabel + "'" + " element");
        }
    }

    public WebElement generateElement(String locator, String locatorLabel) {
        return driver.findElement(By.xpath(locator));
    }

    public WebElement generateElement(By locator) {
        return driver.findElement(locator);
    }
}
