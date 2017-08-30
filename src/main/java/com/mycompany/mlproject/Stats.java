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
    
    public  int count_mutant_dna;
    public  int count_human_dna;
    public  double ratio;
    
    public  void ratio(int count_mutants, int count_humans){
            if(count_humans > 0){
                ratio = (double)count_mutants/(double)count_humans ;
            }
        
           
    }
    public void Stats(){
    
        count_human_dna =0;
        count_mutant_dna = 0;
        ratio = 0;
    }
    
}
