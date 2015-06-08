/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeOefenMeuk;

import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Chris
 */
public class Cheater extends Item{

    public Cheater(){
        try {
            image       = ImageIO.read(new File("src/images/cheater.PNG")); 
        } catch (Exception e) {
        }
    }

    @Override
    public void use(Held speler) {
        Random rn = new Random();
        int maxScore = 2000;
        int minScore = 100;
        int maxSteps = 50;
        int minSteps = 5;
        int newScore = rn.nextInt(maxScore-minScore+1)+minScore;
        int newSteps = rn.nextInt(maxSteps-minSteps+1)+minSteps;
        
        speler.cheatScore(newScore);
    }

    
    
}
