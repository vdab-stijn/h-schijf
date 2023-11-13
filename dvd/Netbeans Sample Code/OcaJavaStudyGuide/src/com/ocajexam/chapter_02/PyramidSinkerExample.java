package com.ocajexam.chapter_02;

/**
 * Pyramid Sinker Example
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class PyramidSinkerExample {

    public static void main(String[] args) {
        int pyramidSinker = 3;
        System.out.print("A pyramid sinker that weighs " + pyramidSinker
                + " ounces is ");
        if (pyramidSinker == 2) {
            System.out.print("used for a slow moving tide. ");
        } else if (pyramidSinker == 3) {
            System.out.print("used for a moderate moving tide. ");
        } else if (pyramidSinker == 4) {
            System.out.print("used for a fast moving tide. ");
        }
    }
}
