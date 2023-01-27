package webdriver_test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;


import java.util.List;

import static config.ConfigReader.getProperty;
import static java.awt.SystemColor.window;

public class FloatingMenuPage {
    private WebDriver driver;
    private SoftAssert softAssert;

    public FloatingMenuPage(WebDriver driver, SoftAssert softAssert){
        this.driver = driver; this.softAssert = softAssert;
        PageFactory.initElements(driver, this);
    }


@FindBy(xpath = "//div[@id='menu']/ul/li")
private List<WebElement> floatingMenuBtns;




public void navigateToFloatingPageLink(){
        driver.get(getProperty("urlFloatingMenu"));}


public void verifyFloatingMenu () throws InterruptedException {

    for (int i = 0; i < floatingMenuBtns.size(); i++) {
      softAssert.assertTrue(floatingMenuBtns.get(i).isDisplayed());
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 350);");
        Thread.sleep(2_000);
        jse.executeScript("scroll(0, -350);");
        Thread.sleep(2_000);
        break;
    }
}

}
