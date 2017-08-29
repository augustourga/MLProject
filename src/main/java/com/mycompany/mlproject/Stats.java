/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mlproject;

/**
 *
 * @author augus
 */
public class Stats {
    
    public static int count_mutant_dna;
    public static int count_human_dna;
    public static double ratio;
    
    public  void ratio(int count_mutants, int count_humans){
    
           ratio = count_mutants/count_humans ;
    }
    public void stats(){
    
        count_human_dna =0;
        count_mutant_dna = 0;
        ratio = 0;
    }
    
}
