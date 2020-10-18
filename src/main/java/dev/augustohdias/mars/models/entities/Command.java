package dev.augustohdias.mars.models.entities;

import java.util.Arrays;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Enum representation of possible {@link Probe} commands.
 *
 * <p>Left: Turn {@link Probe} 90 degrees to the left; Right: Turn {@link Probe} 90 degrees to the
 * right; Move: Move {@link Probe} ahead 1 distance unit.
 */
@AllArgsConstructor
@Accessors(fluent = true)
public enum Command {
  LEFT('L'),
  MOVE('M'),
  RIGHT('R');

  @Getter private final Character value;

  /**
   * Maybe provides a Command.
   *
   * @param directionString Desired command value.
   * @return A command, if exists. Empty otherwise.
   */
  public static Optional<Command> get(char directionString) {
    return Arrays.stream(Command.values())
        .filter(command -> command.value.equals(directionString))
        .findAny();
  }
}
