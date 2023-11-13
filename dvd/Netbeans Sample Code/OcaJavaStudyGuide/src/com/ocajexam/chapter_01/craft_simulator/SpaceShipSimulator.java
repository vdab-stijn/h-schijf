package com.ocajexam.chapter_01.craft_simulator;

import com.ocajexam.chapter_01.craft_simulator.SpaceShip.ShipType;

/**
 * Space Ship Simulator
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class SpaceShipSimulator {

  public static void main(String[] args) {
    // Create SpaceShip object with default ship type
    SpaceShip ship1 = new SpaceShip();
    // Prints "The pirate ship is a caravel ship."
    System.out.println(ship1);
    // Create SpaceShip object with specified ship type
    SpaceShip ship2 = new SpaceShip(ShipType.FRIGATE);
    // Prints "The pirate ship is a galleon ship."
    System.out.println(ship2);
  }
}
