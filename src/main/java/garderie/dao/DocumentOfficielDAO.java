/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.DocumentOfficiel;
import garderie.model.DossierInscription;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fadoua
 */
public class DocumentOfficielDAO extends CommonDAO<DocumentOfficiel> {
    
    public DocumentOfficielDAO(Connection connection) {
        super(connection);
    }
    
    @Override
    public DocumentOfficiel create(DocumentOfficiel documentOfficiel) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_DOCUMENT_OFFICIEL, Statement.RETURN_GENERATED_KEYS);            
            
            preparedStatement.setString(1, documentOfficiel.getNom());
            preparedStatement.setString(2, documentOfficiel.getUrl());
            preparedStatement.setInt(3, documentOfficiel.getDossier().getIdDossier()); 
            
            System.out.println(preparedStatement.toString());
            
            preparedStatement.executeUpdate();
            
            ResultSet resultKeys = preparedStatement.getGeneratedKeys();
            int idDocument;
            
            if (resultKeys.next()) {
                idDocument = resultKeys.getInt(1);
                documentOfficiel.setIdDocument(idDocument);
            }          
            preparedStatement.close();
            
        }
        catch (SQLException e) {
            Logger.getLogger(DocumentOfficielDAO.class.getName()).log(Level.SEVERE, null, e);
        }        
        return documentOfficiel;
    }
    
    @Override
    public DocumentOfficiel update(DocumentOfficiel documentOfficiel) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_DOCUMENT_OFFICIEL);
            
            preparedStatement.setString(1, documentOfficiel.getNom());
            preparedStatement.setString(2, documentOfficiel.getUrl());
            preparedStatement.setInt(3, documentOfficiel.getDossier().getIdDossier());
            preparedStatement.setInt(4, documentOfficiel.getIdDocument());
        }
        catch (SQLException e) {
            Logger.getLogger(DocumentOfficielDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return documentOfficiel;

    }

    @Override
    public void delete(DocumentOfficiel documentOfficiel) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_DOCUMENT_OFFICIEL);
            preparedStatement.setInt(1, documentOfficiel.getIdDocument());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e) {
            Logger.getLogger(DocumentOfficielDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public DocumentOfficiel findById(int id) {
        DocumentOfficiel documentOfficiel = new DocumentOfficiel();
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_DOCUMENT_OFFICIEL_BY_ID);
            preparedStatement.setInt(1, id);
            
            System.out.println(preparedStatement.toString());            
            ResultSet result = preparedStatement.executeQuery();
            
            if (result.first()) {
                //Recupere le dossier
                DossierInscriptionDAO dossierDAO = new DossierInscriptionDAO(connection);
                DossierInscription dossier = dossierDAO.findById(result.getInt("dossierId"));
                
                documentOfficiel.setIdDocument(result.getInt("documentId"));
                documentOfficiel.setNom(result.getString("nom"));
                documentOfficiel.setUrl(result.getString("url"));
                documentOfficiel.setDossier(dossier);
            }
        }
        catch (SQLException e) {
            Logger.getLogger(DocumentOfficielDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return documentOfficiel;
    }

    @Override
    public ArrayList<DocumentOfficiel> findAll() {
        ArrayList<DocumentOfficiel> documents = new ArrayList<>();
        DocumentOfficiel documentOfficiel = new DocumentOfficiel();
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_DOCUMENTS);
            
            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()) {
                //Recupere le dossier
                DossierInscriptionDAO dossierDAO = new DossierInscriptionDAO(connection);
                DossierInscription dossier = dossierDAO.findById(result.getInt("dossierId"));
                
                documentOfficiel.setIdDocument(result.getInt("documentId"));
                documentOfficiel.setNom(result.getString("nom"));
                documentOfficiel.setUrl(result.getString("url"));
                documentOfficiel.setDossier(dossier);
                
                documents.add(documentOfficiel);
            }
        }
        catch (SQLException e) {
            Logger.getLogger(DocumentOfficielDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return documents;
    }
    
    
}
