package support;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import testbase.DriverFactory;
import testbase.ExtentFactory;

public class FrameHandler {


    public void switchToFrame(String nameOrId) {
        try {
            DriverFactory.getInstance().getDriverThreadLocal().switchTo().frame(nameOrId);
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS,"Switched to the frame with name or id: " + nameOrId);
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS,"Unable switch to the frame.");
            ex.printStackTrace();
        }
    }

}

