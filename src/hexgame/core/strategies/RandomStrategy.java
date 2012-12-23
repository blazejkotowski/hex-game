package org.hexgame.core.strategies;

import org.hexgame.core.*;
import org.hexgame.core.strategies.Strategy;

public class RandomStrategy extends Strategy {
  public RandomStrategy(Board board, Player player) {
    super(board, player);
  }

  public Move getMove() {
    return new Move(board, player, 1, 1);
  }
}
