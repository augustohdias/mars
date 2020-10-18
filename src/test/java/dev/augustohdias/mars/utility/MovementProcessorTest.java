package dev.augustohdias.mars.utility;

import dev.augustohdias.mars.models.entities.Coordinate;
import dev.augustohdias.mars.models.entities.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MovementProcessorTest {
  private static final Coordinate BASE_COORDINATE = new Coordinate(0, 0);

  @Test
  void moveEastTest() {
    Coordinate newCoordinate = new MovementProcessor().apply(Direction.EAST, BASE_COORDINATE);
    Assertions.assertEquals(new Coordinate(1, 0), newCoordinate);
  }

  @Test
  void moveWestTest() {
    Coordinate newCoordinate = new MovementProcessor().apply(Direction.WEST, BASE_COORDINATE);
    Assertions.assertEquals(new Coordinate(-1, 0), newCoordinate);
  }

  @Test
  void moveNorthTest() {
    Coordinate newCoordinate = new MovementProcessor().apply(Direction.NORTH, BASE_COORDINATE);
    Assertions.assertEquals(new Coordinate(0, 1), newCoordinate);
  }

  @Test
  void moveSouthTest() {
    Coordinate newCoordinate = new MovementProcessor().apply(Direction.SOUTH, BASE_COORDINATE);
    Assertions.assertEquals(new Coordinate(0, -1), newCoordinate);
  }
}
