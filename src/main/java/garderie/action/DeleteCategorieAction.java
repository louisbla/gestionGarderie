/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.action;

import static com.opensymphony.xwork2.Action.SUCCESS;
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
public class DeleteCategorieAction extends ActionSupport {
    CategorieArticle categorieArticle;
    
    Connection connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
    CategorieArticleDAO categorieArticleDAO = new CategorieArticleDAO(connection);

    public CategorieArticle getCategorieArticle() {
        return categorieArticle;
    }

    public void setCategorieArticle(CategorieArticle categorieArticle) {
        this.categorieArticle = categorieArticle;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(categorieArticle.getIdCategorie());
        categorieArticleDAO.delete(categorieArticle);
        addActionMessage("Catégorie supprimée!");
        return SUCCESS;
    }
    
}
