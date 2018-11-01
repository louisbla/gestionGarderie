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
import garderie.model.Enfant;
import garderie.model.Groupe;
import garderie.model.Inventaire;
import garderie.model.InventaireEnfant;
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
public class InventaireEnfantDAOTest {

    private Connection connection;

    public InventaireEnfantDAOTest() {
    }

    @Before
    public void setUp() {
        connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
    }

    @Test
    public void testFindByEnfantId() {
        InventaireEnfantDAO inventaireEnfantDAO = new InventaireEnfantDAO(connection);
        //ArrayList<Article> articles = inventaireEnfantDAO.getArticlesByEnfantId(4);

        //assertEquals(1, articles.size());
    }

    @Test
    public void testFindAll() {
        InventaireEnfantDAO inventaireEnfantDAO = new InventaireEnfantDAO(connection);
        //ArrayList<InventaireEnfant> inventaires = inventaireEnfantDAO.findAll();

        //assertEquals(6, inventaires.size());
    }

    @Test
    public void testCreate() {
        InventaireEnfantDAO inventaireEnfantDAO = new InventaireEnfantDAO(connection);

        // Creation d'un inventaireEnfant
        InventaireEnfant inventaireEnfant = new InventaireEnfant();

        // Article
        Article article1 = new Article();
        article1.setDescription("Pour faire des roulades");
        article1.setNom("Tapis de roulades");
        article1.setPhoto("http://photo.com");
        article1.setQuantite(30);

        CategorieArticle categorie = new CategorieArticle();
        categorie.setIdCategorie(1);
        article1.setCategorie(categorie);

        ArrayList<Article> listeArticleEnfant = new ArrayList<>();
        listeArticleEnfant.add(article1);
        inventaireEnfant.setListeArticleEnfant(listeArticleEnfant);

        //inventaireEnfantDAO.create(inventaireEnfant);
    }

    @Test
    public void testUpdate() {
        InventaireEnfantDAO inventaireEnfantDAO = new InventaireEnfantDAO(connection);

        // Creation d'un inventaireEnfant
        InventaireEnfant inventaireEnfant = new InventaireEnfant();
        inventaireEnfant.setIdInventaire(2);

        // Article
        Article article1 = new Article();
        article1.setIdArticle(14);
        article1.setDescription("Pour faire des grandes roulades");
        article1.setNom("Tapis de roulades");
        article1.setPhoto("http://photo.com");
        article1.setQuantite(10);

        CategorieArticle categorie = new CategorieArticle();
        categorie.setIdCategorie(1);
        article1.setCategorie(categorie);

        ArrayList<Article> listeArticleEnfant = new ArrayList<>();
        listeArticleEnfant.add(article1);
        inventaireEnfant.setListeArticleEnfant(listeArticleEnfant);

        //inventaireEnfantDAO.update(inventaireEnfant);
    }

    @Test
    public void testDelete() {
        InventaireEnfantDAO inventaireEnfantDAO = new InventaireEnfantDAO(connection);

        // Creation d'un inventaireEnfant
        InventaireEnfant inventaireEnfant = new InventaireEnfant();
        inventaireEnfant.setIdInventaire(9);

        // Article
        Article article1 = new Article();
        article1.setIdArticle(14);
        article1.setDescription("Pour faire des grandes roulades");
        article1.setNom("Tapis de roulades");
        article1.setPhoto("http://photo.com");
        article1.setQuantite(10);

        CategorieArticle categorie = new CategorieArticle();
        categorie.setIdCategorie(1);
        article1.setCategorie(categorie);

        ArrayList<Article> listeArticleEnfant = new ArrayList<>();
        listeArticleEnfant.add(article1);
        inventaireEnfant.setListeArticleEnfant(listeArticleEnfant);

        //inventaireEnfantDAO.delete(inventaireEnfant);
    }

}
