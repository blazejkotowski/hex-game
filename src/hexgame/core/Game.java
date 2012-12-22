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
    return false;
  }

  public Player getWinner() {
    return playerA;
  }

  public Player currentPlayer() {
    return playerA;
  }

  public void performMove(Move move) {
    move.perform();
    moves.add(move);
  }

  public void backMove() { }
}
