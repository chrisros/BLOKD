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
    boolean walkable;
    
    public Block(int c, boolean s, boolean p){
        
        if(c==0){color=Color.black;walkable=false;}
        else if(c==7&&s){color=Color.green;walkable=true;}
        else if(c==2){color=Color.orange;walkable=true;}
        else if(c==4){color=Color.red;walkable=true;}
        else{color=Color.lightGray;walkable=false;}
        if(p==true){color=Color.pink;}
    }
    
    @Override
    public void paintComponent(Graphics g){
        //maakt een component met een bepaalde hoeveelheid squares
        g.setColor(color);
        g.fillRect(0, 0, 100, 100);
        
        setVisible(true);
        
    }
        
    
}
