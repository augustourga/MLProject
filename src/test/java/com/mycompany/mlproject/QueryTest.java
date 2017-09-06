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
public class QueryTest {
    

    /**
     * Test of dna method, of class Query.
     */
    @Test
    public void testDna() {
        System.out.println("dna");
        String[] strings = null;
        Query instance = new Query();
        instance.dna(strings);
    }

    /**
     * Test of validate method NxN, of class Query.
     */
    @Test
    public void testNotNxNValidate() {
        System.out.println("validate");
        Query instance = new Query();
        String[] dna = new String [] { "ATGCGA","CAGTGC","TTGTGT","AGAACG","CGTCTA","TCACT"} ;
        instance.dna(dna);
        assertFalse(instance.validate());
    }
      /**
     * Test of validate method Char accepted, of class Query.
     */
    @Test
    public void testNotAcceptedCharValidate() {
        System.out.println("validate");
        Query instance = new Query();
        String[] dna = new String [] {  "AHGCGA","CAGTGC","TTGTGT","AGAACG","CGTCTA","TCACTA"} ;
        instance.dna(dna);
        assertFalse(instance.validate());
    }
     /**
     * Test of validate method, of class Query.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        Query instance = new Query();
        String[] dna = new String [] {  "ACGCGA","CAGTGC","TTGTGT","AGAACG","CGTCTA","TCACTA"} ;
         instance.dna(dna);
        assertTrue(instance.validate());
    }
    
}
