package com.ocajexam.chapter_11.water;

/**
 * WaterSort
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 1.0.0 07-11-15
 */
import java.util.Comparator;
// Class with sorting algorithm

public class WaterSort implements Comparator<Water> {

    @Override
    public int compare(Water w1, Water w2) {
        return w1.getSource().compareTo(w2.getSource());
    }
}
