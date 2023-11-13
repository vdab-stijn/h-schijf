package com.ocajexam.chapter_01.craft_simulator;

/**
 * Space Ship
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class SpaceShip extends Ship implements Dockable {
// Data Members

    public enum ShipType {

        FRIGATE, BATTLESHIP, MINELAYER, ESCORT, DEFENSE
    }
    ShipType shipType = ShipType.ESCORT;
// Constructors

    public SpaceShip() {
        System.out.println("\nSpaceShip created with default ship type.");
    }

    public SpaceShip(ShipType shipType) {
        System.out.println("\nSpaceShip created with specified ship type.");
        this.shipType = shipType;
    }
// Methods

    @Override
    public void dockShip() {
// TODO
    }

    @Override
    public String toString() {
        String shipTypeRefined = this.shipType.name().toLowerCase();
        return "The pirate ship is a " + shipTypeRefined + " ship.";
    }
}
