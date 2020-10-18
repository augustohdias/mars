package dev.augustohdias.mars.services;

import dev.augustohdias.mars.models.entities.Command;
import dev.augustohdias.mars.models.entities.Coordinate;
import dev.augustohdias.mars.models.entities.Direction;
import dev.augustohdias.mars.models.entities.Position;
import dev.augustohdias.mars.models.entities.Probe;
import dev.augustohdias.mars.models.request.parameters.CreateProbe;
import dev.augustohdias.mars.models.request.parameters.MoveProbe;
import dev.augustohdias.mars.pool.ProbePool;
import dev.augustohdias.mars.utility.CommandParser;
import java.io.IOException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProbeService {

  /**
   * Create a new probe.
   *
   * @param parameters Parameters for a new probe instance.
   * @return Created probe data.
   */
  public Probe createProbe(CreateProbe parameters) {
    Direction direction =
        Direction.get(parameters.getFacingDirection())
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid direction."));
    Coordinate coordinate = new Coordinate(parameters.getProbeX(), parameters.getProbeY());
    Coordinate boundaries = new Coordinate(parameters.getLimitX(), parameters.getLimitY());
    return ProbePool.newProbe(new Position(coordinate, direction), boundaries);
  }

  /**
   * List all created probes.
   *
   * @return Return created probes from {@link ProbePool}.
   */
  public List<Probe> listProbes() {
    return ProbePool.getProbes();
  }

  /**
   * See {@link ProbeService#findProbe}.
   *
   * @param id Desired probe's id.
   * @return Probe information.
   */
  public Probe getProbeById(Integer id) {
    return findProbe(id);
  }

  /**
   * Move probe using the provided parameters.
   *
   * @param id Probe that will run the commands.
   * @param parameters Probe movement parameters.
   * @return Probe's state after the command execution.
   */
  public Probe moveProbe(Integer id, MoveProbe parameters) {
    Probe probe = findProbe(id);
    try {
      List<Command> commands = CommandParser.parseCommands(parameters.getCommands());
      probe.applyCommands(commands);
    } catch (IndexOutOfBoundsException exception) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid command: Out of bounds.");
    } catch (IOException exception) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "Invalid command string. Couldn't parse.");
    }
    return probe;
  }
  /**
   * Search for a probe using the id parameter. Returns the requested probe, if exists. Throws an
   * exception otherwise.
   *
   * @throws ResponseStatusException If the requested probe is not found, returns 404.
   * @param id Desired probe's id.
   * @return Probe information.
   */
  private Probe findProbe(Integer id) {
    return ProbePool.getProbes().stream()
        .filter(probe -> probe.getId().equals(id))
        .findAny()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Probe not found."));
  }
}
