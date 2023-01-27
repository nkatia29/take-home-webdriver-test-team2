package webdriver_test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import static config.ConfigReader.getProperty;

public class ContextMenuPage {
   private WebDriver driver;
   private SoftAssert softAssert;
   private Actions actions;
    public ContextMenuPage(WebDriver driver, SoftAssert softAssert){
        this.driver = driver; this.softAssert = softAssert;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }



@FindBy(xpath = "//div[@id='hot-spot']")
    private WebElement box;



public void navigateContextMenu() {
    driver.get(getProperty("urlContextMenu"));
}


//ContextMenu: http://localhost:7080/context_menu Right-click in the box to see one called 'the-internet'. Test JavaScript alert text on Right-Click.
public void rightClickOnBox(){
    actions.contextClick(box).perform();
    Alert alert = driver.switchTo().alert();
    String alertStr= driver.switchTo().alert().getText();
    softAssert.assertEquals(alertStr.trim().toLowerCase(),"You selected a context menu".trim().toLowerCase());
    alert.accept();

}





}
