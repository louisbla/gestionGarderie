/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.ContactUrgence;
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
public class ContactUrgenceDAOTest {
    private Connection connection;
    private ContactUrgenceDAO contactUrgenceDAO;
    private ContactUrgence contactUrgence;
    
    public ContactUrgenceDAOTest() {
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
        contactUrgenceDAO = new ContactUrgenceDAO(connection);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ContactUrgenceDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        
        contactUrgence = new ContactUrgence();
        contactUrgence.setNom("Zoun");
        contactUrgence.setPrenom("Nadia");
        contactUrgence.setNumSecu("ZOUN71426790");
        contactUrgence.setSexe("feminin");
        LocalDate localDate = LocalDate.of(2017, Month.DECEMBER, 12);
        Date date = Date.valueOf(localDate);
        contactUrgence.setDateNaissance(date);
        contactUrgence.setNumTel("(418)153-9031");
        
        ContactUrgence result = contactUrgenceDAO.create(contactUrgence);
        assertEquals(5, contactUrgenceDAO.findAll().size());
    }

    /**
     * Test of update method, of class ContactUrgenceDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        contactUrgence = contactUrgenceDAO.findById(22);
        contactUrgence.setNom("Zounni");

        ContactUrgence result = contactUrgenceDAO.update(contactUrgence);
        assertEquals("Zounni", contactUrgenceDAO.findById(22).getNom());
    }

    /**
     * Test of delete method, of class ContactUrgenceDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        contactUrgence = new ContactUrgence();
        contactUrgence.setIdPersonne(22);
        contactUrgenceDAO.delete(contactUrgence);
        assertEquals(4, contactUrgenceDAO.findAll().size());
    }

    /**
     * Test of findById method, of class ContactUrgenceDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 20;
        ContactUrgence result = contactUrgenceDAO.findById(id);
        assertEquals("Fernandez", result.getNom());
    }

    /**
     * Test of findAll method, of class ContactUrgenceDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        ArrayList<ContactUrgence> result = contactUrgenceDAO.findAll();
        assertEquals(4, result.size());
    }
    
}
