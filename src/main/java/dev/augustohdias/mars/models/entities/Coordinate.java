package dev.augustohdias.mars.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/** Cartesian coordinate POJO. */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Coordinate {
  private Integer x;
  private Integer y;

  public boolean checkIfItsValid() {
    return x > 0 && y > 0;
  }

  public boolean inBounds(Coordinate boundaries) {
    return x <= boundaries.x && y <= boundaries.y;
  }
}
