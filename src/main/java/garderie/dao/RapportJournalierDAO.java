/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;
import garderie.model.DossierInscription;
import garderie.model.RapportJournalier;
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
 * @author Maryline
 */
public class RapportJournalierDAO extends CommonDAO<RapportJournalier>{
    public RapportJournalierDAO(Connection connection){
        super(connection);
    }

    @Override
    public RapportJournalier create(RapportJournalier rapport) {
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_RAPPORT_JOURNALIER, Statement.RETURN_GENERATED_KEYS);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setDate(1, rapport.getDateRapport());
            preparedStatement.setBoolean(2, rapport.isPresent());
            preparedStatement.setString(3, rapport.getResumeJournee());
            preparedStatement.setInt(4, rapport.getDossierInscription().getIdDossier());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            
            ResultSet resultKeys = preparedStatement.getGeneratedKeys();
            if (resultKeys.next()) {
                int idRapport = resultKeys.getInt(1);
                rapport.setIdRapportJournalier(idRapport);
            }
            
            preparedStatement.close();
            
        }catch (SQLException e) {
            Logger.getLogger(GroupeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return rapport;
    }

    @Override
    public RapportJournalier update(RapportJournalier rapport) {
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_RAPPORT_JOURNALIER);
            
            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setDate(1, rapport.getDateRapport());
            preparedStatement.setBoolean(2, rapport.isPresent());
            preparedStatement.setString(3, rapport.getResumeJournee());
            preparedStatement.setInt(4, rapport.getDossierInscription().getIdDossier());
            preparedStatement.setInt(5, rapport.getIdRapportJournalier());
            
             System.out.println(preparedStatement.toString());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        }catch (SQLException e) {
            Logger.getLogger(GroupeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return rapport;
    
    }

    @Override
    public void delete(RapportJournalier rapport) {
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_RAPPORT_JOURNALIER);
            
            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, rapport.getIdRapportJournalier());
            
             System.out.println(preparedStatement.toString());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        }catch (SQLException e) {
            Logger.getLogger(GroupeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    
    
    @Override
    public RapportJournalier findById(int id) {
       RapportJournalier rapport = new RapportJournalier();
       
       try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_RAPPORT_JOURNALIER_BY_ID);
            
            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, id);
            
            System.out.println(preparedStatement.toString());
            
            ResultSet result = preparedStatement.executeQuery();
            
            if (result.first()) {
                DossierInscriptionDAO dossierInscriptionDAO = new DossierInscriptionDAO(connection);
                DossierInscription dossier = dossierInscriptionDAO.findById(result.getInt("dossierInscription_id"));
                rapport.setIdRapportJournalier(id);
                rapport.setDateRapport(result.getDate("date"));
                rapport.setPresent(result.getBoolean("present"));
                rapport.setResumeJournee(result.getString("resume"));
                rapport.setDossierInscription(dossier);
            }
            
       }catch (SQLException e) {
            Logger.getLogger(GroupeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    
       return rapport;
    
    }

    
    
    
    @Override
    public ArrayList<RapportJournalier> findAll() {
        ArrayList<RapportJournalier> listerapport = new ArrayList<>();
        
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_RAPPORT_JOURNALIER);
            
            System.out.println(preparedStatement.toString());
            
            ResultSet result = preparedStatement.executeQuery();
            
             while (result.next()) {
                RapportJournalier rapport = new RapportJournalier();
                DossierInscriptionDAO dossierInscriptionDAO = new DossierInscriptionDAO(connection);
                DossierInscription dossier = dossierInscriptionDAO.findById(result.getInt("dossierInscription_id"));
                rapport.setIdRapportJournalier(result.getInt("rapportId"));
                rapport.setDateRapport(result.getDate("date"));
                rapport.setPresent(result.getBoolean("present"));
                rapport.setResumeJournee(result.getString("resume"));
                rapport.setDossierInscription(dossier);
                
                listerapport.add(rapport);
             }
            
        }catch (SQLException e) {
            Logger.getLogger(GroupeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    
       return listerapport;
    
    }
    
    
}
