package org.hexgame.core.strategies;

import java.util.List;
import org.hexgame.core.*;

public abstract class Strategy {
  Board board;
  PieceType pieceType;

  public Strategy(Board _board, PieceType _pieceType) {
    board = _board;
    pieceType = _pieceType;
  }

  public Board getBoard() {
    return board;
  }

  abstract public List<Integer> getMove();
}
