/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mlproject;
import java.math.*;

/**
 *
 * @author augus
 */
public class Stats {
    
    public  int count_mutant_dna;
    public  int count_human_dna;
    public  double ratio;
    
   //constructor
    public void Stats(){
        
    
        count_human_dna =0;
        count_mutant_dna = 0;
        ratio = 0;
    }
    //calculate Ratio
    public  double calculateRatio(int count_mutants, int count_humans){
            double average = 0;
        if(count_humans > 0)
        {
                 average = (double)count_mutants/(double)count_humans ;
                
        }
        return new BigDecimal(average)
        .setScale(2, RoundingMode.DOWN)
        .doubleValue();
           
    }
   
    
}
