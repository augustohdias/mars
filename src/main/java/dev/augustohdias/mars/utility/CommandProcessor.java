package dev.augustohdias.mars.utility;

import dev.augustohdias.mars.models.entities.Command;
import dev.augustohdias.mars.models.entities.Coordinate;
import dev.augustohdias.mars.models.entities.Direction;
import dev.augustohdias.mars.models.entities.Position;
import dev.augustohdias.mars.utility.CircularList.Node;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Processes a command list and applies it to a position. See {@link Command} and {@link Direction}
 * for more information.
 */
public class CommandProcessor implements BiFunction<List<Command>, Position, Position> {

  /** Uses a {@link CircularList} with each defined {@link Direction} to emulates movement. */
  private static final CircularList<Direction> directions = new CircularList<>();

  private static final MovementProcessor movementProcessor = new MovementProcessor();

  static {
    directions
        .push(Direction.NORTH)
        .push(Direction.EAST)
        .push(Direction.SOUTH)
        .push(Direction.WEST);
  }

  /**
   * Applies a list of commands to a position and returns the result.
   *
   * @param commands List of commands.
   * @param position Current position.
   * @return Resultant position.
   */
  @Override
  public Position apply(List<Command> commands, Position position) {
    Node<Direction> currentDirection =
        directions.findAndGetReference(position.getFacingDirection()).get();
    Coordinate currentCoordinate = position.getCoordinate();
    for (Command command : commands) {
      switch (command) {
        case LEFT:
          currentDirection = currentDirection.prev();
          break;
        case RIGHT:
          currentDirection = currentDirection.next();
          break;
        default:
          currentCoordinate = movementProcessor.apply(currentDirection.value(), currentCoordinate);
          break;
      }
    }
    return new Position(currentCoordinate, currentDirection.value());
  }
}
