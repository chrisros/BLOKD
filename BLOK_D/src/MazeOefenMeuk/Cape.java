/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeOefenMeuk;

import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author chris
 */
public class Cape extends Item{

    public Cape(){
        try {
            image       = ImageIO.read(new File("src/images/cape.PNG")); 
        } catch (Exception e) {
        }
    }
    
    @Override
    public void use(Held speler) {
        speler.giveCape();
    }
    
}
