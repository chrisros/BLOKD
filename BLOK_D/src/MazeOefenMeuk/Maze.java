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
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author chris
 */
public class Maze {
    
    protected Color color;
    boolean walkable;
    
    private BufferedImage wall;
    private BufferedImage pad;
    private BufferedImage solvedPad;
    private BufferedImage start;
    private BufferedImage finish;
    private BufferedImage held;
    private BufferedImage heldT;
    private BufferedImage heldB;
    private BufferedImage heldL;
    private BufferedImage heldR;
    private BufferedImage returnImage; 
    
    
    protected  JPanel panel; 
    protected final int blockSize = 40;
    protected final int startX;
    protected final int startY;
    protected final int endX;
    protected final int endY;
    protected int playerX;
    protected int playerY;
    protected boolean solution = false;
    protected int[][] grid ={{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                             {0,1,1,1,1,0,1,0,0,1,1,0,1,0},
                             {0,0,1,0,1,0,1,1,1,1,1,1,1,0},       
                             {0,0,0,1,1,1,1,0,0,1,0,1,1,0},      
                             {0,1,0,1,1,0,0,0,0,1,1,0,1,0},
                             {0,1,0,0,1,0,1,0,0,1,0,0,1,0},
                             {0,1,1,1,1,1,1,0,0,1,1,1,1,0}, 
                             {0,0,0,0,0,0,0,0,0,0,0,0,0,0}};  

   public Maze(int x, int y){
       startX = x;
       startY = y;
       playerX = x;
       playerY = y;
       endX = 12;
       endY = 6;
       
        try {
            wall       = ImageIO.read(new File("src/images/wall.PNG"));
            pad        = ImageIO.read(new File("src/images/pad.PNG"));
            solvedPad  = ImageIO.read(new File("src/images/solvedPad.PNG"));
            start      = ImageIO.read(new File("src/images/start.PNG"));
            finish     = ImageIO.read(new File("src/images/finish.PNG"));
            heldB       = ImageIO.read(new File("src/images/heldBottom.PNG")); 
            heldL       = ImageIO.read(new File("src/images/heldLeft.PNG")); 
            heldR       = ImageIO.read(new File("src/images/heldRight.PNG")); 
            heldT       = ImageIO.read(new File("src/images/heldTop.PNG")); 
            held = heldR;
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Niet alle grafische onderdelen konden geladen worden.");
        }
    }
       public void rotate(KEYVALUE key) 
       {
            double angle = 0;
            switch(key)
             {
                 case LEFT:
                    held = heldL;
                    break;
                 case RIGHT:
                    held = heldR;
                    break;
                 case UP:
                    held = heldT;
                     break;
                 case DOWN:
                    held = heldB;
                    break;
             }
            
       }
   
    public void printMaze() {
   
      System.out.println();

      for (int row=0; row < grid.length; row++) 
      {
         for (int column=0; column < grid[row].length; column++)
            System.out.print (grid[row][column]);
         System.out.println();
      }

      System.out.println();
    }
        
    public void paintMaze()
    {
        //panel leegmaken
        panel.removeAll();
                
        for (int row=0; row < grid.length; row++) 
        {
            for (int column=0; column < grid[row].length; column++)
            {
                boolean player = false;
                if(row==startY&&column==startX){grid[row][column]=2;}
                if(row==endY&&column==endX){grid[row][column]=4;}
                if(row==playerY&&column==playerX){player=true;}
                
                switch (grid[row][column]){
                    case(0) :          
                        returnImage = wall;      
                        color = Color.black;      
                        walkable = false;
                        break;
                    case(2)  :        
                        returnImage = start;     
                        color = Color.orange;     
                         walkable = true;
                         break;
                    case(4)  :        
                        returnImage = finish;    
                        color = Color.red;        
                        walkable = true;
                        break;
                
                    default :
                        returnImage = pad;       
                        color = Color.lightGray;  
                        walkable = false;
                }
                if(solution&&grid[row][column]==7){
                    returnImage = solvedPad;
                    color = Color.green;
                    walkable = true;
                }
                
                
                Block blok;
                try {
                    if(player==true)   
                    { 
                       color=Color.pink;
                       blok = new Block(returnImage, color, blockSize, true);
                       blok.setTopImage(held);
                    }else
                    {
                        blok = new Block(returnImage, color, blockSize, false);
                    }
                    panel.add(blok);
                } catch (Exception e) {
                }  
                }
                
                    
        }
        //panel met nieuwe UI inladen
        panel.setBackground(Color.BLACK);
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.updateUI();
        
        
    } 
    
   public int[][] getGrid(){return grid;}
   public int getBlock(int x, int y){return grid[y][x];}
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
