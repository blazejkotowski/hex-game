package org.hexgame.core.strategies;

import java.util.List;
import java.util.ArrayList;
import org.hexgame.core.*;

public abstract class Strategy {
  abstract public Field getField(Board board, PieceType pieceType);

  abstract public String toString();

  protected List<Field> freeFields(Board board) {
    List<Field> result = new ArrayList<Field>();
    for(int i = 1; i < 2 * board.getSize(); i++) {
      for(int l = 1; l <= board.getSize(); l++) {
        if(board.canPlacePiece(i, l)) result.add(new Field(i, l));
      }
    }
    return result;
  }
}
