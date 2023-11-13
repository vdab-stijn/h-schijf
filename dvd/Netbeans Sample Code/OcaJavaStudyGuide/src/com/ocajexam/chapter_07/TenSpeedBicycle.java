package com.ocajexam.chapter_07;

/**
 * Ten Speed Bicycle
 *
 * @author Edward Finegan
 * @author Robert J. Liguori
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 1.0.0 07-11-15
 */
public class TenSpeedBicycle extends Bicycle {

  private float gearRatio = 2f;
  private float wheelRPM;

  public void setGearRatio(float gearRatio) {
    this.gearRatio = gearRatio;
  }

  public void pedalRPM(float pedalRPM) {
    this.wheelRPM = pedalRPM * gearRatio;
  }

  public float getWheelRPM() {
    return this.wheelRPM;
  }
}
