/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package week1bouwen;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class opdracht630 {

    public static void main(String[] args) {
        {
            Scanner in = new Scanner(System.in);
            boolean end = false;
            ArrayList<Double> sales = new ArrayList<Double>();
            ArrayList<String> customers = new ArrayList<String>();
            System.out.println("Voer de namen van alle klanten van vandaag in en typ 'klaar'als je klaar bent.");
            System.out.println("------------------------------------------------------------------------------");
            while (!end) {
                System.out.println("Voer de naam in");
                String naam = in.nextLine();
                if (String.valueOf(naam).equals("klaar")) {
                    end = true;
                }
                if (!end) {
                    customers.add(naam);
                }
                if (!end) {
                    System.out.println("Voer de prijs in");
                    double prijs;
                    try {
                        prijs = in.nextDouble();
                    } catch (Exception e) {
                        System.out.println("geen geldig nummer");
                        prijs = 0.01;
                    }
                    if (prijs == 0) {
                        end = true;
                    }
                    if (!end) {
                        sales.add(prijs);
                    }
//                System.out.println("Druk op enter om nog een klant/prijs in te voeren");
                    in.nextLine();
                }

            }
            printHoogsteArrays(sales, customers);
        }
    }

    public static void printHoogsteArrays(ArrayList<Double> sales, ArrayList<String> customers) {
        double highestPrice = 0;
        String hoogsteKlant = "onbekend";
        for (int i = 0; i < sales.size(); i++) {
            if (sales.get(i) > highestPrice) {
                highestPrice = sales.get(i);
                hoogsteKlant = customers.get(i);
            }

        }
        System.out.println("De best betalende klant is: " + hoogsteKlant + " en deze klant heeft maarliefst " + highestPrice + " euro betaald");



    }
}
