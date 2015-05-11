/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeOefenMeuk;

/**
 *
 * @author chris
 */
public class Grid {
          
   private final int startX;
   private final int startY;
   private int steps;
   private int[][] grid;
   
   public Grid(int[][] maze, int x, int y){
       startX = x;
       startY = y;
       steps = 0;
       grid=maze;
   }
   
    public void printMaze() {
   
      System.out.println();

      for (int row=0; row < grid.length; row++) {
         for (int column=0; column < grid[row].length; column++)
            System.out.print (grid[row][column]);
         System.out.println();
      }

      System.out.println();
       System.out.println("Amount of steps: "+steps);  
   }
    
    public int[][] getGrid()
    {
        return grid;
    }
   
   public int getX(){return startX;}
   public int getY(){return startY;}
}
