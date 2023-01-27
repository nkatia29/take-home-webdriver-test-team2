package webdriver_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import static config.ConfigReader.getProperty;

public class DynamicLoadingPage {
  private WebDriver driver;
  private SoftAssert softAssert;

  public DynamicLoadingPage(WebDriver driver, SoftAssert softAssert){
      this.driver = driver; this.softAssert = softAssert;
  }

@FindBy (xpath = "//button[normalize-space()='Start']")
private WebElement startBtn;
@FindBy (xpath  ="//h4[normalize-space()='Hello World!']")
private WebElement helloMsg;



public void navigateToLogInPage(){
      driver.get(getProperty("urlDynamicLoading"));
    }

//Dynamic Loading: http://localhost:7080/dynamic_loading/2 Test Dynamic Loading using Explict Waits.

public void  verifyDynamicLoading (){ //TODO: TEST IS FAILING
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
startBtn.click();
//wait.until(ExpectedConditions.visibilityOf(helloMsg));
softAssert.assertTrue(helloMsg.isDisplayed());

 }

}
