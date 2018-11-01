/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.ContactUrgence;
import garderie.model.DossierContactUrgence;
import garderie.model.DossierInscription;
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
 * @author fadou
 */
public class DossierContactUrgenceDAOTest {
    private Connection connection;
    private DossierContactUrgenceDAO dossierContactUrgenceDAO;
    private DossierContactUrgence dossier;
    
    public DossierContactUrgenceDAOTest() {
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
        dossierContactUrgenceDAO = new DossierContactUrgenceDAO(connection);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class DossierContactUrgenceDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        ContactUrgenceDAO contactUrgenceDAO = new ContactUrgenceDAO(connection);
        ContactUrgence contactUrgence = contactUrgenceDAO.findById(17);
        
        DossierInscriptionDAO dossierInscriptionDAO = new DossierInscriptionDAO(connection);
        DossierInscription dossierInscription = dossierInscriptionDAO.findByEnfantId(7);
        
                
        dossier = new DossierContactUrgence();
        dossier.setContactUrgence(contactUrgence);
        dossier.setDossierInscription(dossierInscription);
        dossier.setLienParente("ami de la famille");
        
        DossierContactUrgence result = dossierContactUrgenceDAO.create(dossier);
        assertEquals("Josephine", result.getContactUrgence().getPrenom());
        
    }

    /**
     * Test of update method, of class DossierContactUrgenceDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        ContactUrgenceDAO contactUrgenceDAO = new ContactUrgenceDAO(connection);
        ContactUrgence contactUrgence = contactUrgenceDAO.findById(17);
        
        DossierInscriptionDAO dossierInscriptionDAO = new DossierInscriptionDAO(connection);
        DossierInscription dossierInscription = dossierInscriptionDAO.findByEnfantId(7);
        
        dossier = new DossierContactUrgence();
        dossier.setContactUrgence(contactUrgence);
        dossier.setDossierInscription(dossierInscription);
        dossier.setLienParente("tante");
        
        DossierContactUrgence result = dossierContactUrgenceDAO.update(dossier);
        assertEquals("tante", result.getLienParente());
    }

    /**
     * Test of delete method, of class DossierContactUrgenceDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        
        dossier = new DossierContactUrgence();
        dossier.setDossierContactUrgenceId(10);
        
        dossierContactUrgenceDAO.delete(dossier);
        assertEquals(6,dossierContactUrgenceDAO.findAll().size());
    }

    /**
     * Test of findById method, of class DossierContactUrgenceDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 8;
        DossierContactUrgence result = dossierContactUrgenceDAO.findById(id);
        assertEquals(id, result.getDossierContactUrgenceId());
    }

    /**
     * Test of findAll method, of class DossierContactUrgenceDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        ArrayList<DossierContactUrgence> result = dossierContactUrgenceDAO.findAll();
        assertEquals(6, result.size());
    }

    /**
     * Test of findByContactId method, of class DossierContactUrgenceDAO.
     */
    @Test
    public void testFindByContactId() {
        System.out.println("findByContactId");
        int contactId = 18;
        ArrayList<DossierContactUrgence> result = dossierContactUrgenceDAO.findByContactId(contactId);
        assertEquals(2, result.size());
    }
    
}
