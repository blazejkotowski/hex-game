package org.hexgame;

import java.io.Console;
import java.util.regex.*;
import org.hexgame.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("WELCOME TO HEX\n");
    Board board = new Board(10);
    PieceType pieceType = PieceType.WHITE;
    Console console = System.console();
    while(true) {
      System.out.println(board.toString());
      Boolean validMove = false;
      while(!validMove) {
        String name = console.readLine(pieceType.toString() + ", what is your move?\n");
        Matcher matcher = Pattern.compile("(\\d+) (\\d+)").matcher(name);
        if(matcher.find()) {
          int coordinateX = Integer.parseInt(matcher.group(1));
          int coordinateY = Integer.parseInt(matcher.group(2));
          validMove = board.canPlacePiece(coordinateX, coordinateY);
        }
        if(!validMove) {
          System.out.println("Invalid move!\n");
        }
      }
      pieceType = pieceType.invert();
    }
  }
}
