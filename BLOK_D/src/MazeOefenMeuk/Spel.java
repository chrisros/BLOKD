/*
 * Maakt de levels van het spel
 */

package MazeOefenMeuk;

import java.io.IOException;
import javax.swing.JFrame;

/**
 * @author Chris
 */
public class Spel {
   //config 
   int x = 1;               //default start positie 
   int y = 1;               //default start positie
   int blockSize = 100;     //grootte van elke block ven het grid
   int steps;
   
   public void constructLevel() throws IOException{
   //  Level data, creates new Maze object with the start and finish // 
    int i = 1;
    Maze doolhof = new Maze(x, y);
    Solver solver = new Solver(doolhof, i);
    MazeSolved opgelost = solver.start();
    steps = opgelost.getSteps();
    while (i<4)
    {
        i++;
        Maze doolhof2 = new Maze(x, y);
        Solver solver2 = new Solver(doolhof2, i);
        MazeSolved opgelost2 = solver2.start();
        int curSteps = opgelost2.getSteps();
        
        if(curSteps<steps&&curSteps>0)
        {
            steps = curSteps;
            opgelost=opgelost2;
        }
    }
       
    //================================================================//
    
        Held speler = new Held(x, y, doolhof);
        Frame frame = new Frame(doolhof, opgelost, speler);
        ScoreBoard scoreboard = new ScoreBoard(frame, 1000);
        speler.setScoreBoard(scoreboard);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(doolhof.getWidth()*blockSize, (doolhof.getHeight()*blockSize)+90);
        frame.setPanelGrid(doolhof.getWidth(), doolhof.getHeight());
        
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
}
