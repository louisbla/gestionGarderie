/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.Enfant;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Katsuo
 */
public class EnfantDAOTest {
    
    public EnfantDAOTest() {
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
     * Test of create method, of class EnfantDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Enfant obj = null;
        EnfantDAO instance = null;
        Enfant expResult = null;
        Enfant result = instance.create(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class EnfantDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Enfant obj = null;
        EnfantDAO instance = null;
        Enfant expResult = null;
        Enfant result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class EnfantDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Enfant obj = null;
        EnfantDAO instance = null;
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class EnfantDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 0;
        EnfantDAO instance = null;
        Enfant expResult = null;
        Enfant result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class EnfantDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        EnfantDAO instance = null;
        ArrayList<Enfant> expResult = null;
        ArrayList<Enfant> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
