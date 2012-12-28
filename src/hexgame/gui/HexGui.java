/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HexGui.java
 */

package org.hexgame.gui;


import org.hexgame.core.*;


public class HexGui extends javax.swing.JFrame  {
	    
Game game;
    Board board;
    //TextBoardRenderer renderer;
    Player currentPlayer;

    /** Creates new form HexGui */
    public HexGui() {

        Player playerA = new Player(PieceType.WHITE);
        Player playerB = new Player(PieceType.BLACK);
        game = new Game(10, playerA, playerB);
        board = game.getBoard();
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

		hexboard= new Hexboard(size);
		javax.swing.GroupLayout hexboardLayout = new javax.swing.GroupLayout(hexboard);
        hexboard.setLayout(hexboardLayout);
        hexboardLayout.setHorizontalGroup(
            hexboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        hexboardLayout.setVerticalGroup(
            hexboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

	javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hexboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hexboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
	}

    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jButton1 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner(new javax.swing.SpinnerNumberModel(11, 0, 11, 1));
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
	jMenuItem4 = new javax.swing.JMenuItem();
	initHexboard(11);

        jButton1.setText("OK !");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSpinner1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jSpinner1MousePressed(evt);
            }
        });

        jLabel1.setText("size of map");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(36, 36, 36))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hex Game");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu1.setText("File");

        jMenuItem1.setText("New Game");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Exit");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MousePressed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem3.setText("Preferences");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem3MousePressed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

	jMenuItem4.setText("Undo");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem4MousePressed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//event New Game

        Player playerA = new Player(PieceType.WHITE);
        Player playerB = new Player(PieceType.BLACK);
        game = new Game(10, playerA, playerB);
        board = game.getBoard(); hexboard.setVisible(false);
	javax.swing.SpinnerNumberModel model = (javax.swing.SpinnerNumberModel)jSpinner1.getModel();
	int value = model.getNumber().intValue();
	initHexboard(value);
    }

    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//event Exit
	
        System.exit(0); 
    }//

    private void jMenuItem3MousePressed(java.awt.event.MouseEvent evt) {//event Preferences
	jFrame1.pack();
        jFrame1.setVisible(true); 
    }//

	private void jMenuItem4MousePressed(java.awt.event.MouseEvent evt) {//event Undo
		//cofanie ruchu 
    }//

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//event OK!

        jFrame1.setVisible(false);
    }//

    private void jSpinner1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinner1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner1MouseClicked

    /**
    * @param args the command line arguments
    */
    public static void start() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HexGui hex = new HexGui(); 
                hex.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JSpinner jSpinner1;
	private Hexboard hexboard;
    // End of variables declaration//GEN-END:variables

}
