/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.action;

import static com.opensymphony.xwork2.Action.SUCCESS;
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
public class ChercherArticleAction extends ActionSupport {
    ArrayList<Article> articlesTrouves;
    private ArrayList<CategorieArticle> categories;
    private ArrayList<Inventaire> inventaires;
    String motCle;
    
    public ArrayList<Article> getArticlesTrouves() {
        return articlesTrouves;
    }
    
    public void setArticlesTrouves(ArrayList<Article> articles) {
        this.articlesTrouves = articles;
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

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }
    
    public String execute() {
        Connection connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
        articlesTrouves = new ArrayList<>();
        ArticleDAO articleDAO = new ArticleDAO(connection);
        articlesTrouves = articleDAO.findByName(motCle);
        
        categories = new ArrayList<>();
        CategorieArticleDAO categorieArticleDAO = new CategorieArticleDAO(connection);
        categories = categorieArticleDAO.findAll();
        
        inventaires = new ArrayList<>();
        InventaireDAO inventaireDAO = new InventaireDAO(connection);
        inventaires = inventaireDAO.findAll();
        return SUCCESS;
    }
}
