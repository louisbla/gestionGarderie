/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.Adresse;
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
 * @author HP_LOUIS
 */
public class AdresseDAO extends CommonDAO<Adresse> {

    public AdresseDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Adresse create(Adresse adresse) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.INSERT_ADRESSE, Statement.RETURN_GENERATED_KEYS);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setString(1, "ligne_1");
            preparedStatement.setString(2, "ligne_2");
            preparedStatement.setString(3, "ligne_3");
            preparedStatement.setString(4, "ville");
            preparedStatement.setString(5, "code_postal");
            preparedStatement.setString(6, "pays");

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            
            ResultSet resultKeys = preparedStatement.getGeneratedKeys();
            int idAdresse;

            if (resultKeys.next()) {
                idAdresse = resultKeys.getInt(1);
                adresse.setIdAdresse(idAdresse);
            }

            preparedStatement.close();

        } catch (SQLException ex) {
            Logger.getLogger(AdresseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return adresse;
    }

    @Override
    public Adresse update(Adresse adresse) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_ADRESSE);

            preparedStatement.setString(1, adresse.getLigne1());
            preparedStatement.setString(2, adresse.getLigne2());
            preparedStatement.setString(3, adresse.getLigne3());
            preparedStatement.setString(4, adresse.getVille());
            preparedStatement.setString(5, adresse.getCodePostal());
            preparedStatement.setString(6, adresse.getPays());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            Logger.getLogger(AdresseDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return adresse;
    }

    @Override
    public void delete(Adresse adresse) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_ADRESSE);
            
            preparedStatement.setInt(1, adresse.getIdAdresse());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(AdresseDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Adresse findById(int id) {
        Adresse adresse = new Adresse();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_ADRESSE_BY_ID);
            
            preparedStatement.setInt(1, id);
            
            ResultSet result = preparedStatement.executeQuery();
            if (result.first()) {
                adresse.setIdAdresse(id);
                adresse.setLigne1(result.getString("ligne_1"));
                adresse.setLigne2(result.getString("ligne_2"));
                adresse.setLigne3(result.getString("ligne_3"));
                adresse.setCodePostal(result.getString("codePostal"));
                adresse.setVille(result.getString("ville"));
                adresse.setPays(result.getString("pays"));
            }
            
        } catch (SQLException e) {
            Logger.getLogger(AdresseDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return adresse;
    }

    @Override
    public ArrayList<Adresse> findAll() {
        Adresse adresse;
        ArrayList<Adresse> adresses = new ArrayList<>();
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_ADRESSES);
            
            //Recupere les resultats de la requete
            ResultSet result = preparedStatement.executeQuery();
            
            //tant qu'il y a une activite dans les resultats
            while (result.next()) {
                adresse = new Adresse();
                adresse.setIdAdresse(result.getInt("adresseId"));
                adresse.setLigne1(result.getString("ligne_1"));
                adresse.setLigne2(result.getString("ligne_2"));
                adresse.setLigne3(result.getString("ligne_3"));
                adresse.setCodePostal(result.getString("codePostal"));
                adresse.setVille(result.getString("ville"));
                adresse.setPays(result.getString("pays"));
                adresses.add(adresse);
            }
        } catch (SQLException e) {
            Logger.getLogger(ActiviteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return adresses;
    }

}
