package com.ocajexam.chapter_02;

import java.util.Random;

/**
 * RandomFish Example
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class RandomFish {

    public String generateRandomFish() {
        String randomFish;
        Random randomObject = new Random();
        int randomNumber = randomObject.nextInt(5);
        switch (randomNumber) {
            case 0:
                randomFish = "Blue Fish";
                break;
            case 1:
                randomFish = "Red Drum";
                break;
            case 2:
                randomFish = "Striped Bass";
                break;
            case 3:
                randomFish = "Tautog";
                break;
            default:
                randomFish = "Unknown Fish Type";
                break;
        }
        return randomFish;
    }

    public static void main(String[] args) {
        RandomFish rf = new RandomFish();
        System.out.println(rf.generateRandomFish());
    }
}
