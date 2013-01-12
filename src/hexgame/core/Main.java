package org.hexgame;

import org.hexgame.controllers.*;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    GameController gameController;
    if(Arrays.asList(args).contains("-text")) gameController = new TextGameController();
    else gameController = new GuiGameController();
    gameController.start();
  }
}
