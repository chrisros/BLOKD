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
public class BLOK_D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //aanmaken van brandstofsoort gebruikt in de te creeren auto
        Fuel benzine = new Fuel("benzine", 1.50);
        //to return the current fuel level, and addGas, to tank up. Sample usage:
        Car myHybrid = new Car(benzine, 20);     // 20 km/liter
        System.out.println(myHybrid.getGasLevel()); // Print fuel remaining
        System.out.println(myHybrid.getValueOfGasTank()); // Print value of fuel remaining
        myHybrid.addGas(20);            // Tank 20 liter
        System.out.println(myHybrid.getGasLevel()); // Print fuel remaining
        System.out.println(myHybrid.getValueOfGasTank()); // Print value of fuel remaining
        myHybrid.drive(100);            // Drive 100 miles
        System.out.println(myHybrid.getGasLevel()); // Print fuel remaining
        System.out.println(myHybrid.getValueOfGasTank()); // Print value of fuel remaining
    }
    
}
