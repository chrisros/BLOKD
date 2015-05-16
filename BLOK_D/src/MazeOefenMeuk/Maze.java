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
   protected  JPanel panel; 
   protected final int startX;
   protected final int startY;
   protected final int endX;
   protected final int endY;
   protected int playerX;
   protected int playerY;
   protected boolean solution = false;
   protected int[][] grid ={{0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,1,1,1,1,0,1,1,1,0,1,0},
                            {0,0,1,0,1,1,1,0,1,0,1,0},       
                            {0,1,1,0,1,0,0,1,1,0,1,0},
                            {0,1,0,0,1,0,0,1,0,0,1,0},
                            {0,1,1,1,1,1,1,1,1,1,1,0}, 
                            {0,0,0,0,0,0,0,0,0,0,0,0}};  

   public Maze(int x, int y){
       startX = x;
       startY = y;
       playerX = x;
       playerY = y;
       endX = 10;
       endY = 5;
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
    
    public void paintMaze()
    {
        //panel leegmaken
        panel.removeAll();
                
        for (int row=0; row < grid.length; row++) 
        {
            for (int column=0; column < grid[row].length; column++)
            {
                boolean player = false;
                if(row==startY&&column==startX){grid[row][column]=2;}
                if(row==endY&&column==endX){grid[row][column]=4;}
                if(row==playerY&&column==playerX){player=true;}
                
                Block blok = new Block(grid[row][column], solution, player);
                panel.add(blok);            
            }          
        }
        //panel met nieuwe UI inladen
        panel.setBackground(Color.BLACK);
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.updateUI();
        
        
    } 
    
   public int[][] getGrid(){return grid;}
   public int getBlock(int x, int y){return grid[y][x];} 
   public int getStartX(){return startX;}
   public int getStartY(){return startY;}
   public int getEndX(){return endX;}
   public int getEndY(){return endY;}
   public int getWidth(){return grid[0].length  ;}
   public int getHeight(){return grid.length;}
   public void setPanel(JPanel pan){panel = pan;}
   public void setPlayerX(int x){playerX = x;}
   public void setStartY(int y){playerY = y;}
}
