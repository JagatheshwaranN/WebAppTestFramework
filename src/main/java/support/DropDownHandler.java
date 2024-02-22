package support;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testbase.ExtentFactory;

import java.util.LinkedList;
import java.util.List;

public class DropDownHandler {

	private Select initializeSelect(WebElement element) {
		return new Select(element);
	}

	public void selectByValue(WebElement element, String value) {
		try {
			Select select = initializeSelect(element);
			select.selectByValue(value);
			ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "The option with value " + value + " is selected from the dropdown.");
		} catch (Exception ex) {
			ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to select the option from the dropdown. Exception: "+ex);
			ex.printStackTrace();
		}
	}

	public void selectByIndex(WebElement element, int index) {
		try {
			Select select = initializeSelect(element);
			select.selectByIndex(index);
			ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "The option with index " + index + " is selected from the dropdown.");
		} catch (Exception ex) {
			ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to select the option from the dropdown. Exception: "+ex);
			ex.printStackTrace();
		}
	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		try {
			Select select = initializeSelect(element);
			select.selectByVisibleText(visibleText);
			ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS, "The option with visible text " + visibleText + " is selected from the dropdown.");
		} catch (Exception ex) {
			ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to select the option from the dropdown. Exception: "+ex);
			ex.printStackTrace();
		}
	}

	public String getSelectedValue(WebElement element) {
		String value = null;
		try {
			Select select = initializeSelect(element);
			value = select.getFirstSelectedOption().getText();
			ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS,"The selected option from the dropdown is: " + value);
		} catch (Exception ex) {
			ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to get the selected option from the dropdown. Exception: "+ex);
			ex.printStackTrace();
		}
		return value;
	}

	public List<String> getAllDropDownValue(WebElement element) {
		List<String> dropdownValues = null;
		try {
			Select select = initializeSelect(element);
			List<WebElement> listElements = select.getOptions();
			dropdownValues = new LinkedList<>();
			for (WebElement elements : listElements) {
				dropdownValues.add(elements.getText());
			}
			ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.PASS,"The dropdown options are: " + dropdownValues);
		} catch (Exception ex) {
			ExtentFactory.getInstance().getExtentTestThreadLocal().log(Status.FAIL, "Unable to get the dropdown options. Exception: "+ex);
			ex.printStackTrace();
		}
		return dropdownValues;
	}

}

