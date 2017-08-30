/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mlproject;

/**
 *
 * @author augus
 *  *  */


public class MutantCheck {

    /**
     *
     * @param dna
     * @return
     */
        public String posibilities = "ACTG";

         public String isMutant(String[] dna) {
        int n = dna.length;
        for (int i = 0; i < n; i++) {
            //nxn validate
          
               if((i < n-3) && dna[i].length() + dna[i+1].length() + dna[i+2].length() + dna[i+3].length()  + dna[i+4].length()!= n*5){
                return "notNxN";
                }
            
            for (int j = 0; j < n; j++) {
                if (i < n-3) {

                    // Diagonal
                    if (j < n-3) {
                        String diagonalBuffer = "";
                        char sequence = dna[i].charAt(j);
                         String newValidateString = posibilities.replace(String.valueOf(sequence), "");
                        if(newValidateString.length() != 3 ){
                            return "invalidChar";
                        }
                        diagonalBuffer += sequence;
                        diagonalBuffer += dna[i+1].charAt(j+1);
                        diagonalBuffer += dna[i+2].charAt(j+2);
                        diagonalBuffer += dna[i+3].charAt(j+3);
                        String newString = diagonalBuffer.replace(String.valueOf(sequence), "");
                        if (newString.length() == 0) {
                            return "true";
                        }
                    }

                    // Vertical
                    String verticalBuffer = "";
                    char sequence = dna[i].charAt(j);
                     String newValidateString = posibilities.replace(String.valueOf(sequence), "");
                        if(newValidateString.length() != 3 ){
                            return "invalidChar";
                        }
                    verticalBuffer += sequence;
                    verticalBuffer += dna[i+1].charAt(j);
                    verticalBuffer += dna[i+2].charAt(j);
                    verticalBuffer += dna[i+3].charAt(j);
                    String newString = verticalBuffer.replace(String.valueOf(sequence), "");
                    if (newString.length() == 0) {
                        return "true";
                    }
                }

                // Horizontal
                if (j < n-3) {
                    String horizontalBuffer = "";
                    char sequence = dna[i].charAt(j);
                     String newValidateString = posibilities.replace(String.valueOf(sequence), "");
                        if(newValidateString.length() != 3 ){
                            return "invalidChar";
                        }
                    horizontalBuffer += sequence;
                    horizontalBuffer += dna[i].charAt(j+1);
                    horizontalBuffer += dna[i].charAt(j+2);
                    horizontalBuffer += dna[i].charAt(j+3);
                    String newString = horizontalBuffer.replace(String.valueOf(sequence), "");
                    if (newString.length() == 0) {
                        return "true";
                    }
                }
            }
        }
        return "false";
    }
                
    
}
