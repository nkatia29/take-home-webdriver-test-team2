package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Utilities {




public static Actions actionBuilder(WebDriver driver){
     return  new Actions(driver);
    }



}
