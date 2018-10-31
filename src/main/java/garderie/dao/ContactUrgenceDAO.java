/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.ContactUrgence;
import garderie.model.Personne;
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
 * @author fadou
 */
public class ContactUrgenceDAO extends CommonDAO<ContactUrgence> {

    public ContactUrgenceDAO(Connection connection) {
        super(connection);
    }

    @Override
    public ContactUrgence create(ContactUrgence contactUrgence) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_CONTACT_URGENCE, Statement.RETURN_GENERATED_KEYS);
            
            //Insertion du contact urgence dans la table personnes de la BDD
            PersonneDAO personneDAO = new PersonneDAO(connection);
            Personne personne = personneDAO.create(contactUrgence);

            preparedStatement.setInt(1, personne.getIdPersonne());
            preparedStatement.setString(2, contactUrgence.getNumTel());
        
            System.out.println(preparedStatement.toString());

            preparedStatement.executeUpdate();
            preparedStatement.close();
                    
        } catch (SQLException ex) {
            Logger.getLogger(ContactUrgenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return contactUrgence;
    }

    @Override
    public ContactUrgence update(ContactUrgence contactUrgence) {
        try{
            //Insertion du contact urgence dans la table personnes de la BDD
            PersonneDAO personneDAO = new PersonneDAO(connection);
            Personne personne = personneDAO.update(contactUrgence);
            
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.UPDATE_CONTACT_URGENCE);
            
            preparedStatement.setString(1, contactUrgence.getNumTel());
            preparedStatement.setInt(5, personne.getIdPersonne());

            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ContactUrgenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return contactUrgence;
    }

    @Override
    public void delete(ContactUrgence contactUrgence) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_PERSONNE);
            
            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, contactUrgence.getIdPersonne());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ContactUrgenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public ContactUrgence findById(int id) {
        ContactUrgence contactUrgence = new ContactUrgence();
        
        //Creation of the PreparedStatement
            PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(SQLConstant.SELECT_CONTACT_URGENCE_BY_ID);
        

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, id);

            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();

            if (result.first()) {
                contactUrgence.setIdPersonne(id);
                contactUrgence.setNumTel(result.getString("telephone"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ContactUrgenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contactUrgence;
    }

    @Override
    public ArrayList<ContactUrgence> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
