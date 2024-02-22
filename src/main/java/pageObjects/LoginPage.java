package pageObjects;

import action.PageAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.VerificationHandler;
import testbase.TestBase;

public class LoginPage extends TestBase {

    public By loginForm = By.id("loginForm");
    public By loginFormTitle = By.xpath("//h3[@class='form-title']");
    public By email = By.name("login[email]");
    public By password = By.name("login[password]");
    public By rememberMe = By.id("uniform-remember_me");
    public By loginButton = By.xpath("//button[@type='submit']");
    public By forgotPassword = By.xpath("//a[contains(@href,'restorePassword')]");
    public By emailFieldError = By.xpath("//label[@for='login[email]']");
    public By passwordFieldError = By.xpath("//label[@for='login[password]']");
    public By emailPasswordWrongError = By.id("userAlertContainer");

    public void doLogin(String emailId, String passWord) {
        verificationHandler.verifyElementPresent(generateElement(loginForm));
        typeElement(generateElement(email), emailId, "Email");
        typeElement(generateElement(password), passWord, "Password");
        clickElement(generateElement(loginButton), "Login");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
