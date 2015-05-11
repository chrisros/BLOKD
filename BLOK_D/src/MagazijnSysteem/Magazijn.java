/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MagazijnSysteem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Chris
 */
public class Magazijn {
    
    ArrayList<Product> magazijn = new  ArrayList<>();
    
    public void opslaan(Product product){
        magazijn.add(product);
    }
    
            public Product ophalen(int ID){

                Product opgevraagd = null;
                Iterator<Product> iter = magazijn.iterator();
                while(iter.hasNext()){
                    Product prod = iter.next();

                    if(prod.getId()==ID){
                        opgevraagd = prod;
                    }
                } 
                return opgevraagd;
            }
    
}
