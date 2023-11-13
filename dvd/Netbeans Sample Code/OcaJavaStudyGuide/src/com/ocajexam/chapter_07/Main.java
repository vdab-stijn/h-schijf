package com.ocajexam.chapter_07;

/**
 * Main
 *
 * @author Edward Finegan
 * @author Robert J. Liguori
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 1.0.0 07-11-15
 */
public class Main {

  public static void main(String[] args) {

    System.out.println("Starting...");
    System.out.println("Creating a bicycle...");
    Bicycle b = new Bicycle();
    b.setDegreeOfTurn(0);
    b.pedalRPM(50);
    System.out.println("Turning: " + b.getDegreeOfTurn());
    System.out.println("Wheel RPM: " + b.getWheelRPM());
    System.out.println("Creating a 10 speed bicycle...");
    TenSpeedBicycle tb = new TenSpeedBicycle();
    tb.setDegreeOfTurn(10);
    tb.setGearRatio(3f);
    tb.pedalRPM(40);
    System.out.println("Turning: " + tb.getDegreeOfTurn());
    System.out.println("Wheel RPM: " + tb.getWheelRPM());
  }
 
} 

