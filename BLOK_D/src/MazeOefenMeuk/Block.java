/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeOefenMeuk;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author chris
 */
public class Block extends JComponent{
    
    Color color;
    boolean walkable;
    private final BufferedImage wall;
    private final BufferedImage pad;
    private final BufferedImage solvedPad;
    private final BufferedImage start;
    private final BufferedImage finish;
    private final BufferedImage returnImage;
    
    //int c = integer waarde van block in grid
    //s = boolean solved 
    //p = player (locatie bevat player)
    public Block(int c, boolean s, boolean p) throws IOException{    
        
        this.wall       = ImageIO.read(new File("src/images/wall.PNG"));
        this.pad        = ImageIO.read(new File("src/images/pad.PNG"));
        this.solvedPad  = ImageIO.read(new File("src/images/solvedPad.PNG"));
        this.start      = ImageIO.read(new File("src/images/start.PNG"));
        this.finish     = ImageIO.read(new File("src/images/finish.PNG"));
        
        if     (c==0)   {returnImage=wall;      color=Color.black;      walkable=false;}
        else if(c==7&&s){returnImage=solvedPad; color=Color.green;      walkable=true;}
        else if(c==2)   {returnImage=start;     color=Color.orange;     walkable=true;}
        else if(c==4)   {returnImage=finish;    color=Color.red;        walkable=true;}
        else            {returnImage=pad;       color=Color.lightGray;  walkable=false;}
        if     (p==true){                       color=Color.pink;}
    }
    
    @Override
    public void paintComponent(Graphics g){
        //maakt een component met een bepaalde hoeveelheid squares
    
        try {
            g.drawImage(returnImage, 0,0,100,100, this);

            //g.fillRect(0, 0, 64, 64);
            setVisible(true);
        } catch (Exception e) {
            g.setColor(color);
            g.fillRect(0, 0, 100, 100);
            setVisible(true);
        
        }
        
        
    }
        
    
}
