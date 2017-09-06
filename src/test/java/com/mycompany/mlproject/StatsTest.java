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
public class StatsTest {
    

    /**
     * Test of Stats method, of class Stats.
     */
    @Test
    public void testStats() {
        Stats instance = new Stats();
    }

    /**
     * Test of calculateRatio method, of class Stats.
     */
    @Test
    public void testCalculateRatio0() {
        int count_mutants = 0;
        int count_humans = 0;
        Stats instance = new Stats();
        double expResult = 0.0;
        double result = instance.calculateRatio(count_mutants, count_humans);
        assertEquals(expResult, result, 0.0);
    }
      /**
     * Test of calculateRatio method, of class Stats.
     */
    @Test
    public void testCalculateRatio() {
        int count_mutants = 5;
        int count_humans = 34;
        Stats instance = new Stats();
        double expResult = 0.14;
        double result = instance.calculateRatio(count_mutants, count_humans);
        assertEquals(expResult, result, 0.0);
    }
}
