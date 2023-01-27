package webdriver_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static config.ConfigReader.getProperty;

public class CheckBoxesPage {
  private WebDriver driver;

  public CheckBoxesPage(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver, this);
  }
@FindBy (xpath = "//input[1]")
private WebElement checkBox_1;
@FindBy (xpath = "//input[2]")
private WebElement checkBox_2;


public void navigateToCheBoxesPage(){
      driver.get(getProperty("urlCheckBoxes"));
  }
 //CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes

public void checkAndUncheckBoxes(){
 if(!checkBox_1.isSelected()){
     checkBox_1.click();
 }
 if(checkBox_2.isSelected()){
     checkBox_2.click();
 }
}

}
