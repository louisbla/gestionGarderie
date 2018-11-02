/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.Facture;
import garderie.model.Parent;
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
public class ParentDAOTest {
    private Connection connection;
    private ParentDAO parentDAO;
    private Parent parent;
    
    public ParentDAOTest() {
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
        parentDAO = new ParentDAO(connection);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ParentDAO.
     */
    @Test
    public void testCreate() {
//        System.out.println("create");
//        parent = new Parent();
//        parent.setNom("Bloom");
//        parent.setPrenom("Orlando");
//        LocalDate localDate = LocalDate.of(1989, Month.AUGUST, 29);
//        Date date = Date.valueOf(localDate);
//        parent.setDateNaissance(date);
//        parent.setNumSecu("BLOO62711625");
//        parent.setNbEnfantsInscrits(1);
//        parent.setNumTel("(418)638-1827");
//        
//        Parent result = parentDAO.create(parent);
//        assertEquals("BLOO62711625", result.getNumSecu());
    }

    /**
     * Test of update method, of class ParentDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
//        parent = new Parent();
//        parent.setNom("Bloom");
//        parent.setPrenom("Orlando");
//        LocalDate localDate = LocalDate.of(1989, Month.AUGUST, 29);
//        Date date = Date.valueOf(localDate);
//        parent.setDateNaissance(date);
//        parent.setNumSecu("BLOO62711625");
//        parent.setNbEnfantsInscrits(2);
//        parent.setNumTel("(418)638-1827");
//        
//        Parent result = parentDAO.update(parent);
//        assertEquals(2, result.getNbEnfantsInscrits());
    }

    /**
     * Test of delete method, of class ParentDAO.
     */
    @Test
    public void testDelete() {
//        System.out.println("delete");
//        parent = new Parent();
//        parent.setIdPersonne(22);
//        parentDAO.delete(parent);
//        assertEquals(21,parentDAO.findAll().size());
    }

    /**
     * Test of findById method, of class ParentDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
//        int id = 11;
//        Parent result = parentDAO.findById(id);
//        assertEquals("Primavera", result.getNom());
//        assertEquals(2, result.getListeEnfants().size());
    }

    /**
     * Test of findAll method, of class ParentDAO.
     */
    @Test
    public void testFindAll() {
//        System.out.println("findAll");
//        ArrayList<Parent> result = parentDAO.findAll();
//        assertEquals(6, result.size());
    }

    /**
     * Test of getFactureForParent method, of class ParentDAO.
     */
    @Test
    public void testGetFactureForParent() {
//        System.out.println("getFactureForParent");
//        int id = 9;
//        ArrayList<Facture> result = parentDAO.getFactureForParent(id);
//        assertEquals(1, result.size());
    }
    
}