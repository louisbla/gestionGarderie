/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.action;

import com.opensymphony.xwork2.ActionSupport;
import garderie.dao.ArticleDAO;
import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.Article;
import java.sql.Connection;

/**
 *
 * @author Katsuo
 */
public class DeleteArticleAction extends ActionSupport {
    Article article;
    Connection connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
    ArticleDAO articleDAO = new ArticleDAO(connection);

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
    
    @Override
    public String execute() throws Exception {
        articleDAO.delete(article);
        addActionMessage("Article supprimé!");
        return SUCCESS;
    }
}
