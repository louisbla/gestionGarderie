/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.Article;
import garderie.model.CategorieArticle;
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
public class CategorieArticleDAOTest {
    private Connection connection;
    private CategorieArticle categorieArticle;
    private CategorieArticleDAO categorieArticleDAO;
    
    public CategorieArticleDAOTest() {
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
        categorieArticleDAO = new CategorieArticleDAO(connection);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class CategorieArticleDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        categorieArticle = new CategorieArticle();
        categorieArticle.setNom("DVD");
        CategorieArticle result = categorieArticleDAO.create(categorieArticle);
        assertEquals(7, result.getIdCategorie());
    }

    /**
     * Test of update method, of class CategorieArticleDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        categorieArticle = new CategorieArticle();
        categorieArticle.setIdCategorie(3);
        categorieArticle.setNom("Jeux et Jouets");
        CategorieArticle result = categorieArticleDAO.update(categorieArticle);
        result = categorieArticleDAO.findById(3);
        assertEquals("Jeux et Jouets", result.getNom());
    }

    /**
     * Test of delete method, of class CategorieArticleDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        categorieArticle = new CategorieArticle();
        categorieArticle.setIdCategorie(2);
        categorieArticleDAO.delete(categorieArticle);
        
        ArrayList<CategorieArticle> result = categorieArticleDAO.findAll();
        assertEquals(5, result.size());
    }

    /**
     * Test of findById method, of class CategorieArticleDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 4;
        CategorieArticle result = categorieArticleDAO.findById(id);
        assertEquals("Livres", result.getNom());
    }

    /**
     * Test of findAll method, of class CategorieArticleDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        ArrayList<CategorieArticle> result = categorieArticleDAO.findAll();
        assertEquals(6, result.size());
    }

    /**
     * Test of getArticlesForCategorie method, of class CategorieArticleDAO.
     */
    @Test
    public void testGetArticlesForCategorie() {
        System.out.println("getArticlesForCategorie");
        categorieArticle = new CategorieArticle();
        categorieArticle = categorieArticleDAO.findById(3);
        ArrayList<Article> result = categorieArticleDAO.getArticlesForCategorie(categorieArticle);
        assertEquals(3, result.size());
    }
    
}
