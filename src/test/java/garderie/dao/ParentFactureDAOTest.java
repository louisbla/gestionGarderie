/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.Facture;
import garderie.model.ParentFacture;
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
public class ParentFactureDAOTest {
    private Connection connection;
    private ParentFactureDAO parentFactureDAO;
    private ParentFacture parentFacture;
    
    public ParentFactureDAOTest() {
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
        parentFactureDAO = new ParentFactureDAO(connection);
        parentFacture = new ParentFacture();
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ParentFactureDAO.
     */
    @Test
    public void testCreate() {
//        System.out.println("create");
//        ParentFacture obj = null;
//        ParentFactureDAO instance = null;
//        ParentFacture expResult = null;
//        ParentFacture result = instance.create(obj);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ParentFactureDAO.
     */
    @Test
    public void testUpdate() {
//        System.out.println("update");
//        ParentFacture obj = null;
//        ParentFactureDAO instance = null;
//        ParentFacture expResult = null;
//        ParentFacture result = instance.update(obj);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ParentFactureDAO.
     */
    @Test
    public void testDelete() {
//        System.out.println("delete");
//        ParentFacture obj = null;
//        ParentFactureDAO instance = null;
//        instance.delete(obj);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class ParentFactureDAO.
     */
    @Test
    public void testFindById() {
//        System.out.println("findById");
//        int id = 0;
//        ParentFactureDAO instance = null;
//        ParentFacture expResult = null;
//        ParentFacture result = instance.findById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class ParentFactureDAO.
     */
    @Test
    public void testFindAll() {
//        System.out.println("findAll");
//        ParentFactureDAO instance = null;
//        ArrayList<ParentFacture> expResult = null;
//        ArrayList<ParentFacture> result = instance.findAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllFactureByIdParent method, of class ParentFactureDAO.
     */
    @Test
    public void testGetAllFactureByIdParent() {
        System.out.println("getAllFactureByIdParent");
//        int idParent = 8;
//        ArrayList<ParentFacture> result = parentFactureDAO.getAllFactureByIdParent(idParent);
//        assertEquals("Mbappe", result.get(0).getParent().getNom());
    }

    /**
     * Test of getAllParentByIdFacture method, of class ParentFactureDAO.
     */
    @Test
    public void testGetAllParentByIdFacture() {
//        System.out.println("getAllParentByIdFacture");
//        int idFacture = 0;
//        ParentFactureDAO instance = null;
//        ArrayList<ParentFacture> expResult = null;
//        ArrayList<ParentFacture> result = instance.getAllParentByIdFacture(idFacture);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllFactureByIdPersonne method, of class ParentFactureDAO.
     */
    @Test
    public void testFindAllFactureByIdPersonne() {
//        System.out.println("findAllFactureByIdPersonne");
//        int idPersonne = 8;
//        ArrayList<Facture> result = parentFactureDAO.findAllFactureByIdPersonne(idPersonne);
//        assertEquals(250, result.get(0).getMontantTTC(), 0.1);
    }
    
}
