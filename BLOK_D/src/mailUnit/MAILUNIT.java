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
        
        //maken van 10 Emails, de emails printen en toevoegen aan de mailbox
        while(i<10){
            Email mailtje = new Email("Jou", "Mij");
            
            mailtje.append("Dit is een bericht. NR: "+Integer.toString(i));
            box.addMessage(mailtje);
            System.out.println(mailtje);
            i++;
        }
        //selecteren van mail uit dse mailbox op basis van index nummer 'index'
        int index = 4;
        System.out.println(box.getMessage(index));
        box.deleteMessage(4);
        System.out.println(box.getMessage(index));
    }
}
