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
public class ScoreBoardTest {

    public ScoreBoardTest() {
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
     * Test of movePenalty method, of class ScoreBoard.
     */
    private int score = 500;
    private int x = 1, y = 1, i = 1;

    Solver solver;
    Maze doolhof;
    MazeSolved opgelost;
    Frame frame;
    Held speler;

    public void run() throws IOException {

        Spel game = new Spel();
        game.constructLevel();

        doolhof = new Maze(x, y);
        solver = new Solver(doolhof, i);
        opgelost = solver.start();
        speler = new Held(x, y, doolhof);
//        frame = new Frame(doolhof, opgelost, speler);

    }

    @Test
    public void testMovePenalty() throws IOException {
        run();
        System.out.println("movePenalty");
        ScoreBoard instance = new ScoreBoard(frame, 100);
        
        instance.movePenalty();
        instance.movePenalty();
        instance.movePenalty();

        System.out.println("inst " + instance);
        //assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of cheatPenalty method, of class ScoreBoard.
     */
    @Test
    public void testCheatPenalty() {
        System.out.println("cheatPenalty");
//        ScoreBoard instance = new ScoreBoard(null, 100);
        //      instance.cheatPenalty();
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

}
