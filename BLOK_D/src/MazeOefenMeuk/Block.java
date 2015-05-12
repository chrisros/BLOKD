/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeOefenMeuk;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author chris
 */
public class Block extends JComponent{
    
    Color color;
    
    public Block(int c, boolean s){
        
        if(c==0){color=Color.black;}
        else if(c==7&&s){color=Color.green;}
        else{color=Color.lightGray;}
    }
    
    @Override
    public void paintComponent(Graphics g){
        //maakt een component met een bepaalde hoeveelheid squares
        g.setColor(color);
        g.fillRect(0, 0, 100, 100);
        
        setVisible(true);
        
    }
        
    
}
