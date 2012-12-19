package org.hexgame;

import java.io.Console;
import java.util.regex.*;
import org.hexgame.core.*;

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
