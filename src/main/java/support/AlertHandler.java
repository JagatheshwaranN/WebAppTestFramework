package support;


import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;


public class AlertHandler {
	
	private WebDriver driver;

	public AlertHandler(WebDriver driver) {
		this.driver = driver;
	}

	public Alert getAlert() {
		try {
			System.out.println("Switch to alert popup is succesful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return driver.switchTo().alert();
	}

	public void acceptAlert() {
		try {
			getAlert().accept();
			System.out.println("Alert popup accept is succesful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void dismissAlert() {
		try {
			getAlert().dismiss();
			System.out.println("Alert popup dismiss is succesful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getAlertText() {
		String text = null;
		try {
			text = getAlert().getText();
			System.out.println("Alert popup text is : " + text);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return text;

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			System.out.println("Alert popup is present : " + true);
			return false;
		} catch (NoAlertPresentException ex) {
			System.out.println("Alert popup is not present : " + false);
			return true;
		}

	}

	public void acceptAlertIfPresent() {
		try {
			if (isAlertPresent()) {
				return;
			}
			System.out.println("Alert present - alert popup accept is succesful");
			getAlertText();
			acceptAlert();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void dismissAlertIfPresent() {
		try {
			if (isAlertPresent()) {
				return;
			}
			System.out.println("Alert present - alert popup dismiss is succesful");
			dismissAlert();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void acceptPrompt(String text) {
		try {
			if (isAlertPresent()) {
				return;
			}
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			System.out.println("Alert present - alert prompt popup accept is succesful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
