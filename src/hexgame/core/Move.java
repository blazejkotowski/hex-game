package org.hexgame.core;

import org.hexgame.core.PieceType;

public class Move {
  PieceType pieceType;
  public int coordinateX, coordinateY;

  public Move(PieceType _pieceType, int _coordinateX, int _coordinateY) {
    pieceType = _pieceType;
    coordinateX = _coordinateX;
    coordinateY = _coordinateY;
  }

  public PieceType getPieceType() {
    return pieceType;
  }
}
