/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeOefenMeuk;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JComponent;

/**
 *
 * @author chris
 */
public class Block extends JComponent{
    
    private BufferedImage returnImage;
    private BufferedImage topImage;
    private int blokSize;
    private boolean hasItem;
    private boolean destructable;
    private boolean walkable;
    private int x;
    private int y;
    private boolean hasPlayer;

    
    public Block(int X, int Y, BufferedImage image, int bS, boolean item, boolean destruct, boolean Walkable, boolean player) throws IOException{
        
        try {
            returnImage  = image;   
            blokSize     = bS;
            hasItem      = item;
            destructable = destruct;
            x            = X;
            y            = Y;
            walkable     = Walkable;
            hasPlayer    = player;
        } catch (Exception e) {
            
        }
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        //maakt een component met een bepaalde hoeveelheid squares
    
        try {
            
            g.drawImage(returnImage, 0,0,blokSize,blokSize, this);
            if(hasItem){
                g.drawImage(topImage, 0,0,blokSize,blokSize, this);
            }
            setVisible(true);
        } catch (Exception e) {
            g.fillRect(0, 0, blokSize, blokSize);
            setVisible(true);
        
        }
        
        
    }
    public void setTopImage(BufferedImage topimage){
        topImage=topimage;
    }
    
    @Override
    public String toString(){
        return hasPlayer+" "+walkable+" "+destructable+" "+":"+y;
        
    }
    public boolean getWalkable(){return walkable;}
    public void setPlayer(boolean bool){ hasPlayer = bool;}
    public int gety(){ return x;}
    public int getx(){ return y;}
    
}
