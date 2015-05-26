//haalt de levels uit een txt files en parsed ze naar 'Spel'

//IN DEV

package MazeOefenMeuk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chris
 */
public class LevelLoader {

    int i = 1;
    
    public LevelLoader(){
        loadLevels();
    }
   
    private void loadLevels(){
        // create Scanner inFile1
        Scanner inFile1;
       try {
           String token1;
           inFile1 = new Scanner(new File("src/leveldata/levels.txt"));
           while(inFile1.hasNext()){
               String row = inFile1.next();
               if(row.equals("<start>")){
                   System.out.println("startx"+inFile1.next());
                   System.out.println("starty"+inFile1.next());
               }
                if(row.equals("<end>")){
                   System.out.println("endx"+inFile1.next());
                   System.out.println("endy"+inFile1.next());
               }
               if(row.equals("<grid>")){
                   while(!row.equals("</grid>")){
                       System.out.println(inFile1.next());
                   }
               }
               
           }
                    
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Spel.class.getName()).log(Level.SEVERE, null, ex);
           
       }
    
        
}
}