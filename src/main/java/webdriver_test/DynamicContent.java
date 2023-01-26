package webdriver_test;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class DynamicContent {

  private WebDriver driver;
  private SoftAssert softAssert;

  public DynamicContent (WebDriver driver, SoftAssert softAssert){
      this.driver = driver; this.softAssert = softAssert;
      PageFactory.initElements(driver, this);
  }



@FindBy (xpath = "//a[normalize-space()='click here']")
private WebElement clickHereBtn;
@FindBy (css = "div[class='large-10 columns large-centered'] div:nth-child(1) div:nth-child(1)")
private WebElement text;


public void navigatetoDynamicContentPage(){
   driver.get(ConfigReader.getProperty("urlDynamicContent"));
    }


//Dynamic Content: http://localhost:7080/dynamic_content Test content changes with page reload.



public void verifyContentChanges(){
    softAssert.assertTrue(clickHereBtn.isEnabled());
    clickHereBtn.click();
    String firstText = text.getText();
    clickHereBtn.click();
    String secondText = text.getText();
    softAssert.assertNotEquals(firstText, secondText, "Text are the same, test failed");


}


}
