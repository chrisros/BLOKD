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

     /**
     * Test of move method, of class Held.
     */
    private Maze doolhof;
    int x;
    int y;
    protected int[][] grid = {  {0, 0, 0, 0, 0},
                                {0, 1, 1, 1, 0},
                                {0, 1, 1, 1, 0},
                                {0, 1, 1, 1, 0},
                                {0, 0, 0, 0, 0}};
    Frame frame;


    @BeforeClass
    public static void setUpClass() {
        
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {

        doolhof = new Maze(1, 1);
        doolhof.createMaze();
        //doolhof.createMaze();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testMove1() throws IOException {
        x = 1;
        y = 1;
        Held instance = new Held(x, y, doolhof);
        instance.move(KEYVALUE.LEFT);
        int expResultX = 2;
        int expResultY = 1;
        int resultX = instance.getX();
        int resultY = instance.getY();
        assertEquals(expResultX, resultX);
        assertEquals(expResultY, resultY);
        System.out.println("Test geslaagd, niet bewogen DOWN");
    }
        @Test
    public void testMove2() throws IOException {
        
        x = 3;
        y = 2;
        Held instance = new Held(x, y, doolhof);
        instance.move(KEYVALUE.DOWN);
        int expResultX = 3;
        int expResultY = 3;
        int resultX = instance.getX();
        int resultY = instance.getY();
        assertEquals(expResultX, resultX);
        assertEquals(expResultY, resultY);
        System.out.println("Test geslaagd, niet bewogen DOWN");
    }
        @Test
    public void testMove3() throws IOException {
        
        x = 1;
        y = 2;
        Held instance = new Held(x, y, doolhof);
        instance.move(KEYVALUE.LEFT);
        int expResultX = 1;
        int expResultY = 2;
        int resultX = instance.getX();
        int resultY = instance.getY();
        assertEquals(expResultX, resultX);
        assertEquals(expResultY, resultY);
        System.out.println("Test geslaagd, niet bewogen DOWN");
    }

  
}
