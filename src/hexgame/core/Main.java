package org.hexgame;

import org.hexgame.controllers.*;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    GameController gameController;
    System.out.println("[1]: tryb tekstowy\n[2]: tryb graficzny");
    Scanner sc = new Scanner(System.in);
    int i = sc.nextInt();
    if(i == 1) gameController = new TextGameController();
    else gameController = new GuiGameController();
    gameController.start();
  }
}
