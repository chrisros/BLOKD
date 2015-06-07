/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeOefenMeuk;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author chris
 */
public class Maze {
    
    protected Color color;
    protected boolean walkable;
    protected int height;
    protected int width;
    
    private BufferedImage wall;
    private BufferedImage pad;
    private BufferedImage solvedPad;
    private BufferedImage start;
    private BufferedImage finish;
    private BufferedImage held;
    private BufferedImage returnImage; 
    
    
    protected  JPanel panel; 
    protected final int blockSize = 40;
    protected final int startX;
    protected final int startY;
    protected final int endX;
    protected final int endY;
    protected final int cheaterX;
    protected final int cheaterY;
    protected int playerX;
    protected int playerY;
    protected boolean solution = false;
    protected int[][] grid ={{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                             {0,2,1,1,1,0,1,0,0,1,1,0,1,0},
                             {0,0,1,0,1,0,1,1,1,1,1,1,1,0},       
                             {0,0,0,1,1,1,1,0,0,1,0,1,1,0},      
                             {0,1,0,1,1,0,0,0,0,1,1,0,1,0},
                             {0,1,0,0,1,0,1,0,0,1,0,0,1,0},
                             {0,1,1,1,1,1,1,0,0,1,1,1,4,0}, 
                             {0,0,0,0,0,0,0,0,0,0,0,0,0,0}};  
    ArrayList<Block> bloks;
    
   public Maze(int x, int y){
       startX = x;
       startY = y;
       playerX = x;
       playerY = y;
       cheaterX = 2;
       cheaterY = 2;
       endX = 12;
       endY = 6;
       height = grid.length;
       width = grid[0].length;

       
        try {
            wall       = ImageIO.read(new File("src/images/wall.PNG"));
            pad        = ImageIO.read(new File("src/images/pad.PNG"));
            solvedPad  = ImageIO.read(new File("src/images/solvedPad.PNG"));
            start      = ImageIO.read(new File("src/images/start.PNG"));
            finish     = ImageIO.read(new File("src/images/finish.PNG"));
            held = ImageIO.read(new File("src/images/heldRight.PNG")); 
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Niet alle grafische onderdelen konden geladen worden.");
        }
    }

           
       
    public void paintMaze()
    {  
        bloks = new ArrayList();
        for (int row=0; row < height; row++) 
        {
            for (int column=0; column < width; column++)
            {
                boolean player = false;
                boolean destructable = true;
                boolean edge = false;
                boolean cheater = false;
                if(row==startY&&column==startX){grid[row][column]=2;}
                if(row==endY&&column==endX){grid[row][column]=4;}
                if(row==playerY&&column==playerX){player=true;}
                if(row==cheaterY&&column==cheaterX){cheater=true; }                
                if(row==0||column==0||row==height-1||column==width-1){destructable = false; edge = true;}
                
                switch (grid[row][column]){
                    
                    case(2)  :        
                        returnImage = start;        
                        walkable = true;
                        destructable = false;
                         break;
                    case(4)  :        
                        returnImage = finish;          
                        walkable = true;
                        destructable = false;
                        break;
                    case(0) :          
                        returnImage = wall;           
                        walkable = false;
                        break;
                    default :
                        returnImage = pad;       
                        walkable = true;
                        destructable = false;
                }
                if(solution&&grid[row][column]==7){
                    returnImage = solvedPad;
                    walkable = true;
                }
                
                
                Block blok;
                
                try {
                    blok = new Block(row, column, returnImage, blockSize, false, destructable, walkable, player, edge);
                    if(player==true){ blok.setPlayerImage(held);}
                    if(cheater==true){
                        Item cheat = new Cheater(); 
                        blok.addItem(cheat);
                    }
                    bloks.add(blok);
                    System.out.println(blok);
                } catch (Exception e) {}  
                }
                    
        }
        panel.setBackground(Color.BLACK);
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        repaint();        
    } 
    
    //tekent de objecten uit de arraylist opnieuw op het panel
    public void repaint(){
        
        panel.removeAll();   
        
        Iterator<Block> iter = bloks.iterator();
        while(iter.hasNext()){
            Block curBlok  = iter.next();
            panel.add(curBlok); 
        }
        panel.updateUI();
    } 
    
    //bekijkt of een object op een bepaal dcoordinaat (x, y) walkable is
    public boolean isBlockWalkable(int x, int y)
    {
        boolean walk = false;
        Iterator<Block> iter = bloks.iterator();
        while(iter.hasNext()){
            Block curBlok  = iter.next();
            if(curBlok.getx()==x&&curBlok.gety()==y){
                walk = curBlok.getWalkable();   
            }                  
        }
        return walk;
    }
    
    public Block getFirstDestructableBlock(int x, int y, KEYVALUE direction){
        
            Block curBlok = getBlock(x, y);
            System.out.println(curBlok);
            if(curBlok.getDestructable()){
                    return curBlok;                           
            }else if(curBlok.isEdge()){
                return null;
            }
                    else{
                switch(direction)
                {
                case LEFT:
                   x--;
                   break;
                case RIGHT:
                   x++;
                   break;
                case UP:
                    y--;
                    break;
                case DOWN:
                   y++;
                   break;
                }
                return getFirstDestructableBlock(x, y, direction);
            }   
        }
    
    public Block getBlock(int x, int y){
        Iterator<Block> iter = bloks.iterator();
        while(iter.hasNext()){
            Block curBlok  = iter.next();
            if(curBlok.getx()==x&&curBlok.gety()==y){
                return curBlok;
            }  
    }
        return null;
    }
    public void movePLayer(int x, int y){
         Iterator<Block> iter = bloks.iterator();
        while(iter.hasNext()){
            Block curBlok  = iter.next();
            if(curBlok.getx()==x&&curBlok.gety()==y){
                curBlok.setPlayer(true); 
                curBlok.setPlayerImage(held);
                System.out.println(curBlok);
            }else{
                curBlok.setPlayer(false);
                curBlok.setPlayerImage(null);
            } 

        }
    }
    
   public int[][] getGrid(){return grid;}
   public void setHeld(BufferedImage Held){held = Held;}
   public void setBlock(int x, int y, int value){grid[y][x]=value;} 
   public int getStartX(){return startX;}
   public int getStartY(){return startY;}
   public int getEndX(){return endX;}
   public int getEndY(){return endY;}
   public int getWidth(){return grid[0].length  ;}
   public int getHeight(){return grid.length;}
   public int getPlayerX(){return playerX;}
   public int getPlayerY(){return playerY;}
   public void setPanel(JPanel pan){panel = pan;}
   public void setPlayerX(int x){playerX = x;}
   public void setPlayerY(int y){playerY = y;}
   public void setSolution(boolean bool){solution=bool;}
   public void setGrid(int[][] Grid){grid = Grid;}
        

}
