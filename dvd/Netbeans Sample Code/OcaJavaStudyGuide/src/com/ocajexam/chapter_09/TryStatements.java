package com.ocajexam.chapter_09;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Try Statements
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class TryStatements {

    public void demonstrateTryCatch() {
        try {
            int result = (3 / 0);
        } catch (ArithmeticException ae) {
            System.out.println(ae.getMessage());
            System.out.println(ae.toString());
            ae.printStackTrace();
        }
    }

    public void printMessage() {
        System.out.print("Jab");
    }

    public void demonstrateTryFinally1() {
        try {
            printMessage();
        } finally {
            System.out.println(" and Roundhouse ");
        }
    }

    public void demonstrateTryFinally2() {
        try {
            printMessage();
            System.exit(0);
        } finally {
            System.out.println(" and Uppercut ");
        }
    }

    public void demonstrateTryWithResources() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Number of apples: ");
            int apples = sc.nextInt();
            System.out.print("Number of oranges: ");
            int oranges = sc.nextInt();
            System.out.println("Pieces of Fruit: " + (apples + oranges));
        } catch (InputMismatchException ime) {
            ime.printStackTrace();
        }
    }

    public void demonstrateTryCatchFinally() {
        try {
        } catch (Exception e) {
        } finally {
        }
    }

    public void demonstrateMultiCatch1() {
        try {
            Random random = new Random();
            int i = random.nextInt(2);
            if (i == 0) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                throw new NullPointerException();
            }
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            aioobe.printStackTrace();
        } catch (NullPointerException nbe) {
            nbe.printStackTrace();
        }
    }

    public void demonstrateMultiCatch() {
        try {
            Random random = new Random();
            int i = random.nextInt(2);
            if (i == 0) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                throw new NullPointerException();
            }
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
