/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EscApe;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Chris
 */
public class Helper extends Item{

    public Helper(){
        try {
            image       = ImageIO.read(new File("src/images/helper.PNG")); 
        } catch (Exception e) {
        }
    }
    
    @Override
    public void use(Held speler) {
        try {
            speler.verkrijgSnelsteRoute();
        } catch (IOException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
