package utilities;


import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

import java.io.File;

public class Utilities {



    /* Get the latest file from a specific directory*/
    public static File getLatestFilefromDir(String dirPath){
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }


    public static void main(String[] args) {
       System.out.println ( getLatestFilefromDir("C:\\Users\\nkati\\Downloads").getName());

    }

    public static void logConsoleEntries (LogEntries logEntries) {
        for (LogEntry logEntry : logEntries) {
            System.out.println(String.valueOf(" Time Stamp: " + logEntry.getTimestamp()));
            System.out.println(String.valueOf(" Log Level: " + logEntry.getLevel()));
            System.out.println(String.valueOf(" Log Message: " + logEntry.getMessage()));
        }
    }

}


