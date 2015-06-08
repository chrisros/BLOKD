/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeOefenMeuk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Aaik
 */
public class reader {

     
    private int[][] veldLijst;
    private Scanner levelOpbouw;
    private final int AANTAL_KOL_RIJ;
    private String[] level;
    private String[][] level_2D;
    private int hoeveelheidLevels;
    
    public reader(int levelCount){
        AANTAL_KOL_RIJ = 12;
        level = new String[AANTAL_KOL_RIJ];
        level_2D = new String[AANTAL_KOL_RIJ][AANTAL_KOL_RIJ];
        veldLijst = new int[AANTAL_KOL_RIJ][AANTAL_KOL_RIJ];
        hoeveelheidLevels = levelCount();
        openFile(levelCount);
        readFile();
        closeFile();
        bouwGrid();
    }
    
    // Telt de levels
    private int levelCount(){
        boolean isGevonden = false;
        int i = 1;
        while(isGevonden){
            try{
                Scanner levelCount = new Scanner(new File("C:\\Users\\Aaik\\Documents\\000 HHS\\INF-D 2015-1.2 VT DH Software Engineering\\Bouwen\\VerplichteOpdrachtenBlokD\\src\\TESTtxtREAD\\Levels\\level" + i + ".txt"));
                System.out.println("gevonden " + isGevonden);
            } catch (Exception e){
                isGevonden = true;
            }
        }
        return i-1;
    }
    
    // Openen van het textbestand
    private void openFile(int level){
        String levelText = "";
        levelText = "C:\\Users\\Aaik\\Documents\\000 HHS\\INF-D 2015-1.2 VT DH Software Engineering\\Bouwen\\VerplichteOpdrachtenBlokD\\src\\TESTtxtREAD\\Levels\\level" + 
                Integer.toString(level)+ ".txt";
        try {
            levelOpbouw = new Scanner(new File(levelText));
        } catch (Exception e) {
        }
    }
    
    // Lees het text bestand
    private void readFile(){
        while(levelOpbouw.hasNext()){
            for (int i = 0; i < AANTAL_KOL_RIJ; i++) {
                level[i] = levelOpbouw.next();
            }
        } try {
            for (int i = 0; i < AANTAL_KOL_RIJ; i++) {
                for (int j = 0; j < AANTAL_KOL_RIJ; j++) {
                    level_2D[i][j] = level[i].substring(j, j+i);
                }
        }
        } catch (Exception e) {
        }
    }
    
    // Text bestand weer dicht maken
    private void closeFile(){
        levelOpbouw.close();
    }
    
    // grid bouwen
    private void bouwGrid(){
        for (int i = 0; i < AANTAL_KOL_RIJ; i++) {
            for (int j = 0; j < AANTAL_KOL_RIJ; j++) {
                String huidig = level_2D[i][j];
                switch (huidig){
                    case "0":{
                        // set muren
                    } case "1":{
                        // set pad
                    } case "h":{
                        // set helper
                    } case "s":{
                        // set start
                    } case "v":{
                        // set valsspeler
                    } case "b":{
                        // set bazooka
                    }
                }
            }
        }
    }
    
    public int AANTAL_KOL_RIJ(){
        return AANTAL_KOL_RIJ;
    }
     
    
}