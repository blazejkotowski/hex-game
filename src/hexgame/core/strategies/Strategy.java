package org.hexgame.core.strategies;

import org.hexgame.core.*;

public abstract class Strategy {
  Board board;
  Player player;

  public Strategy(Board _board, Player _player) {
    board = _board;
    player = _player;
  }

  abstract public Move getMove();
}
