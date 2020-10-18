package dev.augustohdias.mars.models.request.parameters;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/** Probe parameters POJO. */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CreateProbe {
  @NotNull
  Integer probeX;

  @NotNull
  Integer probeY;

  @NotNull
  Integer limitX;

  @NotNull
  Integer limitY;

  @NotNull
  Character facingDirection;
}
