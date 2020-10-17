package dev.augustohdias.mars.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.augustohdias.mars.models.entities.Command;
import dev.augustohdias.mars.models.entities.Coordinate;
import dev.augustohdias.mars.models.entities.Direction;
import dev.augustohdias.mars.models.entities.Position;
import dev.augustohdias.mars.models.entities.Probe;
import dev.augustohdias.mars.models.request.parameters.CreateProbe;
import dev.augustohdias.mars.models.request.parameters.MoveProbe;
import dev.augustohdias.mars.pool.ProbePool;
import dev.augustohdias.mars.utility.CommandParser;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProbeService {

  public Probe createProbe(CreateProbe parameters) {
    Direction direction = Direction.get(parameters.getFacingDirection())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid direction."));
    Coordinate coordinate = new Coordinate(parameters.getX(), parameters.getY());
    return ProbePool.newProbe(new Position(coordinate, direction));
  }

  public List<Probe> listProbes() {
    return ProbePool.getProbes();
  }

  public Probe getProbeById(Integer id) {
    return findProbe(id);
  }

  public Probe moveProbe(Integer id, MoveProbe parameters) {
    Probe probe = findProbe(id);
    List<Command> commands = CommandParser.parseCommands(parameters.getCommands());
    return probe.applyCommands(commands);
  }

  private Probe findProbe(Integer id) {
    return ProbePool
        .getProbes()
        .stream()
        .filter(probe -> probe.getId().equals(id))
        .findAny()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Probe not found."));
  }
}
