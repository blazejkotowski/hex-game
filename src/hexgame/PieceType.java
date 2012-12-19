package org.hexgame.core;

public enum PieceType {
  BLACK, WHITE;
  public PieceType invert() {
    if(this == WHITE)
      return BLACK;
    else
      return WHITE;
  }
}
