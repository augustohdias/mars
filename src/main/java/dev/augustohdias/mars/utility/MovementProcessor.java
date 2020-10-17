package dev.augustohdias.mars.utility;

import dev.augustohdias.mars.models.entities.Coordinate;
import dev.augustohdias.mars.models.entities.Direction;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MovementProcessor implements BiFunction<Direction, Coordinate, Coordinate> {
  private static final Map<Direction, Function<Coordinate, Coordinate>> movementStrategy = new HashMap<>();
  static {
    movementStrategy.put(Direction.North, MovementProcessor::moveNorth);
    movementStrategy.put(Direction.South, MovementProcessor::moveSouth);
    movementStrategy.put(Direction.East, MovementProcessor::moveEast);
    movementStrategy.put(Direction.West, MovementProcessor::moveWest);
  }

  public Coordinate apply(Direction direction, Coordinate coordinate) {
    return movementStrategy.get(direction).apply(coordinate);
  }

  public static Coordinate moveNorth(Coordinate coordinate) {
    final Integer newY = coordinate.getY() + 1;
    return new Coordinate(coordinate.getX(), newY);
  }

  public static Coordinate moveSouth(Coordinate coordinate) {
    final Integer newY = coordinate.getY() - 1;
    return new Coordinate(coordinate.getX(), newY);
  }

  public static Coordinate moveEast(Coordinate coordinate) {
    final Integer newX = coordinate.getX() + 1;
    return new Coordinate(newX, coordinate.getY());
  }

  public static Coordinate moveWest(Coordinate coordinate) {
    final Integer newX = coordinate.getX() - 1;
    return new Coordinate(newX, coordinate.getY());
  }
}
