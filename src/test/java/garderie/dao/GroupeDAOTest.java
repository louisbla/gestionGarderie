/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.Employe;
import garderie.model.Enfant;
import garderie.model.Groupe;
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
public class GroupeDAOTest {
    private Connection connection;
    private GroupeDAO groupeDAO;
    
    public GroupeDAOTest() {
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
        groupeDAO = new GroupeDAO(connection);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class GroupeDAO.
     */
    @Test
    public void testCreate() {
//        System.out.println("create");
//        Groupe groupe = null;
//        GroupeDAO instance = null;
//        Groupe expResult = null;
//        Groupe result = instance.create(groupe);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class GroupeDAO.
     */
    @Test
    public void testUpdate() {
//        System.out.println("update");
//        Groupe groupe = null;
//        GroupeDAO instance = null;
//        Groupe expResult = null;
//        Groupe result = instance.update(groupe);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class GroupeDAO.
     */
    @Test
    public void testDelete() {
//        System.out.println("delete");
//        Groupe groupe = null;
//        GroupeDAO instance = null;
//        instance.delete(groupe);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class GroupeDAO.
     */
    @Test
    public void testFindById() {
//        System.out.println("findById");
//        int id = 0;
//        GroupeDAO instance = null;
//        Groupe expResult = null;
//        Groupe result = instance.findById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class GroupeDAO.
     */
    @Test
    public void testFindAll() {
//        System.out.println("findAll");
//        GroupeDAO instance = null;
//        ArrayList<Groupe> expResult = null;
//        ArrayList<Groupe> result = instance.findAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getReferantGroupe method, of class GroupeDAO.
     */
    @Test
    public void testGetReferantGroupe() {
//        System.out.println("getReferantGroupe");
//        int id = 0;
//        GroupeDAO instance = null;
//        Employe expResult = null;
//        Employe result = instance.getReferantGroupe(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnfantsForGroupe method, of class GroupeDAO.
     */
    @Test
    public void testGetEnfantsForGroupe() {
//        System.out.println("getEnfantsForGroupe");
//        int id = 0;
//        GroupeDAO instance = null;
//        ArrayList<Enfant> expResult = null;
//        ArrayList<Enfant> result = instance.getEnfantsForGroupe(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployesForGroupe method, of class GroupeDAO.
     */
    @Test
    public void testGetEmployesForGroupe() {
//        System.out.println("getEmployesForGroupe");
//        int id = 2;
//        ArrayList<Employe> expResult = null;
//        ArrayList<Employe> result = groupeDAO.getEmployesForGroupe(id);
//        assertEquals(2, result.size());
    }
    
    
    
}
