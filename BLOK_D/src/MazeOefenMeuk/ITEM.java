/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeOefenMeuk;

import java.awt.image.BufferedImage;

/**
 *
 * @author Aaik
 */
    public abstract class Item {
    
    protected BufferedImage image;
    protected int x;
    protected int y;
    
    
    public abstract void use(Held speler);
    
    public BufferedImage getImage(){
        return image;
    }
    
    //

}
