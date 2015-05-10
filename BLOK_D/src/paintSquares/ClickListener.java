/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintSquares;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author Chris
 */
public class ClickListener implements ActionListener 
{
    DrawFrame frame;
    ClickListener(DrawFrame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent event)
    { 
        int number = getValueTextfield();
        if(number>0){
            drawImages(number);            
        }
    }
    
    private int getValueTextfield(){
        try {
            String amount = frame.getinput();
            int textFieldValue = Integer.parseInt(amount);
            if(textFieldValue<21&&textFieldValue>0){
                return textFieldValue;
            } else{
                frame.setOutput("Getal buiten bereik");
                return 0;
            }
            
        } catch (Exception e) {
            frame.setOutput("Geen geldig cijfer ingevoerd");
            return 0;
        }
 

    }
    private void drawImages(int i)
    {    
        JComponent squares = new Square(i);
        JFrame frame = new DrawFrame(i+" Vierkanten", 1000, 800);
        frame.add(squares);
        

    } 
}
