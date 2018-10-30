/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.Article;
import garderie.model.Inventaire;
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
public class InventaireDAOTest {
    private Connection connection;
    private Inventaire inventaire;
    private InventaireDAO inventaireDAO;
    
    public InventaireDAOTest() {
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
        inventaireDAO = new InventaireDAO(connection);
        inventaire = new Inventaire();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class InventaireDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        inventaire = new Inventaire();
        EmployeDAO employeDAO = new EmployeDAO(connection);
        inventaire.setEmploye(employeDAO.findById(3));
        inventaire.setStockActuel(45);
        inventaire.setStockMax(60);
        Inventaire result = inventaireDAO.create(inventaire);
        assertEquals(2, result.getIdInventaire());
        assertEquals(45, result.getStockActuel());
        assertEquals(60, result.getStockMax());
        assertEquals(3, result.getEmploye().getIdPersonne());
    }

    /**
     * Test of update method, of class InventaireDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        
        EmployeDAO employeDAO = new EmployeDAO(connection);
        inventaire.setIdInventaire(1);
        inventaire.setEmploye(employeDAO.findById(1));
        inventaire.setStockActuel(10);
        inventaire.setStockMax(60);
        Inventaire result = inventaireDAO.update(inventaire);
        result = inventaireDAO.findById(1);
        assertEquals(10, result.getStockActuel());
        assertEquals(60, result.getStockMax());
    }

    /**
     * Test of delete method, of class InventaireDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        inventaire.setIdInventaire(2);
        inventaireDAO.delete(inventaire);
        assertEquals(1, inventaireDAO.findAll().size());
    }

    /**
     * Test of findById method, of class InventaireDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 1;
        Inventaire result = inventaireDAO.findById(id);
        assertEquals(1, result.getEmploye().getIdPersonne());
        assertEquals(60, result.getStockMax());
        assertEquals(10, result.getStockActuel());
    }

    /**
     * Test of findAll method, of class InventaireDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        ArrayList<Inventaire> result = inventaireDAO.findAll();
        assertEquals(1, result.size());
    }

    /**
     * Test of getArticlesForInventaire method, of class InventaireDAO.
     */
    @Test
    public void testGetArticlesForInventaire() {
        System.out.println("getArticlesForInventaire");
        int id = 1;
        ArrayList<Article> result = inventaireDAO.getArticlesForInventaire(id);
        assertEquals(4, result.size());
    }
    
}
