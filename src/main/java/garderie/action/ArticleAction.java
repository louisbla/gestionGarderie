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
import java.util.ArrayList;

/**
 *
 * @author Katsuo
 */
public class ArticleAction extends ActionSupport {
    
    private ArrayList<Article> articles;
    private ArrayList<CategorieArticle> categories;
    private ArrayList<Inventaire> inventaires;
    
    public ArrayList<Article> getArticles() {
        return articles;
    }
    
    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public ArrayList<CategorieArticle> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<CategorieArticle> categories) {
        this.categories = categories;
    }

    public ArrayList<Inventaire> getInventaires() {
        return inventaires;
    }

    public void setInventaires(ArrayList<Inventaire> inventaires) {
        this.inventaires = inventaires;
    }
    
    public String execute() {
        Connection connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
        articles = new ArrayList<>();
        ArticleDAO articleDAO = new ArticleDAO(connection);
        articles = articleDAO.findAll();
        
        categories = new ArrayList<>();
        CategorieArticleDAO categorieArticleDAO = new CategorieArticleDAO(connection);
        categories = categorieArticleDAO.findAll();
        
        inventaires = new ArrayList<>();
        InventaireDAO inventaireDAO = new InventaireDAO(connection);
        inventaires = inventaireDAO.findAll();
        return SUCCESS;
    }
    
}
