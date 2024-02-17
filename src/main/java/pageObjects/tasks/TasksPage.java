package pageObjects.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage {

    public WebDriver driver;
    public AddTaskPage addTaskPage;

//    private ViewAllPage viewAllPage;

    public TasksPage(WebDriver driver) {
        this.driver = driver;
        this.addTaskPage = PageFactory.initElements(driver, AddTaskPage.class);
        //  this.viewAllPage = PageFactory.initElements(driver, ViewAllPage.class);
    }

    public void clickOnSideMenu(String menuName) {
        String sideMenuBar = "//ul[contains(@class,'page-sidebar-menu')]//li//i//following-sibling::span[text()='" + menuName + "']";
        driver.findElement(By.xpath(sideMenuBar)).click();
    }

    public void clickOnSideMenuBarSubMenu(String menuName, String subMenuName) {
        String sideMenuBarSubMenu = "//ul[contains(@class,'page-sidebar-menu')]//li//i//following-sibling::span[text()='" + menuName + "']//ancestor::li//ul//span[text()='" + subMenuName + "']";
        driver.findElement(By.xpath(sideMenuBarSubMenu)).click();
    }

    public void performAddTask() {
        addTaskPage.addTask();
    }

}

