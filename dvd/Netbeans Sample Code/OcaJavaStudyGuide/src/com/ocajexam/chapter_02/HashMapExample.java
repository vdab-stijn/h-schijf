package com.ocajexam.chapter_02;

import java.util.HashMap;

/**
 * HashMap Example
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class HashMapExample {

    public static void main(String[] args) {
        HashMap<String, String> leftHand = new HashMap<String, String>();
        leftHand.put("Thumb", null);
        leftHand.put("Index finger", "Puzzle Ring");
        leftHand.put("Middle finger", null);
        leftHand.put("Ring finger", "Engagement Ring");
        leftHand.put("Little finger", "Pinky Ring");
        // Iteration statement
        for (String s : leftHand.keySet()) {
            // Conditional statement
            if (s.equals("Little finger")) {
                System.out.println(s + " had a " + leftHand.get(s));
                // Expression Statement
                leftHand.put("Little finger", "Engineer's Ring");
                System.out.println(s + " has an " + leftHand.get(s));
            }
        }
    }
}
