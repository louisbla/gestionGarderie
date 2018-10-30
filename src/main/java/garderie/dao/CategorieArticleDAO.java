/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.Article;
import garderie.model.CategorieArticle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Katsuo
 */
public class CategorieArticleDAO extends CommonDAO<CategorieArticle> {
    public CategorieArticleDAO(Connection connection) {
        super(connection);
    }

    @Override
    public CategorieArticle create(CategorieArticle categorieArticle) {
        try {   
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_CATEGORIE_ARTICLE, Statement.RETURN_GENERATED_KEYS);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setString(1, categorieArticle.getNom());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            
            ResultSet resultKeys = preparedStatement.getGeneratedKeys();
            if (resultKeys.next()) {
                int idCategorie = resultKeys.getInt(1);
                categorieArticle.setIdCategorie(idCategorie);
            }
            
            
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(CategorieArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return categorieArticle;
    }

    @Override
    public CategorieArticle update(CategorieArticle categorieArticle) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_CATEGORIE_ARTICLE);
            
            preparedStatement.setString(1, categorieArticle.getNom());
            preparedStatement.setInt(2, categorieArticle.getIdCategorie());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(CategorieArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return categorieArticle;
    }

    @Override
    public void delete(CategorieArticle categorieArticle) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_CATEGORIE_ARTICLE);
            preparedStatement.setInt(1, categorieArticle.getIdCategorie());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(CategorieArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public CategorieArticle findById(int id) {
        CategorieArticle categorieArticle = new CategorieArticle();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_CATEGORIE_ARTICLE_BY_ID);
            preparedStatement.setInt(1, id);
            
            ResultSet result = preparedStatement.executeQuery();
            
            if (result.first()) {
                categorieArticle.setIdCategorie(id);
                categorieArticle.setNom(result.getString("nom"));
            }
            
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(CategorieArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return categorieArticle;
    }

    @Override
    public ArrayList<CategorieArticle> findAll() {
        ArrayList<CategorieArticle> categoriesArticle = new ArrayList<>();
        CategorieArticle categorieArticle = new CategorieArticle();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_CATEGORIES_ARTICLE);
            
            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()) {
                categorieArticle.setIdCategorie(result.getInt("categorieId"));
                categorieArticle.setNom(result.getString("nom"));
                categoriesArticle.add(categorieArticle);
            }
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(CategorieArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return categoriesArticle;
    }
    
    public ArrayList<Article> getArticlesForCategorie(CategorieArticle categorieArticle) {
        ArrayList<Article> articles = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_ARTICLES_FOR_CATEGORIE);
            preparedStatement.setInt(1, categorieArticle.getIdCategorie());
            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()) {
                InventaireDAO inventaireDAO = new InventaireDAO(connection);
                Article article = new Article();
                article.setIdArticle(result.getInt("articleId"));
                article.setNom(result.getString("nom"));
                article.setQuantite(result.getInt("quantite"));
                article.setPhoto(result.getString("photo"));
                article.setDescription(result.getString("description"));
                article.setInventaire(inventaireDAO.findById(result.getInt("inventaireId")));
                article.setCategorie(categorieArticle);
                articles.add(article);
            }
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(CategorieArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return articles;
    }
    
    
    
}
