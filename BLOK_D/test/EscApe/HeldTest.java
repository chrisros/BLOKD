/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscApe;

import EscApe.Frame;
import EscApe.KEYVALUE;
import EscApe.Held;
import EscApe.Maze;
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
    int x = 2;
    int y = 2;
    protected int[][] grid = 
    {
    {0, 0, 0, 0, 0},
    {0, 1, 1, 1, 0},
    {0, 1, 1, 1, 0},
    {0, 1, 1, 0, 0},
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
        instance.move(KEYVALUE.UP);
        int expResultX = 3;
        int expResultY = 1;
        int resultX = instance.getX();
        int resultY = instance.getY();
        assertEquals(expResultX, resultX);
        assertEquals(expResultY, resultY);
        System.out.println("Test geslaagd move, bewogen UP");
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

        System.out.println("Test geslaagd parseMovement, End level - No Cape");
    }

    @Test
    public void testparseMove2() throws IOException {

        int endX = 3;
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

        System.out.println("Test geslaagd parseMovement, No End - Cape");
    }

    @Test
    public void testparseMove3() throws IOException {

        int endX = 3;
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

        System.out.println("Test geslaagd parseMovement, No End - No Cape");
    }

    @Test
    public void testparseMove4() throws IOException {

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

        System.out.println("Test geslaagd parseMovement, End level - Cape");
    }

   @Test
    public void testFire1() {
        x = 2;
        y = 3;
                
        Held instance = new Held(x, y, doolhof);

        instance.fire();
        instance.setBullets(0);
        instance.setDirection(KEYVALUE.UP);

        int expResultBull = 0;
        int resultBull = instance.getBullets();
        
        assertEquals(expResultBull, resultBull);
        System.out.println("Test geslaagd fire, 0 kogels");
    }
    
    @Test
    public void testFire2() {
        x = 1;
        y = 4;
                
        Held instance = new Held(x, y, doolhof);

        instance.fire();
        instance.setBullets(2);
        instance.setDirection(KEYVALUE.LEFT);

        int expResultBull = 2;
        int resultBull = instance.getBullets();
        
        assertEquals(expResultBull, resultBull);
        System.out.println("Test geslaagd fire, 2 kogels over (begonnen met 2)");
    }
    @Test
    public void testFire2_2() {
        x = 2;
        y = 4;
                
        Held instance = new Held(x, y, doolhof);

        instance.fire();
        instance.setBullets(2);
        instance.setDirection(KEYVALUE.LEFT);

        int expResultBull = 2;
        int resultBull = instance.getBullets();
        
        assertEquals(expResultBull, resultBull);
        System.out.println("Test geslaagd fire, 2 kogels over (begonnen met 2)");
    }
    
    @Test
    public void testFire3() {
        x = 3;
        y = 3;
                
        Held instance = new Held(x, y, doolhof);

        instance.setBullets(3);
        instance.setDirection(KEYVALUE.LEFT);
        instance.fire();

        int expResultBull = 2;
        int resultBull = instance.getBullets();
        
        assertEquals(expResultBull, resultBull);
        System.out.println("Test geslaagd fire, 2 kogels over (begonnen met 3)");
    }
}