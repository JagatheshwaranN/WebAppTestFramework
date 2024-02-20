package support;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import testbase.ExtentFactory;

public class FrameHandler {

    private WebDriver driver;

    public FrameHandler(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame(String nameOrId) {
        try {
            driver.switchTo().frame(nameOrId);
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS,"Switched to the frame with name or id: " + nameOrId);
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS,"Unable switch to the frame.");
            ex.printStackTrace();
        }
    }

}

