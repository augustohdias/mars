package dev.augustohdias.mars.utility;

import dev.augustohdias.mars.models.entities.Command;
import dev.augustohdias.mars.models.entities.Coordinate;
import dev.augustohdias.mars.models.entities.Direction;
import dev.augustohdias.mars.models.entities.Position;
import dev.augustohdias.mars.utility.CircularList.Node;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

public class CommandProcessor implements BiFunction<List<Command>, Position, Position> {
  private static final CircularList<Direction> directions = new CircularList<>();
  private static final MovementProcessor movementProcessor = new MovementProcessor();
  static {
      directions
          .push(Direction.North)
          .push(Direction.East)
          .push(Direction.South)
          .push(Direction.West);
  }

  @Override
  public Position apply(List<Command> commands, Position position) {
    Optional<Node<Direction>> maybeDirection = directions.findAndGetReference(position.getFacingDirection());
    if (maybeDirection.isEmpty()) {
      return null;
    }
    Node<Direction> currentDirection = maybeDirection.get();
    Coordinate currentCoordinate = position.getCoordinate();
    for (Command command : commands) {
      switch (command) {
        case Left:
          currentDirection = currentDirection.prev();
          break;
        case Right:
          currentDirection = currentDirection.next();
          break;
        default: // Move
           currentCoordinate = movementProcessor.apply(currentDirection.value(), currentCoordinate);
           break;
      }
    }
    return new Position(currentCoordinate, currentDirection.value());
  }
}
