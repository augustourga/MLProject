/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mlproject;
import java.util.List;

/**
 *
 * @author augus
 */
public class Query {
    
    public String[] dna;
    public void dna(String[] strings){
    dna = strings;
    }
    
    
    public boolean validate() {
        int n = dna.length;
        for (int i = 0; i < n; i++) {
        if(dna[i].length() != n){return false;}
            String newString = dna[i].toUpperCase();
            //newString = newString.replace("[ACTG]","")
            newString = newString.replace("A", "");
            newString = newString.replace("C", "");
            newString = newString.replace("T", "");
            newString = newString.replace("G", "");
      if(newString.length() != 0){return false;}
            }  return true;}
    
}
