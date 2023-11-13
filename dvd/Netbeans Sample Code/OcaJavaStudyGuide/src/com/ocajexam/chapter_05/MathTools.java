package com.ocajexam.chapter_05;

/**
 * MathTools
 *
 * @author Edward Finegan
 * @author Robert J. Liguori
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 1.0.0 07-11-15
 */
public class MathTools {

  public int findLowerValue(int number1, int number2) {
    int result;
    if (number1 < number2) {
      result = number1;
    } else {
      result = number2;
    }
    return result;
  }

  public double findLowerValue(double number1, double number2) {
    double result;
    if (number1 < number2) {
      result = number1;
    } else {
      result = number2;
    }
    return result;
  }

  public static void main(String[] args) {
    MathTools mTools = new MathTools();
    int x = 8;
    int y = 13;
    int lowestInt = mTools.findLowerValue(x, y);
    System.out.println("Result1 : " + lowestInt);
    System.out.println("Result2 : " + mTools.findLowerValue(x, y));
  }
}
