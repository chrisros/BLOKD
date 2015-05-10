/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintSquares;

/**
 *
 * @author Chris
 */
public class PAINTSQUARES {
    public static void main (String[] args) {
        
        DrawFrame frame = new DrawFrame("Een Frame", 1000, 800);
        ClickListener listener = new ClickListener(frame);
        frame.setListener(listener);
    }
}
