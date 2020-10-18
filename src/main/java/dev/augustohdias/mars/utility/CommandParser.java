package dev.augustohdias.mars.utility;

import dev.augustohdias.mars.models.entities.Command;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CommandParser {

  /**
   * Parse a command string to a {@link Command} list.
   *
   * Command string example:
   * "RRMMMRLMRMLMRMLLLMRM"
   *
   * @param commands A String with commands.
   * @return A list of commands.
   */
  public List<Command> parseCommands(String commands) {
    return commands
        .toUpperCase()
        .chars()
        .mapToObj(c -> (char) c)
        .map(Command::get)
        .filter(Optional::isPresent)
        .map(Optional::get)
        .collect(Collectors.toList());
  }
}
