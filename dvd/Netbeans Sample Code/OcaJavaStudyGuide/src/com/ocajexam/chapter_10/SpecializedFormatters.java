package com.ocajexam.chapter_10;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * Specialized Formatters
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class SpecializedFormatters {

  public static void main(String[] args) {
    String[] minutes = {"m", "mm"};
    String[] hours = {"h", "hh"};
    String[] days = {"d", "dd"};
    String[] months = {"M", "MM", "MMM", "MMMM", "MMMMM"};
    String[] years = {"y", "yy", "yyyy"};
    String converts = "\u2192"; // Right arrow
    LocalDateTime ldt = LocalDateTime.parse("2015-01-01T01:01:01");

    System.out.print("Hours: ");
    Arrays.asList(hours)
            .forEach(p -> {
              System.out.print(p + converts + ldt.format(DateTimeFormatter.ofPattern(p)) + " ");
            }
            );
    System.out.print(
            "\nMinutes: ");
    Arrays.asList(minutes)
            .forEach(p -> {
              System.out.print(p + converts + ldt.format(DateTimeFormatter.ofPattern(p)) + " ");
            }
            );
    System.out.print(
            "\nMonths: ");
    Arrays.asList(months)
            .forEach(p -> {
              System.out.print(p + converts + ldt.format(DateTimeFormatter.ofPattern(p)) + " ");
            }
            );
    System.out.print(
            "\nDays: ");
    Arrays.asList(days)
            .forEach(p -> {
              System.out.print(p + converts + ldt.format(DateTimeFormatter.ofPattern(p)) + " ");
            }
            );
    System.out.print(
            "\nYears: ");
    Arrays.asList(years)
            .forEach(p -> {
              System.out.print(p + converts + ldt.format(DateTimeFormatter.ofPattern(p)) + " ");
            }
            );

  }

}
