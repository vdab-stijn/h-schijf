package com.ocajexam.chapter_04;

/**
 * Thermostat
 *
 * @author Edward Finegan
 * @author Robert J. Liguori
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 1.0.0 07-11-15
 */
class Thermostat {

  int temperatureTrigger;

  int getTemperatureTrigger() {
    return temperatureTrigger;
  }

  public void setTemperatureTrigger(int temperatureTrigger) {
    this.temperatureTrigger = temperatureTrigger;
  }

  public static void main(String[] args) {
    Thermostat houseThermostat = new Thermostat();
    houseThermostat.setTemperatureTrigger(68);
    System.out.println(houseThermostat.getTemperatureTrigger());
  }
}
