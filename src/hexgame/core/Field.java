package org.hexgame.core;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Field {
  public int xCoordinate, yCoordinate;

  public Field(int _xCoordinate, int _yCoordinate) {
    xCoordinate = _xCoordinate;
    yCoordinate = _yCoordinate;
  }

  public List<Field> adjacentFields() {
    List<Field> result = new ArrayList<Field>();
    result.add(new Field(xCoordinate-1, yCoordinate-1));
    result.add(new Field(xCoordinate-1, yCoordinate));
    result.add(new Field(xCoordinate, yCoordinate+1));
    result.add(new Field(xCoordinate+1, yCoordinate+1));
    result.add(new Field(xCoordinate+1, yCoordinate));
    result.add(new Field(xCoordinate, yCoordinate-1));
    return result;
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
