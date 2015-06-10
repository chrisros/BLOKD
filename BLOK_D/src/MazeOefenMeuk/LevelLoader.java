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
    private int startX, startY;
    int endX, endY;
    int height, width;
    private String[] levelAr;
    private String[][] level2DAr;

    public LevelLoader() {
        //loadLevels(i);
    }

    public void loadLevels(int level) {
        // create Scanner inFile1
        Scanner inFile1;

        // Aanroepen values
        Maze mz = new Maze(startX, startY);
        try {
            String token1;
            inFile1 = new Scanner(new File("src/leveldata/level" + 1 + ".txt"));
            while (inFile1.hasNext()) {
                String row = inFile1.next();
                if (row.equals("<start>")) {
                    startX = Integer.getInteger(inFile1.next());
                    startY = Integer.getInteger(inFile1.next());
                    System.out.println(startX + ", " + startY);

                    mz.setPlayerX(startX);
                    mz.setPlayerY(startY);
                }
                if (row.equals("<end>")) {

                    endX = Integer.getInteger(inFile1.next());
                    endY = Integer.getInteger(inFile1.next());

                    mz.setEndX(endX);
                    mz.setEndY(endY);
                }
                if (row.equals("<height>")) {
                    height = Integer.getInteger(inFile1.next());
                }
                if (row.equals("<width>")) {
                    width = Integer.getInteger(inFile1.next());
                }
                if (row.equals("<grid>")) {
                    while (!row.equals("</grid>")) {
                        for (int j = 0; j < width; j++) {
                            levelAr[j] = inFile1.next();
                        }
                        try {
                            for (int i1 = 0; i1 < width; i1++) {
                                for (int j1 = 0; j1 < width; j1++) {
                                    level2DAr[i1][j1] = levelAr[i1].substring(j1, j1 + i1);
                                }
                            }
                        } catch (Exception e) {
                        }
                    }
                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Spel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
