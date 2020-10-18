package dev.augustohdias.mars.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/** Position POJO. */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Position {
  Coordinate coordinate;
  Direction facingDirection;
}
