//Exercise 1-1
package com.ocajexam.chapter_01;

import java.io.*;
import java.text.*;
import java.util.*;
import java.util.logging.*;

/**
 * Test Class
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class TestClass {

    public static void main(String[] args) throws IOException {
        /* Ensure directory has been created */
        new File("logs").mkdir();
        /* Get the date to be used in the filename */
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        Date now = new Date();
        String date = df.format(now);
        /* Set up the filename in the logs directory */
        String logFileName = "logs\\testlog-" + date + ".txt";
        /* Set up Logger */
        FileHandler myFileHandler = new FileHandler(logFileName);
        myFileHandler.setFormatter(new SimpleFormatter());
        Logger ocajLogger = Logger.getLogger("OCAJ Logger");
        ocajLogger.setLevel(Level.ALL);
        ocajLogger.addHandler(myFileHandler);
        /* Log Message */
        ocajLogger.info("\nThis is a logged information message.");
        /* Close the file */
        myFileHandler.close();
    }
}
 
