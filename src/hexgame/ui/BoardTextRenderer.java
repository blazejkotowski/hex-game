package org.hexgame.ui;

import org.hexgame.core.Board;

public class BoardTextRenderer {
  private Board board;

  public BoardTextRenderer(Board _board) { board = _board; }

  public String toString() {
    String result = "";
    int size = board.getSize();
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
}
