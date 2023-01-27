package webdriver_test;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class DynamicControlsPage {

    private WebDriver driver;
    private SoftAssert softAssert;

    public DynamicControlsPage(WebDriver driver, SoftAssert softAssert){
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver, this);
    }


@FindBy (xpath = "//input[@type='checkbox']")
private WebElement checkBox;
@FindBy (xpath = "//button[normalize-space()='Remove']" )
private  WebElement removeBtn;
@FindBy (xpath = "//button[normalize-space()='Add']")
private WebElement addBtn;
@FindBy (id ="message")
private WebElement msg;

@FindBy(xpath = "//button[normalize-space()='Enable']")
private WebElement enableBtn;
@FindBy (xpath = "//button[normalize-space()='Disable']")
private WebElement disableBtn;



public void navigatetoDynamicControlPage(){
        driver.get(ConfigReader.getProperty("urlDynamicControl"));
}

//Dynamic Controls: http://localhost:7080/dynamic_controls Test Dynamic Controls using Explicit Waits.

public void verifyRemoveAndAddSection(){
    checkBox.click();
    softAssert.assertTrue(checkBox.isSelected());
    softAssert.assertTrue(removeBtn.isEnabled());
    removeBtn.click();
    softAssert.assertEquals(msg.getText().trim().toLowerCase(), "It's gone!".trim().toLowerCase(), "Message is not correct");
    softAssert.assertTrue(addBtn.isEnabled());
    addBtn.click();
    softAssert.assertEquals(msg.getText().trim().toLowerCase(),"It's back!".trim().toLowerCase(), "Message is not correct");


}
public void verifyEnableAndDisableSection(){
    softAssert.assertTrue(enableBtn.isEnabled());
    enableBtn.click();
    softAssert.assertEquals(msg.getText().trim().toLowerCase(), "It's enabled!".trim().toLowerCase(), "message is not correct");
    softAssert.assertTrue(disableBtn.isEnabled());
    disableBtn.click();
    softAssert.assertEquals(msg.getText().trim().toLowerCase(), "It's disabled!".trim().toLowerCase(), "message is not correct");

}


}
