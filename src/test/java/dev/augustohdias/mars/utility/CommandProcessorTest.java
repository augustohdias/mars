package dev.augustohdias.mars.utility;

import dev.augustohdias.mars.models.entities.Command;
import dev.augustohdias.mars.models.entities.Coordinate;
import dev.augustohdias.mars.models.entities.Direction;
import dev.augustohdias.mars.models.entities.Position;
import dev.augustohdias.mars.models.entities.Probe;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommandProcessorTest {
  private static final Coordinate BIG_BOUNDARIES = new Coordinate(99, 99);

  @Test
  void commandProcessorTestA() throws IOException {
    Position currentPosition = new Position(new Coordinate(3, 3), Direction.EAST);
    Probe probe = new Probe(0, currentPosition, BIG_BOUNDARIES);
    List<Command> commandList = CommandParser.parseCommands("MMRMMRMRRM");
    Position newPosition = new CommandProcessor().apply(commandList, probe);
    Assertions.assertEquals(newPosition, new Position(new Coordinate(5, 1), Direction.EAST));
  }

  @Test
  void commandProcessorTestB() throws IOException {
    Position currentPosition = new Position(new Coordinate(1, 2), Direction.NORTH);
    Probe probe = new Probe(0, currentPosition, BIG_BOUNDARIES);
    List<Command> commandList = CommandParser.parseCommands("LMLMLMLMM");
    Position newPosition = new CommandProcessor().apply(commandList, probe);
    Assertions.assertEquals(newPosition, new Position(new Coordinate(1, 3), Direction.NORTH));
  }

  @Test
  void commandProcessorInvalidDirectionTest() throws IOException {
    Position currentPosition = new Position(new Coordinate(1, 2), Direction.NORTH);
    Probe probe = new Probe(0, currentPosition, BIG_BOUNDARIES);
    List<Command> commandList = CommandParser.parseCommands("LMLMLMLMM");
    Position newPosition = new CommandProcessor().apply(commandList, probe);
    Assertions.assertEquals(newPosition, new Position(new Coordinate(1, 3), Direction.NORTH));
  }
}
