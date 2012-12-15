package org.hexgame;

public class Board {
  int size;

  public Board(int _size) {
    if(_size <= 3) {
      throw new RuntimeException("4 is minimum Board size");
    }
    size = _size;
  }

  public int getSize() {
    return size;
  }
}

