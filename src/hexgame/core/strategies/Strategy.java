package org.hexgame.core.strategies;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.hexgame.core.*;

public abstract class Strategy {
  abstract public List<Integer> getMove(Board board, PieceType pieceType);

  protected List<List<Integer>> freeFields(Board board) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    for(int i = 1; i < 2 * board.getSize(); i++) {
      for(int l = 1; l <= board.getSize(); l++) {
        if(board.canPlacePiece(i, l)) result.add(Arrays.asList(i, l));
      }
    }
    return result;
  }
}
