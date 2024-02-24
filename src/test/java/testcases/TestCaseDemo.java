package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.taskspage.TasksPage;
import testbase.TestBase;
import utils.CustomLogger;
import utils.DataBaseReader;
import utils.FileReader;

import java.util.HashMap;

public class TestCaseDemo extends TestBase {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    TasksPage tasksPage = new TasksPage();
    DataBaseReader dataBaseReader = new DataBaseReader();

    @Test
    public void testCase1() throws InterruptedException {
        //Thread.sleep(10000);
        System.out.println("TestCase 1");
        CustomLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
        CustomLogger.info("TestCase 1 Execution");
        loginPage.doLogin("john@gmail.com", "admin");
        dashboardPage.verifyDashboardDetails();
        dashboardPage.clickOnSideMenu("Tasks");
        Thread.sleep(2000);
        dashboardPage.clickOnSideMenuBarSubMenu("Tasks","Add Task");
        tasksPage.performAddTask();
        HashMap<String, String> dataFromDB = dataBaseReader.getDBResultAsMap(FileReader.getDataFromPropFile("query"));
        Assert.assertEquals(dataFromDB.get("name"), "Project Documents");
        Thread.sleep(10000);
    }

    @Test(enabled = false)
    public void testCase2() throws InterruptedException {
        //Thread.sleep(10000);
        System.out.println("TestCase 2");
        CustomLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
        CustomLogger.info("TestCase 2 Execution");
        loginPage.doLogin("john@gmail.com", "admin1");
        Assert.fail("Failing the TestCase");
    }

}
