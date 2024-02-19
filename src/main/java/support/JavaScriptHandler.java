package support;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHandler {
	
	private WebDriver driver;

	public JavaScriptHandler(WebDriver driver) {
		this.driver = driver;
	}

	public Object executeScript(String script) {
		try {
			System.out.println("Script : " + script);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		return executor.executeAsyncScript(script);

	}

	public Object executeScript(String script, Object... arguments) {
		try {
			System.out.println("Script : " + script);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		return executor.executeAsyncScript(script, arguments);
	}

	public void elementClick(WebElement element) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			System.out.println("Element click using JS executor is successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void scrollToElement(WebElement element) {
		try {
			executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x,
					element.getLocation().y);
			System.out.println("Scroll to element is successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void scrollToElementAndClick(WebElement element) {
		try {
			scrollToElement(element);
			element.click();
			System.out.println("Scroll to element and click is successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void scrollIntoView(WebElement element) {
		try {
			executeScript("arguments[0].scrollIntoView()", element);
			System.out.println("Scroll to view is successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void scrollIntoViewAndClick(WebElement element) {
		try {
			scrollIntoView(element);
			element.click();
			System.out.println("Scroll to view and click is successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void scrollUpVertical() {
		try {
			executeScript("window.scrollTo(0, -document.body.scrollHeight)");
			System.out.println("Scroll up vertical is successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void scrollDownVertical() {
		try {
			executeScript("window.scrollTo(0, document.body.scrollHeight)");
			System.out.println("Scroll down vertical is successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void ScrolUpByPixel(String pixel) {
		try {
			executeScript("window.scrollBy(0, -'" + pixel + "')");
			System.out.println("Scroll up by pixel is successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void ScrolDownByPixel(String pixel) {
		try {
			executeScript("window.scrollBy(0, '" + pixel + "')");
			System.out.println("Scroll down by pixel is successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void zoomInByPercentage(String percent) {
		try {
			executeScript("document.body.style.zoom='" + percent + "'");
			System.out.println("Zoom in by percent is successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
