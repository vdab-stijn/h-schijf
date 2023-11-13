package com.ocajexam.chapter_11.water;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * WaterApp
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 1.0.0 07-11-15
 */
public class WaterApp {

  public static void main(String[] args) {
    Water hardWater = new Water("Hard");
    Water softWater = new Water("Soft");
    Water boiledWater = new Water("Boiled");
    Water rawWater = new Water("Raw");
    Water rainWater = new Water("Rain");
    Water snowWater = new Water("Snow");
    Water filteredWater = new Water("Filtered");
    Water reverseOsmosisWater = new Water("Reverse Osmosis");
    Water deionizedWater = new Water("Deionized");
    Water distilledWater = new Water("Distilled");
    // List of Water types
    List<Water> waterList = new ArrayList<>();
    waterList.add(hardWater);
    waterList.add(softWater);
    waterList.add(boiledWater);
    waterList.add(rawWater);
    waterList.add(rainWater);
    waterList.add(snowWater);
    waterList.add(filteredWater);
    waterList.add(reverseOsmosisWater);
    waterList.add(deionizedWater);
    waterList.add(distilledWater);
    // Without Sort
    System.out.println("Not Sorted: " + waterList);
    // With Sort
    WaterSort waterSort = new WaterSort();
    Collections.sort(waterList, waterSort);
    System.out.println("Sorted: " + waterList);

    // Comparator Sorted
    Comparator<Water> waterSort2 = (Water w1, Water w2)
            -> w1.getSource().compareTo(w2.getSource());
    Collections.sort(waterList, waterSort2);
    System.out.println("Inline Comparator Sorted: " + waterList);

    // With Lambda
    Collections.sort(waterList, (w1, w2)
            -> w1.getSource().compareTo(w2.getSource()));
    System.out.println("\u03BB Sorted: " + waterList);
  }
}
