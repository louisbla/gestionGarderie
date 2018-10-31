/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import garderie.dao.CategorieArticleDAO;
import garderie.dao.InventaireDAO;
import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.CategorieArticle;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Katsuo
 */
public class AfficherCategorieAction extends ActionSupport {
    private ArrayList<CategorieArticle> categories;

    public ArrayList<CategorieArticle> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<CategorieArticle> categories) {
        this.categories = categories;
    }
    
    public String execute() {
        Connection connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
        
        categories = new ArrayList<>();
        CategorieArticleDAO categorieArticleDAO = new CategorieArticleDAO(connection);
        categories = categorieArticleDAO.findAll();
        return SUCCESS;
    }
    
}
