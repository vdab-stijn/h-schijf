package com.ocajexam.chapter_09;

import java.util.ArrayList;
import java.util.List;

/**
 * Main
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class Main {

  public static void testMethod1() {
    try {
      testMethod2();
    } catch (Throwable ex) {
      System.out.println("Hickory");
    }
  }

  public static void testMethod2() throws ArithmeticException, Throwable {
    try {
      testMethod3();
    } catch (ArithmeticException ex) {
      System.out.println("Dickory");
    }
  }

  public static void testMethod3() throws Throwable, Error, Exception, RuntimeException {
    //   System.out.println("Dock");
  }

  public static void test() throws Exception {
  }

  public static void main(String[] args) {

    ClassCastException i = new ClassCastException();


    /*
     * ErrorsTester e = new ErrorsTester();
     *
     * e.forceStackOverFlowError();
     *
     */
    List<String> a = new ArrayList<>();

    UncheckedExceptionsTester u = new UncheckedExceptionsTester();

    try {
      u.forceIllegalArgumentException();
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {

      u.forceNumberFormatException();

    } catch (Exception e) {
      e.printStackTrace();

    }
    try {

      u.forceArrayIndexOutOfBoundsException();

    } catch (Exception e) {
      e.printStackTrace();
    }
    try {

      u.forceIndexOutOfBoundsException();

    } catch (Exception e) {
      e.printStackTrace();
    }
    try {

      u.forceNullPointerException();

    } catch (Exception e) {
      e.printStackTrace();
    }
    try {

      u.forceIllegalStateException();

    } catch (Exception e) {
      e.printStackTrace();
    }
    try {

      u.forceClassCastException();

    } catch (Exception e) {
      e.printStackTrace();
    }
    try {

      u.forceArithmeticException();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
