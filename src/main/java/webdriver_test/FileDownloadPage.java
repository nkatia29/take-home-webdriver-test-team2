package webdriver_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import static config.ConfigReader.getProperty;
import static utilities.Utilities.getLatestFilefromDir;


public class FileDownloadPage {

    private WebDriver driver;
    private SoftAssert softAssert;

    public FileDownloadPage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'some-file.txt')]")
    private WebElement someFileLink;
//Test clicks on the file.
//Test asserts that the file is downloaded.

    public void navigateFileDownloadLink() {
        driver.get(getProperty("urlFileDownload"));
    }

    public void verifyFileDownloadLink() {
        someFileLink.click();
        boolean fileExists = getLatestFilefromDir("C:\\Users\\nkati\\Downloads").exists();
        softAssert.assertTrue(fileExists);


    }






}