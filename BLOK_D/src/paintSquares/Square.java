/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintSquares;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JComponent;

/**
 *
 * @author Chris
 */
public class Square extends JComponent{

 
private int x;
private int y;
private int height;
private int width;
private int j;
private final int i;
ArrayList<Color> colours = new  ArrayList<>();

    
    
public Square(int amount)
    {
    i = amount;
    
    //add colours
    colours.add(Color.red);
    colours.add(Color.blue);
    colours.add(Color.ORANGE);
    colours.add(Color.YELLOW);
    colours.add(Color.green);
    colours.add(Color.magenta);
    colours.add(Color.cyan);
    colours.add(Color.darkGray);
    colours.add(Color.lightGray);
    colours.add(Color.red);
    colours.add(Color.blue);
    colours.add(Color.ORANGE);
    colours.add(Color.YELLOW);
    colours.add(Color.green);
    colours.add(Color.magenta);
    colours.add(Color.cyan);
    colours.add(Color.darkGray);
    colours.add(Color.lightGray);
    colours.add(Color.red);
    colours.add(Color.blue);
    colours.add(Color.ORANGE);
    }

    @Override
    public void paintComponent(Graphics g){
        //maakt een component met een bepaalde hoeveelheid squares
        while(j<i)
        {
            g.setColor(colours.get(j));
            Random generator = new Random(); 
            x = generator.nextInt(1000) + 1;
            y = generator.nextInt(800) + 1;
            height = generator.nextInt(500) + 1;
            width = generator.nextInt(500) + 1;
            g.fillRect(x, y, width, height);
            
            j++;
        }
        
        
    }
    
}
