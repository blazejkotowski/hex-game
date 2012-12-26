package org.hexgame.gui;

import org.hexgame.gui.Hexagon;
import javax.swing.*;
import java.awt.*;

class Hexboard extends JPanel {
    public Hexagon [][] tab=new Hexagon [21][11];
    private int bx=142,by=0;
    public Hexboard() {
	setPreferredSize(new Dimension(310,630));
        setLayout(null);
        int m=0;
        for(int i=0;i<21;++i) {
            int bx1=bx;
            for(int j=0;j<=m;++j) {
                Hexagon tmp=new Hexagon(15);
                tmp.setBounds(bx1,by,26,30);
                tab[i][j]=tmp; add(tab[i][j]);
                bx1+=26;
            }
            if(i<10) {
                m++;
                bx-=13;
            }
            else {
                bx+=13;
                m--;
            }
            by+=30;
        }          
    }
}
