/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeOefenMeuk;

import MagazijnSysteem.Product;
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
                             {0,2,1,1,1,0,1,0,0,1,1,0,1,0},
                             {0,0,1,0,1,0,1,1,1,1,1,1,1,0},       
                             {0,0,0,1,1,1,1,0,0,1,0,1,1,0},      
                             {0,1,0,1,1,0,0,0,0,1,1,0,1,0},
                             {0,1,0,0,1,0,1,0,0,1,0,0,1,0},
                             {0,1,1,1,1,1,1,0,0,1,1,1,4,0}, 
                             {0,0,0,0,0,0,0,0,0,0,0,0,0,0}};  
    ArrayList<Block> bloks = new ArrayList();
    
   public Maze(int x, int y){
       startX = x;
       startY = y;
       playerX = x;
       playerY = y;
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
           
       
    public void paintMaze()
    {
                
        for (int row=0; row < height; row++) 
        {
            for (int column=0; column < width; column++)
            {
                boolean player = false;
                boolean destructable = true;
                boolean hasitem = false;
                if(row==startY&&column==startX){grid[row][column]=2;}
                if(row==endY&&column==endX){grid[row][column]=4;}
                if(row==playerY&&column==playerX){player=true;}
                if(row==0||column==0||row==height-1||column==width-1){destructable = false;}
                
                switch (grid[row][column]){
                    
                    case(2)  :        
                        returnImage = start;        
                        walkable = true;
                         break;
                    case(4)  :        
                        returnImage = finish;          
                        walkable = true;
                        break;
                    case(0) :          
                        returnImage = wall;           
                        walkable = false;
                        break;
                    default :
                        returnImage = pad;       
                        walkable = true;
                }
                if(solution&&grid[row][column]==7){
                    returnImage = solvedPad;
                    walkable = true;
                }
                
                
                Block blok;
                
                try {
                    blok = new Block(row, column, returnImage, blockSize, hasitem, destructable, walkable, player);
                    if(player==true){ blok.setTopImage(held);}
                    bloks.add(blok);
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
            //System.out.println(curBlok); 
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
    
    public void movePLayer(int x, int y){
         Iterator<Block> iter = bloks.iterator();
        while(iter.hasNext()){
            Block curBlok  = iter.next();
            if(curBlok.getx()==x&&curBlok.gety()==y){
                curBlok.setPlayer(true);  
            }else{
                curBlok.setPlayer(false);
            } 

        }
    }
    
   public int[][] getGrid(){return grid;}
   
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
