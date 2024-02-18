package testcases;

import org.testng.annotations.Test;
import testbase.TestBase;
import utils.LoggerUtil;

public class TestCaseDemo extends TestBase {

    @Test
    public void testCase1() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("TestCase 1");
        LoggerUtil.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
        LoggerUtil.info("TestCase 1 Execution");
    }

    @Test
    public void testCase2() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("TestCase 2");
        LoggerUtil.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
        LoggerUtil.info("TestCase 2 Execution");
    }

}
