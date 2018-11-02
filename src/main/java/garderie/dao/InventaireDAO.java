/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.Article;
import garderie.model.Employe;
import garderie.model.Inventaire;
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
public class InventaireDAO extends CommonDAO<Inventaire>{
    public InventaireDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Inventaire create(Inventaire inventaire) {
        try {   
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_INVENTAIRE, Statement.RETURN_GENERATED_KEYS);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, inventaire.getStockMax());
            preparedStatement.setInt(2, inventaire.getStockActuel());
            preparedStatement.setInt(3, inventaire.getEmploye().getIdPersonne());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            
            ResultSet resultKeys = preparedStatement.getGeneratedKeys();
            int idInventaire;

            if (resultKeys.next()) {
                idInventaire = resultKeys.getInt(1);
                inventaire.setIdInventaire(idInventaire);
            }
            
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(InventaireDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return inventaire;
    }

    @Override
    public Inventaire update(Inventaire inventaire) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_INVENTAIRE);
            
            preparedStatement.setInt(1, inventaire.getStockMax());
            preparedStatement.setInt(2, inventaire.getStockActuel());
            preparedStatement.setInt(3, inventaire.getEmploye().getIdPersonne());
            preparedStatement.setInt(4, inventaire.getIdInventaire());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(InventaireDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return inventaire;
    }

    @Override
    public void delete(Inventaire inventaire) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_INVENTAIRE);
            preparedStatement.setInt(1, inventaire.getIdInventaire());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(InventaireDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Inventaire findById(int id) {
        Inventaire inventaire = new Inventaire();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_INVENTAIRE_BY_ID);
            preparedStatement.setInt(1, id);
            
            ResultSet result = preparedStatement.executeQuery();
            
            if (result.first()) {
                EmployeDAO employeDAO = new EmployeDAO(connection);
                Employe employe = employeDAO.findById(result.getInt("employeId"));
                inventaire.setIdInventaire(id);
                inventaire.setStockActuel(result.getInt("stock_actuel"));
                inventaire.setStockMax(result.getInt("stock_max"));
                inventaire.setEmploye(employe);
                //Articles
            }
            
        } catch (SQLException e) {
            Logger.getLogger(InventaireDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return inventaire;
    }

    @Override
    public ArrayList<Inventaire> findAll() {
        
        ArrayList<Inventaire> inventaires = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_INVENTAIRES);
            
            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()) {
                Inventaire inventaire = new Inventaire();
                EmployeDAO employeDAO = new EmployeDAO(connection);
                Employe employe = employeDAO.findById(result.getInt("employeId"));
                inventaire.setIdInventaire(result.getInt("inventaireId"));
                inventaire.setStockActuel(result.getInt("stock_actuel"));
                inventaire.setStockMax(result.getInt("stock_max"));
                inventaire.setEmploye(employe);
                //Articles
                inventaires.add(inventaire);
            }
        } catch (SQLException e) {
            Logger.getLogger(InventaireDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return inventaires;
    }
    
    public ArrayList<Article> getArticlesForInventaire(int id) {
        ArrayList<Article> articles = new ArrayList<>();
        
        ArticleDAO articleDAO = new ArticleDAO(connection);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_ARTICLES_FOR_INVENTAIRE);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement.toString());
            
            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()) {
                Article article = new Article();
                article = articleDAO.findById(result.getInt("articleId"));
                articles.add(article);
            }
        } catch (SQLException e) {
            Logger.getLogger(InventaireDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return articles;
    }
    
    
    
}
