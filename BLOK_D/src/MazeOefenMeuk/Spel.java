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
    int blockSize = 40;     //grootte van elke block ven het grid
    int steps;
    Frame frame;
    Maze doolhof;
    Held speler;
    ScoreBoard scoreboard;

    public void constructLevel() throws IOException {

//  Level data, creates new Maze object with the start and finish // 
        int i = 1;
        doolhof = new Maze(x, y);

        Solver solver = new Solver(doolhof, i);
        MazeSolved opgelost = solver.start();
        //verplaats dit naar solver!!!!!!!!!!
        steps = opgelost.getSteps();
        while (i < 4) {
            i++;
            Maze doolhof2 = new Maze(x, y);
            Solver solver2 = new Solver(doolhof2, i);
            MazeSolved opgelost2 = solver2.start();
            int curSteps = opgelost2.getSteps();

            if (curSteps < steps && curSteps > 0) {
                steps = curSteps;
                opgelost = opgelost2;
            }
        }

    //================================================================//
        speler = new Held(1, 1, doolhof);
        frame = new Frame(doolhof, opgelost, speler);

        setScoreBoard();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(doolhof.getWidth() * blockSize, (doolhof.getHeight() * blockSize) + 90);
        frame.setPanelGrid(doolhof.getWidth(), doolhof.getHeight());

        String feedback;
        if (opgelost.isDone()) {
            feedback = "Minimale hoeveelheid stappen = " + opgelost.getSteps();
        } else {
            feedback = "Geen oplossing";
        }
        frame.setFeedback(feedback);
    //================================================================//    

    }

    public void setScoreBoard() {
        scoreboard = new ScoreBoard(frame, 1000);
        speler.setScoreBoard(scoreboard);
    }

    public Frame getFrame() {
        return frame;
    }

    public Maze getMaze() {
        return doolhof;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
