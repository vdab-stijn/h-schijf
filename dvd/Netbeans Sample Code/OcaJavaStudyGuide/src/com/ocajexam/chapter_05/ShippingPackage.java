package com.ocajexam.chapter_05;

/**
 * Shipping Package
 *
 * @author Edward Finegan
 * @author Robert J. Liguori
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 1.0.0 07-11-15
 */
public class ShippingPackage {

  public static int nextTrackingNumber = 100000;
  private int packageTrackingNumber;

  public ShippingPackage() {
    this.packageTrackingNumber = nextTrackingNumber;
    nextTrackingNumber++;
  }

  public int getPackageTrackingNumber() {
    return packageTrackingNumber;
  }

  public static void main(String[] args) {
    ShippingPackage packageOne = new ShippingPackage();
    ShippingPackage packageTwo = new ShippingPackage();
    ShippingPackage packageThree = new ShippingPackage();

    System.out.println("Package One Tracking Number: "
            + packageOne.getPackageTrackingNumber());
    System.out.println("Package Two Tracking Number: "
            + packageTwo.getPackageTrackingNumber());
    System.out.println("Package Three Tracking Number: "
            + packageThree.getPackageTrackingNumber());

    System.out.println("Next Tracking Number: "
            + ShippingPackage.nextTrackingNumber);
  }

}
