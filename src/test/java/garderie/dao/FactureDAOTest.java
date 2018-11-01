/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.Facture;
import garderie.model.LigneFacture;
import garderie.model.StatutFacture;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
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
public class FactureDAOTest {
    private Connection connection;
    private FactureDAO factureDAO;
    private Facture facture;
    
    public FactureDAOTest() {
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
        factureDAO = new FactureDAO(connection);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class FactureDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
//        facture = new Facture();
//        LocalDate localDate = LocalDate.of(2018, 10, 3);
//        Date date = Date.valueOf(localDate);
//        facture.setDateEmission(date);
//        facture.setMontantTTC(200);
//        facture.setStatut(StatutFacture.EnRetard);
//        
//        Facture result = factureDAO.create(facture);
//        result = factureDAO.findById(3);
//        assertEquals(date, result.getDateEmission());
    }

    /**
     * Test of update method, of class FactureDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
//        facture = factureDAO.findById(3);
//        facture.setStatut(StatutFacture.EnAttenteDePaiement);
//        Facture result = factureDAO.update(facture);
//        facture = factureDAO.findById(3);
//        assertEquals("en attente de paiement", facture.getStatut().toString());
    }

    /**
     * Test of delete method, of class FactureDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
//        facture = factureDAO.findById(3);
//        factureDAO.delete(facture);
//        facture = factureDAO.findById(3);
//        assertEquals(null, facture);
    }

    /**
     * Test of findById method, of class FactureDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
//        int id = 1;
//        Facture result = factureDAO.findById(id);
//        assertEquals(250, result.getMontantTTC(), 0.1);
    }

    /**
     * Test of findAll method, of class FactureDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
//        ArrayList<Facture> result = factureDAO.findAll();
//        assertEquals(2, result.size());
//        assertEquals(250, result.get(0).getMontantTTC(), 0.1);
    }

    /**
     * Test of getAllLigneForFacture method, of class FactureDAO.
     */
    @Test
    public void testGetAllLigneForFacture() {
        System.out.println("getAllLigneForFacture");
//        int id = 1;
//        ArrayList<LigneFacture> result = factureDAO.getAllLigneForFacture(id);
//        assertEquals(2, result.size());
    }
    
}
