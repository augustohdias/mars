package dev.augustohdias.mars.models.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DirectionTest {
  @Test
  void getWrongDirectionTest() {
    Direction direction = Direction.get('0').orElse(null);
    Assertions.assertNull(null);
  }

  @Test
  void getDirectionEastTest() {
    Direction direction = Direction.get('E').orElse(null);
    Assertions.assertEquals(Direction.EAST, direction);
  }

  @Test
  void getDirectionWestTest() {
    Direction direction = Direction.get('W').orElse(null);
    Assertions.assertEquals(Direction.WEST, direction);
  }

  @Test
  void getDirectionNorthTest() {
    Direction direction = Direction.get('N').orElse(null);
    Assertions.assertEquals(Direction.NORTH, direction);
  }

  @Test
  void getDirectionSouthTest() {
    Direction direction = Direction.get('S').orElse(null);
    Assertions.assertEquals(Direction.SOUTH, direction);
  }
}
