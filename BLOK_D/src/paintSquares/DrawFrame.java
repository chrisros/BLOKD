/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintSquares;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Chris
 */
public class DrawFrame extends JFrame {
    
    private JTextField inputField;
    private JLabel outputField;
    public JButton button;
    private JLabel label;
    
    
public DrawFrame(String title, int width, int height){
    setVisible(true);
    addComponents();
    setSize(width, height);
    setTitle(title);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
}
//voegt alle componenten aan een panel 
private void addComponents(){
    createTextfield(5);
    createButton();
    JPanel panel = new JPanel();    
    panel.add(label);
    panel.add(inputField);
    panel.add(button);
    panel.add(outputField);
    add(panel);   
    
}

private void createTextfield(int LENGTH)
{
    label = new JLabel("Klik op de knop om een bepaalde hoeveelheid vierkanten te tekenen");
    outputField = new JLabel("");
    inputField = new JTextField(LENGTH);
    inputField.setText("0");
    
}

public void setOutput(String text){
    outputField.setText(text);
}
public String getinput(){
    return inputField.getText();
}
public void setListener(ClickListener a){
   button.addActionListener(a);
}

private void createButton()
{
    button = new JButton("Teken!");
}
}
