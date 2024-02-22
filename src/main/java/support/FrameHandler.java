package support;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import testbase.DriverFactory;
import testbase.ExtentFactory;

public class FrameHandler {


    public void switchToFrame(String nameOrId) {
        try {
            DriverFactory.getInstance().getDriverThreadLocal().switchTo().frame(nameOrId);
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS,"Switched to the frame with name or id: " + nameOrId);
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL,"Unable switch to the frame.");
            ex.printStackTrace();
        }
    }

    public void switchToFrame(WebElement element, String elementLabel) {
        try {
            DriverFactory.getInstance().getDriverThreadLocal().switchTo().frame(element);
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS,"Switched to the frame with element: " + elementLabel);
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL,"Unable switch to the frame.");
            ex.printStackTrace();
        }
    }

    public void leaveFrame(){
        try {
            DriverFactory.getInstance().getDriverThreadLocal().switchTo().defaultContent();
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS,"Switched back from the frame to Main Page.");
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL,"Unable switch back from the frame.");
            ex.printStackTrace();
        }
    }
}

