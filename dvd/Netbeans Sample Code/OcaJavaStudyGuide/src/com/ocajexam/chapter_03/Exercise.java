package com.ocajexam.chapter_03;

/**
 * Exercise 3-1
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class Exercise {

    public static void main(String[] args) {
        byte a;
        a = 10;
        System.out.println(a += 3);
        a = 15;
        System.out.println(a -= 3);
        a = 20;
        System.out.println(a *= 3);
        a = 25;
        System.out.println(a /= 3);
        a = 30;
        System.out.println(a %= 3);
        a = 35;
        // Optional as outside the scope of the exam
        System.out.println(a &= 3);
        a = 40;
        System.out.println(a ^= 3);
        a = 45;
        System.out.println(a |= 3);
        a = 50;
        System.out.println(a <<= 3);
        System.out.println(a >>= 3);
        a = 60;
        System.out.println(a >>>= 3);
       // End optional

    }
}
