package dev.augustohdias.mars.utility;

import dev.augustohdias.mars.models.entities.Coordinate;
import dev.augustohdias.mars.models.entities.Direction;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * A {@link BiFunction} to process movement commands. Each direction defined at {@link Direction}
 * should have an correspondent function inside {@link MovementProcessor#movementStrategy}.
 */
public class MovementProcessor implements BiFunction<Direction, Coordinate, Coordinate> {
  private static final Map<Direction, Function<Coordinate, Coordinate>> movementStrategy =
      new EnumMap<>(Direction.class);

  static {
    movementStrategy.put(Direction.NORTH, MovementProcessor::moveNorth);
    movementStrategy.put(Direction.SOUTH, MovementProcessor::moveSouth);
    movementStrategy.put(Direction.EAST, MovementProcessor::moveEast);
    movementStrategy.put(Direction.WEST, MovementProcessor::moveWest);
  }

  /**
   * Apply a movement strategy to provided {@link Direction}.
   *
   * @param direction A valid direction.
   * @param coordinate A valid coordinate
   * @return A new direction.
   */
  public Coordinate apply(Direction direction, Coordinate coordinate) {
    return movementStrategy.get(direction).apply(coordinate);
  }

  /**
   * Adds 1 to {@link Coordinate}'s y and creates a new instance.
   *
   * @param coordinate Current coordinate.
   * @return A new coordinate.
   */
  public static Coordinate moveNorth(Coordinate coordinate) {
    final Integer newY = coordinate.getY() + 1;
    return new Coordinate(coordinate.getX(), newY);
  }

  /**
   * Subtracts 1 to {@link Coordinate}'s y and returns a new instance.
   *
   * @param coordinate Current coordinate.
   * @return A new coordinate.
   */
  public static Coordinate moveSouth(Coordinate coordinate) {
    final Integer newY = coordinate.getY() - 1;
    return new Coordinate(coordinate.getX(), newY);
  }

  /**
   * Adds 1 to {@link Coordinate}'s x and returns a new instance.
   *
   * @param coordinate Current coordinate.
   * @return A new coordinate.
   */
  public static Coordinate moveEast(Coordinate coordinate) {
    final Integer newX = coordinate.getX() + 1;
    return new Coordinate(newX, coordinate.getY());
  }

  /**
   * Subtracts 1 to {@link Coordinate}'s x and returns a new instance.
   *
   * @param coordinate Current coordinate.
   * @return A new coordinate.
   */
  public static Coordinate moveWest(Coordinate coordinate) {
    final Integer newX = coordinate.getX() - 1;
    return new Coordinate(newX, coordinate.getY());
  }
}
