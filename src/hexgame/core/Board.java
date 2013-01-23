package org.hexgame.core;

import java.util.*;

public class Board {
  private int size;
  private HashMap<Field, PieceType> pieces;

  public Board(int _size) {
    size = _size;
    assertMinSize();
    pieces = new HashMap<Field, PieceType>();
  }

  public int getSize() {
    return size;
  }

  public PieceType getPiece(int xCoordinate, int yCoordinate) {
    assertCoordinates(xCoordinate, yCoordinate);
    return pieces.get(new Field(xCoordinate, yCoordinate));
  }

  public void placePiece(int xCoordinate, int yCoordinate, PieceType piece) {
    assertCanPlacePiece(xCoordinate, yCoordinate);
    pieces.put(new Field(xCoordinate, yCoordinate), piece);
  }

  public void removePiece(int xCoordinate, int yCoordinate) {
    assertCoordinates(xCoordinate, yCoordinate);
    pieces.put(new Field(xCoordinate, yCoordinate), null);
  }

  public Boolean canPlacePiece(int xCoordinate, int yCoordinate) {
    return fieldOnBoard(xCoordinate, yCoordinate) && fieldFree(xCoordinate, yCoordinate);
  }

  public Boolean isFull() {
    return fieldsCount() == pieces.values().size();
  }

  public Boolean bridgeExists(PieceType pieceType) {
    List<Set<Field>> disjoint = disjointFieldSets(pieceType);
    for(int i = 0; i < disjoint.size(); i++) {
      Set<Field> upperBoundarySet = upperBoundary(pieceType);
      Set<Field> lowerBoundarySet = lowerBoundary(pieceType);
      upperBoundarySet.retainAll(disjoint.get(i));
      lowerBoundarySet.retainAll(disjoint.get(i));
      if(!upperBoundarySet.isEmpty() && !lowerBoundarySet.isEmpty()) return true;
    }
    return false;
  }

  private List<Set<Field>> disjointFieldSets(PieceType pieceType) {
    List<Set<Field>> result = new ArrayList<Set<Field>>();

    Set<Field> uncheckedFields = fieldSet(pieceType);
    Set<Field> adjacentFields = new HashSet<Field>();
    Stack<Field> waitingFields = new Stack<Field>();

    while(!uncheckedFields.isEmpty() || !adjacentFields.isEmpty() || !waitingFields.empty()) {
      if(waitingFields.empty()) {
        if(!adjacentFields.isEmpty()) {
          result.add(adjacentFields);
          adjacentFields = new HashSet<Field>();
        }
        else {
          Field newElement = uncheckedFields.iterator().next();
          uncheckedFields.remove(newElement);
          waitingFields.push(newElement);
        }
      }
      else {
        Field poppedField = waitingFields.pop();
        adjacentFields.add(poppedField);
        List<Field> adjacentToPopped = poppedField.adjacentFields();
        for(int i = 0; i < adjacentToPopped.size(); i++) {
          if(uncheckedFields.contains(adjacentToPopped.get(i))) {
            uncheckedFields.remove(adjacentToPopped.get(i));
            waitingFields.push(adjacentToPopped.get(i));
          }
        }
      }
    }
    return result;
  }

  public Set<Field> fieldSet(PieceType pieceType) {
    Set<Field> result = new HashSet<Field>();
    for(int i = 1; i < size * 2; i++) {
      for(int l = 1; l <= size; l++) {
        if(fieldOnBoard(i, l) && getPiece(i, l) == pieceType)
          result.add(new Field(i, l));
      }
    }
    return result;
  }

  private Set<Field> upperBoundary(PieceType pieceType) {
    Set<Field> result = new HashSet<Field>();
    if(pieceType == PieceType.WHITE) {
      for(int i = 1; i <= size; i++) result.add(new Field(i, 1));
    }
    else if(pieceType == PieceType.BLACK) {
      for(int i = 1; i <= size; i++)  result.add(new Field(i, i));
    }
    return result;
  }

  private Set<Field> lowerBoundary(PieceType pieceType) {
    Set<Field> result = new HashSet<Field>();
    if(pieceType == PieceType.WHITE) {
      for(int i = size; i < 2 * size; i++) result.add(new Field(i, size));
    }
    else if(pieceType == PieceType.BLACK) {
      for(int i = size; i < 2 * size; i++)  result.add(new Field(i, i - size + 1));
    }
    return result;
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

