/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.LigneFacture;
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
public class LigneFactureDAOTest {
    private Connection connection;
    private LigneFactureDAO ligneFactureDAO;
    private LigneFacture ligneFacture;
    
    public LigneFactureDAOTest() {
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
        ligneFactureDAO = new LigneFactureDAO(connection);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class LigneFactureDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
//        LigneFacture obj = null;
//        LigneFactureDAO instance = null;
//        LigneFacture expResult = null;
//        LigneFacture result = instance.create(obj);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class LigneFactureDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
//        LigneFacture obj = null;
//        LigneFactureDAO instance = null;
//        LigneFacture expResult = null;
//        LigneFacture result = instance.update(obj);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class LigneFactureDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
//        ligneFacture = new LigneFacture();
//        ligneFacture.setIdLigneFacture(3);
//        ligneFactureDAO.delete(ligneFacture);
//        ArrayList<LigneFacture> result = ligneFactureDAO.findAll();
//        assertEquals(2, result.size());
        
    }

    /**
     * Test of findById method, of class LigneFactureDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
//        int id = 1;
//        LigneFacture result = ligneFactureDAO.findById(id);
//        assertEquals(200, result.getTotalHT(), 0.1);
//        assertEquals("Demi journee", result.getObjetsFacturable().getNom());
    }

    /**
     * Test of findAll method, of class LigneFactureDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
//        ArrayList<LigneFacture> result = ligneFactureDAO.findAll();
//        assertEquals(3, result.size());
    }

    /**
     * Test of findAllLignesForFacture method, of class LigneFactureDAO.
     */
    @Test
    public void testFindAllLignesForFacture() {
        System.out.println("findAllLignesForFacture");
//        int id = 2;
//        ArrayList<LigneFacture> result = ligneFactureDAO.findAllLignesForFacture(id);
//        assertEquals(1, result.size());
//        assertEquals(500, result.get(0).getTotalHT(), 0.1);
    }
    
}
