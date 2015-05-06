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
public class MAGAZIJNSYSTEEM {
    
    public static void main(String[] args) {
        int id = 0;
        
        Product shirt1 = new Kleding(id, 10.00, "Mooi thsirt met cool design", "M"); id++;
        Product shirt2 = new Kleding(id, 14.00, "Mooi thsirt met uniek design", "f"); id++;
        Product shirt3 = new Kleding(id, 10.00, "Mooi thsirt met vet design", "XL"); id++;
        Product drank1 = new AlcoholischeDrank(id, 12.00, "Wodka", 40.00); id++;
        Product drank2 = new AlcoholischeDrank(id, 06.00, "pasoa", 14.99); id++;
        Product drank3 = new AlcoholischeDrank(id, 02.00, "bier", 5.5); id++;
        Product voedsel1 = new Voedsel(id, 09.75, "hamburger", "01-10-2015"); id++;
        Product voedsel2 = new Voedsel(id, 06.25, "pizza", "28-04-2105"); id++;
        Product voedsel3 = new Voedsel(id, 12.12, "boerenkool", "08-05-2015"); id++;
        
        System.out.println(shirt1);
        System.out.println(shirt2);
        System.out.println(shirt3);
        System.out.println(drank1);
        System.out.println(drank2);
        System.out.println(drank3);
        System.out.println(voedsel1);
        System.out.println(voedsel2);
        System.out.println(voedsel3);
    

    }
}
