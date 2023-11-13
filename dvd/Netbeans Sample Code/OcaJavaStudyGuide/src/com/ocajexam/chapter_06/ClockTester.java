package com.ocajexam.chapter_06;

/**
 * Clock Tester
 *
* @author Edward Finegan
 * @author Robert J. Liguori
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class ClockTester {

  public static void main(String[] args) {
    String[] clockTypes = {"Wrist Watch", "Desk Clock", "Wall Clock"};
    String[] newClockTypes = new String[2];
    System.arraycopy(clockTypes, 1, newClockTypes, 0, 2);
    for (String s : clockTypes) {
      System.out.println(s);
    }
    System.out.println("------");
    for (String s : newClockTypes) {
      System.out.println(s);
    }
  }
}
