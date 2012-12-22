package org.hexgame.core;

import org.hexgame.core.Player;

public class Game {
  Board  board;
  Player playerA, playerB;

  public Game(int _size, Player _playerA, Player _playerB) {
    board = new Board(_size);
    playerA = _playerA;
    playerB = _playerB;
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
}
