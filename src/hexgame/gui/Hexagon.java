package org.hexgame.gui;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;

class Hexagon extends JPanel implements MouseListener, MouseMotionListener {
  private  int size;
  private Color c;
  private boolean B;

  public Hexagon(int size) {
    this.size=size;
    addMouseListener(this);
    addMouseMotionListener(this);
    setPreferredSize(new Dimension(26,30));
    c=Color.gray;
    B=true;
  }

  public void mouseDragged(MouseEvent arg0) {}
  public void mouseMoved(MouseEvent arg0) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseClicked(MouseEvent e) {
    if(B) {
      c=Color.blue;
      B=false;
    }
    else {
      c=Color.gray;
      B=true;
    }
    this.paintComponent(this.getGraphics());
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    super.setOpaque(false);
    Graphics2D g2=(Graphics2D) g;
    double [] pointx=new double [6];
    double [] pointy=new double [6];
    pointx[0]=13; pointy[0]=0;
    pointx[1]=pointx[0]+size*Math.sqrt(3)/2; pointy[1]=pointy[0]+size/2;
    pointx[2]=pointx[1]; pointy[2]=size+pointy[1];
    pointx[3]=pointx[0]; pointy[3]=pointy[2]+size/2;
    pointx[4]=pointx[3]-size*Math.sqrt(3)/2; pointy[4]=pointy[3]-size/2;
    pointx[5]=pointx[4]; pointy[5]=pointy[4]-size;
    Path2D.Double d=new Path2D.Double();
    g2.setColor(c);
    d.moveTo(pointx[0],pointy[0]);
    for(int i=0;i<6;++i) {
      d.lineTo(pointx[(i+1)%6],pointy[(i+1)%6]);
    }
    g2.fill(d);
  }
}
