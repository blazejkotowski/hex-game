package org.hexgame.ui;

import org.hexgame.core.*;
import org.hexgame.controllers.GuiGameController;
import javax.swing.*;
import java.awt.event.*;

public class HexGui extends javax.swing.JFrame  {
  GuiGameController controller;

  /** Creates new form HexGui */
  public HexGui(GuiGameController _controller) {
    controller = _controller;
    controller.setGui(this);
    initComponents();
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initHexboard(int size){

    hexboard= new Hexboard(size, this);
    
    GroupLayout hexboardLayout = new GroupLayout(hexboard);
    hexboard.setLayout(hexboardLayout);
    hexboardLayout.setHorizontalGroup(
        hexboardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGap(0, 460, Short.MAX_VALUE)
        );
    hexboardLayout.setVerticalGroup(
        hexboardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGap(0, 496, Short.MAX_VALUE)
        );

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(hexboard, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    layout.setVerticalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(hexboard, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
  }

  private void initComponents() {

    jFrame1 = new JFrame();
    jButton1 = new JButton();
    jSpinner1 = new JSpinner(new SpinnerNumberModel(11, 0, 11, 1));
    jLabel1 = new JLabel();
    
	jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
    initHexboard(11);

	jButton4.setText("New Game");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

	jButton2.setText("Undo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

	jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

    jButton1.setText("OK !");
    jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jSpinner1.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent evt) {
        jSpinner1MousePressed(evt);
      }
    });

	javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(230, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(420, Short.MAX_VALUE))
        );

    jLabel1.setText("size of map");

    javax.swing.GroupLayout jFrame1Layout = new GroupLayout(jFrame1.getContentPane());
    jFrame1.getContentPane().setLayout(jFrame1Layout);
    jFrame1Layout.setHorizontalGroup(
        jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
          .addGap(61, 61, 61)
          .addComponent(jSpinner1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
              .addComponent(jButton1)
              .addGap(36, 36, 36))
            .addGroup(jFrame1Layout.createSequentialGroup()
              .addGap(50, 50, 50)
              .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
              .addContainerGap())))
        );
    jFrame1Layout.setVerticalGroup(
        jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jFrame1Layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(jFrame1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(jSpinner1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel1))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
          .addComponent(jButton1)
          .addContainerGap())
        );

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setTitle("Hex Game");
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

    jFrame1.pack(); // New Game
    		jFrame1.setVisible(true);
    
    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(ActionEvent evt) {//event OK!
    hexboard.setVisible(false);
    SpinnerNumberModel model = (SpinnerNumberModel)jSpinner1.getModel();
    int size = model.getNumber().intValue();
    controller.startNewGameAction(size, "playerA", "playerB");
    initHexboard(size);
    jFrame1.setVisible(false);
  }//

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        	jFrame1.pack(); // New Game
    		jFrame1.setVisible(true); 
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        controller.undoMoveAction();
    	//cofanie ruchu
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        controller.exitAction(); // Exit
    }

  private void jSpinner1MousePressed(MouseEvent evt) {//GEN-FIRST:event_jSpinner1MouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_jSpinner1MouseClicked

  /**
   * @param args the command line arguments
   */
  public static void start(GuiGameController _controller) {
    final GuiGameController controller = _controller;
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        HexGui hex = new HexGui(controller);
        hex.setVisible(true);
      }
    });
  }

  public void redrawComponents(Game game, Board board) {
    // TODO
  }
  
  public void updateTitle(String title) {
    setTitle(title);
  }
  
  public void paintHexagon(int x, int y) {
    hexboard.paintHexagon(x,y);
  }
  
  public void clearHexagon(int x, int y) {
    hexboard.clearHexagon(x,y);
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;  
	private JButton jButton1;
  private JFrame jFrame1;
  private JLabel jLabel1;
  

  private JSpinner jSpinner1;
  private Hexboard hexboard;
  // End of variables declaration//GEN-END:variables

}
