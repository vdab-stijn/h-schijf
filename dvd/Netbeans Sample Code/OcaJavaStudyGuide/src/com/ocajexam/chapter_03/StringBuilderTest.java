package com.ocajexam.chapter_03;

/**
 * StringBuilderTest
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class StringBuilderTest {

    public static void main(String[] args) {

        StringBuilder e = new StringBuilder("Examples:");

        // Append
        e.append(" ").append("1"); // String 
        e.append(" ").append(new StringBuffer("2"));
        e.append(" ").append('\u0031'); // char 
        e.append(" ").append((int) 2); // int 
        e.append(" ").append(1L); // long 
        e.append(" ").append(2F); // float 
        e.append(" ").append(1D); // double  
        e.append(" ").append(true); // true  
        /* Prints out "Examples: 1 2 1 2 1 2.0 1.0 true" */
        System.out.println(e);

        // Insert
        StringBuilder mateyMessage1 = new StringBuilder("Shiver Me Timbers!");
        /* Prints out "Shiver Me Timbers and Bricks! */
        System.out.println(mateyMessage1.insert(17, " and Bricks"));

        // delete
        StringBuilder d = new StringBuilder("Shiver Me Timbers!");
        /* Prints out "Shivers!" */
        System.out.println(d.delete(6, 16));

        // deleteCharAt
        StringBuilder dca = new StringBuilder("Shiver Me Timbers!");
        /* Removes the '!' and prints out "Shiver Me Timbers" */
        System.out.println(dca.deleteCharAt(17));

        // reverse
        StringBuilder r = new StringBuilder("part");
        r.reverse();
        /* Prints out "It's a trap!" */
        System.out.println("It's a " + r + "!");

    }
}
