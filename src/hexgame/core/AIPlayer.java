package org.hexgame.core;

import java.util.List;
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
    List<Integer> newMove = strategy.getMove();
    return new Move(strategy.getBoard(), this, newMove.get(0), newMove.get(1));
  }

  public Boolean isHuman() {
    return false;
  }
}
