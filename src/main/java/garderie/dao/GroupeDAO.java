/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.Employe;
import garderie.model.Enfant;
import garderie.model.Groupe;
import garderie.model.NomGroupe;
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
 * @author Katsuo
 */
public class GroupeDAO extends CommonDAO<Groupe>{
    public GroupeDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Groupe create(Groupe groupe) {
        try {   
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_GROUPE, Statement.RETURN_GENERATED_KEYS);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setString(1, groupe.getDescriptif());
            preparedStatement.setInt(2, groupe.getReferant().getIdPersonne());
            preparedStatement.setInt(3, groupe.getNom().getId());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            
            ResultSet resultKeys = preparedStatement.getGeneratedKeys();
            if (resultKeys.next()) {
                int idGroupe = resultKeys.getInt(1);
                groupe.setIdGroupe(idGroupe);
            }
            
            
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(GroupeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return groupe;
    }

    @Override
    public Groupe update(Groupe groupe) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_GROUPE);
            
            preparedStatement.setString(1, groupe.getDescriptif());
            preparedStatement.setInt(2, groupe.getReferant().getIdPersonne());
            preparedStatement.setInt(3, groupe.getNom().getId());
            preparedStatement.setInt(4, groupe.getIdGroupe());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(GroupeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return groupe;
    }

    @Override
    public void delete(Groupe groupe) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_GROUPE);
            preparedStatement.setInt(1, groupe.getIdGroupe());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(GroupeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Groupe findById(int id) {
        Groupe groupe = new Groupe();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_GROUPE_BY_ID);
            preparedStatement.setInt(1, id);
            
            ResultSet result = preparedStatement.executeQuery();
            
            if (result.first()) {
                EmployeDAO employeDAO = new EmployeDAO(connection);
                Employe referant = employeDAO.findById(result.getInt("referant"));
                groupe.setIdGroupe(result.getInt("groupeId"));
                groupe.setDescriptif(result.getString("descriptif"));
                groupe.setReferant(referant);
                groupe.setNom(NomGroupe.valueOf(result.getInt("nom_groupe")));
            }
            
        } catch (SQLException e) {
            Logger.getLogger(GroupeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return groupe;
    }

    @Override
    public ArrayList<Groupe> findAll() {
        Groupe groupe = new Groupe();
        ArrayList<Groupe> groupes = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_GROUPES);
            
            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()) {
                EmployeDAO employeDAO = new EmployeDAO(connection);
                Employe referant = employeDAO.findById(result.getInt("referant"));
                groupe.setIdGroupe(result.getInt("groupeId"));
                groupe.setDescriptif(result.getString("descriptif"));
                groupe.setReferant(referant);
                groupe.setNom(NomGroupe.valueOf(result.getInt("nom_groupe")));
                groupes.add(groupe);
            }
        } catch (SQLException e) {
            Logger.getLogger(GroupeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return groupes;
    }
    
    public Employe getReferantGroupe(int id) {
        Employe employe = new Employe();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_REFERANT_GROUPE);
            
            ResultSet result = preparedStatement.executeQuery();
            
            if (result.first()) {
                EmployeDAO employeDAO = new EmployeDAO(connection);
                employe = employeDAO.findById(result.getInt("referant"));
            }
        } catch (SQLException e) {
            Logger.getLogger(GroupeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return employe;
    }
    
    public ArrayList<Employe> getEmployesForGroupe(int id) {
        ArrayList<Employe> employes = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_EMPLOYES_FOR_GROUPE);
            preparedStatement.setInt(1, id);
            
            ResultSet result = preparedStatement.executeQuery();
            System.out.println(preparedStatement.toString());
            while (result.next()) {
                EmployeDAO employeDAO = new EmployeDAO(connection);
                Employe employe = employeDAO.findById(result.getInt("employeId"));
                employes.add(employe);
            }
        } catch (SQLException e) {
            Logger.getLogger(GroupeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return employes;
        
    }
    
    public ArrayList<Enfant> getEnfantsForGroupe(int id) {
        ArrayList<Enfant> enfants = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_ENFANTS_FOR_GROUPE);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()) {
                EnfantDAO enfantDAO = new EnfantDAO(connection);
                Enfant enfant = enfantDAO.findById(result.getInt("enfantId"));
                enfants.add(enfant);
            }
        } catch (SQLException e) {
            Logger.getLogger(GroupeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return enfants;
        
    }
    
    
}
