package org.hexgame.ui;

import java.io.Console;
import java.util.regex.*;
import org.hexgame.core.*;
import org.hexgame.core.strategies.RandomStrategy;
import org.hexgame.ui.TextBoardRenderer;

public class TextGameController {
  Game game;
  Board board;
  TextBoardRenderer renderer;
  Player currentPlayer;
  Console console;

  public TextGameController() {
    Player playerA = new Player(PieceType.WHITE);
    Player playerB = new AIPlayer(PieceType.BLACK, new RandomStrategy());
    game = new Game(10, playerA, playerB);
    board = game.getBoard();
    renderer = new TextBoardRenderer(board);
    console = System.console();
  }

  public void start() {
    greet();
    while(!game.isFinished()) {
      currentPlayer = game.currentPlayer();
      printBoard();
      askForAction();
    }
  }

  private void greet() {
    console.printf("WELCOME TO HEX\n");
  }

  private void askForAction() {
    if(currentPlayer.isHuman()) {
      console.printf(currentPlayer.toString() + ", what is your move?\n");
      console.printf("[1]: Place a piece\n");
      console.printf("[2]: Undo a move\n");
      console.printf("[3]: Show board\n");
      console.printf("[4]: Exit\n");
      String move = console.readLine("> ");

      if     (move.equals("1")) placePieceAction();
      else if(move.equals("2")) undoMoveAction();
      else if(move.equals("3")) showBoardAction();
      else if(move.equals("4")) exitAction();
      else                      defaultAction();
    }
    else {
      game.performMove(currentPlayer.getMove(board));
    }
  }

  private void placePieceAction() {
    console.printf(currentPlayer.toString() + ", where to place a piece?\n");
    String name = console.readLine("> ");
    Matcher matcher = Pattern.compile("(\\d+) (\\d+)").matcher(name);
    int xCoordinate = -1;
    int yCoordinate = -1;
    if(matcher.find()) {
      xCoordinate = Integer.parseInt(matcher.group(1));
      yCoordinate = Integer.parseInt(matcher.group(2));
    }
    Move move = new Move(board, currentPlayer, xCoordinate, yCoordinate);
    if(move.isValid()) {
      game.performMove(move);
    }
    else {
      console.printf("Invalid move!\n");
      placePieceAction();
    }
  }

  private void undoMoveAction() {
    game.undoMove();
  }

  private void showBoardAction() {
    printBoard();
    askForAction();
  }

  private void exitAction() {
    System.exit(0);
  }

  private void defaultAction() {
    console.printf("Invalid action!\n\n");
    askForAction();
  }

  private void printBoard() {
    console.printf(renderer.toString());
  }
}
