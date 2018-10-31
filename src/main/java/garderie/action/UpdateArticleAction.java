/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.action;

import com.opensymphony.xwork2.ActionSupport;
import garderie.dao.ArticleDAO;
import garderie.dao.CategorieArticleDAO;
import garderie.dao.InventaireDAO;
import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.Article;
import garderie.model.CategorieArticle;
import garderie.model.Inventaire;
import java.sql.Connection;

/**
 *
 * @author Katsuo
 */
public class UpdateArticleAction extends ActionSupport {
    private int idArticle;
    private String nom;
    private int quantite;
    private String  photo;
    private String description;
    private int categorie;
    private int inventaire;
    Connection connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
    ArticleDAO articleDAO = new ArticleDAO(connection);
    
    @Override
    public String execute() throws Exception {
        Article article = new Article();
        article.setIdArticle(idArticle);
        article.setNom(nom);
        article.setQuantite(quantite);
        article.setPhoto(photo);
        article.setDescription(description);
        CategorieArticleDAO categorieArticleDAO = new CategorieArticleDAO(connection);
        article.setCategorie(categorieArticleDAO.findById(categorie));
        InventaireDAO inventaireDAO = new InventaireDAO(connection);
        article.setInventaire(inventaireDAO.findById(inventaire));
        
        System.out.println(inventaire);
        System.out.println(categorie);
        System.out.println(nom);
        
        return "update";
        
    }
    
    
}
