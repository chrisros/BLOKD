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
    
    //int c = integer waarde van block in grid
    //s = boolean solved 
    //p = player (locatie bevat player)
    public Block(BufferedImage image, Color color) throws IOException{    
        try {
            returnImage = image;   
            returnColor =color;  
        } catch (Exception e) {
            
        }
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        //maakt een component met een bepaalde hoeveelheid squares
    
        try {
            g.drawImage(returnImage, 0,0,100,100, this);

            //g.fillRect(0, 0, 64, 64);
            setVisible(true);
        } catch (Exception e) {
            g.setColor(returnColor);
            g.fillRect(0, 0, 100, 100);
            setVisible(true);
        
        }
        
        
    }
        
    
}
