package dev.augustohdias.mars.models.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommandTest {
  @Test
  void getWrongCommandTest() {
    Command command = Command.get('0').orElse(null);
    Assertions.assertNull(null);
  }

  @Test
  void getCommandLeftTest() {
    Command command = Command.get('L').orElse(null);
    Assertions.assertEquals(Command.LEFT, command);
  }

  @Test
  void getCommandRightTest() {
    Command command = Command.get('R').orElse(null);
    Assertions.assertEquals(Command.RIGHT, command);
  }

  @Test
  void getCommandMoveTest() {
    Command command = Command.get('M').orElse(null);
    Assertions.assertEquals(Command.MOVE, command);
  }
}
