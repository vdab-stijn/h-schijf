package com.ocajexam.chapter_11.water;

/**
 * Water
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 1.0.0 07-11-15
 */
public class Water {

  private String source;

  public Water(String source) {
    this.source = source;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String toString() {
    return this.source;
  }
}