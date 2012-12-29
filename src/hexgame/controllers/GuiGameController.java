package org.hexgame.controllers;

import org.hexgame.controllers.GameController;
import org.hexgame.core.*;
import org.hexgame.core.strategies.RandomStrategy;
import org.hexgame.ui.*;

public class GuiGameController extends GameController {
  public void start() {
    initGuiComponents();
    startNewGame(10);
  }

  public void startNewGameAction(int size, String pA, String pB) {
    startNewGame(size);
  }

  public void placePieceAction(int xCoordinate, int yCoordinate) {
    Move move = new Move(board, currentPlayer, xCoordinate, yCoordinate);
    if(move.isValid()) {
      performMove(move);
      performNextMove();
    }
  }

  public void undoMoveAction() {
    game.undoMove();
  }

  public void exitAction() {
    System.exit(0);
  }

  private void startNewGame(int size) {
    playerA = new Player(PieceType.WHITE);
    playerB = new AIPlayer(PieceType.BLACK, new RandomStrategy());
    game = new Game(size, playerA, playerB);
    board = game.getBoard();
  }

  private void performNextMove() {
    if(!currentPlayer.isHuman() && !game.isFinished()) {
      performMove(currentPlayer.getMove(board));
    }
  }

  private void performMove(Move move) {
    game.performMove(move);
    redrawGuiComponents();
    if(game.isFinished()) finish();
    else performNextMove();
  }

  private void finish() { }

  private void redrawGuiComponents() { }

  private void initGuiComponents() {
    HexGui.start(this);
  }
}
