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

/**
 *
 * @author Chris
 */
class HeldBlock extends Block {

    private final BufferedImage held;
    
    public HeldBlock(BufferedImage held, BufferedImage returnImage, Color color, int blokSize) throws IOException 
    {
        super(returnImage, color, blokSize);
        this.held = held; 
    }
    @Override
    public void paintComponent(Graphics g){
        //maakt een component met een bepaalde hoeveelheid squares
    
        try {
            g.drawImage(returnImage, 0,0,blokSize,blokSize, this);
            g.drawImage(held, 0,0,blokSize,blokSize, this);
            //g.fillRect(0, 0, 64, 64);
            setVisible(true);
        } catch (Exception e) {
            g.setColor(returnColor);
            g.fillRect(0, 0, blokSize, blokSize);
            setVisible(true);
        
        }
        
        
    }
}
