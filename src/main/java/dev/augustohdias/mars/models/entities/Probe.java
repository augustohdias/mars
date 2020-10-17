package dev.augustohdias.mars.models.entities;

import dev.augustohdias.mars.utility.CommandProcessor;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Probe {
  private Integer id;
  private Position position;
  private static final CommandProcessor commandProcessor = new CommandProcessor();

  public Probe applyCommands(List<Command> commands) {
    this.position = commandProcessor.apply(commands, position);
    return this;
  }
}
