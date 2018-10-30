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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.INSERT_PERSONNE, Statement.RETURN_GENERATED_KEYS);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setString(1, obj.getNom());
            preparedStatement.setString(2, obj.getPrenom());
            preparedStatement.setString(3, obj.getSexe());
            preparedStatement.setDate(4, obj.getDateNaissance());
            preparedStatement.setString(5, obj.getNumSecu());

            System.out.println(preparedStatement.toString());
            //Executing the preparedStatement
            preparedStatement.executeUpdate();

            ResultSet resultKeys = preparedStatement.getGeneratedKeys();
            int idPersonne;

            if (resultKeys.next()) {
                idPersonne = resultKeys.getInt(1);
                obj.setIdPersonne(idPersonne);
            }

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
        Personne personne = new Personne();
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_PERSONNE_BY_ID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, id);

            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();

            if (result.first()) {
                personne.setIdPersonne(result.getInt("personneId"));
                personne.setNom(result.getString("nom"));
                personne.setPrenom(result.getString("prenom"));
                personne.setSexe(result.getString("sexe"));
                personne.setDateNaissance(result.getDate("date_naissance"));
                personne.setNumSecu(result.getString("numSecu"));
            }
        } catch (SQLException e) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return personne;
    }

    @Override
    public ArrayList<Personne> findAll() {
        ArrayList<Personne> personnes = new ArrayList<>();
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_PERSONNE);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                Personne personne = new Personne();
                personne.setIdPersonne(result.getInt("personneId"));
                personne.setNom(result.getString("nom"));
                personne.setPrenom(result.getString("prenom"));
                personne.setSexe(result.getString("sexe"));
                personne.setDateNaissance(result.getDate("date_naissance"));
                personne.setNumSecu(result.getString("numSecu"));

                personnes.add(personne);
            }
        } catch (SQLException e) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return personnes;
    }

}
