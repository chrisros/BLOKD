/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeOefenMeuk;

import java.awt.image.BufferedImage;
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
    int x = 1;
    int y = 1;
    protected int[][] grid = {{0, 0, 0, 0, 0},
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

        doolhof = new Maze(x, y);
        doolhof.setGrid(grid);
        doolhof.createMaze();
        //doolhof.createMaze();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testMove1() throws IOException {
        x = 3;
        y = 1;
        Held instance = new Held(x, y, doolhof);
        instance.move(KEYVALUE.LEFT);
        int expResultX = 2;
        int expResultY = 1;
        int resultX = instance.getX();
        int resultY = instance.getY();
        assertEquals(expResultX, resultX);
        assertEquals(expResultY, resultY);
        System.out.println("Test geslaagd move, bewogen LEFT");
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
        System.out.println("Test geslaagd move, bewogen DOWN");
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
        System.out.println("Test geslaagd move, niet bewogen LEFT");
    }


    @Test
    public void testparseMove1() throws IOException {

        x = 2;
        y = 2;
        int endX = 2;
        int endY = 2;

        Held instance = new Held(x, y, doolhof);

        instance.parseMovement();
        instance.setCape(true);
        doolhof.setEnd(endX, endY);

        boolean expResultCape = true;
        boolean expResultEnd = true;
        boolean resultCape = instance.getCape();
        boolean resultEnd = instance.isAtEnd();
        assertEquals(expResultCape, resultCape);
        assertEquals(expResultEnd, resultEnd);

        System.out.println("Test geslaagd parseMovement, End level - met Cape");
    }
    
    @Test
    public void testparseMove2() throws IOException {

        x = 2;
        y = 2;
        int endX = 2;
        int endY = 2;

        Held instance = new Held(x, y, doolhof);

        instance.parseMovement();
        instance.setCape(false);
        doolhof.setEnd(endX, endY);

        boolean expResultCape = false;
        boolean expResultEnd = true;
        boolean resultCape = instance.getCape();
        boolean resultEnd = instance.isAtEnd();
        assertEquals(expResultCape, resultCape);
        assertEquals(expResultEnd, resultEnd);

        System.out.println("Test geslaagd parseMovement, End level - zonder Cape");
    }
    
    @Test
    public void testparseMove3() throws IOException {

        x = 3;
        y = 2;
        int endX = 2;
        int endY = 2;

        Held instance = new Held(x, y, doolhof);

        instance.parseMovement();
        instance.setCape(true);
        doolhof.setEnd(endX, endY);

        boolean expResultCape = true;
        boolean expResultEnd = false;
        boolean resultCape = instance.getCape();
        boolean resultEnd = instance.isAtEnd();
        assertEquals(expResultCape, resultCape);
        assertEquals(expResultEnd, resultEnd);

        System.out.println("Test geslaagd parseMovement, Not end level - met Cape");
    }
    
     @Test
    public void testparseMove4() throws IOException {

        x = 3;
        y = 2;
        int endX = 2;
        int endY = 2;

        Held instance = new Held(x, y, doolhof);

        instance.parseMovement();
        instance.setCape(false);
        doolhof.setEnd(endX, endY);

        boolean expResultCape = false;
        boolean expResultEnd = false;
        boolean resultCape = instance.getCape();
        boolean resultEnd = instance.isAtEnd();
        assertEquals(expResultCape, resultCape);
        assertEquals(expResultEnd, resultEnd);

        System.out.println("Test geslaagd parseMovement, Not end level - not Cape");
    }
}
