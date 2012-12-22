package org.hexgame.ui;

import java.io.Console;
import java.util.regex.*;
import org.hexgame.core.*;
import org.hexgame.ui.BoardTextRenderer;

public class TextGameController {
  Game game;
  Board board;
  BoardTextRenderer renderer;

  public TextGameController(int size) {
    Player playerA = new Player(PieceType.WHITE);
    Player playerB = new Player(PieceType.BLACK);
    game = new Game(size, playerA, playerB);
    board = game.getBoard();
    renderer = new BoardTextRenderer(board);
  }

  public void start() {
    System.out.println("WELCOME TO HEX\n");
    PieceType pieceType = PieceType.WHITE;
    Console console = System.console();
    while(true) {
      System.out.println(renderer.toString());
      while(true) {
        String name = console.readLine(pieceType.toString() + ", what is your move?\n");
        Matcher matcher = Pattern.compile("(\\d+) (\\d+)").matcher(name);
        int xCoordinate = -1;
        int yCoordinate = -1;
        if(matcher.find()) {
          xCoordinate = Integer.parseInt(matcher.group(1));
          yCoordinate = Integer.parseInt(matcher.group(2));
        }
        Move move = new Move(board, game.currentPlayer(), xCoordinate, yCoordinate);
        if(move.isValid()) {
          game.performMove(move);
          pieceType = pieceType.invert();
          break;
        }
        else {
          System.out.println("Invalid move!\n");
        }
      }
    }
  }
}
