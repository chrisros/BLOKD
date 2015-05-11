/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MagazijnSysteem;

/**
 *
 * @author Chris
 */
public class Voedsel extends Product {
    
    String date;
    
    public Voedsel(int Id, double Prijs, String Omschrijving, String Date ){
        setId(Id);
        setPrijs(Prijs);
        setOmschrijving(Omschrijving);
        setDagenLevertijd(1);
        date = Date;   
    }
    
    @Override
    public String toString(){
        return "----------\nId: "+getId()+"\nPrijs: "+getPrijs()+"\nOmschrijving: "+getOmschrijving()+"\n Levertijd: "+getLevertijd()+" Dagen \n Uiterste houdbaarheids datum: "+ date+"\n----------";
    }
    
}
