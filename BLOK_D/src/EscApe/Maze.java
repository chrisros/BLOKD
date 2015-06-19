/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EscApe;

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
    private Spel spel;
    protected final int blockSize = 40;
    protected final int startX, startY;
    protected int endX, endY;
    protected int cheaterX, cheaterY;
    protected int helperX, helperY;
    protected int bazookaX, bazookaY;
    protected int capeX, capeY;
    protected int playerX, playerY;
    protected boolean solution = false;
    protected int[][] grid;
    ArrayList<Block> bloks;
    
   public Maze(int x, int y){
       startX = x;
       startY = y;
       playerX = x;
       playerY = y;

       
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

           
       
    public void createMaze()
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
                boolean helper = false;
                boolean bazooka = false;
                boolean cape = false;
                if(row==0||column==0||row==height-1||column==width-1){destructable = false; edge = true;} else{
                if(row==startY&&column==startX){grid[row][column]=2;}
                if(row==endY&&column==endX){grid[row][column]=4;}
                if(row==playerY&&column==playerX){player=true;}
                if(row==cheaterY&&column==cheaterX){cheater=true; }  
                if(row==helperY&&column==helperX){helper=true; } 
                if(row==bazookaY&&column==bazookaX){bazooka=true; }
                if(row==capeY&&column==capeX){cape=true; }
                }
                
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
                Item item = null;
                try {
                    blok = new Block(row, column, returnImage, blockSize, destructable, walkable, player, edge);
                    if(player==true){ blok.setPlayerImage(held);}
                    if(cheater==true){ 
                        item = new Cheater(); 
                    }
                    if(helper==true){ 
                        item = new Helper();                         
                    }
                    if(bazooka==true){ 
                        item = new Bazooka();                         
                    }
                    if(cape==true){ 
                        item = new Cape();                         
                    }
                    if(null!=item){blok.addItem(item);}
                    bloks.add(blok);
                } catch (Exception e) {}  
                }
                    
        }
      
    } 
    
    public void paintSolution(Maze opgelost){
        int[][] solvedgrid = opgelost.getGrid();
    for (int row=0; row < height; row++) 
        {
            for (int column=0; column < width; column++)
            {
                if(solvedgrid[row][column]==7){
                    
                    Block blok = getBlock(column, row);
                    
                    blok.setReturnImage(solvedPad);
                }
            }
        }
    }
    
    //tekent de objecten uit de arraylist opnieuw op het panel
    public void repaint(){
        try {
        panel.removeAll();   
        
        Iterator<Block> iter = bloks.iterator();
        while(iter.hasNext()){
            Block curBlok  = iter.next();
            panel.add(curBlok); 
        }
        panel.updateUI();
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        } catch (Exception e) {
        }

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
    public Item movePLayer(int x, int y, boolean hasCape){
        playerX = x;
        playerY = y;
        Item item = null;
         Iterator<Block> iter = bloks.iterator();
        while(iter.hasNext()){
            Block curBlok  = iter.next();
            if(curBlok.getx()==x&&curBlok.gety()==y){
                curBlok.setPlayer(true); 
                curBlok.setPlayerImage(held);
                if(!hasCape){
                curBlok.setReturnImage(pad);
                }
                if(curBlok.hasItem()){
                    item = curBlok.getItem();
                    curBlok.useItem();
                }
            }else{
                curBlok.setPlayer(false);
                curBlok.setPlayerImage(null);
                
            } 

        }
        return item;
    }
    
    public void restartLevel() throws IOException{
        
        spel.start();
    }
    public void finishGame() throws IOException{
        spel.finish();
    }
    
   public int[][] getGrid(){return grid;}
   public void setHeld(BufferedImage Held){held = Held;}
   public void setBlock(int x, int y, int value){grid[y][x]=value;} 
   public int getEndX(){return endX;}
   public int getEndY(){return endY;}
   public int getWidth(){return grid[0].length  ;}
   public int getHeight(){return grid.length;}
   public int getPlayerX(){return playerX;}
   public int getPlayerY(){return playerY;}
   public void setPanel(JPanel pan){panel = pan;}
   public void setSolution(boolean bool){solution=bool;}
   public void setSpel(Spel spel){this.spel = spel;} 
       public void setCheater(int x, int y){cheaterX = x; cheaterY = y;}
       public void setHelper(int x, int y){helperX = x; helperY = y;}
       public void setBazooka(int x, int y){bazookaX = x; bazookaY = y;}
       public void setEnd(int x, int y){endX = x; endY = y;}
       public void setCape(int x, int y){capeX = x; capeY = y;}
       public void setGrid(int[][] level){
           grid = level;
           height = grid.length;
           width = grid[0].length;
       }
}
