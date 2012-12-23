package org.hexgame.core.strategies;

import java.util.List;
import org.hexgame.core.*;

public abstract class Strategy {
  abstract public List<Integer> getMove(Board board, PieceType pieceType);
}
