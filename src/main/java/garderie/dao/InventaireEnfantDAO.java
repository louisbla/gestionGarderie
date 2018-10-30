/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.Article;
import garderie.model.Inventaire;
import garderie.model.InventaireEnfant;
import garderie.model.Personne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InventaireEnfant update(InventaireEnfant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(InventaireEnfant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InventaireEnfant findById(int id) {
        InventaireEnfant inventaireEnfant = null;
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_INVENTAIRE_ENFANT_BY_ID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            if (result.first()) {
                inventaireEnfant = new InventaireEnfant();
                inventaireEnfant.setIdInventaire(result.getInt("inventaireId"));

                ArticleDAO articleDAO = new ArticleDAO(connection);
                ArrayList<Article> articles = articleDAO.findAll();
                inventaireEnfant.setListeArticleEnfant(articles);
            }
        } catch (SQLException e) {
            Logger.getLogger(InventaireEnfantDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return inventaireEnfant;
    }

    @Override
    public ArrayList<InventaireEnfant> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
