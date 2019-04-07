/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carrerarelevoshilos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SuperUs
 */
public class UtilitariaTest {
    
    public UtilitariaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of generaNumero method, of class Utilitaria.
     */
    @Test
    public void testGeneraNumero() {
        System.out.println("generaNumero");
        int expResult = 1;
        int expResult1 = 2;
        int expResult2 = 3;
        int result = Utilitaria.generaNumero();
        //assertEquals(expResult, result);
        
        if(expResult == result || expResult1 == result || expResult2 == result){
            
        }
        else
        {
            fail("The test case is a prototype.");
        }
                
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
