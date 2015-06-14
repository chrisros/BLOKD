/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeOefenMeuk;

import java.io.IOException;

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
        Spel game = new Spel();
        frame = game.getFrame();
        doolhof = game.getMaze();
//       doolhof.setGrid(grid);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of move method, of class Held.
     */
    private Maze doolhof;
    int x = 4;
    int y = 4;
    protected int[][] grid = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
    {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
    {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
    {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
    {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
    {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    Frame frame;


    @Test
    public void testMoveDown() throws IOException {
        
        x = 1;
        y = 1;
        Held instance = new Held(1, 1, doolhof);
        instance.rotate(KEYVALUE.DOWN);
        int expResult = 1;
        int result = instance.getY();
        assertEquals(expResult, result);
        System.out.println("Test geslaagd, niet bewogen DOWN");
    }

    @Test
    public void testMoveUp() throws IOException {
        
        x = 1;
        y = 1;
        Held instance = new Held(1, 1, doolhof);
        instance.rotate(KEYVALUE.UP);

        int expResult = 1;
        int result = instance.getY();
        assertEquals(expResult, result);
        System.out.println("Test geslaagd, niet bewogen UP");
    }

    @Test
    public void testMoveLeft() throws IOException {
        
        x = 1;
        y = 1;
        Held instance = new Held(1, 1, doolhof);
        instance.rotate(KEYVALUE.LEFT);
        int expResult = 1;
        int result = instance.getX();
        assertEquals(expResult, result);
        System.out.println("Test geslaagd, niet bewogen LEFT");
    }

    @Test
    public void testMoveRight() throws IOException {
        
        x = 1;
        y = 1;
        Held instance = new Held(1, 1, doolhof);
        instance.rotate(KEYVALUE.RIGHT);
        int expResult = 1;
        int result = instance.getX();
        assertEquals(expResult, result);
        System.out.println("Test geslaagd, niet bewogen RIGHT");
    }

    @Test
    public void testMoveLEFTWEL() throws IOException {
        

        Held instance = new Held(x, y, doolhof);
        instance.rotate(KEYVALUE.LEFT);
        int expResult = 4;
        int result = instance.getX();
        assertEquals(expResult, result);
        System.out.println("Test geslaagd, leftmove");
    }

    @Test
    public void testMoveRightWEL() throws IOException {
        

        Held instance = new Held(x, y, doolhof);
        instance.rotate(KEYVALUE.RIGHT);
        int expResult = 4;
        int result = instance.getX();
        assertEquals(expResult, result);
        System.out.println("Test geslaagd, rightMOve");
    }

    @Test
    public void testMoveUpWEL() throws IOException {
        

        Held instance = new Held(x, y, doolhof);
        instance.rotate(KEYVALUE.UP);
        int expResult = 4;
        int result = instance.getY();
        assertEquals(expResult, result);
        System.out.println("Test geslaagd, upMove");
    }

    @Test
    public void testMoveDownWEL() throws IOException {
        

        Held instance = new Held(x, y, doolhof);
        instance.rotate(KEYVALUE.DOWN);

        int expResult = 4;
        int result = instance.getY();
        assertEquals(expResult, result);
        System.out.println("Test geslaagd, downMove");
    }
}
