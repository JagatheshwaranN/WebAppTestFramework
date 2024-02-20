package support;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import testbase.ExtentFactory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;

public class WindowHandler {

    private WebDriver driver;

    public WindowHandler(WebDriver driver) {
        this.driver = driver;
    }

    public String getWindowHandle() {
        try {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Window handle capture is successful.");
            return driver.getWindowHandle();
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to capture the window handle. Exception: " + ex);
            ex.printStackTrace();
            return null;
        }
    }

    public Set<String> getWindowHandles() {
        try {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "Window handles capture is successful.");
            return driver.getWindowHandles();
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to capture the window handles. Exception: " + ex);
            ex.printStackTrace();
            return Collections.emptySet();
        }
    }

    public void switchToWindow(int index) {
        try {
            LinkedList<String> windowHandles = new LinkedList<>(getWindowHandles());
            if (index < 0 || index >= windowHandles.size())
                throw new IllegalArgumentException("Window handle has an invalid index: " + index);

            driver.switchTo().window(windowHandles.get(index));
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS,"Switched to the window with index: " + index);
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to switch to the window. Exception: " + ex);
            ex.printStackTrace();
        }
    }

    public void switchToParentWindow() {
        try {
            LinkedList<String> windowHandles = new LinkedList<>(getWindowHandles());
            if (!windowHandles.isEmpty()) {
                driver.switchTo().window(windowHandles.get(0));
                ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS,"Switched to the parent window.");
            }
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to switch to the window. Exception: " + ex);
            ex.printStackTrace();
        }
    }

    public void switchToParentWithChildClose() {
        try {
            LinkedList<String> windowHandles = new LinkedList<>(getWindowHandles());
            for (int i = 1; i < windowHandles.size(); i++) {
                driver.switchTo().window(windowHandles.get(i));
                ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS,"Switched to the child window with id: " + windowHandles.get(i)+" and closed.");
                driver.close();
            }
            switchToParentWindow();
        } catch (Exception ex) {
            ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to switch to the window. Exception: " + ex);
            ex.printStackTrace();
        }
    }

}
