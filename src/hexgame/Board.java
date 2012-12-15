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

  private int minSize() {
    return 4;
  }
}

