package org.hexgame.core;

import java.util.ArrayList;
import org.hexgame.core.Player;

public class Game {
  Board  board;
  Player playerA, playerB;
  ArrayList<Move> moves;

  public Game(int _size, Player _playerA, Player _playerB) {
    board = new Board(_size);
    playerA = _playerA;
    playerB = _playerB;
    moves = new ArrayList<Move>();
  }

  public Board getBoard() {
    return board;
  }

  public Player getPlayerA() {
    return playerA;
  }

  public Player getPlayerB() {
    return playerB;
  }

  public Boolean isFinished() {
    return board.isFull() || getWinner() != null;
  }

  public Boolean canUndoMove() {
    return !isFinished() && !moves.isEmpty();
  }

  public Player getWinner() {
    if(board.bridgeExists(playerA.getPieceType()))
      return playerA;
    else if(board.bridgeExists(playerB.getPieceType()))
      return playerB;
    else
      return null;
  }

  public Player currentPlayer() {
    if(moves.size() % 2 == 0)
      return playerA;
    else
      return playerB;
  }

  public void performMove(Move move) {
    move.perform();
    moves.add(move);
  }

  public Move undoMove() {
    assertAnyMoves();
    Move move = moves.remove(moves.size() - 1);
    move.undo();
    return move;
  }

  private void assertAnyMoves() {
    if(moves.isEmpty()) throw new RuntimeException("No moves");
  }
}
