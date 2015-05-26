/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeOefenMeuk;

import static MazeOefenMeuk.KEYVALUE.DOWN;
import static MazeOefenMeuk.KEYVALUE.RIGHT;
import java.io.IOException;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aaik
 */
public class HeldTest {

    public HeldTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of move method, of class Held.
     */
    private Maze doolhof;
    int x = 1;
    int y = 1;

    public void runTheGame() throws IOException {

        Spel game = new Spel();
        game.constructLevel();
    }

    @Test
    public void testMoveDown() throws IOException {
        runTheGame();

        doolhof = new Maze(x, y);
        Held instance = new Held(1, 1, doolhof);
        instance.move(KEYVALUE.DOWN);

        int expResult = 1;        
        int result = x;
        assertEquals(expResult, result);
        System.out.println("Test geslaagd, DOWN");
    }
    
     @Test
    public void testMoveUp() throws IOException {
        runTheGame();

        doolhof = new Maze(x, y);
        Held instance = new Held(1, 1, doolhof);
        instance.move(KEYVALUE.UP);

        int expResult = 1;        
        int result = x;
        assertEquals(expResult, result);
        System.out.println("Test geslaagd, UP");
    }
    
     @Test
    public void testMoveLeft() throws IOException {
        runTheGame();

        doolhof = new Maze(x, y);
        Held instance = new Held(1, 1, doolhof);
        instance.move(KEYVALUE.LEFT);

        int expResult = 1;        
        int result = x;
        assertEquals(expResult, result);
        System.out.println("Test geslaagd, LEFT");
    }
    
     @Test
    public void testMoveRIGHT() throws IOException {
        runTheGame();

        doolhof = new Maze(x, y);
        Held instance = new Held(1, 1, doolhof);
        instance.move(KEYVALUE.RIGHT);
        int expResult = 1;        
        int result = x;
        assertEquals(expResult, result);
        System.out.println("Test geslaagd, RIGHT");
    }

}
