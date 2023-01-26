package webdriver_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static config.ConfigReader.getProperty;

public class DynamicLoading {
  private WebDriver driver;
  private SoftAssert softAssert;

  public DynamicLoading ( WebDriver driver, SoftAssert softAssert){
      this.driver = driver; this.softAssert = softAssert;
  }

@FindBy (tagName = "button")
private WebElement startBtn;
@FindBy (xpath  ="//h4[normalize-space()='Hello World!']")
private WebElement helloMsg;



public void navigateToLogInPage(){
      driver.get(getProperty("urlDynamicLoading"));
    }

//Dynamic Loading: http://localhost:7080/dynamic_loading/2 Test Dynamic Loading using Explict Waits.

public void  verifyDynamicLoading (){ //TODO: TEST IS FAILING
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
wait.until(ExpectedConditions.visibilityOf(startBtn));
softAssert.assertTrue(startBtn.isEnabled());
startBtn.click();
wait.until(ExpectedConditions.visibilityOf(helloMsg));
softAssert.assertTrue(helloMsg.isDisplayed());

 }

}
