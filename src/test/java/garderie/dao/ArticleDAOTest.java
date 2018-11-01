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
public class ArticleDAOTest {
    private Connection connection;
    private ArticleDAO articleDAO;
    private Article article;
    
    public ArticleDAOTest() {
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
        articleDAO = new ArticleDAO(connection);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ArticleDAO.
     */
    @Test
    public void testCreate() {
//        System.out.println("create");
//        InventaireDAO inventaireDAO = new InventaireDAO(connection);
//        Inventaire inventaire = inventaireDAO.findById(1);
//        CategorieArticleDAO categorieArticleDAO = new CategorieArticleDAO(connection);
//        article = new Article();
//        article.setNom("piano");
//        article.setQuantite(4);
//        article.setPhoto("https://images-na.ssl-images-amazon.com/images/I/71XjXkQUKgL._SX355_.jpg");
//        article.setInventaire(inventaire);
//        article.setCategorie(categorieArticleDAO.findById(5));
//        article.setDescription("piano colore enfant");
//        
//        Article result = articleDAO.create(article);
//        assertEquals(10, result.getIdArticle());
    }

    /**
     * Test of update method, of class ArticleDAO.
     */
    @Test
    public void testUpdate() {
//        System.out.println("update");
//        InventaireDAO inventaireDAO = new InventaireDAO(connection);
//        Inventaire inventaire = inventaireDAO.findById(1);
//        CategorieArticleDAO categorieArticleDAO = new CategorieArticleDAO(connection);
//        article = new Article();
//        article.setIdArticle(2);
//        article.setNom("piano");
//        article.setQuantite(4);
//        article.setPhoto("https://images-na.ssl-images-amazon.com/images/I/71XjXkQUKgL._SX355_.jpg");
//        article.setInventaire(inventaire);
//        article.setCategorie(categorieArticleDAO.findById(3));
//        article.setDescription("piano bleu enfant");
//        
//        Article result = articleDAO.update(article);
//        result = articleDAO.findById(2);
//        assertEquals("piano bleu enfant", result.getDescription());
    }

    /**
     * Test of delete method, of class ArticleDAO.
     */
    @Test
    public void testDelete() {
//        System.out.println("delete");
//        article = new Article();
//        article.setIdArticle(3);
//        articleDAO.delete(article);
//        assertEquals(9, articleDAO.findAll().size());
    }

    /**
     * Test of findById method, of class ArticleDAO.
     */
    @Test
    public void testFindById() {
//        System.out.println("findById");
//        int id = 1;
//        Article result = articleDAO.findById(id);
//        assertEquals("maracas", result.getNom());
    }

    /**
     * Test of findAll method, of class ArticleDAO.
     */
    @Test
    public void testFindAll() {
//        System.out.println("findAll");
//        ArrayList<Article> result = articleDAO.findAll();
//        assertEquals(9, result.size());
    }

    /**
     * Test of getArticlesForCategorie method, of class ArticleDAO.
     */
    @Test
    public void testGetArticlesForCategorie() {
//        System.out.println("getArticlesForCategorie");
//        int id = 0;
//        ArticleDAO instance = null;
//        ArrayList<Article> expResult = null;
//        ArrayList<Article> result = instance.getArticlesForCategorie(id);
//        assertEquals(expResult, result);
    }

    /**
     * Test of getArticlesForEnfants method, of class ArticleDAO.
     */
    @Test
    public void testGetArticlesForEnfants() {
//        System.out.println("getArticlesForEnfants");
//        int idEnfant = 0;
//        ArticleDAO instance = null;
//        ArrayList<Article> expResult = null;
//        ArrayList<Article> result = instance.getArticlesForEnfants(idEnfant);
//        assertEquals(expResult, result);
    }

    /**
     * Test of findByName method, of class ArticleDAO.
     */
    @Test
    public void testFindByName() {
        System.out.println("findByName");
        String name = "mar";
        ArrayList<Article> result = articleDAO.findByName(name);
        assertEquals(1, result.size());
    }
    
}
