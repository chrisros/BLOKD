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
    private BufferedImage playerImage;
    private BufferedImage itemImage;
    private int blokSize;
    private boolean hasItem;
    private boolean destructable;
    private boolean walkable;
    private boolean isEdge;
    private int x;
    private int y;
    private boolean hasPlayer;

    
    public Block(int X, int Y, BufferedImage image, int bS, boolean item, boolean destruct, boolean Walkable, boolean player, boolean edge) throws IOException{
        
        try {
            returnImage  = image;   
            blokSize     = bS;
            hasItem      = item;
            destructable = destruct;
            x            = X;
            y            = Y;
            walkable     = Walkable;
            hasPlayer    = player;
            isEdge       = edge;
        } catch (Exception e) {
            
        }
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        //maakt een component met een bepaalde hoeveelheid squares
    
        try {
            
            g.drawImage(returnImage, 0,0,blokSize,blokSize, this);
            if(hasItem){
                g.drawImage(itemImage, 0,0,blokSize,blokSize, this);
            }
            if(hasPlayer){
                g.drawImage(playerImage, 0,0,blokSize,blokSize, this);
            }
            setVisible(true);
        } catch (Exception e) {
            g.fillRect(0, 0, blokSize, blokSize);
            setVisible(true);
        
        }
        
        
    }
    
    
    @Override
    public String toString(){
        return hasPlayer+" "+walkable+" "+destructable+" "+x+":"+y;
        
    }
    public boolean getWalkable(){return walkable;}
    public boolean getDestructable(){return destructable;}
    public boolean isEdge(){return isEdge;}
    public void setPlayer(boolean bool){ hasPlayer = bool;}
    public int gety(){ return x;}
    public int getx(){ return y;}
    public void setReturnImage(BufferedImage image){returnImage = image;}
    public void setItemImage(BufferedImage image){itemImage = image;}
    public void setPlayerImage(BufferedImage image){playerImage=image;}
    public void setWalkable(boolean bool){walkable = bool;}
    public void setDestructable(boolean bool){destructable = bool;}
}
