package webdriver_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import static config.ConfigReader.getProperty;

public class LoginPage {

    private WebDriver driver;
    private SoftAssert softAssert;

    public LoginPage(WebDriver driver, SoftAssert softAssert){
        this.driver = driver; this.softAssert = softAssert;
        PageFactory.initElements(driver, this);
    }

@FindBy(id = "username")
private WebElement userName;
@FindBy(id="password")
private WebElement password;
@FindBy (xpath = "//i[@class='fa fa-2x fa-sign-in']")
private WebElement logInBtn;
@FindBy (xpath = "//div[contains(text(),'Your username is invalid!')]")
private WebElement errorMsg;

public void navigateToLogInPage(){

    driver.get(getProperty("url"));
}

 //   Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!
public void loginSuccess(){
    userName.sendKeys(getProperty("username"));
    password.sendKeys(getProperty("password"));
    softAssert.assertTrue(logInBtn.isEnabled(), "Log in button is not enabled");
    logInBtn.click();
}
//Login Failure: http://localhost:7080/login Login fail invalid creadentials

public void loginFailure(){
    userName.sendKeys(getProperty("incUsername"));
    password.sendKeys(getProperty("incPassword"));
    logInBtn.click();
    softAssert.assertEquals(errorMsg.getText().trim().toLowerCase(), "Your username is invalid!".trim().toLowerCase());
}

    }






