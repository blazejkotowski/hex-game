package org.hexgame;

import org.hexgame.ui.TextGameController;

public class Main {
  public static void main(String[] args) {
    TextGameController gameController = new TextGameController(10);
    gameController.start();
  }
}
