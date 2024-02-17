package testbase;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {

    // Singleton Class Design Pattern
    private ExtentFactory(){

    }
    private static final ExtentFactory instance = new ExtentFactory();

    public static ExtentFactory getInstance(){
        return instance;
    }

    // Factory design pattern - Define separate factory methods for creating objects and calling the methods.
    ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    public ExtentTest getDriverThreadLocal() {
        return extentTestThreadLocal.get();
    }

    public void setDriverThreadLocal(ExtentTest extentTest) {
        extentTestThreadLocal.set(extentTest);
    }

    public void closeExtentTest(){
        extentTestThreadLocal.remove();
    }
}
