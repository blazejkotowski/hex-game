package org.hexgame.controllers;

import org.hexgame.core.*;
import org.hexgame.core.strategies.RandomStrategy;
import org.hexgame.ui.*;

public class GuiGameController {
  Game game;
  Board board;
  Player playerA, playerB, currentPlayer;

  public GuiGameController() {
    playerA = new Player(PieceType.WHITE);
    playerB = new AIPlayer(PieceType.BLACK, new RandomStrategy());
    game = new Game(10, playerA, playerB);
    board = game.getBoard();
  }

  public void start() {
    initGuiComponents();
  }

  private void initGuiComponents() {
    HexGui.start();
  }
}
