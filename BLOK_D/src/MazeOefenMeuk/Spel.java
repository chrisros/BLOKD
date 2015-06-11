/*
 * Maakt de levels van het spel
 */
package MazeOefenMeuk;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Chris
 */
public class Spel {
    
    //config 

    int x = 1;               //default start positie    
    int y = 1;               //default start positie
    int blockSize = 40;     //grootte van elke block ven het grid
    int currentLevel = 0;
    int totalScore = 0;
    protected int[][] grid ={{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                             {0,2,1,1,1,0,1,0,0,1,1,0,1,0},
                             {0,0,1,0,1,0,1,1,1,1,1,1,1,0},       
                             {0,0,0,1,1,1,1,0,0,1,0,1,1,0},      
                             {0,1,0,1,1,0,0,0,0,1,1,0,1,0},
                             {0,1,0,0,1,0,1,0,0,1,0,0,1,0},
                             {0,1,1,1,1,1,1,0,0,1,1,1,4,0}, 
                             {0,0,0,0,0,0,0,0,0,0,0,0,0,0}};  
    int steps;
    Frame frame;
    Maze doolhof;
    Held speler;
    ScoreBoard scoreboard;
    
    
    
    
    public void constructFrame(){
        frame = new Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPanelGrid(1, 1); 
        frame.setLocationRelativeTo(null);
    }
    
    public void constructLevel() throws IOException {
//  Level data, creates new Maze object with the start and finish // 
        
          
            LevelLoader loader = new LevelLoader();
            doolhof = loader.loadLevel(currentLevel); 
            doolhof.setSpel(this); 

            speler = new Held(1, 1, doolhof);
            frame.startGame(doolhof, speler);
            frame.setSize(doolhof.getWidth() * blockSize, (doolhof.getHeight() * blockSize) + 90);
            frame.setPanelGrid(doolhof.getWidth(), doolhof.getHeight());   
            doolhof.createMaze();
            scoreboard = new ScoreBoard(frame, 1000);
            speler.setScoreBoard(scoreboard);
        
        


    }
    public void start() throws IOException{
        LevelLoader loader = new LevelLoader();
        if(loader.hasLevel(currentLevel)){
            frame.dispose();
            constructFrame();
            constructLevel();
        } else{
            frame.dispose();  
            EndScreen endscreen = new EndScreen(totalScore);
            endscreen.setVisible(true);
                    
            
        }

    }
    
    public void finish() throws IOException{
        totalScore += scoreboard.getScore();      
        currentLevel++;
        start();
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


//        int i = 1;
//        
//
//        Solver solver = new Solver(doolhof, i);
//        MazeSolved opgelost = solver.start();
//        //verplaats dit naar solver!!!!!!!!!!
//        steps = opgelost.getSteps();
//        while (i < 4) {
//            i++;
//            Maze doolhof2 = new Maze(x, y);
//            Solver solver2 = new Solver(doolhof2, i);
//            MazeSolved opgelost2 = solver2.start();
//            int curSteps = opgelost2.getSteps();
//
//            if (curSteps < steps && curSteps > 0) {
//                steps = curSteps;
//                opgelost = opgelost2;
//            }
//        }