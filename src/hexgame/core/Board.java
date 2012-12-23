package org.hexgame.core;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class Board {
  private int size;
  private HashMap<List<Integer>, PieceType> pieces;

  public Board(int _size) {
    size = _size;
    assertMinSize();
    pieces = new HashMap<List<Integer>, PieceType>();
  }

  public int getSize() {
    return size;
  }

  public PieceType getPiece(int xCoordinate, int yCoordinate) {
    assertCoordinates(xCoordinate, yCoordinate);
    return pieces.get(Arrays.asList(xCoordinate, yCoordinate));
  }

  public void placePiece(int xCoordinate, int yCoordinate, PieceType piece) {
    assertCanPlacePiece(xCoordinate, yCoordinate);
    pieces.put(Arrays.asList(xCoordinate, yCoordinate), piece);
  }

  public void removePiece(int xCoordinate, int yCoordinate) {
    assertCoordinates(xCoordinate, yCoordinate);
    pieces.put(Arrays.asList(xCoordinate, yCoordinate), null);
  }

  public Boolean canPlacePiece(int xCoordinate, int yCoordinate) {
    return fieldOnBoard(xCoordinate, yCoordinate) && fieldFree(xCoordinate, yCoordinate);
  }

  public Boolean isFull() {
    return fieldsCount() == pieces.values().size();
  }

  private int fieldsCount() {
    return size * size;
  }

  private void assertCanPlacePiece(int xCoordinate, int yCoordinate) {
    assertCoordinates(xCoordinate, yCoordinate);
    if(!canPlacePiece(xCoordinate, yCoordinate)) {
      throw new RuntimeException(String.format("cannot place piece on %d:%d", xCoordinate, yCoordinate));
    }
  }

  private void assertCoordinates(int xCoordinate, int yCoordinate) {
    if(!fieldOnBoard(xCoordinate, yCoordinate)) {
      throw new RuntimeException(String.format("invalid coordinates: %d:%d", xCoordinate, yCoordinate));
    }
  }

  private void assertMinSize() {
    if(size < minSize())
      throw new RuntimeException(String.format("%d is minimum Board size", minSize()));
  }

  private int minSize() {
    return 4;
  }

  private Boolean fieldOnBoard(int xCoordinate, int yCoordinate) {
    return(xCoordinate > 0 && yCoordinate > 0 && xCoordinate < size*2 && yCoordinate > xCoordinate - size && yCoordinate < xCoordinate + 1 && yCoordinate < size + 1);
  }

  private Boolean fieldFree(int xCoordinate, int yCoordinate) {
    return getPiece(xCoordinate, yCoordinate) == null;
  }
}

