/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.ContactUrgence;
import garderie.model.DossierContactUrgence;
import garderie.model.DossierInscription;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fadou
 */
public class DossierContactUrgenceDAO extends CommonDAO<DossierContactUrgence>{

    public DossierContactUrgenceDAO(Connection connection) {
        super(connection);
    }

    @Override
    public DossierContactUrgence create(DossierContactUrgence dossier) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_DOSSIER_CONTACT_URGENCE);
            
            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setString(1, dossier.getLienParente());
            preparedStatement.setInt(2, dossier.getContactUrgence().getIdPersonne());
            preparedStatement.setInt(2, dossier.getDossierInscription().getIdDossier());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DossierContactUrgenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dossier;
    }

    @Override
    public DossierContactUrgence update(DossierContactUrgence dossier) {
                        
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.UPDATE_DOSSIER_CONTACT_URGENCE);
            
            preparedStatement.setString(1, dossier.getLienParente());
            preparedStatement.setInt(1, dossier.getContactUrgence().getIdPersonne());
            preparedStatement.setInt(1, dossier.getDossierInscription().getIdDossier());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DossierContactUrgenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dossier;
    }

    @Override
    public void delete(DossierContactUrgence dossier) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_DOSSIER_CONTACT_URGENCE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, dossier.getDossierContactUrgenceId());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(EmployeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public DossierContactUrgence findById(int id) {
        DossierContactUrgence dossier = new DossierContactUrgence();
        
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_DOSSIER_CONTACT_URGENCE_BY_ID);
        
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();
            
            if (result.first()) {
                dossier.setDossierContactUrgenceId(id);
                dossier.setLienParente(result.getString("lien_parente"));
                
                //Dossier d'inscription
                DossierInscriptionDAO dossierDAO = new DossierInscriptionDAO(connection);
                DossierInscription dossierInscription = dossierDAO.findById(result.getInt("dossier_inscription_id"));
                dossier.setDossierInscription(dossierInscription);

                //Contact d'urgence
                ContactUrgenceDAO contactUrgenceDAO = new ContactUrgenceDAO(connection);
                ContactUrgence contact = contactUrgenceDAO.findById(result.getInt("contactId"));
                dossier.setContactUrgence(contact);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DossierContactUrgenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dossier;
    }

    @Override
    public ArrayList<DossierContactUrgence> findAll() {
        ArrayList<DossierContactUrgence> dossiers = new ArrayList<>();
        
        
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(SQLConstant.SELECT_DOSSIER_CONTACT_URGENCE);
            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()) {
                DossierContactUrgence dossier = new DossierContactUrgence();

                dossier = this.findById(result.getInt("dossierContactUrgenceId"));

                dossiers.add(dossier);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DossierContactUrgenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dossiers;
    }
    
}
