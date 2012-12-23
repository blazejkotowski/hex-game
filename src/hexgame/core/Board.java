package org.hexgame.core;

import java.util.*;

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

  public Boolean bridgeExists(PieceType pieceType) {
    Set<List<Integer>> uncheckedFields = new HashSet<List<Integer>>();
    Set<List<Integer>> adjacentFields = new HashSet<List<Integer>>();
    Stack<List<Integer>> waitingFields = new Stack<List<Integer>>();

    for(int i = 1; i < size * 2; i++) {
      for(int l = 1; l <= size; l++) {
        if(fieldOnBoard(i, l) && getPiece(i, l) == pieceType)
          uncheckedFields.add(Arrays.asList(i, l));
      }
    }

    while(!uncheckedFields.isEmpty() || !adjacentFields.isEmpty() || !waitingFields.empty()) {
      if(waitingFields.empty()) {
        if(!adjacentFields.isEmpty()) {
          Set<List<Integer>> upperBoundarySet = upperBoundaryFor(pieceType);
          Set<List<Integer>> lowerBoundarySet = lowerBoundaryFor(pieceType);
          upperBoundarySet.retainAll(adjacentFields);
          lowerBoundarySet.retainAll(adjacentFields);
          if(!upperBoundarySet.isEmpty() && !lowerBoundarySet.isEmpty())
            return true;
          else
            adjacentFields.clear();
        }
        else {
          List<Integer> newElement = uncheckedFields.iterator().next();
          uncheckedFields.remove(newElement);
          waitingFields.push(newElement);
        }
      }
      else {
        List<Integer> poppedField = waitingFields.pop();
        adjacentFields.add(poppedField);
        List<List<Integer>> adjacentToPopped = adjacentFields(poppedField);
        for(int i = 0; i < adjacentToPopped.size(); i++) {
          if(uncheckedFields.contains(adjacentToPopped.get(i))) {
            uncheckedFields.remove(adjacentToPopped.get(i));
            waitingFields.push(adjacentToPopped.get(i));
          }
        }
      }
    }
    return false;
  }

  private List<List<Integer>> adjacentFields(List<Integer> field) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    int x = field.get(0);
    int y = field.get(1);
    result.add(Arrays.asList(x-1, y-1));
    result.add(Arrays.asList(x-1, y));
    result.add(Arrays.asList(x, y+1));
    result.add(Arrays.asList(x+1, y+1));
    result.add(Arrays.asList(x+1, y));
    result.add(Arrays.asList(x, y-1));
    return result;
  }

  private Set<List<Integer>> upperBoundaryFor(PieceType pieceType) {
    Set<List<Integer>> result = new HashSet<List<Integer>>();
    if(pieceType == PieceType.WHITE) {
      for(int i = 1; i <= size; i++) result.add(Arrays.asList(i, 1));
    }
    else if(pieceType == PieceType.BLACK) {
      for(int i = 1; i <= size; i++)  result.add(Arrays.asList(i, i));
    }
    return result;
  }

  private Set<List<Integer>> lowerBoundaryFor(PieceType pieceType) {
    Set<List<Integer>> result = new HashSet<List<Integer>>();
    if(pieceType == PieceType.WHITE) {
      for(int i = size; i < 2 * size; i++) result.add(Arrays.asList(i, size));
    }
    else if(pieceType == PieceType.BLACK) {
      for(int i = size; i < 2 * size; i++)  result.add(Arrays.asList(i, i - size + 1));
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

