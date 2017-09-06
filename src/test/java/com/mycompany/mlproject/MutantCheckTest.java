/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mlproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aurga
 */
public class MutantCheckTest {
    


    /**
     * Test of isNotMutant method, of class MutantCheck.
     */
    @Test
    public void testIsNotMutant() {
        String[] dna = new String [] { "ATGCGA","CAGTGC","TTGTGT","AGAACG","CGTCTA","TCACTA"} ;
        MutantCheck instance = new MutantCheck();
        assertFalse( instance.isMutant(dna));
      
    }
    
    /**
     * Test of isMutant method, of class MutantCheck.
     */
    @Test
     public void testIsMutant() {
        String[] dna = new String [] { "ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"} ;
        MutantCheck instance = new MutantCheck();
        assertTrue( instance.isMutant(dna));
      
    }
    
    
}
