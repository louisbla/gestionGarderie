/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.Activite;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Katsuo
 */
public class ActiviteDAO extends CommonDAO<Activite>{

    public ActiviteDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Activite create(Activite activite) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.INSERT_ACTIVITE);
            
            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setString(1, activite.getNom());
            preparedStatement.setDate(2, activite.getDate());
            preparedStatement.setString(3, activite.getDescription());
            preparedStatement.setInt(4, activite.getNbEnfantMax());
            preparedStatement.setString(5, activite.getLieu());
            preparedStatement.setDouble(6, activite.getPrix());
            
            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(ActiviteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return activite;
    }

    @Override
    public Activite update(Activite activite) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_ACTIVITE);
            
            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setString(1, activite.getNom());
            preparedStatement.setDate(2, activite.getDate());
            preparedStatement.setString(3, activite.getDescription());
            preparedStatement.setInt(4, activite.getNbEnfantMax());
            preparedStatement.setString(5, activite.getLieu());
            preparedStatement.setDouble(6, activite.getPrix());
            preparedStatement.setInt(7, activite.getIdActivite());
            
            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            activite = this.findById(activite.getIdActivite());
        } catch (SQLException e) {
            Logger.getLogger(ActiviteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return activite;
    }

    @Override
    public void delete(Activite activite) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_ACTIVITE);
            
            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, activite.getIdActivite());
            
            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(ActiviteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Activite findById(int id) {
        Activite activite = new Activite();
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_ACTIVITE_BY_ID);
            
            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, id);
            
            //Recupere les resultats de la requete
            ResultSet result = preparedStatement.executeQuery();
            if (result.first()) {
                activite = new Activite(id, result.getString("nom"), 
                        result.getDate("date"), result.getString("description"),
                        result.getInt("nb_enfants_max"), result.getString("lieu"),
                        result.getDouble("prix"));
            }
        } catch (SQLException e) {
            Logger.getLogger(ActiviteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return activite;
    }

    @Override
    public ArrayList<Activite> findAll() {
        Activite activite;
        ArrayList<Activite> activites = new ArrayList<>();
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_ACTIVITES);
            
            //Recupere les resultats de la requete
            ResultSet result = preparedStatement.executeQuery();
            
            //tant qu'il y a une activite dans les resultats
            while (result.next()) {
                activite = new Activite();
                activite.setIdActivite(result.getInt("activiteId"));
                activite.setNom(result.getString("nom"));
                activite.setDate(result.getDate("date"));
                activite.setDescription(result.getString("description"));
                activite.setNbEnfantMax(result.getInt("nb_enfants_max"));
                activite.setLieu(result.getString("lieu"));
                activite.setPrix(result.getDouble("prix"));
                activites.add(activite);
            }
        } catch (SQLException e) {
            Logger.getLogger(ActiviteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return activites;
    }
    
    
    
    
}
