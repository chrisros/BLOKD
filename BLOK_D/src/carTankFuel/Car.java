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
public class Car {
    
    private final double kmPerLiter;
    private double tankNiveau = 0;
    private final Fuel brandstofType;
    
    //constructor voor auto
    public Car(Fuel brandstofType,double kmPerLiter){
        this.kmPerLiter = kmPerLiter;
        this.brandstofType = brandstofType;
    }
    //simuleert het tanken van het voertuig
    public void addGas(double hoeveelheid){
        this.tankNiveau = this.tankNiveau + hoeveelheid;
    }
    //laat de auto een afstand in kilometers rijden
    public void drive (double afstand){
        this.tankNiveau = this.tankNiveau - (afstand/this.kmPerLiter);
    }
    //returned hoeveelheid brandstof als double
    public String getGasLevel(){
        return Double.toString(tankNiveau);
    }
    //krijgt waarde van gastank op basis van waarde van het object van de brandstof in de auto
    public double getValueOfGasTank(){
        return brandstofType.getGasPrice()*tankNiveau;
    }
}
