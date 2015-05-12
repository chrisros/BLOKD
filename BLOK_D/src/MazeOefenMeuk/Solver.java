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
    private final int row;
    private final int column;
    private final int endX;
    private final int endY;
    private int[][] grid2;
    private int steps;
    
    public Solver(Maze Maze)
    {
        grid2    = Maze.getGrid();
        column  = Maze.getX();
        row     = Maze.getY();
        endX    =grid2[0].length-2; 
        endY    =grid2.length-2; 
        steps   = -1;
    }
        //Start de solve actie 
       public Maze_Solved start()
       {
           boolean  solved = solve(row, column);         
           Maze_Solved doolhofOpgelost = new Maze_Solved(grid2, column, row, steps, solved);           
           return doolhofOpgelost;
         
       }
    
       private boolean solve (int row, int column) 
       {       
            boolean done = false;
            
            if (valid (row, column)) 
            {
                grid2[row][column] = 3;                        // laat 'breadcrumb'achter (cell is geprobeerd)

                if (row == endY && column == endX)
                {
                   done = true;                              // doolhoof opgelost (eindpunt bereikt)  
                }
                else 
                {
                   done = solve (row+1, column);             // down
                   if (!done)
                      done = solve (row, column+1);          // right
                   if (!done)
                      done = solve (row-1, column);          // up
                   if (!done)
                      done = solve (row, column-1);         // left
                }
                if (done)                                   // markeer als'final path'
                   grid2[row][column] = 7;
                   steps++;
          }
           
          return done;    
        } 
       private boolean valid (int row, int column) {

      boolean result = false;
 
        // check if cell is in the bounds of the matrix
        if (row >= 0 && row < grid2.length &&
            column >= 0 && column < grid2[0].length)

        //  check if cell is not blocked and not previously tried
        if (grid2[row][column] == 1||grid2[row][column] == 2||grid2[row][column] == 4)
           result = true;

      return result;

   }
}
