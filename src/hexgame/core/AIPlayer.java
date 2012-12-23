package org.hexgame.core;

import org.hexgame.core.Player;
import org.hexgame.core.Move;
import org.hexgame.core.strategies.Strategy;

public class AIPlayer extends Player {
  Strategy strategy;

  public AIPlayer(PieceType _pieceType, Strategy _strategy) {
    super(_pieceType);
    strategy = _strategy;
  }

  public Move getMove() {
    return strategy.getMove();
  }
}
