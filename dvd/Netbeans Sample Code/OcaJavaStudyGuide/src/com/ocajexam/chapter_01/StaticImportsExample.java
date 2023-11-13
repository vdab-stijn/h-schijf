package com.ocajexam.chapter_01;

// import static java.util.Locale.*;
/* Import static member ITALY */
import static java.util.Locale.ITALY;
/* Import static member GERMANY */
import static java.util.Locale.GERMANY;

/**
 * Static Imports Example
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class StaticImportsExample {

    public static void main(String[] args) {

        System.out.println("Locale: " + ITALY); // Prints "Local: it_IT"

        /* Imports all static members in class Locale */
        System.out.println("Locale: " + ITALY); // Prints "Local: it_IT"
        System.out.println("Locale: " + GERMANY); // Prints "Local: de_DE"
    }

}
