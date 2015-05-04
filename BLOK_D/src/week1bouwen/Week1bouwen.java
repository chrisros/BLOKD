
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package week1bouwen;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Chris
 * 
 */
public class Week1bouwen {
 static int[][] array = new int[4][4];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        {
           //haal input op en valideer die voordat het in de array wordt gezet
            Scanner in = new Scanner(System.in);
            System.out.println("Voer 1 tot en met 16 in");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    int nieuwgetal = in.nextInt();
                    boolean x = checkArray(nieuwgetal);
                    while(x)
                    {
                        System.out.println("getal is al ingevoerd");
                        nieuwgetal=in.nextInt();
                        x=checkArray(nieuwgetal);
                    }
                    array[i][j] = nieuwgetal;
                   }
            }
            
            
            
            
          //print de magic square en laat weten of het een magic square is  
            
            for (int i = 0; i < 4; i++) {
                // Process the ith row
                for (int j = 0; j < 4; j++) {
                    // Process the jth column in the ith row
                    System.out.printf("%8d", array[i][j]);
                }
                System.out.println(); // Start a new line at the end of the row
            }
            if(isMagicSquare(array))
            {
                System.out.println("Het is een magic SQUARE!");
            }
            else{
                System.out.println("Het is helaas geen magic square");
            }
        }
    }
    //methode voor validatie van input
    private static boolean checkArray(int val)
    {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(array[i][j] == val)
                {
                    return true;
                }
            }
          
        } return false;
    } 
    //check of de cijfers in de array een magic square zijn
    private static boolean isMagicSquare(int[][] array)
    {
        
        boolean isMagicSquare = false;
        int horizontaal = 0;
        int diagonaal = 0;
        int verticaal = 0;
        for (int i = 0; i < 4; i++) {
            horizontaal = horizontaal + array[0][i];
            System.out.println("horizontaal : " +horizontaal);
        }
        for (int i = 0; i < 4; i++) {
            diagonaal = diagonaal+array[i][i];
            System.out.println("diagonaal : " +diagonaal);
        }
        for (int i = 0; i < 4; i++) {
            verticaal = verticaal + array[i][0];
            System.out.println("verticaal: " +verticaal);
        }
        if(diagonaal == horizontaal)
        {
            isMagicSquare = true;
        }
            return isMagicSquare;
        }
        
    }

