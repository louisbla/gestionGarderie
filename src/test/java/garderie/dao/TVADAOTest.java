/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.TVA;
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
public class TVADAOTest {
    private Connection connection;
    private TVADAO tvaDAO;
    private TVA tva;
    
    public TVADAOTest() {
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
        tvaDAO = new TVADAO(connection);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class TVADAO.
     */
    @Test
    public void testCreate() {
//        System.out.println("create");
//        tva = new TVA();
//        tva.setMontant(12);
//        tva.setNom("Eco participation");
//        TVA result = tvaDAO.create(tva);
//        assertEquals(4, result.getIdTVA());
    }

    /**
     * Test of update method, of class TVADAO.
     */
    @Test
    public void testUpdate() {
//        System.out.println("update");
//        tva = new TVA();
//        tva.setIdTVA(1);
//        tva.setMontant(20);
//        tva.setNom("Normal");
//        TVA result = tvaDAO.update(tva);
//        tva = tvaDAO.findById(1);
//        assertEquals(20, result.getMontant(), 0.1);
    }

    /**
     * Test of delete method, of class TVADAO.
     */
    @Test
    public void testDelete() {
//        System.out.println("delete");
//        tva = new TVA();
//        tva.setIdTVA(4);
//        tvaDAO.delete(tva);
//        ArrayList<TVA> result = tvaDAO.findAll();
//        assertEquals(3, result.size());
    }

    /**
     * Test of findById method, of class TVADAO.
     */
    @Test
    public void testFindById() {
//        System.out.println("findById");
//        int id = 1;
//        TVA result = tvaDAO.findById(id);
//        assertEquals("Normal", result.getNom());
//        assertEquals(20, result.getMontant(), 0.1);
    }

    /**
     * Test of findAll method, of class TVADAO.
     */
    @Test
    public void testFindAll() {
//        System.out.println("findAll");
//        ArrayList<TVA> result = tvaDAO.findAll();
//        assertEquals(3, result.size());
    }
    
}
