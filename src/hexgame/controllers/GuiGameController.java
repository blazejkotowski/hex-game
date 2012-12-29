package org.hexgame.controllers;

import org.hexgame.controllers.GameController;
import org.hexgame.core.*;
import org.hexgame.core.strategies.RandomStrategy;
import org.hexgame.ui.*;

public class GuiGameController extends GameController {
  public void start() {
    initGuiComponents();
    startNewGame();
  }

  public void startNewGame() {
    playerA = new Player(PieceType.WHITE);
    playerB = new AIPlayer(PieceType.BLACK, new RandomStrategy());
    game = new Game(10, playerA, playerB);
    board = game.getBoard();
  }

  public void exitAction() {
    System.exit(0);
  }

  private void initGuiComponents() {
    HexGui.start(this);
  }
}
