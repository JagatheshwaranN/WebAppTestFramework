package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

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

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

}
