/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.Activite;
import garderie.model.Adresse;
import garderie.model.Personne;
import garderie.model.PersonneAdresse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dendaneys
 */
public class PersonneAdresseDAO extends CommonDAO<PersonneAdresse> {

    public PersonneAdresseDAO(Connection connection) {
        super(connection);
    }

    @Override
    public PersonneAdresse create(PersonneAdresse obj) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.INSERT_PERSONNE_ADRESSE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, obj.getAdresse().getIdAdresse());
            preparedStatement.setInt(2, obj.getPersonne().getIdPersonne());
            preparedStatement.setBoolean(3, obj.isDomicile());
            preparedStatement.setBoolean(4, obj.isFacturation());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(PersonneAdresseDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return obj;
    }

    @Override
    public PersonneAdresse update(PersonneAdresse obj) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_PERSONNE_ADRESSE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, obj.getAdresse().getIdAdresse());
            preparedStatement.setBoolean(2, obj.isDomicile());
            preparedStatement.setBoolean(3, obj.isFacturation());
            preparedStatement.setInt(4, obj.getPersonne().getIdPersonne());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(ActiviteDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return obj;
    }

    @Override
    public void delete(PersonneAdresse obj) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_PERSONNE_ADRESSE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, obj.getAdresse().getIdAdresse());
            preparedStatement.setInt(2, obj.getPersonne().getIdPersonne());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(ActiviteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public PersonneAdresse findById(int idPersonne) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PersonneAdresse> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Adresse> findAllAdressesById(int idPersonne) {
        List<Adresse> adresses = null;

        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_PERSONNE_ADRESSE_BY_PERSONNE_ID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, idPersonne);

            //Recupere les resultats de la requete
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                PersonneAdresse personneAdresse = new PersonneAdresse();
                AdresseDAO adresseDAO = new AdresseDAO(connection);
                Adresse adresse = adresseDAO.findById(result.getInt("adresseId"));

                adresses.add(adresse);
            }
        } catch (SQLException e) {
            Logger.getLogger(ActiviteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return adresses;
    }

}
