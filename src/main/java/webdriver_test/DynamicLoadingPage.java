package webdriver_test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import static config.ConfigReader.getProperty;

public class DynamicLoadingPage {
  private WebDriver driver;
  private SoftAssert softAssert;
  private WebDriverWait wait;

  public DynamicLoadingPage(WebDriver driver, SoftAssert softAssert){
      this.driver = driver; this.softAssert = softAssert;
      this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
      PageFactory.initElements(driver, this);
  }

@FindBy (xpath = "//button[normalize-space()='Start']")
private WebElement startBtn;
@FindBy (xpath  ="//h4[normalize-space()='Hello World!']")
private WebElement helloMsg;



public void navigateToLogInPage(){
      driver.get(getProperty("urlDynamicLoading"));
    }

//Dynamic Loading: http://localhost:7080/dynamic_loading/2 Test Dynamic Loading using Explict Waits.

public void  verifyDynamicLoading (){
   startBtn.click();
   softAssert.assertTrue(helloMsg.isDisplayed());

 }

}
