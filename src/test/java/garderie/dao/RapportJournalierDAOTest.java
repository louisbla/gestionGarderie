/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.Enfant;
import garderie.model.RapportJournalier;
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
public class RapportJournalierDAOTest {
    private Connection connection;
    private RapportJournalierDAO rapportJournalierDAO;
    private RapportJournalier rapport;
    
    public RapportJournalierDAOTest() {
    }
    
    
    @Before
    public void setUp() {
        connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
        rapportJournalierDAO = new RapportJournalierDAO(connection);
    }
    
    /**
     * Test of create method, of class RapportJournalierDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        
        rapport = new RapportJournalier();
        rapport.setPresent(true);
        rapport.setResumeJournee("RAS");
        
        LocalDate localDate = LocalDate.of(2018, Month.FEBRUARY, 14);
        Date date = Date.valueOf(localDate);
        rapport.setDateRapport(date);
        
        EnfantDAO enfantDAO = new EnfantDAO(connection);
        //Enfant enfant = enfantDAO.findById(7);
        
        //rapport.setDossierInscription(enfant.getDossier());
        
        //RapportJournalier result = rapportJournalierDAO.create(rapport);
        //assertEquals(3, result.getIdRapportJournalier());
    }

    /**
     * Test of update method, of class RapportJournalierDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        
        rapport = new RapportJournalier();
        
        rapport.setPresent(true);
        rapport.setIdRapportJournalier(3);
        rapport.setResumeJournee("Nez qui coule");
        
        LocalDate localDate = LocalDate.of(2018, Month.FEBRUARY, 14);
        Date date = Date.valueOf(localDate);
        rapport.setDateRapport(date);
        
        EnfantDAO enfantDAO = new EnfantDAO(connection);
        //Enfant enfant = enfantDAO.findById(7);
        //rapport.setDossierInscription(enfant.getDossier());
        
        //rapportJournalierDAO.update(rapport);
        //assertEquals("Nez qui coule", rapportJournalierDAO.findById(3).getResumeJournee());
    }

    /**
     * Test of delete method, of class RapportJournalierDAO.
     */
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        rapport = new RapportJournalier();
//        rapport.setIdRapportJournalier(3);
//        rapportJournalierDAO.delete(rapport);
//        assertEquals(1, rapportJournalierDAO.findAll().size());
//    }

    /**
     * Test of findById method, of class RapportJournalierDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        
        int id = 3;
        RapportJournalier result = rapportJournalierDAO.findById(id);
        assertEquals(id, result.getIdRapportJournalier());
        assertEquals("Nez qui coule", result.getResumeJournee());
    }

    /**
     * Test of findAll method, of class RapportJournalierDAO.
     */
//    @Test
//    public void testFindAll() {
//        System.out.println("findAll");
//        ArrayList<RapportJournalier> result = rapportJournalierDAO.findAll();
//        assertEquals(1, result.size());
//    }
    
}
