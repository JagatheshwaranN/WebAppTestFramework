package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TasksPage {

    @FindBy(xpath = "//a[@href='/index.php/']//span[@class='title']")
    WebElement dashboard;

    String sideMenuBar = "//ul[contains(@class,'page-sidebar-menu')]//li//i//following-sibling::span[text()='Tasks']";
}
