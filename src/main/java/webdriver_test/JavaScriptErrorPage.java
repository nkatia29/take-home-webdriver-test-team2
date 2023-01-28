package webdriver_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utilities.Utilities;

import static config.ConfigReader.getProperty;

public class JavaScriptErrorPage {

    LogEntries logEntries;
    private WebDriver driver;
    private SoftAssert softAssert;

    public JavaScriptErrorPage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver, this);
    }


 public void navigateJavaScriptErrorLink() {
 driver.get(getProperty("urlJavaScriptError"));
}



//Test asserts that the page contains error: Cannot read property 'xyz' of undefined.
public void logConsoleEntries (LogEntries logEntries) {
                 String errorMsg = null;
                for (LogEntry logEntry : logEntries) {
                   errorMsg = logEntry.getMessage();
                }
                softAssert.assertTrue(errorMsg.contains("Cannot read property 'xyz' of undefined"), "Error msg does not match");
                
        }

public void catchJavaScriptError()  {
            logEntries = driver.manage().logs().get(LogType.BROWSER);
            logConsoleEntries(logEntries);
            
        }
    }


















