/*
 * een representatie van de held (super aap)
 */

package MazeOefenMeuk;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * @author Chris
 */
public class Held{
    private int x;
    private int y;
    private Maze doolhof;
    private int steps = 0;
    private ScoreBoard scoreBoard;
    private JPanel panel;
    
    public Held(int x, int y, Maze doolhof)
    {
        this.x = x;
        this.y = y;
        this.doolhof = doolhof;
    }
    
    public void move(KEYVALUE key)
    {
        
        switch(key)
        {
            case LEFT:
                x--; 
                doolhof.rotate(KEYVALUE.LEFT);
                if(doolhof.isBlockWalkable(x, y)){
                    doMove();                    
                } else{
                    x++;
                }
                
                break;
            case RIGHT:
                x++; 
                doolhof.rotate(KEYVALUE.RIGHT);
                System.out.println(x);
                System.out.println(y);
                System.out.println(doolhof.isBlockWalkable(x, y));
                if(doolhof.isBlockWalkable(x, y)){
                    doMove();                    
                } else{
                   x--; 
                }
                
                break;
            case UP:
                y--; 
                doolhof.rotate(KEYVALUE.UP);
                if(doolhof.isBlockWalkable(x, y)){                    
                    doMove();
                } else{
                    y++;
                }
                
                break;
            case DOWN:
                y++; 
                doolhof.rotate(KEYVALUE.DOWN);
                if(doolhof.isBlockWalkable(x, y)){
                    doMove();
                } else{
                    y--;
                }
                
                break;
        } 
    }
    
    private void doMove(){
        System.out.println("jep");
           steps++;
           doolhof.movePLayer(x, y);
           doolhof.repaint();
           //scoreBoard.movePenalty();
           if(isAtEnd())
           {
                JOptionPane.showMessageDialog(null, "Het einde is bereikt");   
           }
        }
    
    public void verkrijgSnelsteRoute() throws IOException
    {
        doolhof.setSolution(true);
        int i = 1;
        Maze doolhof2 = new Maze(x, y);
        Solver solver = new Solver(doolhof2, i);
        MazeSolved opgelost = solver.start();
        opgelost.setPanel(panel);
        steps = opgelost.getSteps();
        while (i<4)
        {
            i++;
            Solver solver2 = new Solver(doolhof2, i);
            MazeSolved opgelost2 = solver2.start();
            int curSteps = opgelost2.getSteps();

            if(curSteps<steps&&curSteps>0)
            {
                steps = curSteps;
                opgelost=opgelost2;
            }
        }
        //opgelost.paintMaze();
        doolhof.setGrid(doolhof2.getGrid());
        doolhof.setBlock(x, y, 1);
        doolhof.paintMaze();
        scoreBoard.cheatPenalty();
    }
    
    private boolean isAtEnd(){
        return x==doolhof.getEndX()&&y==doolhof.getEndY();
    }
    public void setScoreBoard(ScoreBoard board){
        scoreBoard = board;
    }
    
    public int getX(){return x;}
    public int getY(){return y;}
    public void setPanel(JPanel p){panel = p;}
}