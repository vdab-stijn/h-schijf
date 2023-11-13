package com.ocajexam.chapter_02;

/**
 * Bait Example
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class BaitExample {

    private enum ClamBait {
        FRESH, SALTED, ARTIFICIAL
    }

    public static void main(String[] args) {

        ClamBait bait = ClamBait.SALTED;
        switch (bait) {
            default:
                System.out.println("No bait");
                break;
            case FRESH:
                System.out.println("Fresh clams");
                break;
            case SALTED:
                System.out.println("Salted clams");
                break;
            case ARTIFICIAL:
                System.out.println("Artificial clams");
                break;

        }
    }
}
