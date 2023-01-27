package webdriver_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utilities.Utilities;

import java.io.File;

import static config.ConfigReader.getProperty;
import static utilities.Utilities.isFileDownloaded;

public class FileDownloadPage {

    private WebDriver driver;
    private SoftAssert softAssert;

    public FileDownloadPage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='some-file.txt']")
    private WebElement someTextBtn;
//Test clicks on the file.
//Test asserts that the file is downloaded.

    public void fileDownloadLink() {
        driver.get(getProperty("urlFileDownload"));
    }

    public void verifyFileDownloadLink() {
        someTextBtn.click();
        String filePath ="C:\Users\nkati\Downloads\some-file.txt";
        softAssert.assertTrue(isFileDownloaded(filePath, "file"));
    }






}