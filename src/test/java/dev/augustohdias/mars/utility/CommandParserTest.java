package dev.augustohdias.mars.utility;

import dev.augustohdias.mars.models.entities.Command;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommandParserTest {
  @Test
  void parseCommandTest() throws Exception {
    List<Command> expectedResult =
        Arrays.asList(
            Command.LEFT,
            Command.RIGHT,
            Command.RIGHT,
            Command.LEFT,
            Command.MOVE,
            Command.LEFT,
            Command.RIGHT,
            Command.MOVE,
            Command.MOVE);
    StringBuilder sb = new StringBuilder();
    expectedResult.stream().map(Command::value).forEach(sb::append);
    List<Command> commandsList = CommandParser.parseCommands(sb.toString());
    Assertions.assertEquals(expectedResult, commandsList);
  }
}
