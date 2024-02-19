package support;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandler {
	
	public void selectByValue(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByValue(value);
			System.out.println("The value " + value + " is selected");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void selectByIndex(WebElement element, int index) {
		try {
			Select select = new Select(element);
			select.selectByIndex(index);
			System.out.println("The value at index " + index + " is selected");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(visibleText);
			System.out.println("The visible text " + visibleText + " is selected");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getSelectValue(WebElement element) {
		String value = null;
		try {
			value = new Select(element).getFirstSelectedOption().getText();
			System.out.println("The selected value text is : " + value);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return value;
	}

	public List<String> getAllDropDownValue(WebElement element) {
		List<String> dropdownvalues = null;
		try {
			Select select = new Select(element);
			List<WebElement> listelements = select.getOptions();
			dropdownvalues = new LinkedList<String>();
			for (WebElement elements : listelements) {
				System.out.println("The element values of the dropdown are : " + elements.getText());
				dropdownvalues.add(elements.getText());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dropdownvalues;
	}

}
