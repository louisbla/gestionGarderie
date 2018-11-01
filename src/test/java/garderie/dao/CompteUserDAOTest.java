/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.CompteUser;
import java.sql.Connection;
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
public class CompteUserDAOTest {
    private Connection connection;
    private CompteUser compteUser;
    private CompteUserDAO compteUserDAO;
    
    public CompteUserDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
        compteUserDAO = new CompteUserDAO(connection);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class CompteUserDAO.
     */
    @Test
    public void testCreate() {
//        System.out.println("create");
//        CompteUser compte = null;
//        CompteUserDAO instance = null;
//        CompteUser expResult = null;
//        CompteUser result = instance.create(compte);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CompteUserDAO.
     */
    @Test
    public void testUpdate() {
//        System.out.println("update");
//        CompteUser compte = null;
//        CompteUserDAO instance = null;
//        CompteUser expResult = null;
//        CompteUser result = instance.update(compte);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class CompteUserDAO.
     */
    @Test
    public void testDelete() {
//        System.out.println("delete");
//        CompteUser compte = null;
//        CompteUserDAO instance = null;
//        instance.delete(compte);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class CompteUserDAO.
     */
    @Test
    public void testFindById() {
//        System.out.println("findById");
//        int id = 1;
//        CompteUser result = compteUserDAO.findById(id);
//        assertEquals("jdoe", result.getLogin());
    }

    /**
     * Test of findAll method, of class CompteUserDAO.
     */
    @Test
    public void testFindAll() {
//        System.out.println("findAll");
//        ArrayList<CompteUser> result = compteUserDAO.findAll();
//        assertEquals(9, result.size());
    }
    
}
