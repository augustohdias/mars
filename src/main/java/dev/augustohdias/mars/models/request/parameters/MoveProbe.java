package dev.augustohdias.mars.models.request.parameters;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Parameters to move a {@link dev.augustohdias.mars.models.entities.Probe}. */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoveProbe {
  @NotNull
  String commands;
}
