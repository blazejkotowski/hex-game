package org.hexgame.core.strategies;

import java.util.List;
import java.util.Arrays;
import org.hexgame.core.*;
import org.hexgame.core.strategies.Strategy;

public class RandomStrategy extends Strategy {
  public RandomStrategy(Board board, PieceType pieceType) {
    super(board, pieceType);
  }

  public List<Integer> getMove() {
    return Arrays.asList(1, 1);
  }
}
