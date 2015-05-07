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
    
    //toevoegen van bericht aan arraylist
    public void addMessage(Email M){
        myArray.add(M);
    }
    //ophalen van bericht uit arraylist op basis van index i
    public Email getMessage(int i)
    {
        return myArray.get(i);
    }
    //verwijderen van bericht uit arraylist op basis van index i 
    public void deleteMessage(int i){
        myArray.remove(i);
    }
}
