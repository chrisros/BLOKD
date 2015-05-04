/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mailUnit;

import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class MailBox {
    ArrayList<Email> myArray = new ArrayList<Email>();
    
    
    public void addMessage(Email M){
        myArray.add(M);
    }
    public Email getMessage(int i)
    {
        return myArray.get(i);
    }
    public void deleteMessage(int i){
        myArray.remove(i);
    }
}
