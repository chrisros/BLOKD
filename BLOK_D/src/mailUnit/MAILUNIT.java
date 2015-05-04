/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mailUnit;

/**
 *
 * @author Chris
 */
public class MAILUNIT {
    
    public static void main(String[] args) {
        int i =1;
        MailBox box = new MailBox();
        
        while(i<10){
            Email mailtje = new Email("Jou", "Mij");
            
            mailtje.append("Dit is een bericht. NR: "+Integer.toString(i));
            box.addMessage(mailtje);
            System.out.println(mailtje.getMail());
            i++;
        }
        System.out.println(box.getMessage(4).getMail());
    }
}
