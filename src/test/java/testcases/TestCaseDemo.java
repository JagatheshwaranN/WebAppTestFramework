package testcases;

import org.testng.annotations.Test;
import testbase.TestBase;

public class TestCaseDemo extends TestBase {

    @Test
    public void testCase1() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("TestCase 1");
    }

    @Test
    public void testCase2() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("TestCase 2");
    }

}
