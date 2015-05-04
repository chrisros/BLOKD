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
public class Email {
    private final String reciepant;
    private final String sender;
    private String message = "";
    
    public Email(String R, String S){
        this.reciepant = R;
        this.sender = S;
    }
    
    public void append(String M){
        this.message=this.message+M+"\n";
    }
    
    public String getMail(){
        return "FROM: "+this.sender+"\nTO: "+this.reciepant+"\n \n"+this.message;
    }
}
