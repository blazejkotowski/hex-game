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
      Boolean validMove = false;
      while(!validMove) {
        String name = console.readLine(pieceType.toString() + ", what is your move?\n");
        Matcher matcher = Pattern.compile("(\\d+) (\\d+)").matcher(name);
        int coordinateX;
        int coordinateY;
        if(matcher.find()) {
          coordinateX = Integer.parseInt(matcher.group(1));
          coordinateY = Integer.parseInt(matcher.group(2));
          validMove = board.canPlacePiece(coordinateX, coordinateY);
          if(validMove) {
            board.placePiece(coordinateX, coordinateY, pieceType);
          }
        }
        if(!validMove) System.out.println("Invalid move!\n");
      }
      pieceType = pieceType.invert();
    }
  }
}
