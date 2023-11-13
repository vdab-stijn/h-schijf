package com.ocajexam.chapter_11;

import javafx.scene.paint.Color;

/**
 * Planet
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 1.0.0 07-11-15
 */
public class Planet {

  private String name = "Unknown";
  private Color primaryColor = Color.WHITE;
  private Integer numberOfMoons = 0;
  private Boolean ringed = false;

  public Planet(String name, Color primaryColor, Integer numberOfMoons, Boolean ringed) {
    this.name = name;
    this.primaryColor = primaryColor;
    this.numberOfMoons = numberOfMoons;
    this.ringed = ringed;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Color getPrimaryColor() {
    return primaryColor;
  }

  public void setPrimaryColor(Color primaryColor) {
    this.primaryColor = primaryColor;
  }

  public Integer getNumberOfMoons() {
    return numberOfMoons;
  }

  public void setNumberOfMoons(Integer numberOfMoons) {
    this.numberOfMoons = numberOfMoons;
  }

  public Boolean isRinged() {
    return ringed;
  }

  public void setRinged(Boolean ringed) {
    this.ringed = ringed;
  }

  public String toString() {
    return this.name;
  }
}
