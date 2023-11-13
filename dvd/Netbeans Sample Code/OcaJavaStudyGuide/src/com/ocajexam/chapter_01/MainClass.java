package com.ocajexam.chapter_01;

/* Imports class ArrayList from the java.util package */
import java.util.ArrayList;
/* Imports all classes from the java.io package */
import java.io.*;

/**
 * Main Class
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class MainClass {

    public static void main(String[] args) {
        /* Creates console from java.io package */
        Console console = System.console();  // Don't invoke in NetBeans
        String planet = console.readLine("\nEnter your favorite planet: ");
        /* Creates list for planets */
        ArrayList planetList = new ArrayList();
        planetList.add(planet); // Adds users input to the list
        planetList.add("Gliese 581 c"); // Adds a string to the list
        System.out.println("\nTwo cool planets: " + planetList);
    }
}
