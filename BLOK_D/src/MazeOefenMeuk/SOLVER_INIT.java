package MazeOefenMeuk;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SOLVER_INIT {


   public static void main (String[] args) {
   //================================================================//
   //  Level data, creates new Maze object with the start and finish //
   //================================================================//
    int x = 1;
    int y = 1;
    int[][] grid = {{0,0,0,0,0,0},
                    {0,1,1,1,1,0},
                    {0,0,1,0,1,0},       
                    {0,1,1,0,1,0},
                    {0,1,0,0,1,0},
                    {0,1,1,1,1,0}, 
                    {0,0,0,0,0,0}};

    Maze doolhof = new Maze(grid, x, y);
    doolhof.printMaze();
    
    Solver solver = new Solver(doolhof);
    Maze_Solved opgelost = solver.start();
    opgelost.printMaze();
    if(opgelost.isDone())
    {
         System.out.println ("Maze solved!");
    } else{
       System.out.println ("No solution."); 
    }
         
    
    //================================================================//
    Frame frame = new Frame(doolhof, opgelost);
        frame.setVisible(true);
        frame.setTitle("een mooi frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Block blok = new Block();
        //frame.addBlock(blok);
        
    //================================================================//    


     
   }
}// class Maze