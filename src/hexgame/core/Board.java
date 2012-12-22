package org.hexgame.core;

public class Board {
  private int size;
  private PieceType[][] pieces;

  public Board(int _size) {
    if(_size < minSize()) {
      throw new RuntimeException(String.format("%d is minimum Board size", minSize()));
    }
    size = _size;
    int doubleSize = size * 2;
    pieces = new PieceType[doubleSize][];
    for(int i = 0; i < doubleSize; i++) {
      pieces[i] = new PieceType[doubleSize];
    }
  }

  public int getSize() {
    return size;
  }

  public PieceType getPiece(int coordinateX, int coordinateY) {
    return PieceType.WHITE;
  }

  public void placePiece(int xCoordinate, int yCoordinate, PieceType piece) {
    if(!canPlacePiece(xCoordinate, yCoordinate)) {
      throw new RuntimeException(String.format("piece cannot be placed at %d:%d", xCoordinate, yCoordinate));
    }
    pieces[xCoordinate-1][yCoordinate-1] = piece;
  }

  public Boolean canPlacePiece(int xCoordinate, int yCoordinate) {
    return fieldOnBoard(xCoordinate, yCoordinate) && fieldFree(xCoordinate, yCoordinate);
  }

  private int minSize() {
    return 4;
  }

  private Boolean fieldOnBoard(int xCoordinate, int yCoordinate) {
    return(xCoordinate > 0 && yCoordinate > 0 && xCoordinate < size*2 && yCoordinate > xCoordinate - size && yCoordinate < xCoordinate + 1 && yCoordinate < size + 1);
  }

  private Boolean fieldFree(int xCoordinate, int yCoordinate) {
    PieceType pieceType = pieces[xCoordinate-1][yCoordinate-1];
    return pieceType != PieceType.WHITE && pieceType != PieceType.BLACK;
  }
}

