package support;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testbase.ExtentFactory;


public class MouseHandler {

    private WebDriver driver;

    public MouseHandler(WebDriver driver) {
        this.driver = driver;
    }

    public void mouseHover(WebElement element1, WebElement element2) {
        try {
            Actions builder = new Actions(driver);
            builder.moveToElement(element1).build().perform();
            element2.click();
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Mouse hover and click on element is successful.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to mouse hover. Exception: " + ex);
            ex.printStackTrace();
        }
    }

}
