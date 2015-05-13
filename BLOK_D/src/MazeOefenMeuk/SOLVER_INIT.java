package MazeOefenMeuk;

import javax.swing.JFrame;

public class SOLVER_INIT {
    static int x = 1;
    static int y = 1;
    static int blockSize = 100;
   public static void main (String[] args) {

   //================================================================//
   //  Level data, creates new Maze object with the start and finish //
   //================================================================//

    
    Maze doolhof = new Maze(x, y);
    Maze doolhof2 = new Maze(x, y);
    Solver solver = new Solver(doolhof2);
    Maze_Solved opgelost = solver.start();
    
//debug info
    doolhof.printMaze();
    opgelost.printMaze();
    if(opgelost.isDone())
    {
        System.out.println ("Maze solved!");
    } else{
        System.out.println ("No solution."); 
    }
    //     
    
    //================================================================//
    Frame frame = new Frame(doolhof, opgelost);
        frame.setVisible(true);
        frame.setTitle("MazeSolver 9001");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(doolhof.getWidth()*blockSize, doolhof.getHeight()*blockSize);
        String feedback;
        if(opgelost.isDone())
        {
            feedback="Minimale hoeveelheid stappen = "+opgelost.getSteps();
        } else{
            feedback = "Geen oplossing";
        }
        frame.setFeedback(feedback);
    //================================================================//    


     
   }
}// class Maze