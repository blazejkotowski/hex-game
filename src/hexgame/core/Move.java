package org.hexgame.core;

import org.hexgame.core.Board;
import org.hexgame.core.Player;

public class Move {
  Player player;
  Board  board;
  public int xCoordinate, yCoordinate;

  public Move(Board _board, Player _player, int _xCoordinate, int _yCoordinate) {
    board = _board;
    player = _player;
    xCoordinate = _xCoordinate;
    yCoordinate = _yCoordinate;
  }

  public Player getPlayer() {
    return player;
  }

  public Boolean isValid() {
    return board.canPlacePiece(xCoordinate, yCoordinate);
  }

  public void perform() {
    if(!isValid()) throw new RuntimeException("Invalid move");
    board.placePiece(xCoordinate, yCoordinate, player.getPieceType());
  }

  public void undo() {
    board.removePiece(xCoordinate, yCoordinate);
  }
}
