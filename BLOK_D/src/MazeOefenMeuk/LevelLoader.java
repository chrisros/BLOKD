//haalt de levels uit een txt files en parsed ze naar 'Spel'
//IN DEV
package MazeOefenMeuk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Chris
 */
public class LevelLoader {

    int i = 1;
    private int X, Y;
    private int height, width;
    private int[][] grid;
    private Maze maze ;
    private Scanner inFile1;

    
    public boolean hasLevel(int level) {
        boolean haslevel = false;
        File f = new File("src/leveldata/level" + level + ".txt");
        if(f.exists() && !f.isDirectory()){haslevel = true;} 
        return haslevel;
    }

    public Maze loadLevel(int level) {
        // create Scanner inFile1
        

        // Aanroepen values
        
        try {
           
            inFile1 = new Scanner(new File("src/leveldata/level" + level + ".txt"));
            while (inFile1.hasNext()) {
                String row = inFile1.next();                
                if (row.equals("<start>")) {
                    X = Integer.parseInt(inFile1.next());
                    Y = Integer.parseInt(inFile1.next());
                    maze = new Maze(X, Y);
                }
                if (row.equals("<end>")) {

                    X = Integer.parseInt(inFile1.next());
                    Y = Integer.parseInt(inFile1.next());
                    maze.setEnd(X, Y);
                }
                if (row.equals("<height>")) {
                    height = Integer.parseInt(inFile1.next());
                }
                if (row.equals("<width>")) {
                    width = Integer.parseInt(inFile1.next());
                }
                if (row.equals("<cheater>")) {
                    X = Integer.parseInt(inFile1.next());
                    Y = Integer.parseInt(inFile1.next());
                    maze.setCheater(X, Y);
                }
                if (row.equals("<bazooka>")) {
                    X = Integer.parseInt(inFile1.next());
                    Y = Integer.parseInt(inFile1.next());
                    maze.setBazooka(X, Y);
                }
                if (row.equals("<helper>")) {
                    X = Integer.parseInt(inFile1.next());
                    Y = Integer.parseInt(inFile1.next());
                    maze.setHelper(X, Y);
                }

                if (row.equals("<grid>")) {
                    
                    row = inFile1.next();
                    int curHeight = 0;
                    grid = new int[height][width];
                    
                    while (!row.equals("</grid>")) {
                        
                        int curPos = 0;
                        
                        while(curPos<width){
                            int cell = Integer.parseInt(row.substring(curPos, curPos+1));
                            grid[curHeight][curPos] = cell;
                            curPos++;
                        }
                        curHeight++;
                        row = inFile1.next();
                    }
                    maze.setGrid(grid);
                    
                }
                

            }

        } catch (FileNotFoundException ex) {
            return null;
        }
        
        return maze;
        
    }
}