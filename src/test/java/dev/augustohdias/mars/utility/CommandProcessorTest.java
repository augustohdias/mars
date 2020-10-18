package dev.augustohdias.mars.utility;

import dev.augustohdias.mars.models.entities.Command;
import dev.augustohdias.mars.models.entities.Coordinate;
import dev.augustohdias.mars.models.entities.Direction;
import dev.augustohdias.mars.models.entities.Position;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommandProcessorTest {
  @Test
  void commandProcessorTest() {
    Position position = new Position(new Coordinate(3, 3), Direction.EAST);
    List<Command> commandList = CommandParser.parseCommands("MMRMMRMRRM");
    Position newPosition = new CommandProcessor().apply(commandList, position);
    Assertions.assertEquals(newPosition, new Position(new Coordinate(5, 1), Direction.EAST));
  }
}
