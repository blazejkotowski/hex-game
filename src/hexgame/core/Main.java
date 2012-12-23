package org.hexgame;

import org.hexgame.ui.TextGameController;
import org.hexgame.gui.HexGui;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
	System.out.println("1:tryb tekstowy\n 2:tryb graficzny");
	Scanner sc = new Scanner(System.in);
	int i = sc.nextInt();
	if(i == 1){
    		TextGameController gameController = new TextGameController();
    		gameController.start();
	}
	if(i == 2){
		HexGui.start();
	}
  }
}
