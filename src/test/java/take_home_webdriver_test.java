import driver.Driver;
import org.checkerframework.checker.units.qual.C;
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
    CheckBoxes checkBoxes = new CheckBoxes (driver);
    checkBoxes.navigateToCheBoxesPage();
    checkBoxes.checkAndUncheckBoxes();
}
@Test
public void verifyContextMenuPage(){
   ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
   contextMenuPage.navigateContextMenu();contextMenuPage.rightClickOnBox();
}
@Test
public void verifyDragAndDropFunctions() throws InterruptedException {
    DragAndDrop dragAndDrop = new DragAndDrop(driver);
    dragAndDrop.navigatetoDragAndDropPage();dragAndDrop.performDragAndDrop();
}


@Test public void verifyDynamicControls(){
    DynamicControls dynamicControls = new DynamicControls(driver, softAssert);
    dynamicControls.navigatetoDynamicControlPage();
    dynamicControls.verifyEnableAndDisableSection();
    dynamicControls.verifyRemoveAndAddSection();

}

@Test
public void verifyDynamicContent(){
    DynamicContent dynamicContent = new DynamicContent(driver, softAssert);
    dynamicContent.navigatetoDynamicContentPage();dynamicContent.verifyContentChanges();
}

@Test public void verifyDynamicLoading(){
    DynamicLoading dynamicLoading = new DynamicLoading(driver, softAssert);
    dynamicLoading.navigateToLogInPage();dynamicLoading.verifyDynamicLoading();
}






}
