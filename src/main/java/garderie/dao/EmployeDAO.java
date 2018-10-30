/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import com.mysql.jdbc.Statement;
import garderie.model.Employe;
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
 * @author Katsuo
 */
public class EmployeDAO extends CommonDAO<Employe> {
    
    public EmployeDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Employe create(Employe employe) {
        try {
            //Insertion de l'employe dans la table personnes de la BDD
            PersonneDAO personneDAO = new PersonneDAO(connection);
            Personne personne = personneDAO.create(employe);
            
            
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_EMPLOYE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, personne.getIdPersonne());
            preparedStatement.setString(2, employe.getPoste());
            preparedStatement.setBoolean(3, employe.isExterne());
            preparedStatement.setString(4, employe.getNumTel());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(EmployeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return employe;
    }

    @Override
    public Employe update(Employe employe) {
        try {
            //Insertion de l'employe dans la table personnes de la BDD
            PersonneDAO personneDAO = new PersonneDAO(connection);
            Personne personne = personneDAO.update(employe);
            
            
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.UPDATE_EMPLOYE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setString(1, employe.getPoste());
            preparedStatement.setBoolean(2, employe.isExterne());
            preparedStatement.setString(3, employe.getNumTel());
            preparedStatement.setInt(5, personne.getIdPersonne());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(EmployeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return employe;
    }

    @Override
    public void delete(Employe employe) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_PERSONNE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, employe.getIdPersonne());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(EmployeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Employe findById(int id) {
        Employe employe = new Employe();
        try {
            
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_EMPLOYE_BY_ID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, id);

            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();

            if (result.first()) {
                employe.setIdPersonne(id);
                employe.setNom(result.getString("nom"));
                employe.setPrenom(result.getString("prenom"));
                employe.setSexe(result.getString("sexe"));
                employe.setDateNaissance(result.getDate("date_naissance"));
                employe.setNumSecu(result.getString("numSecu"));
                
                employe.setPoste(result.getString("poste"));
                employe.setExterne(result.getBoolean("externe"));
                employe.setNumTel(result.getString("telephone"));
                //get DossierEmploye
            }
        } catch (SQLException e) {
            Logger.getLogger(EmployeDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return employe;
    }

    @Override
    public ArrayList<Employe> findAll() {
        ArrayList<Employe> employes = new ArrayList<>();
        
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_EMPLOYES);

            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                Employe employe = new Employe();
                PersonneDAO personneDAO = new PersonneDAO(connection);
                Personne personne = personneDAO.findById(result.getInt("employeId"));
                employe.setIdPersonne(personne.getIdPersonne());
                employe.setNom(personne.getNom());
                employe.setPrenom(personne.getPrenom());
                employe.setSexe(personne.getSexe());
                employe.setDateNaissance(personne.getDateNaissance());
                employe.setNumSecu(personne.getNumSecu());
                
                employe.setPoste(result.getString("poste"));
                employe.setExterne(result.getBoolean("externe"));
                employe.setNumTel(result.getString("telephone"));
                
                employes.add(employe);
                
            }
        } catch (SQLException e) {
            Logger.getLogger(EmployeDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return employes; 
    }
    
    
    
    
}
