/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.Article;
import garderie.model.Inventaire;
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
 * @author Maryline
 */
public class ArticleDAO extends CommonDAO<Article> {

    public ArticleDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Article create(Article article) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_ARTICLE, Statement.RETURN_GENERATED_KEYS);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setString(1, article.getNom());
            preparedStatement.setInt(2, article.getQuantite());
            preparedStatement.setString(3, article.getPhoto());
            preparedStatement.setString(4, article.getDescription());
            preparedStatement.setInt(5, article.getInventaire().getIdInventaire());
            preparedStatement.setInt(6, article.getCategorie().getIdCategorie());

            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();

            //Recupere l'id genere par la BDD
            ResultSet resultKeys = preparedStatement.getGeneratedKeys();
            if (resultKeys.next()) {
                int idArticle = resultKeys.getInt(1);
                article.setIdArticle(idArticle);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return article;
    }

    @Override
    public Article update(Article article) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.UPDATE_ARTICLE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setString(1, article.getNom());
            preparedStatement.setInt(2, article.getQuantite());
            preparedStatement.setString(3, article.getPhoto());
            preparedStatement.setString(4, article.getDescription());
            preparedStatement.setInt(5, article.getInventaire().getIdInventaire());
            preparedStatement.setInt(6, article.getCategorie().getIdCategorie());
            preparedStatement.setInt(7, article.getIdArticle());

            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return article;

    }

    @Override
    public void delete(Article article) {

        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_ARTICLE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, article.getIdArticle());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public Article findById(int id) {
        Article article = new Article();

        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_INVENTAIRE_ENFANT_BY_ID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, id);

            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();

            if (result.first()) {
                InventaireDAO inventaireDAO = new InventaireDAO(connection);
                Inventaire inventaire = inventaireDAO.findById(result.getInt("inventaireId"));

                CategorieArticleDAO categorieArticleDAO = new CategorieArticleDAO(connection);
                CategorieArticle categorie = categorieArticleDAO.findById(result.getInt("categorieId"));

                article.setIdArticle(id);
                article.setNom(result.getString("nom"));
                article.setQuantite(result.getInt("quantite"));
                article.setPhoto(result.getString("photo"));
                article.setDescription(result.getString("description"));
                article.setInventaire(inventaire);
                article.setCategorie(categorie);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return article;

    }

    @Override
    public ArrayList<Article> findAll() {

        ArrayList<Article> listeArticle = new ArrayList<>();

        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_ARTICLE);

            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                Article article = new Article();

                InventaireDAO inventaireDAO = new InventaireDAO(connection);
                Inventaire inventaire = inventaireDAO.findById(result.getInt("inventaireId"));

                CategorieArticleDAO categorieArticleDAO = new CategorieArticleDAO(connection);
                CategorieArticle categorie = categorieArticleDAO.findById(result.getInt("categorieId"));

                article.setIdArticle(result.getInt("articleId"));
                article.setNom(result.getString("nom"));
                article.setQuantite(result.getInt("quantite"));
                article.setPhoto(result.getString("photo"));
                article.setDescription(result.getString("description"));
                article.setInventaire(inventaire);
                article.setCategorie(categorie);

                listeArticle.add(article);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return listeArticle;
    }

    public ArrayList<Article> getArticlesForCategorie(int id) {
        ArrayList<Article> listeArticle = new ArrayList<>();
        Article article = new Article();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_CATEGORIE_FOR_ARTICLE);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                InventaireDAO inventaireDAO = new InventaireDAO(connection);
                Inventaire inventaire = inventaireDAO.findById(result.getInt("invenatireId"));

                CategorieArticleDAO categorieArticleDAO = new CategorieArticleDAO(connection);
                CategorieArticle categorie = categorieArticleDAO.findById(result.getInt("categorieId"));

                article.setIdArticle(result.getInt("articleId"));
                article.setNom(result.getString("nom"));
                article.setQuantite(result.getInt("quantite"));
                article.setPhoto(result.getString("photo"));
                article.setDescription(result.getString("description"));
                article.setInventaire(inventaire);
                article.setCategorie(categorie);

                listeArticle.add(article);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listeArticle;

    }

    public ArrayList<Article> getArticlesForEnfants(int idEnfant) {
        ArrayList<Article> listeArticle = new ArrayList<>();
        Article article = new Article();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_CATEGORIE_FOR_ARTICLE);
            preparedStatement.setInt(1, idEnfant);
            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                InventaireDAO inventaireDAO = new InventaireDAO(connection);
                Inventaire inventaire  = inventaireDAO.findById(result.getInt("inventaireId"));
                 
                CategorieArticleDAO categorieArticleDAO = new CategorieArticleDAO(connection);
                CategorieArticle categorie = categorieArticleDAO.findById(result.getInt("categorieId"));

                article.setIdArticle(result.getInt("articleId"));
                article.setNom(result.getString("nom"));
                article.setQuantite(result.getInt("quantite"));
                article.setPhoto(result.getString("photo"));
                article.setDescription(result.getString("description"));
                article.setInventaire(inventaire);
                article.setCategorie(categorie);

                listeArticle.add(article);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listeArticle;

    }

    public Article findByName(String name){
        Article article = new Article();
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_ARTICLE_BY_NAME);
            preparedStatement.setString(1, name);
            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();
            
            if (result.first()){
                InventaireDAO inventaireDAO = new InventaireDAO(connection);
                Inventaire inventaire = inventaireDAO.findById(result.getInt("inventaireId"));

                CategorieArticleDAO categorieArticleDAO = new CategorieArticleDAO(connection);
                CategorieArticle categorie = categorieArticleDAO.findById(result.getInt("categorieId"));

                article.setIdArticle(result.getInt("articleId"));
                article.setNom(result.getString(name));
                article.setQuantite(result.getInt("quantite"));
                article.setPhoto(result.getString("photo"));
                article.setDescription(result.getString("description"));
                article.setInventaire(inventaire);
                article.setCategorie(categorie);
            }

             preparedStatement.close();
            
        }catch (SQLException e) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return article;
    }
}
