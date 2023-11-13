package com.ocajexam.chapter_11;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javafx.scene.paint.Color;

/**
 * Planet Predicates
 *
 * @author Robert J. Liguori
 * @author Edward Finegan
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 1.0.0 07-11-15
 */
public class PlanetPredicates {

  public static Predicate<Planet> hasMoonsMoreThan(Integer moons) {
    return p -> p.getNumberOfMoons() > moons;
  }

  public static Predicate<Planet> hasAColor() {
    return p -> p.getPrimaryColor() != Color.BLACK;
  }

  public static List<Planet> filterPlanets(List<Planet> planetList, Predicate<Planet> predicate) {
    return planetList.stream().filter(predicate).collect(Collectors.<Planet>toList());
  }

  public static StringBuilder listFilteredPlanets(List<Planet> planetList,
          Predicate<Planet> predicate) {
    StringBuilder planets = new StringBuilder();
    planetList.stream().filter((planet) -> (predicate.test(planet))).forEach((planet) -> {
      planets.append(planet).append(" ");
    });
// Alternate approach
// for (Planet planet : planetList) {
// if (predicate.test(planet)) {
// planets.append(planet).append(" ");
// }
// }
    return planets;
  }
}
