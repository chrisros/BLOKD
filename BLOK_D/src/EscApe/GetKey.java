/*
 *verantwoordelijk voor het ophalken van toetsaanslagen, en deze doorgeven aan de held 
 */

package EscApe;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Chris
 */
public class GetKey implements KeyListener
{
    //array voor het bewaren van de laatste 4 ingetoetste toetsen
    //hiermee kunnen cheatcodes worden herkend
    private int[] c = new int[4];
    private final Held speler;
    
    public GetKey(Held speler){
        this.speler = speler;
    }
    //slaat de laatste 4 toetsanslaagen op
    private void cacheUserInput(int code){
        c[3]=c[2]; c[2]=c[1]; c[1]=c[0]; c[0] = code;
    }
    
    //kijkt of het woord 'help' wordt getyped   
    private boolean helperCheatCode()
    {
        boolean cheated = false;
        //     H       E       L       P
        if(c[3]==72&&c[2]==69&&c[1]==76&&c[0]==80)
        {
            cheated = true;
        } 
        return cheated;
    }
    //kijkt of het woord 'boom' wordt getyped
    private boolean bazookaCheatCode()
    {
        boolean cheated = false;
        //     B       O       O       M
        if(c[3]==66&&c[2]==79&&c[1]==79&&c[0]==77)
        {
            cheated = true;
        } 
        return cheated;
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        
        try {
            int keyCode = e.getKeyCode();
            cacheUserInput(keyCode);
            
            switch(keyCode)
            {
                case 32:
                    speler.fire();
                    break;
                case 37:
                    speler.move(KEYVALUE.LEFT);
                    break;
                    
                case 38:
                    speler.move(KEYVALUE.UP);
                    break;
                    
                case 39:
                    speler.move(KEYVALUE.RIGHT);
                    break;
                    
                case 40:
                    speler.move(KEYVALUE.DOWN);
                    break;
            }
            
            if(helperCheatCode())
            {
                try {
                    speler.verkrijgSnelsteRoute();    
                } catch (IOException ex) {
                    Logger.getLogger(GetKey.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(bazookaCheatCode())
            {
                speler.setBullets(5);
            }
        } catch (IOException ex) {
            Logger.getLogger(GetKey.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //vereiste methodes voor het implementeren van KeyListener java class
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}
