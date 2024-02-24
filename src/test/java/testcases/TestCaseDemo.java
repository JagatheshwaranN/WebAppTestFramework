package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.taskspage.TasksPage;
import testbase.ExtentFactory;
import testbase.TestBase;
import utils.CustomLogger;
import utils.DataBaseReader;
import utils.ExcelReader;
import utils.FileReader;

import java.util.HashMap;

public class TestCaseDemo extends TestBase {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    TasksPage tasksPage = new TasksPage();
    DataBaseReader dataBaseReader = new DataBaseReader();
    ExcelReader excelReader = new ExcelReader("AddTask");

    @Test(dataProvider = "taskCreationData")
    public void taskCreation(Object dataSet) throws InterruptedException {
        @SuppressWarnings("unchecked")
        HashMap<String, String> testData = (HashMap<String, String>) dataSet;
        //Thread.sleep(10000);
        ExtentFactory.getInstance().getExtentTestThreadLocal().info("Test Data for current execution is:" +testData);
        CustomLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
        CustomLogger.info("TestCase 1 Execution");
        loginPage.doLogin(testData.get("UserName"), testData.get("Password"));
        dashboardPage.verifyDashboardDetails();
//        dashboardPage.clickOnSideMenu("Tasks");
//        Thread.sleep(2000);
//        dashboardPage.clickOnSideMenuBarSubMenu("Tasks","Add Task");
//        tasksPage.performAddTask(testData);
//        String taskName = testData.get("TaskName");
//        String rawQuery = FileReader.getDataFromPropFile("query");
//        String convertedQuery = rawQuery.replace("?", taskName);
//        HashMap<String, String> dataFromDB = dataBaseReader.getDBResultAsMap(convertedQuery);
//        Assert.assertEquals(dataFromDB.get("name"), taskName);
        Thread.sleep(5000);
    }

    @Test(enabled = false)
    public void testCase2() throws InterruptedException {
        //Thread.sleep(10000);
        System.out.println("TestCase 2");
        CustomLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
        CustomLogger.info("TestCase 2 Execution");
        loginPage.doLogin("john@gmail.com", "admin1");
        //Assert.fail("Failing the TestCase");
    }

    @DataProvider(name="taskCreationData")
    public Object[][] testDataSupplier() {
        HashMap<String, String> excelDataMap;
        Object[][] dataSet = new Object[excelReader.getRowCount()][1];
        for(int i=1; i<= excelReader.getRowCount(); i++){
            excelDataMap = excelReader.getTestDataFromExcelAsMap(i);
            dataSet[i-1][0] = excelDataMap;
        }
        return dataSet;
    }

}
