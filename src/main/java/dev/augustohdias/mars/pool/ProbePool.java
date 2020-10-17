package dev.augustohdias.mars.pool;

import dev.augustohdias.mars.models.entities.Position;
import dev.augustohdias.mars.models.entities.Probe;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.UtilityClass;

/**
 * Virtual persistence class, to store instantiated probes.
 */
@UtilityClass
public class ProbePool {
  @Getter
  private final List<Probe> probes = new ArrayList<>();

  /**
   * Creates a new probe. Uses the probes list's size as identifier, to keep it simple.
   * @param position Probe initial position.
   * @return Recently created probe instance.
   */
  public Probe newProbe(Position position) {
    Probe newProbe = new Probe(probes.size(), position);
    probes.add(newProbe);
    return newProbe;
  }
}
