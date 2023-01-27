import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import webdriver_test.*;

public class take_home_webdriver_test {
private WebDriver driver;
private SoftAssert softAssert;


@BeforeMethod
    public void SetUp(){
    driver = Driver.getDriver();
    softAssert = new SoftAssert();
}
@AfterMethod
    public void tearDown(){
    Driver.quitDriver();
    softAssert.assertAll();
}

@Test
public void verifylogin(){
    LoginPage loginPage = new LoginPage(driver, softAssert);

    loginPage.navigateToLogInPage();loginPage.loginSuccess();
    }

@Test
public void verifyLoginFailure(){
    LoginPage loginPage = new LoginPage(driver, softAssert);
    loginPage.navigateToLogInPage(); loginPage.loginFailure();
}
@Test
public void verifyCheckBoxes() throws InterruptedException {
    CheckBoxesPage checkBoxes = new CheckBoxesPage(driver);
    checkBoxes.navigateToCheBoxesPage();
    checkBoxes.checkAndUncheckBoxes();
}
@Test
public void verifyContextMenuPage(){
   ContextMenuPage contextMenuPage = new ContextMenuPage(driver, softAssert);
   contextMenuPage.navigateContextMenu();contextMenuPage.rightClickOnBox();
}
@Test
public void verifyDragAndDropFunctions() throws InterruptedException {
    DragAndDropPage dragAndDrop = new DragAndDropPage(driver);
    dragAndDrop.navigatetoDragAndDropPage();dragAndDrop.performDragAndDrop();
}


@Test public void verifyDynamicControls(){
    DynamicControlsPage dynamicControls = new DynamicControlsPage(driver, softAssert);
    dynamicControls.navigatetoDynamicControlPage();
    dynamicControls.verifyEnableAndDisableSection();
    dynamicControls.verifyRemoveAndAddSection();

}

@Test
public void verifyDynamicContent(){
    DynamicContentPage dynamicContent = new DynamicContentPage(driver, softAssert);
    dynamicContent.navigatetoDynamicContentPage();dynamicContent.verifyContentChanges();
}

@Test public void verifyDynamicLoading(){
    DynamicLoadingPage dynamicLoading = new DynamicLoadingPage(driver, softAssert);
    dynamicLoading.navigateToLogInPage();dynamicLoading.verifyDynamicLoading();
}






}
