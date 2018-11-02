/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.action;

import com.opensymphony.xwork2.ActionSupport;
import garderie.dao.CategorieArticleDAO;
import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.CategorieArticle;
import java.sql.Connection;

/**
 *
 * @author Katsuo
 */
public class UpdateCategorieAction extends ActionSupport {
    private CategorieArticle categorieArticle;
    
    private Connection connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
    private CategorieArticleDAO categorieArticleDAO = new CategorieArticleDAO(connection);

    public CategorieArticle getCategorieArticle() {
        return categorieArticle;
    }

    public void setCategorieArticle(CategorieArticle categorieArticle) {
        this.categorieArticle = categorieArticle;
    }

    @Override
    public String execute() throws Exception {
        categorieArticle = categorieArticleDAO.update(categorieArticle);
        addActionMessage("Catégorie modifiée!");
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (categorieArticle.getNom().length() == 0) {
            addFieldError("categorieArticle.nom", "Veuillez remplir le champs");
        }
    }
    
    
    
    
}
