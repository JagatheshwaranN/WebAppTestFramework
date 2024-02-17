package testbase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    // Singleton Class Design Pattern
    private DriverFactory(){

    }
    private static final DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance(){
        return instance;
    }

    // Factory design pattern - Define separate factory methods for creating objects and calling the methods.
    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public WebDriver getDriverThreadLocal() {
        return driverThreadLocal.get();
    }

    public void setDriverThreadLocal(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public void closeBrowser(){
        driverThreadLocal.get().close();
        driverThreadLocal.remove();
    }

}
