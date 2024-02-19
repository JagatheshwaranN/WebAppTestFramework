package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


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
			System.out.println("Mouse hover and click on element is successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
