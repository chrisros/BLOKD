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
    
    public Car(Fuel brandstofType,double kmPerLiter){
        this.kmPerLiter = kmPerLiter;
        this.brandstofType = brandstofType;
    }
    
    public void addGas(double hoeveelheid){
        this.tankNiveau = this.tankNiveau + hoeveelheid;
    }
    
    public void drive (double afstand){
        this.tankNiveau = this.tankNiveau - (afstand/this.kmPerLiter);
    }
    public String getGasLevel(){
        return Double.toString(tankNiveau);
    }
    public double getValueOfGasTank(){
        return brandstofType.getGasPrice()*tankNiveau;
    }
}
