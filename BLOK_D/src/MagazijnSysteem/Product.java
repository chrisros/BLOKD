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
public class Product {
    private int id;
    private double prijs;
    private String omschrijving;
    private int dagenLevertijd;
    
    public int getId(){
        return id;
    }
    public double getPrijs(){
        return prijs;
    }
    public String getOmschrijving(){
        return omschrijving;
    }
    public int getLevertijd(){
        return dagenLevertijd;
    }
    public void setId(int x){
         id=x;
    }
    public void setPrijs(double x){
         prijs=x;
    }
    public void setOmschrijving(String x){
         omschrijving=x;
    }
    public void setDagenLevertijd(int x){
         dagenLevertijd=x;
    }
                

    
}
