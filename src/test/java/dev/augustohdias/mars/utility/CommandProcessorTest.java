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
  void commandProcessorTestA() {
    Position position = new Position(new Coordinate(3, 3), Direction.EAST);
    List<Command> commandList = CommandParser.parseCommands("MMRMMRMRRM");
    Position newPosition = new CommandProcessor().apply(commandList, position);
    Assertions.assertEquals(newPosition, new Position(new Coordinate(5, 1), Direction.EAST));
  }

  @Test
  void commandProcessorTestB() {
    Position position = new Position(new Coordinate(1, 2), Direction.NORTH);
    List<Command> commandList = CommandParser.parseCommands("LMLMLMLMM");
    Position newPosition = new CommandProcessor().apply(commandList, position);
    Assertions.assertEquals(newPosition, new Position(new Coordinate(1, 3), Direction.NORTH));
  }

  @Test
  void commandProcessorInvalidDirectionTest() {
    Position position = new Position(new Coordinate(1, 2), Direction.NORTH);
    List<Command> commandList = CommandParser.parseCommands("LMLMLMLMM");
    Position newPosition = new CommandProcessor().apply(commandList, position);
    Assertions.assertEquals(newPosition, new Position(new Coordinate(1, 3), Direction.NORTH));
  }
}
