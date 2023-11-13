package com.ocajexam.chapter_01;

import java.util.Properties;

/**
 * Properties Manager
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class PropertiesManager {

  public static void main(String[] args) {
    if (args.length == 0) {
      System.exit(0);
    }
    Properties props = System.getProperties();
    /* New property example */
    props.setProperty("new_property2", "new_value2");
    switch (args[0]) {
      case "-list_all":
        props.list(System.out); // Lists all properties
        break;
      case "-list_prop":
        /* Lists value */
        System.out.println(props.getProperty(args[1]));
        break;
      default:
        System.out.println("Usage: java PropertiesManager [-list_all]");
        System.out.println(" java PropertiesManager [-list_prop [property]]");
        break;
    }
  }
}
