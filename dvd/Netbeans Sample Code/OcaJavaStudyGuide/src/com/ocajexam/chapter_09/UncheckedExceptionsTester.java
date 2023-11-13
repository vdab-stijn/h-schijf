package com.ocajexam.chapter_09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * Unchecked Exceptions Tester
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class UncheckedExceptionsTester {

  // Thrown to indicate that a method has been passed an illegal or inappropriate argument.
  public void forceIllegalArgumentException() {
    // IllegalArgumentException 
    int s = 1;
   // Path path = Paths.get(s);
  }

  // Thrown to indicate that the application has attempted to convert a string to one of the numeric types, but that the string does not have the appropriate format.
  public void forceNumberFormatException() {
    Double.parseDouble("2.1"); 
    Double.parseDouble("INVALID");  // NumberFormatException
  }

  // Thrown to indicate that an array has been accessed with an illegal index. The index is either negative or greater than or equal to the size of the array.
  public void forceArrayIndexOutOfBoundsException() {
    Float[][] num = new Float[2][3];
    num[2][0] = (float)1.0;
    num[2][1] = (float)2.0;
    System.out.println(num[2][2]); // VALID
    System.out.println(num[2][3]);  // ArrayIndexOutOfBoundsException
  }

  // Thrown to indicate that an index of some sort (such as to an array, to a string, or to a vector) is out of range. 
  public void forceIndexOutOfBoundsException() {
    LinkedList gorillaSpecies = new LinkedList();
    gorillaSpecies.add("Eastern");
    gorillaSpecies.add("Western");
    System.out.println(gorillaSpecies.get(1)); 
    System.out.println(gorillaSpecies.get(2)); // IndexOutOfBoundsException
  }

  // Thrown when an application attempts to use null in a case where an object is required.
  public void forceNullPointerException() {
    String iceCreamFlavor = "vanilla";
    iceCreamFlavor = null;
    System.out.println(iceCreamFlavor.length());  // NullPointerException
  }

  // Signals that a method has been invoked at an illegal or inappropriate time. In other words, the Java environment or Java application is not in an appropriate state for the requested operation.
  public void forceIllegalStateException() {
    ArrayList chord = new ArrayList();
    chord.add("D");
    chord.add("G");
    chord.add("B");
    chord.add("G");
    Iterator it = chord.iterator();
    while (it.hasNext()) {
      it.next();
      it.remove();
      it.remove(); // IllegalStateException (remove depends on next)
    }
  }

  // Thrown to indicate that the code has attempted to cast an object to a subclass of which it is not an instance.
  public void forceClassCastException() {
    Object x = new Float("1.0");
    System.out.println((Double) x);
    System.out.println((String) x); // ClassCastException
  }

  // Thrown when an exceptional arithmetic condition has occurred. 
  public void forceArithmeticException() {
    int apple;
    apple = (4 / 2); 
    apple = (4 / 0); // ArithmeticException 
  }
}