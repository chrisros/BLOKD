/*
 * een representatie van de held (super aap)
 */

package MazeOefenMeuk;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


/**
 * @author Chris
 */
public class Held{
    private int x;
    private int y;
    private Maze doolhof;
    private KEYVALUE direction;
    private int steps = 0;
    private ScoreBoard scoreBoard;
    private JPanel panel;
    private BufferedImage heldT;
    private BufferedImage heldB;
    private BufferedImage heldL;
    private BufferedImage heldR;
    private BufferedImage held;
    private BufferedImage pad;
    private int bullets = 0;
    private boolean hasCape = false;
    
    public Held(int x, int y, Maze doolhof)
    {
        this.x = x;
        this.y = y;
        this.doolhof = doolhof;
        try{
            pad       = ImageIO.read(new File("src/images/pad.PNG"));
            heldB       = ImageIO.read(new File("src/images/heldBottom.PNG")); 
            heldL       = ImageIO.read(new File("src/images/heldLeft.PNG")); 
            heldR       = ImageIO.read(new File("src/images/heldRight.PNG")); 
            heldT       = ImageIO.read(new File("src/images/heldTop.PNG")); 
            held = heldR;
            direction = KEYVALUE.RIGHT;
        } catch(IOException ex){}
    }
    
    public void move(KEYVALUE key) throws IOException
    {
        
        switch(key)
        {
            case LEFT:
                x--; 
                rotate(KEYVALUE.LEFT);
                if(!isBlockAccesible()){
                    x++;
                }
                
                break;
            case RIGHT:
                x++; 
                rotate(KEYVALUE.RIGHT);
                if(!isBlockAccesible()){
                   x--; 
                }
                
                break;
            case UP:
                y--; 
                rotate(KEYVALUE.UP);
                if(!isBlockAccesible()){                    
                    y++;
                }
                
                break;
            case DOWN:
                y++; 
                rotate(KEYVALUE.DOWN);
                if(!isBlockAccesible()){
                    y--;               
                }
                break;
        }
        parseMovement();
    }
    
    private boolean isBlockAccesible(){
        boolean walkable = doolhof.isBlockWalkable(x, y);
        boolean destructable = false;
        
        if(doolhof.getFirstDestructableBlock(x, y, direction)!=null){destructable = true;}
        if(hasCape&&destructable){
            return true;
        }else{
            return walkable;
        }
    }
    
           public void rotate(KEYVALUE key) 
       {
            switch(key)
             {
                 case LEFT:
                    held = heldL;
                    direction = KEYVALUE.LEFT;
                    break;
                 case RIGHT:
                    held = heldR;
                    direction = KEYVALUE.RIGHT;
                    break;
                 case UP:
                    held = heldT;
                    direction = KEYVALUE.UP;
                     break;
                 case DOWN:
                    held = heldB;
                    direction = KEYVALUE.DOWN;
                    break;
             }
       }
    
    private void parseMovement() throws IOException{
        
           steps++;
           doolhof.setHeld(held);
           Item item = doolhof.movePLayer(x, y, hasCape);
           if (item!=null){item.use(this);}
           try {
                       doolhof.repaint();
           scoreBoard.movePenalty();
            } catch (Exception e) {}
           if(isAtEnd())
           {
                doolhof.finishGame();  
           }
        }
    
    public void verkrijgSnelsteRoute() throws IOException
    {
        int i = 1;
        Maze doolhof2 = doolhof;
        Solver solver = new Solver(doolhof2, i);
        MazeSolved opgelost = solver.start();
        
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

        doolhof.paintSolution(opgelost);
        scoreBoard.cheatPenalty();
        doolhof.repaint();
    }
    
    public void fire(){
        if(bullets>0){
            Block destructBlock = doolhof.getFirstDestructableBlock(x, y, direction);
            if(null!=destructBlock){
                destructBlock.setReturnImage(pad);
                destructBlock.setWalkable(true);
                destructBlock.setDestructable(false);
                panel.repaint();
                bullets--;
                scoreBoard.bazooka(bullets);
            }else{
        }
            
        }
    }
    
    private boolean isAtEnd(){
        return x==doolhof.getEndX()&&y==doolhof.getEndY();
    }
    public void setScoreBoard(ScoreBoard board){
        scoreBoard = board;
    }
    
    public void cheatScore(int newScore ){scoreBoard.alterScore(newScore);}
    public int getX(){return x;}
    public int getY(){return y;}
    public void setPanel(JPanel p){panel = p;}
    public void setBullets(int shots){bullets = shots; scoreBoard.bazooka(shots);}
    public void giveCape(){hasCape = true;}
    public int getSteps(){return steps;}
}