package webdriver_test;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class InframePage {
    private WebDriver driver;
    private SoftAssert softAssert;

    public InframePage(WebDriver driver, SoftAssert softAssert){
        this.driver = driver; this.softAssert = softAssert;
        PageFactory.initElements(driver, this);

    }

@FindBy(xpath = "//span[@class='tox-mbtn__select-label']")
private List<WebElement> switches;
@FindBy(xpath = "//iframe[@id='mce_0_ifr']")
private WebElement textBox;
@FindBy(xpath = "//*[name()='path' and contains(@d,'M17.3 8.2L')]")
private WebElement xBtn;

public void navigateToInframeLink(){
        driver.get(ConfigReader.getProperty("urlInframe"));
}



//Test switches to Iframe and types some text.
//Test asserts that the typed text is as expected.

public void TestSwitches() throws InterruptedException {
    for (int i = 0; i < switches.size(); i++) {
        driver.switchTo().frame(i);

    }
    Thread.sleep(3_000);
//    xBtn.click();
    textBox.clear();
    textBox.sendKeys("test");
    softAssert.assertEquals(textBox.getText(), "test", "test message does not match");
}



}
