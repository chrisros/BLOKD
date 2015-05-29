/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeOefenMeuk;

import java.io.IOException;

/**
 *
 * @author Chris
 */
public class MazeSolved extends Maze{
    
    private final int steps;
    private final boolean done;
    
    public MazeSolved(int[][] maze, int x, int y, int count, boolean solved) throws IOException {
        super(x, y);
        grid = maze;
        steps = count;
        done = solved;
        solution = true;
    }
      
    public boolean isDone(){return done;}
    public int getSteps(){return steps;}
}
