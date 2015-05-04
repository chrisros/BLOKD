/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carTankFuel;

/**
 *
 * @author Chris
 */
public class Fuel {
    
    private double brandstofPrijs;
    private String naam;
    
    public  Fuel(String name, double brandstofPrijs){
        this.brandstofPrijs = brandstofPrijs;
        this.naam = name;
    }
    
    public void setGasPrice(double brandstofPrijs){
        this.brandstofPrijs = brandstofPrijs;
    }
    public double getGasPrice(){
        return this.brandstofPrijs;
    }
    
}
