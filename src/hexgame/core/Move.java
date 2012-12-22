package org.hexgame.core;

import org.hexgame.core.Board;
import org.hexgame.core.PieceType;

public class Move {
  PieceType pieceType;
  Board board;
  public int coordinateX, coordinateY;

  public Move(Board _board, PieceType _pieceType, int _coordinateX, int _coordinateY) {
    board = _board;
    pieceType = _pieceType;
    coordinateX = _coordinateX;
    coordinateY = _coordinateY;
  }

  public PieceType getPieceType() {
    return pieceType;
  }

  public Boolean isValid() {
    return board.canPlacePiece(coordinateX, coordinateY);
  }
}
