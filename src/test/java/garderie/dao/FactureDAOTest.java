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
import java.time.Month;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fadou
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
        facture = new Facture();
        LocalDate localDate1 = LocalDate.of(2018, Month.MARCH, 5);
        LocalDate localDate2 = LocalDate.of(2018, Month.MARCH, 21);
        
        Date dateEmission = Date.valueOf(localDate1);
        Date datePaiement = Date.valueOf(localDate2);
        facture.setDateEmission(dateEmission);
        facture.setDatePaiement(datePaiement);
        facture.setMontantTTC(500);
        facture.setStatut(StatutFacture.Payee);
        
        Facture result = factureDAO.create(facture);
        assertEquals(3, result.getIdFacture());
    }

    /**
     * Test of update method, of class FactureDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        facture = new Facture();
        
        LocalDate localDate1 = LocalDate.of(2018, Month.MARCH, 5);
        LocalDate localDate2 = LocalDate.of(2018, Month.MARCH, 21);
        
        Date dateEmission = Date.valueOf(localDate1);
        Date datePaiement = Date.valueOf(localDate2);
        facture.setDateEmission(dateEmission);
        facture.setDatePaiement(datePaiement);
        facture.setMontantTTC(700);
        facture.setStatut(StatutFacture.Payee);
        
        Facture result = factureDAO.update(facture);
        assertEquals(700, factureDAO.findById(3).getMontantTTC(),0.1);
    }

    /**
     * Test of delete method, of class FactureDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        facture = new Facture();
        facture.setIdFacture(3);
        factureDAO.delete(facture);
        
        assertEquals(2, factureDAO.findAll().size());
    }

    /**
     * Test of findById method, of class FactureDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 2;
        Facture result = factureDAO.findById(id);
        assertEquals(600, result.getMontantTTC(),0.1);
    }

    /**
     * Test of findAll method, of class FactureDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        ArrayList<Facture> result = factureDAO.findAll();
        assertEquals(2, result.size());
    }

    /**
     * Test of getAllLigneForFacture method, of class FactureDAO.
     */
    @Test
    public void testGetAllLigneForFacture() {
        System.out.println("getAllLigneForFacture");
        int id = 1;
        ArrayList<LigneFacture> result = factureDAO.getAllLigneForFacture(id);
        assertEquals(2, result.size());
    }
    
}
