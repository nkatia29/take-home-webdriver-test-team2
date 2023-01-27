package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class Utilities {




public static Actions actionBuilder(WebDriver driver){

    return  new Actions(driver);
    }

public static boolean isFileDownloaded(String fileDownloadpath, String fileName) {

    boolean flag = false;

    File directory = new File(fileDownloadpath);

    File[] content = directory.listFiles();

    for (int i = 0; i < content.length; i++) {
        if (content[i].getName().equals(fileName))
            return flag = true;
    }
    return flag;


}








}


