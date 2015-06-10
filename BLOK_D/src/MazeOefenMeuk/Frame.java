/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeOefenMeuk;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author chris
 */
public class Frame extends javax.swing.JFrame {

    Maze doolhof;
    MazeSolved opgelost;
    Held speler;
    BufferedImage splashScreen;
    public Frame(Maze doolhof, MazeSolved opgelost, Held speler ) {
        
        try {splashScreen = ImageIO.read(new File("src/images/heldRight.png")); } catch (Exception e) {}
        
        initComponents();
        setVisible(true);
        setTitle("EscApe The Game");
        setIconImage(null);
        setResizable(false); 
        setFocusable(true); 
        setIconImage(splashScreen);
        
        this.doolhof = doolhof;
        this.opgelost = opgelost;
        this.speler = speler;
        speler.setPanel(panel);
        panel.setFocusable(true);
        KeyListener checkKey = new GetKey(speler);
        panel.addKeyListener(checkKey);
        
        doolhof.setPanel(panel);
        opgelost.setPanel(panel);
    }
    
    public void setPanelGrid(int w, int h){
        panel.setLayout(new GridLayout(h,w));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        panel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        feedback = new javax.swing.JLabel();
        topPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        score = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bazooka = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        panel.setBackground(new java.awt.Color(248, 179, 50));
        panel.setForeground(new java.awt.Color(255, 255, 255));
        panel.setFocusCycleRoot(true);
        panel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                panelKeyReleased(evt);
            }
        });
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        panel2.setBackground(new java.awt.Color(51, 51, 51));

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("P22 Constructivist", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 0));
        jButton1.setText("Show Maze");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel2.add(jButton1);

        jButton2.setBackground(new java.awt.Color(0, 0, 255));
        jButton2.setFont(new java.awt.Font("P22 Constructivist", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 0));
        jButton2.setText("Solve Maze");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel2.add(jButton2);

        feedback.setBackground(new java.awt.Color(255, 255, 51));
        feedback.setFont(new java.awt.Font("P22 Constructivist", 0, 24)); // NOI18N
        feedback.setForeground(new java.awt.Color(255, 255, 51));
        feedback.setMinimumSize(new java.awt.Dimension(10, 10));
        panel2.add(feedback);

        getContentPane().add(panel2, java.awt.BorderLayout.SOUTH);

        topPanel.setBackground(new java.awt.Color(51, 51, 51));
        topPanel.setForeground(new java.awt.Color(255, 255, 255));
        topPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("P22 Constructivist", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Score: ");
        topPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        score.setBackground(new java.awt.Color(255, 255, 255));
        score.setFont(new java.awt.Font("P22 Constructivist", 0, 18)); // NOI18N
        score.setForeground(new java.awt.Color(255, 255, 255));
        score.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        score.setText("0000");
        score.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        topPanel.add(score, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 80, -1));

        level.setBackground(new java.awt.Color(255, 255, 255));
        level.setFont(new java.awt.Font("P22 Constructivist", 0, 18)); // NOI18N
        level.setForeground(new java.awt.Color(255, 255, 255));
        level.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        level.setText("0001");
        topPanel.add(level, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, 20));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("P22 Constructivist", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Level: ");
        topPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 90, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("P22 Constructivist", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("BAzooka");
        topPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 110, -1));

        bazooka.setBackground(new java.awt.Color(255, 255, 255));
        bazooka.setFont(new java.awt.Font("P22 Constructivist", 0, 18)); // NOI18N
        bazooka.setForeground(new java.awt.Color(255, 255, 255));
        bazooka.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bazooka.setText("0");
        topPanel.add(bazooka, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 20, -1));

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            doolhof.createMaze();
            
        } catch (Exception e) {
        }
        
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            //button clicked > teken de oplossing:
            speler.verkrijgSnelsteRoute();
            
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Er is een kritische fout opgetreden, graag de applicatie opnieuw opstarten"); 
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed

    private void panelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelKeyPressed
        
    }//GEN-LAST:event_panelKeyPressed

    private void panelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelKeyReleased

    }//GEN-LAST:event_panelKeyReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bazooka;
    private javax.swing.JLabel feedback;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel level;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel2;
    private javax.swing.JLabel score;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables

  public void setFeedback(String text){
        feedback.setText(text);
    }
    public void setScore(String text){
        score.setText(text);
    }

    public void setBazooka(boolean hasBazooka){
        if(hasBazooka){
            bazooka.setText("1");
        } else{
            bazooka.setText("0"); 
        }
    }

}
