package dev.augustohdias.mars.models.entities;

import java.util.Arrays;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Direction {
  North("N"),
  East("E"),
  South("S"),
  West("W");

  @Getter
  private final String value;

  public static Optional<Direction> get(String directionString) {
    return Arrays.stream(Direction.values()).filter(direction -> direction.value.equals(directionString)).findAny();
  }
}
