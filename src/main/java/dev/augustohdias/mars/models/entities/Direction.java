package dev.augustohdias.mars.models.entities;

import java.util.Arrays;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;

/** Enum representation of {@link Probe}'s supported directions. */
@AllArgsConstructor
public enum Direction {
  NORTH('N'),
  EAST('E'),
  SOUTH('S'),
  WEST('W');

  @Getter private final Character value;

  /**
   * Maybe provides a direction.
   *
   * @param directionString Desired direction value.
   * @return A direction, if exists. Empty otherwise.
   */
  public static Optional<Direction> get(Character directionString) {
    return Arrays.stream(Direction.values())
        .filter(direction -> direction.value.equals(directionString))
        .findAny();
  }
}
