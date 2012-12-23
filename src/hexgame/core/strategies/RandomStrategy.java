package org.hexgame.core.strategies;

import java.util.Random;
import java.util.List;
import java.util.Arrays;
import org.hexgame.core.*;
import org.hexgame.core.strategies.Strategy;

public class RandomStrategy extends Strategy {

  public List<Integer> getMove(Board board, PieceType pieceType) {
    List<List<Integer>> free = freeFields(board);
    return free.get((new Random()).nextInt(free.size()));
  }
}
