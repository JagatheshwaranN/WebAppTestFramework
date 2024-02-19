package testcases;

import org.testng.annotations.Test;
import testbase.TestBase;
import utils.CustomLogger;

public class TestCaseDemo extends TestBase {

    @Test
    public void testCase1() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("TestCase 1");
        CustomLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
        CustomLogger.info("TestCase 1 Execution");
    }

    @Test
    public void testCase2() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("TestCase 2");
        CustomLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
        CustomLogger.info("TestCase 2 Execution");
    }

}
