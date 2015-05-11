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

public class Solver {
    private Grid maze;
    private int row;
    private int column;
    private int[][] grid;
    private int steps;
    
    public Solver(Grid grid)
    {
        maze = grid;
        this.grid = maze.getGrid();
        steps = 0;
    }
    
    
       public boolean solve (int row, int column) {
        boolean done = false;
      if (valid (row, column)) {
         grid[row][column] = 3;  // cell has been tried

         if (row == grid.length-2 && column == grid[0].length-2)
            done = true;  // maze is solved
         else {
            done = solve (row+1, column);  // down
            if (!done)
               done = solve (row, column+1);  // right
            if (!done)
               done = solve (row-1, column);  // up
            if (!done)
               done = solve (row, column-1);  // left
         }
         if (done)  // part of the final path
            grid[row][column] = 7;
        steps++;
      }  
      return done;    
   } 
       private boolean valid (int row, int column) {

      boolean result = false;
 
      // check if cell is in the bounds of the matrix
      if (row >= 0 && row < grid.length &&
          column >= 0 && column < grid[0].length)

         //  check if cell is not blocked and not previously tried
         if (grid[row][column] == 1)
            result = true;

      return result;

   }
}
