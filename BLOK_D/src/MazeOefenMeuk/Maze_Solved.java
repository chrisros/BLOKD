/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeOefenMeuk;

/**
 *
 * @author Chris
 */
public class Maze_Solved extends Maze{
    
    private final int steps;
    private final boolean done;
    public Maze_Solved(int[][] maze, int x, int y, int count, boolean solved) {
        super(x, y);
        steps = count;
        done = solved;
        solution = true;
    }
    
        
    @Override
    public void printMaze() 
    {

        System.out.println();

        for (int row=0; row < grid.length; row++) 
        {
            for (int column=0; column < grid[row].length; column++)
                System.out.print (grid[row][column]);
            System.out.println();
        }
        System.out.println();
        System.out.println("Amount of steps: "+steps);  
    }
      
    public boolean isDone(){return done;}
    public int getSteps(){return steps;}
}
