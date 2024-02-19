package support;

import java.util.LinkedList;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class BrowserHandler {
	
	private WebDriver driver;

	public BrowserHandler(WebDriver driver) {
		this.driver = driver;
	}

	public void goBack() {
		try {
			driver.navigate().back();
			System.out.println("Browser navigate to previous page");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void goForward() {
		try {
			driver.navigate().forward();
			System.out.println("Browser navigate to front page");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void refresh() {
		try {
			driver.navigate().refresh();
			System.out.println("Browser refresh the current page");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Set<String> getWindowHandles() {
		try {
			System.out.println("Capturing windows unique alphanumeric ids");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return driver.getWindowHandles();
	}

	public void SwitchToWindow(int index) {
		try {
			LinkedList<String> windowsId = new LinkedList<String>(getWindowHandles());
			if (index < 0 || index > windowsId.size())
				throw new IllegalArgumentException("Window handle has invalid index : " + index);
			driver.switchTo().window(windowsId.get(index));
			System.out.println("Switch to window with index : " + index);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void switchToParentWindow() {
		try {
			LinkedList<String> windowsid = new LinkedList<String>(getWindowHandles());
			driver.switchTo().window(windowsid.get(0));
			System.out.println("Switch to parent window");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void switchToParentWithChildClose() {
		try {
			//switchToParentWindow();
			LinkedList<String> windowsid = new LinkedList<String>(getWindowHandles());
			for (int i = 1; i < windowsid.size(); i++) {
				System.out.println("Child window id : " + windowsid.get(i));
				driver.switchTo().window(windowsid.get(i));
				driver.close();
			}
			switchToParentWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void switchToFrame(String nameOrid) {
		try {
			driver.switchTo().frame(nameOrid);
			System.out.println("Switch to frame with name or id : " + nameOrid);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getCurrentPageUrl() {
		String url = null;
		try {
			url = driver.getCurrentUrl();
			System.out.println("Current page url : " + url);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return url;
	}

}
