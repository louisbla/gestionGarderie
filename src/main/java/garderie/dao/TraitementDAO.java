/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.Enfant;
import garderie.model.Maladie;
import garderie.model.Traitement;
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
public class TraitementDAO extends CommonDAO<Traitement> {

    public TraitementDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Traitement create(Traitement traitement) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_TRAITEMENT);
                        
            preparedStatement.setInt(1, traitement.getMaladie().getIdMaladie());            
            preparedStatement.setInt(2, traitement.getEnfant().getIdPersonne());            
            preparedStatement.setString(3, traitement.getNomMedicament());
            preparedStatement.setString(4, traitement.getSpecification());
            preparedStatement.setString(5, traitement.getType());
            preparedStatement.setDouble(6, traitement.getQuantite());
            preparedStatement.setInt(7, traitement.getFrequence());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
                                 
        } catch (SQLException e) {
            Logger.getLogger(TraitementDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return traitement;
    }

    @Override
    public Traitement update(Traitement traitement) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_TRAITEMENT);
            
            preparedStatement.setString(1, traitement.getNomMedicament());
            preparedStatement.setString(2, traitement.getSpecification());
            preparedStatement.setString(3, traitement.getType());
            preparedStatement.setDouble(4, traitement.getQuantite());
            preparedStatement.setInt(5, traitement.getFrequence());
            
            preparedStatement.setInt(6, traitement.getMaladie().getIdMaladie());
            preparedStatement.setInt(7, traitement.getEnfant().getIdPersonne());
            
            System.out.println(preparedStatement.toString());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TraitementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return traitement;
    }

    @Override
    public void delete(Traitement traitement) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_TRAITEMENT);
            
            preparedStatement.setInt(1,traitement.getMaladie().getIdMaladie());
            preparedStatement.setInt(2,traitement.getEnfant().getIdPersonne());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TraitementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public ArrayList<Traitement> findByEnfantId(int enfantId) {
        ArrayList<Traitement> traitements = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_TRAITEMENT_BY_ENFANT_ID);
            preparedStatement.setInt(1, enfantId);
            System.out.println(preparedStatement.toString());
            
            ResultSet result = preparedStatement.executeQuery();
            
            if (result.next()) {
                Traitement traitement = new Traitement();
                
                //On recupere la maladie
                MaladieDAO maladieDAO = new MaladieDAO(connection);
                Maladie maladie = maladieDAO.findById(result.getInt("maladieId"));
                traitement.setMaladie(maladie);
                
                //On recupere l'enfant
                EnfantDAO enfantDAO = new EnfantDAO(connection);
                Enfant enfant = enfantDAO.findById(enfantId);
                traitement.setEnfant(enfant);
                
                traitement.setNomMedicament(result.getString("nom_medicament"));
                traitement.setSpecification(result.getString("specification"));
                traitement.setType(result.getString("type"));
                traitement.setQuantite(result.getDouble("quantite"));
                traitement.setFrequence(result.getInt("frequence"));
                
                traitements.add(traitement);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(TraitementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return traitements;
    }

    @Override
    public ArrayList<Traitement> findAll() {
        ArrayList<Traitement> traitements = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_TRAITEMENTS);
            
            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()) {
                Traitement traitement = new Traitement();
                
                //On recupere la maladie
                MaladieDAO maladieDAO = new MaladieDAO(connection);
                Maladie maladie = maladieDAO.findById(result.getInt("maladieId"));
                traitement.setMaladie(maladie);
                
                //On recupere l'enfant
                EnfantDAO enfantDAO = new EnfantDAO(connection);
                Enfant enfant = enfantDAO.findById(result.getInt("enfantId"));
                traitement.setEnfant(enfant);
                
                traitement.setNomMedicament(result.getString("nom_medicament"));
                traitement.setSpecification(result.getString("specification"));
                traitement.setType(result.getString("type"));
                traitement.setQuantite(result.getDouble("quantite"));
                traitement.setFrequence(result.getInt("frequence"));
                
                traitements.add(traitement);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TraitementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return traitements;
    }

    @Override
    public Traitement findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
