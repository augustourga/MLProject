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
public class SaveTest {


    /**
     * Test of isMutant method, of class Save.
     */
    @Test
    public void testIsMutant() {
        Save instance = new Save();
        instance.isMutant=false;
        boolean expResult = false;
        boolean result = instance.isMutant();
        assertEquals(expResult, result);
        
    }
    
}
