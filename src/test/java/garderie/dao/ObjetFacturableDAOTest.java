/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.ObjetFacturable;
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
public class ObjetFacturableDAOTest {
    private Connection connection;
    private ObjetFacturableDAO objetFacturableDAO;
    private ObjetFacturable objetFacturable;
    
    public ObjetFacturableDAOTest() {
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
        objetFacturableDAO = new ObjetFacturableDAO(connection);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ObjetFacturableDAO.
     */
    @Test
    public void testCreate() {
//        System.out.println("create");
//        objetFacturable = new ObjetFacturable();
//        objetFacturable.setNom("Sport");
//        objetFacturable.setPrixHT(40);
//        TVA tva = new TVA();
//        tva.setIdTVA(2);
//        objetFacturable.setTva(tva);
//        ObjetFacturable result = objetFacturableDAO.create(objetFacturable);
//        assertEquals(3, result.getIdObjectFacturable());
    }

    /**
     * Test of update method, of class ObjetFacturableDAO.
     */
    @Test
    public void testUpdate() {
//        System.out.println("update");
//        objetFacturable = new ObjetFacturable();
//        objetFacturable.setIdObjetFacturable(1);
//        objetFacturable.setNom("Demi journee");
//        objetFacturable.setPrixHT(60);
//        TVA tva = new TVA();
//        tva.setIdTVA(2);
//        objetFacturable.setTva(tva);
//        ObjetFacturable result = objetFacturableDAO.update(objetFacturable);
//        objetFacturable = objetFacturableDAO.findById(1);
//        assertEquals(60, result.getPrixHT(), 0.1);
    }

    /**
     * Test of delete method, of class ObjetFacturableDAO.
     */
    @Test
    public void testDelete() {
//        System.out.println("delete");
//        objetFacturable = new ObjetFacturable();
//        objetFacturable.setIdObjetFacturable(3);
//        objetFacturableDAO.delete(objetFacturable);
//        ArrayList<ObjetFacturable> result = objetFacturableDAO.findAll();
//        assertEquals(2, result.size());
    }

    /**
     * Test of findById method, of class ObjetFacturableDAO.
     */
    @Test
    public void testFindById() {
//        System.out.println("findById");
//        int id = 1;
//        ObjetFacturable result = objetFacturableDAO.findById(id);
//        assertEquals("Demi journee", result.getNom());
    }

    /**
     * Test of findAll method, of class ObjetFacturableDAO.
     */
    @Test
    public void testFindAll() {
//        System.out.println("findAll");
//        ArrayList<ObjetFacturable> result = objetFacturableDAO.findAll();
//        assertEquals(2, result.size());
    }
    
}
