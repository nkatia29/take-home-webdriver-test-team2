package webdriver_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static config.ConfigReader.getProperty;
import static utilities.Utilities.actionBuilder;

public class DragAndDropPage {

    private WebDriver driver;

    public DragAndDropPage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
//Drag and Drop: http://localhost:7080/drag_and_drop Perofrm Drag And Drop in a Webdriver test.


@FindBy (id = "column-a")
    private WebElement colA;

@FindBy (id = "column-b")
    private WebElement colB;

public void navigatetoDragAndDropPage(){
    driver.get(getProperty("urlDragAndDrop"));
}

//Drag and Drop: http://localhost:7080/drag_and_drop Perofrm Drag And Drop in a Webdriver test

public void performDragAndDrop() throws InterruptedException {

    actionBuilder(driver);
//Perform drag and drop
    actionBuilder(driver).dragAndDrop(colA, colB).perform();//happens to quick, cannot see changes
    Thread.sleep(2_000);
    actionBuilder(driver).dragAndDrop(colB, colA);

}











}
