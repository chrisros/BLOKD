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
public class AlcoholischeDrank  extends Product{
    
    double alcoholPercentage;
    
    public AlcoholischeDrank(int Id, double Prijs, String Omschrijving, double AlcoholPercentage ){
        setId(Id);
        setPrijs(Prijs);
        setOmschrijving(Omschrijving);
        setDagenLevertijd(2);
        alcoholPercentage = AlcoholPercentage;   
    }
 
        @Override
    public String toString(){
        return "----------\nId: "+getId()+"\nPrijs: "+getPrijs()+"\nOmschrijving: "+getOmschrijving()+"\n Levertijd: "+getLevertijd()+" Dagen \n UalcoholPercentage: "+ alcoholPercentage +"%\n----------";
    }
    
}
