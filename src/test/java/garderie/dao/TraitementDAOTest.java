/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.Enfant;
import garderie.model.Maladie;
import garderie.model.Traitement;
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
public class TraitementDAOTest {
    private Connection connection;
    private TraitementDAO traitementDAO;
    
    public TraitementDAOTest() {
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
        traitementDAO = new TraitementDAO(connection);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class TraitementDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        MaladieDAO maladieDAO = new MaladieDAO(connection);
        Maladie maladie = maladieDAO.findById(2);
        EnfantDAO enfantDAO = new EnfantDAO(connection);
        Enfant enfant = enfantDAO.findById(5);
        
                
        Traitement traitement = new Traitement();
        traitement.setMaladie(maladie);
        traitement.setEnfant(enfant);
        traitement.setNomMedicament("Nasonex");
        traitement.setSpecification("En cas de nez qui coule, un spray dans chaque narine");
        traitement.setType("Spray");
        traitement.setQuantite(1);
        traitement.setFrequence(1);
        
        String expResult = "Nasonex";
        Traitement result = traitementDAO.create(traitement);
         
        assertEquals(expResult, result.getNomMedicament());
        
    }

    /**
     * Test of update method, of class TraitementDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Traitement traitement = new Traitement();
        
        MaladieDAO maladieDAO = new MaladieDAO(connection);
        Maladie maladie = maladieDAO.findById(2);
        EnfantDAO enfantDAO = new EnfantDAO(connection);
        Enfant enfant = enfantDAO.findById(5);
        
        traitement.setMaladie(maladie);
        traitement.setEnfant(enfant);
        traitement.setNomMedicament("Nasonex allergy");
        traitement.setSpecification("En cas de nez qui coule, un spray dans chaque narine");
        traitement.setType("Spray");
        traitement.setQuantite(2);
        traitement.setFrequence(1);
        
        Traitement result = traitementDAO.update(traitement);

        assertEquals(2.0, result.getQuantite(), 0.1);
        assertEquals("Nasonex allergy", result.getNomMedicament());        
    }

    /**
     * Test of delete method, of class TraitementDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Traitement traitement = new Traitement();
        Enfant enfant = new Enfant();
        enfant.setIdPersonne(10);
        Maladie maladie = new Maladie();
        maladie.setIdMaladie(1);
        
        traitement.setEnfant(enfant);
        traitement.setMaladie(maladie);
        traitementDAO.delete(traitement);

        assertEquals(2,traitementDAO.findAll().size());
    }

    /**
     * Test of findByEnfantId method, of class TraitementDAO.
     */
    @Test
    public void testFindByEnfantId() {
        System.out.println("findByEnfantId");
        
        int enfantId = 7;
        ArrayList<Traitement> result = traitementDAO.findByEnfantId(enfantId);
        assertEquals(1, result.size());
    }

    /**
     * Test of findAll method, of class TraitementDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        ArrayList<Traitement> result = traitementDAO.findAll();
        assertEquals(2, result.size());
    }
    
}
