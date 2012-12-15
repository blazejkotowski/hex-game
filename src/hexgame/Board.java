package org.hexgame;

public class Board {
  int size;

  public Board(int _size) {
    if(_size < minSize()) {
      throw new RuntimeException(String.format("%d is minimum Board size", minSize()));
    }
    size = _size;
  }

  public int getSize() {
    return size;
  }

  public Boolean canPlacePiece(int xCoordinate, int yCoordinate) {
    return(xCoordinate > 0 && yCoordinate > 0 && xCoordinate < size*2 && yCoordinate > xCoordinate - size && yCoordinate < xCoordinate + 1 && yCoordinate < size + 1);
  }

  public String toString() {
    String result = "";
    int maxRows = size * 4 + 1;
    for(int row = 0; row < maxRows; row++) {
      int maxColumns = (size * 4) - Math.abs((row * 2) - size * 4) + 1;
      int numSpaces = Math.abs(row - size * 2);
      for(int column = 0; column < numSpaces; column++) {
        result += " ";
      }
      if(row % 2 == 0) {
        for(int column = 0; column < maxColumns; column++) {
          if(column % 4 == 0) {
            result += "|";
          }
          else {
            result += " ";
          }
        }
      }
      else {
        for(int column = 0; column < maxColumns; column++) {
          Boolean inversed = (row > size * 2);
          int modColumn = column % 4;
          if((modColumn == 0 && !inversed) || (modColumn == 2 && inversed)) {
            result += "/";
          }
          else if((modColumn == 0 && inversed) || (modColumn == 2 && !inversed)) {
            result += "\\";
          }
          else {
            result += " ";
          }
        }
      }
      result += "\n";
    }
    return result;
  }

  private int minSize() {
    return 4;
  }
}

