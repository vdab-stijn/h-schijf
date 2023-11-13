package com.ocajexam.chapter_10;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Formatting Example
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 0.0.1 05-06-14
 */
public class FormattingExample {

  public static void main(String[] args) {
    ArrayList<DateTimeFormatter> ldtFormattersList = new ArrayList<>();
    ldtFormattersList.add(DateTimeFormatter.BASIC_ISO_DATE);
    ldtFormattersList.add(DateTimeFormatter.ISO_LOCAL_TIME);
    ldtFormattersList.add(DateTimeFormatter.ISO_LOCAL_DATE);
    ldtFormattersList.add(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    ldtFormattersList.add(DateTimeFormatter.ISO_TIME);
    ldtFormattersList.add(DateTimeFormatter.ISO_DATE);
    ldtFormattersList.add(DateTimeFormatter.ISO_DATE_TIME);
    ldtFormattersList.add(DateTimeFormatter.ISO_ORDINAL_DATE);
    LocalDateTime ldt = LocalDateTime.now();
    ldtFormattersList.forEach(c -> {
      System.out.println(ldt.format(c));
    });
  }
}
