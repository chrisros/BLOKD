/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeOefenMeuk;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JComponent;

/**
 *
 * @author chris
 */
public class Block extends JComponent{
    
    protected Color returnColor;
    protected BufferedImage returnImage;
    protected int blokSize;
    //int c = integer waarde van block in grid
    //s = boolean solved 
    //p = player (locatie bevat player)
    
    public Block(BufferedImage image, Color color, int bS) throws IOException{
        
        try {
            returnImage = image;   
            returnColor =color;  
            blokSize = bS;
        } catch (Exception e) {
            
        }
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        //maakt een component met een bepaalde hoeveelheid squares
    
        try {
            g.drawImage(returnImage, 0,0,40,40, this);

            //g.fillRect(0, 0, 64, 64);
            setVisible(true);
        } catch (Exception e) {
            g.setColor(returnColor);
            g.fillRect(0, 0, blokSize, blokSize);
            setVisible(true);
        
        }
        
        
    }
        
    
}
