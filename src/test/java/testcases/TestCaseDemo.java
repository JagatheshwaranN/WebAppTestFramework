package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testbase.TestBase;
import utils.CustomLogger;

public class TestCaseDemo extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void testCase1() throws InterruptedException {
        //Thread.sleep(10000);
        System.out.println("TestCase 1");
        CustomLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
        CustomLogger.info("TestCase 1 Execution");
        loginPage.doLogin("john@gmail.com", "admin");
    }

    @Test
    public void testCase2() throws InterruptedException {
        //Thread.sleep(10000);
        System.out.println("TestCase 2");
        CustomLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
        CustomLogger.info("TestCase 2 Execution");
        loginPage.doLogin("john@gmail.com", "admin1");
        Assert.fail("Failing the TestCase");
    }

}
