package dev.augustohdias.mars.models.entities;

import java.util.Arrays;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Accessors(fluent = true)
public enum Command {
  Left('L'),
  Right('R'),
  Move('M');

  @Getter
  private final Character value;

  public static Optional<Command> get(char directionString) {
    return Arrays.stream(Command.values()).filter(command -> command.value.equals(directionString)).findAny();
  }}
