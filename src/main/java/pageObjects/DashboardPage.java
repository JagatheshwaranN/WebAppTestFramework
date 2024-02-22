package pageObjects;

import org.openqa.selenium.By;
import testbase.DriverFactory;
import testbase.TestBase;

public class DashboardPage  extends TestBase {

    By dashboardTitle = By.xpath("//span[@class='title' and text()='Dashboard']");
    By configureDashboardButton = By.xpath("//div[@id='dashboard-csg-box']//input");

    public void clickOnSideMenu(String menuName) {
        String sideMenuBar = "//ul[contains(@class,'page-sidebar-menu')]//li//i//following-sibling::span[text()='" + menuName + "']";
        DriverFactory.getInstance().getDriverThreadLocal().findElement(By.xpath(sideMenuBar)).click();
    }

    public void clickOnSideMenuBarSubMenu(String menuName, String subMenuName) {
        String sideMenuBarSubMenu = "//ul[contains(@class,'page-sidebar-menu')]//li//i//following-sibling::span[text()='" + menuName + "']//ancestor::li//ul//span[text()='" + subMenuName + "']";
        DriverFactory.getInstance().getDriverThreadLocal().findElement(By.xpath(sideMenuBarSubMenu)).click();
    }

    public void verifyDashboardDetails() {
        verificationHandler.verifyElementPresent(generateElement(dashboardTitle));
        verificationHandler.verifyElementPresent(generateElement(configureDashboardButton));
    }
}
