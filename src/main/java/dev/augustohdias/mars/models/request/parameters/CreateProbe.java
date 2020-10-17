package dev.augustohdias.mars.models.request.parameters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CreateProbe {
  Integer x;
  Integer y;
  String facingDirection;
}
