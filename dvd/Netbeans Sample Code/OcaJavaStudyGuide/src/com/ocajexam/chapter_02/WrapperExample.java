package com.ocajexam.chapter_02;

/**
 * Wrapper Example
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class WrapperExample {

  public static void main(String[] args) {
    Boolean wrapperBoolean = new Boolean("true");
    // Boolean wrapperBoolean = Boolean.valueOf("true"); 
    
    /* Valid */
    boolean primitiveBoolean1 = wrapperBoolean.booleanValue();
    /* Valid because of unboxing */
    boolean primitiveBoolean2 = wrapperBoolean;
    if (wrapperBoolean) {
      System.out.println("Works because of unboxing");
    }
  }
}
