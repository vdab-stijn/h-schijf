package com.ocajexam.chapter_09;

import java.util.ArrayList;

/**
 * Errors Tester
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class ErrorsTester {

    public void forceStackOverFlowError() {
        Integer counter = 0;
        ArrayList<Integer> unstoppable = new ArrayList<>();

        while (true) {
            unstoppable.add(counter);
            counter++;
            if (counter % 10000 == 0) {
                System.out.println(counter);
            }
        }
    }
}
