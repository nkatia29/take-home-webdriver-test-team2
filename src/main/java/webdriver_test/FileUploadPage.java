package webdriver_test;


import jdk.jfr.Timespan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static config.ConfigReader.getProperty;


public class FileUploadPage {

    private WebDriver driver;
    private SoftAssert softAssert;

    public FileUploadPage(WebDriver driver, SoftAssert softAssert){
        this.driver = driver; this.softAssert = softAssert;
        PageFactory.initElements(driver, this);
    }

@FindBy (name = "file")
private WebElement chooseFileBtn;
@FindBy (className = "button")
private WebElement uploadBtn;
@FindBy (xpath = "//h3[contains(text(),'File Uploaded!')]")
private  WebElement fileUploadedSign;




//Test uses Upload Button or Drag and Drop to upload a file.
//Test asserts that the file is uploaded.



public void navigateToFileUploasedLink(){
     driver.get(getProperty("urlFileUpload"));
    }



public void UploadFileTest() throws InterruptedException {// must have input and file
    softAssert.assertTrue(chooseFileBtn.isEnabled());
    chooseFileBtn.isSelected();
    chooseFileBtn.sendKeys("C:\\Users\\nkati\\OneDrive\\Desktop\\Test.rtf");
    Thread.sleep(5_000);
    uploadBtn.click();
    softAssert.assertTrue(fileUploadedSign.isDisplayed());


}



}
