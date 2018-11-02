/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.Employe;
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
public class EmployeDAOTest {
    private Connection connection;
    private Employe employe;
    private EmployeDAO employeDAO;
    public EmployeDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
//        connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
//        employeDAO = new EmployeDAO(connection);
//        employe = new Employe();
//        
//        employe.setNom("Doe");
//        employe.setPrenom("John");
//        employe.setSexe("masculin");
//        LocalDate localDate = LocalDate.of(1985, 10, 3);
//        Date date = Date.valueOf(localDate);
//        employe.setDateNaissance(date);
//        employe.setNumSecu("DOEJ97441816");
//        employe.setPoste("Directeur");
//        employe.setExterne(false);
//        employe.setNumTel("(418)431-1698");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class EmployeDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
//        EmployeDAO employeDAO = new EmployeDAO(connection);
//        Employe expResult = employe;
//        Employe result = employeDAO.create(employe);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class EmployeDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        
//        employe.setIdPersonne(22);
//        employe.setNom("Doe");
//        employe.setPrenom("Jane");
//        employe.setSexe("feminin");
//        LocalDate localDate = LocalDate.of(1985, 10, 12);
//        Date date = Date.valueOf(localDate);
//        employe.setDateNaissance(date);
//        employe.setNumSecu("DOEJ97441818");
//        employe.setPoste("Directeur");
//        employe.setExterne(false);
//        employe.setNumTel("(418)431-1698");
//        EmployeDAO employeDAO = new EmployeDAO(connection);
//        Employe expResult = employe;
//        Employe result = employeDAO.update(employe);
//        if (expResult.getPrenom().equals(result.getPrenom()) && expResult.getDateNaissance() == result.getDateNaissance()) {
//            
//        } else {
//            fail("The test case is a prototype.");  
//        }

    }

    /**
     * Test of findById method, of class EmployeDAO.
     */
    @Test
    public void testFindById() {
//        System.out.println("findById");
//        int id = 1;
//        Employe expResult = new Employe();
//        expResult.setIdPersonne(id);
//        expResult.setNom("Doe");
//        expResult.setPrenom("John");
//        expResult.setSexe("masculin");
//        LocalDate localDate = LocalDate.of(1985, 10, 3);
//        Date date = Date.valueOf(localDate);
//        expResult.setDateNaissance(date);
//        expResult.setNumSecu("DOEJ97441816");
//        expResult.setPoste("Directeur");
//        expResult.setExterne(false);
//        expResult.setNumTel("(418)431-1698");
//        
//        Employe result = employeDAO.findById(id);
//        assertEquals(expResult.getNom(), result.getNom());
//        assertEquals(expResult.getPrenom(), result.getPrenom());
//        assertEquals(expResult.getDateNaissance(), result.getDateNaissance());
//        assertEquals(expResult.getSexe(), result.getSexe());
//        assertEquals(expResult.getNumSecu(), result.getNumSecu());
//        assertEquals(expResult.getPoste(), result.getPoste());
//        assertEquals(expResult.isExterne(), result.isExterne());
//        assertEquals(expResult.getNumTel(), result.getNumTel());
    }

    /**
     * Test of findAll method, of class EmployeDAO.
     */
    @Test
    public void testFindAll() {
//        System.out.println("findAll");
//        
//        ArrayList<Employe> result = employeDAO.findAll();
//        assertEquals(5, result.size());
    }

    /**
     * Test of delete method, of class EmployeDAO.
     */
    @Test
    public void testDelete() {
//       System.out.println("delete");
//       employe = employeDAO.findById(1);
//       employeDAO.delete(employe);
//       employe = employeDAO.findById(1);
//       assertNull(employe.getNom());
//       assertNull(employe.getPrenom());
//       assertNull(employe.getNumTel());
    }
    
}
