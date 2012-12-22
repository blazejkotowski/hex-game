package org.hexgame.core;

import org.hexgame.core.Board;
import org.hexgame.core.PieceType;

public class Move {
  PieceType pieceType;
  Board board;
  public int xCoordinate, yCoordinate;

  public Move(Board _board, PieceType _pieceType, int _xCoordinate, int _yCoordinate) {
    board = _board;
    pieceType = _pieceType;
    xCoordinate = _xCoordinate;
    yCoordinate = _yCoordinate;
  }

  public PieceType getPieceType() {
    return pieceType;
  }

  public Boolean isValid() {
    return board.canPlacePiece(xCoordinate, yCoordinate);
  }
}
