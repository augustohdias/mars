package dev.augustohdias.mars.models.request.parameters;

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
  Integer probeX;
  Integer probeY;

  Integer limitX;
  Integer limitY;

  Character facingDirection;
}
