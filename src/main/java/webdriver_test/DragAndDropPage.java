package webdriver_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static config.ConfigReader.getProperty;


public class DragAndDropPage {

    private WebDriver driver;
    private Actions actions;

    public DragAndDropPage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);

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

public void performDragAndDrop()  {

//Perform drag and drop
    actions.dragAndDrop(colA, colB).perform();//happens to quick, cannot see changes


}











}
