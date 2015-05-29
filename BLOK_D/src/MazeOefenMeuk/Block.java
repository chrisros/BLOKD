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
    
    private Color returnColor;
    private BufferedImage returnImage;
    private BufferedImage topImage;
    private int blokSize;
    private boolean hasItem;
    //int c = integer waarde van block in grid
    //s = boolean solved 
    //p = player (locatie bevat player)
    
    public Block(BufferedImage image, Color color, int bS, boolean item) throws IOException{
        
        try {
            returnImage = image;   
            returnColor =color;  
            blokSize = bS;
            hasItem = item;
        } catch (Exception e) {
            
        }
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        //maakt een component met een bepaalde hoeveelheid squares
    
        try {
            
            g.drawImage(returnImage, 0,0,40,40, this);
            if(hasItem){
                g.drawImage(topImage, 0,0,blokSize,blokSize, this);
            }
            //g.fillRect(0, 0, 64, 64);
            setVisible(true);
        } catch (Exception e) {
            g.setColor(returnColor);
            g.fillRect(0, 0, blokSize, blokSize);
            setVisible(true);
        
        }
        
        
    }
    public void setTopImage(BufferedImage topimage){
        topImage=topimage;
    }
    
}
