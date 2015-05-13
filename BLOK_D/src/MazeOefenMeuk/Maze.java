/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeOefenMeuk;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author chris
 */
public class Maze {
          
   protected final int startX;
   protected final int startY;
   protected boolean solution = false;
   protected int[][] grid ={{0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,2,1,1,1,0,1,1,1,1,1,0},
                            {0,0,1,0,1,1,1,0,1,0,1,0},       
                            {0,1,1,0,1,0,0,1,1,0,1,0},
                            {0,1,0,0,1,0,0,1,0,0,1,0},
                            {0,1,1,1,1,0,0,1,1,1,4,0}, 
                            {0,0,0,0,0,0,0,0,0,0,0,0}};  

   public Maze(int x, int y){
       startX = x;
       startY = y;
    }
   
    public void printMaze() {
   
      System.out.println();

      for (int row=0; row < grid.length; row++) 
      {
         for (int column=0; column < grid[row].length; column++)
            System.out.print (grid[row][column]);
         System.out.println();
      }

      System.out.println();
    }
    
    public void paintMaze(JPanel panel)
    {
        //panel leegmaken
        panel.removeAll();
        
        for (int row=0; row < grid.length; row++) 
        {
            for (int column=0; column < grid[row].length; column++)
            {
                //if(row==startY&&column==startX){grid[row][column]=2;}
                Block blok = new Block(grid[row][column], solution);
                panel.add(blok);            
            }          
        }
        //panel met nieuwe UI inladen
        panel.setBackground(Color.BLACK);
        panel.updateUI();
    } 
    
   public int[][] getGrid(){return grid;}   
   public int getX(){return startX;}
   public int getY(){return startY;}
   public int getWidth(){return grid[0].length  ;}
   public int getHeight(){return grid.length;}

}
