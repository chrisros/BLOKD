/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EscApe;

import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Chris
 */
public class Bazooka extends Item{

    public Bazooka(){
        try {
            image       = ImageIO.read(new File("src/images/bomb.PNG")); 
        } catch (Exception e) {
        }
    }
    
    @Override
    public void use(Held speler) {
        Random rn = new Random();
        int maxShots = 5;
        int minShots = 1;
        int shots = rn.nextInt(maxShots-minShots+1)+minShots;
        speler.setBullets(shots);
    }
    
}
