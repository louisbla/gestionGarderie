/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.Article;
import garderie.model.InventaireEnfant;
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
 * @author dendaneys
 */
public class InventaireEnfantDAO extends CommonDAO<InventaireEnfant> {

    public InventaireEnfantDAO(Connection connection) {
        super(connection);
    }

    @Override
    public InventaireEnfant create(InventaireEnfant obj) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.INSERT_INVENTAIRE_ENFANT, Statement.RETURN_GENERATED_KEYS);
            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            ResultSet resultKeys = preparedStatement.getGeneratedKeys();
            int idInventaireEnfant;

            if (resultKeys.next()) {
                idInventaireEnfant = resultKeys.getInt(1);
                obj.setIdInventaire(idInventaireEnfant);
            }
            preparedStatement.close();

            ArticleDAO articleDAO = new ArticleDAO(connection);

            for (Article article : obj.getListeArticleEnfant()) {
                articleDAO.create(article);
            }

        } catch (SQLException e) {
            Logger.getLogger(EnfantDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return obj;
    }

    @Override
    public InventaireEnfant update(InventaireEnfant obj) {
        ArticleDAO articleDAO = new ArticleDAO(connection);

        for (Article article : obj.getListeArticleEnfant()) {
            articleDAO.update(article);
        }
        return obj;
    }

    @Override
    public void delete(InventaireEnfant obj) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_INVENTAIRE_ENFANT);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, obj.getIdInventaire());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(EnfantDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public InventaireEnfant findById(int idInventaire) {
        InventaireEnfant inventaireEnfant = null;
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_INVENTAIRE_ENFANT_BY_ID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, idInventaire);
            ResultSet result = preparedStatement.executeQuery();

            if (result.first()) {
                inventaireEnfant = new InventaireEnfant();
                inventaireEnfant.setIdInventaire(idInventaire);
                ArrayList<Article> articles = this.getArticlesByEnfantId(idInventaire);
                inventaireEnfant.setListeArticleEnfant(articles);
            }
        } catch (SQLException e) {
            Logger.getLogger(InventaireEnfantDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return inventaireEnfant;
    }

    @Override
    public ArrayList<InventaireEnfant> findAll() {
        ArrayList<InventaireEnfant> inventaireEnfants = new ArrayList<>();
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_INVENTAIRE_ENFANT);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                InventaireEnfant inventaireEnfant = this.findById(result.getInt("inventaireId"));
                inventaireEnfants.add(inventaireEnfant);
            }
        } catch (SQLException e) {
            Logger.getLogger(InventaireEnfantDAO.class
                    .getName()).log(Level.SEVERE, null, e);
        }

        return inventaireEnfants;
    }

    public ArrayList<Article> getArticlesByEnfantId(int enfantInventaireId) {
        ArrayList<Article> articles = new ArrayList<>();
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_ARTICLES_BY_ENFANTID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, enfantInventaireId);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                ArticleDAO articleDAO = new ArticleDAO(connection);
                Article article = articleDAO.findById(result.getInt("articleId"));

                articles.add(article);

            }
        } catch (SQLException e) {
            Logger.getLogger(InventaireEnfantDAO.class
                    .getName()).log(Level.SEVERE, null, e);
        }

        return articles;
    }
}
