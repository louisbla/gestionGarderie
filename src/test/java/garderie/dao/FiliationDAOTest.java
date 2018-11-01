/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.Enfant;
import garderie.model.Filiation;
import garderie.model.Parent;
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
public class FiliationDAOTest {
    private Connection connection;
    private Filiation filiation;
    private FiliationDAO filiationDAO;
    
    public FiliationDAOTest() {
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
        filiationDAO = new FiliationDAO(connection);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class FiliationDAO.
     */
    @Test
    public void testCreate() {
//        System.out.println("create");
//        Filiation obj = null;
//        FiliationDAO instance = null;
//        Filiation expResult = null;
//        Filiation result = instance.create(obj);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class FiliationDAO.
     */
    @Test
    public void testUpdate() {
//        System.out.println("update");
//        Filiation obj = null;
//        FiliationDAO instance = null;
//        Filiation expResult = null;
//        Filiation result = instance.update(obj);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class FiliationDAO.
     */
    @Test
    public void testDelete() {
//        System.out.println("delete");
//        Filiation obj = null;
//        FiliationDAO instance = null;
//        instance.delete(obj);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class FiliationDAO.
     */
    @Test
    public void testFindById() {
//        System.out.println("findById");
//        int id = 0;
//        FiliationDAO instance = null;
//        Filiation expResult = null;
//        Filiation result = instance.findById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class FiliationDAO.
     */
    @Test
    public void testFindAll() {
//        System.out.println("findAll");
//        FiliationDAO instance = null;
//        ArrayList<Filiation> expResult = null;
//        ArrayList<Filiation> result = instance.findAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllById method, of class FiliationDAO.
     */
    @Test
    public void testFindAllById() {
//        System.out.println("findAllById");
//        FiliationDAO instance = null;
//        ArrayList<Filiation> expResult = null;
//        ArrayList<Filiation> result = instance.findAllById();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllEnfantsForParent method, of class FiliationDAO.
     */
    @Test
    public void testFindAllEnfantsForParent() {
        System.out.println("findAllEnfantsForParent");
        int idPersonne = 11;
        ArrayList<Filiation> result = filiationDAO.findAllEnfantsForParent(idPersonne);
        assertEquals(2, result.size());
    }

    /**
     * Test of findAllParentsForEnfant method, of class FiliationDAO.
     */
    @Test
    public void testFindAllParentsForEnfant() {
        System.out.println("findAllParentsForEnfant");
        int idEnfant = 4;
        ArrayList<Filiation> result = filiationDAO.findAllParentsForEnfant(idEnfant);
        assertEquals(2, result.size());
    }
    
}
