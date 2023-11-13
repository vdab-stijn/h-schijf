package com.ocajexam.chapter_07;

/**
 * Bicycle 
 *
 * @author Edward Finegan
 * @author Robert J. Liguori
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 1.0.0 07-11-15
 */
public class Bicycle {

  private float wheelRPM;
  private int degreeOfTurn;

  public void pedalRPM(float pedalRPM) {
    float gearRatio = 2f;
    this.wheelRPM = pedalRPM * gearRatio;
  }

  public void setDegreeOfTurn(int degreeOfTurn) {
    this.degreeOfTurn = degreeOfTurn;
  }

  public float getWheelRPM() {
    return this.wheelRPM;
  }

  public int getDegreeOfTurn() {
    return this.degreeOfTurn;
  }
}
