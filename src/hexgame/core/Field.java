package org.hexgame.core;

import java.util.Arrays;

public class Field {
  public int xCoordinate, yCoordinate;

  public Field(int _xCoordinate, int _yCoordinate) {
    xCoordinate = _xCoordinate;
    yCoordinate = _yCoordinate;
  }

  @Override
  public int hashCode() {
    return Arrays.asList(xCoordinate, yCoordinate).hashCode();
  }

  @Override
  public boolean equals(Object object) {
    return hashCode() == object.hashCode();
  }
}
