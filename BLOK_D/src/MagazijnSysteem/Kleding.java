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
public class Kleding extends Product {
    
    private final String maat;
    
    
    public Kleding(int Id, double Prijs, String Omschrijving, String Maat){
        setId(Id);
        setPrijs(Prijs);
        setOmschrijving(Omschrijving);
        setDagenLevertijd(3);
        if (!Maat.matches("S|s|M|m|L|l|XL|xl")){
            maat = "n/a";
        } else {
            maat = Maat;
        }
           
    }

    @Override
    public double getPrijs(){
        if(maat.equals("XL")){
            return super.getPrijs()*1.1;
        }
        else{
            return super.getPrijs();
        }
    }
    
            @Override
    public String toString(){
        return "----------\nId: "+getId()+"\nPrijs: "+getPrijs()+"\nOmschrijving: "+getOmschrijving()+"\n Levertijd: "+getLevertijd()+" Dagen \n Maat: "+ maat+"\n----------";
    }
    
}
