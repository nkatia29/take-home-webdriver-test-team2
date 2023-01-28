package webdriver_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static config.ConfigReader.getProperty;


public class DragAndDropPage {

    private WebDriver driver;
    private Actions actions;
    private Actions builder;

    public DragAndDropPage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver); this.builder = new Actions(driver);

        PageFactory.initElements(driver, this);
    }
//Drag and Drop: http://localhost:7080/drag_and_drop Perofrm Drag And Drop in a Webdriver test.


@FindBy (id = "column-a")
    private WebElement colA;

@FindBy (xpath = "(//div[@class='column'])[2]")
    private WebElement colB;

public void navigatetoDragAndDropPage(){
    driver.get(getProperty("urlDragAndDrop"));
}

//Drag and Drop: http://localhost:7080/drag_and_drop Perofrm Drag And Drop in a Webdriver test

public void performDragAndDrop() throws InterruptedException {

//Perform drag and drop
    final Actions action = new Actions(driver);
    action.clickAndHold(colB)
            .moveByOffset(-1, -1) // To fix issue with drag and drop in Chrome V61.0.3163.79
            .moveToElement(colA, colA.getLocation().getX()+colA.getSize().getWidth()/2, colA.getLocation().getY()+colA.getSize().getHeight()/2)
            .release(colA)
            .build()
            .perform();
}











}
