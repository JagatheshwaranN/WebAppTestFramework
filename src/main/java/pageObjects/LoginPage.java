package pageObjects;

import action.ReusableComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.VerificationHandler;
import testbase.DriverFactory;
import testbase.TestBase;

public class LoginPage extends TestBase {

    By LoginForm = By.id("loginForm");
    By Email = By.name("login[email]");
    By Password = By.name("login[password]");
    By Login = By.xpath("//button[@type='submit']");

    @FindBy(id = "loginForm")
    WebElement loginForm;

    @FindBy(xpath = "//h3[@class='form-title']")
    WebElement loginFormTitle;

    @FindBy(name = "login[email]")
    WebElement email;

    @FindBy(name="login[password]")
    WebElement password;

    @FindBy(id = "uniform-remember_me")
    WebElement rememberMe;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement login;

    @FindBy(xpath = "//a[contains(@href,'restorePassword')]")
    WebElement forgotPassword;

    @FindBy(name = "//label[@for='login[email]']")
    WebElement emailFieldError;

    @FindBy(name="//label[@for='login[password]']")
    WebElement passwordFieldError;

    @FindBy(id="userAlertContainer")
    WebElement emailPasswordWrongError;

//    public LoginPage(WebDriver driver){
//        PageFactory.initElements(driver, this);
//    }

    public void doLogin(String email, String password) {
        VerificationHandler verificationHandler = new VerificationHandler();
        ReusableComponent reusableComponent = new ReusableComponent(DriverFactory.getInstance().getDriverThreadLocal());
        verificationHandler.verifyElementPresent(reusableComponent.generateElement(LoginForm));
        reusableComponent.typeElement(reusableComponent.generateElement(Email), email, "Email");
        reusableComponent.typeElement(reusableComponent.generateElement(Password), password, "Password");
        reusableComponent.clickElement(reusableComponent.generateElement(Login), "Login");
    }

}
