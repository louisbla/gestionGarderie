/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

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
public class PersonneDAO extends CommonDAO<Personne> {

    public PersonneDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Personne create(Personne obj) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.INSERT_PERSONNE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setString(1, obj.getNom());
            preparedStatement.setString(2, obj.getPrenom());
            preparedStatement.setString(3, obj.getSexe());
            preparedStatement.setDate(4, obj.getDateNaissance());
            preparedStatement.setString(5, obj.getNumSecu());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return obj;
    }

    @Override
    public Personne update(Personne obj) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_PERSONNE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setString(1, obj.getNom());
            preparedStatement.setString(2, obj.getPrenom());
            preparedStatement.setString(3, obj.getSexe());
            preparedStatement.setDate(4, obj.getDateNaissance());
            preparedStatement.setString(5, obj.getNumSecu());
            preparedStatement.setInt(6, obj.getIdPersonne());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return obj;
    }

    @Override
    public void delete(Personne obj) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_PERSONNE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, obj.getIdPersonne());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Personne findById(int id) {
        Personne personne = null;
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_PERSONNE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, id);

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();

            ResultSet result = preparedStatement.executeQuery();

            if (result.first()) {
                personne = new Personne();

                personne.setNom(result.getString(1));
                personne.setPrenom(result.getString(2));
                personne.setSexe(result.getString(3));
                personne.setDateNaissance(result.getDate(4));
                personne.setNumSecu(result.getString(5));
                // set adresses
                // set compte user
            }
        } catch (SQLException e) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return personne;
    }

    @Override
    public ArrayList<Personne> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
