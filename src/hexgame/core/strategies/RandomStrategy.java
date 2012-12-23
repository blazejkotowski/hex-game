package org.hexgame.core.strategies;

import java.util.Random;
import java.util.List;
import org.hexgame.core.*;
import org.hexgame.core.strategies.Strategy;

public class RandomStrategy extends Strategy {

  public Field getMove(Board board, PieceType pieceType) {
    List<Field> free = freeFields(board);
    return free.get((new Random()).nextInt(free.size()));
  }
}
