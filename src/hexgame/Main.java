package org.hexgame;

import java.io.Console;
import org.hexgame.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("WELCOME TO HEX\n");
    Board board = new Board(10);
    Boolean white = true;
    Console console = System.console();
    while(true) {
      System.out.println(board.toString());
      Boolean validMove = false;
      while(!validMove) {
        String name = console.readLine((white ? "WHITE" : "BLACK") + ", what is your move?\n");
        validMove = name.matches("\\d+ \\d+");
        if(!validMove) {
          System.out.println("Invalid move!\n");
        }
      }
      white = !white;
    }
  }
}
