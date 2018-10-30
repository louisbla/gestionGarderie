/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.DossierEmploye;
import garderie.model.Employe;
import garderie.model.TypeContrat;
import java.sql.Connection;
import java.sql.Date;
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
public class DossierEmployeDAO extends CommonDAO<DossierEmploye>{
    public DossierEmployeDAO(Connection connection) {
        super(connection);
    } 

    @Override
    public DossierEmploye create(DossierEmploye dossierEmploye) {
        try {            
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_DOSSIER_EMPLOYE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setDate(1, dossierEmploye.getDateEntree());
            preparedStatement.setDouble(2, dossierEmploye.getNbMoisAnciennete());
            preparedStatement.setDouble(3, dossierEmploye.getTauxHoraireBrut());
            preparedStatement.setInt(4, dossierEmploye.getTypeContrat().getId());
            preparedStatement.setInt(5, dossierEmploye.getEmploye().getIdPersonne());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(DossierEmployeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return dossierEmploye;
    }

    @Override
    public DossierEmploye update(DossierEmploye dossierEmploye) {
        try {            
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.UPDATE_DOSSIER_EMPLOYE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setDouble(1, dossierEmploye.getTauxHoraireBrut());
            preparedStatement.setInt(2, dossierEmploye.getTypeContrat().getId());
            preparedStatement.setInt(3, dossierEmploye.getIdDossierEmploye());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(DossierEmployeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return dossierEmploye;
    }

    @Override
    public void delete(DossierEmploye dossierEmploye) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_DOSSIER_EMPLOYE);
            preparedStatement.setInt(1, dossierEmploye.getIdDossierEmploye());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(DossierEmployeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public DossierEmploye findById(int id) {
        
        EmployeDAO employeDAO = new EmployeDAO(connection);
        DossierEmploye dossierEmploye = new DossierEmploye();
        try {
            
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_DOSSIER_EMPLOYE_ID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, id);

            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();

            if (result.first()) {
                Employe employe = employeDAO.findById(result.getInt("employe_id"));
                dossierEmploye.setIdDossierEmploye(id);
                dossierEmploye.setEmploye(employe);
                dossierEmploye.setDateEntree(result.getDate("date_entree"));
                System.out.println(result.getDate("date_entree"));
                dossierEmploye.setNbMoisAnciennete(result.getDouble("nb_mois_anciennete"));
                System.out.println(result.getDouble("nb_mois_anciennete"));
                dossierEmploye.setTauxHoraireBrut(result.getDouble("taux_horaire_brut"));
                dossierEmploye.setTypeContrat(TypeContrat.valueOf(result.getInt("type_contrat")));
            }
        } catch (SQLException e) {
            Logger.getLogger(DossierEmployeDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return dossierEmploye;
    }

    @Override
    public ArrayList<DossierEmploye> findAll() {
        
        ArrayList<DossierEmploye> dossiersEmploye = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_DOSSIERS_EMPLOYE);
            System.out.println(preparedStatement.toString());
            
            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()) {
                Employe employe = new Employe();
                EmployeDAO employeDAO = new EmployeDAO(connection);
                DossierEmploye dossierEmploye = new DossierEmploye();
                
                employe = employeDAO.findById(result.getInt("employe_id"));
                dossierEmploye.setIdDossierEmploye(result.getInt("dossierId"));
                dossierEmploye.setEmploye(employe);
                dossierEmploye.setDateEntree(result.getDate("date_entree"));
                dossierEmploye.setNbMoisAnciennete(result.getDouble("nb_mois_anciennete"));
                dossierEmploye.setTauxHoraireBrut(result.getDouble("taux_horaire_brut"));
                dossierEmploye.setTypeContrat(TypeContrat.values()[result.getInt("type_contrat")]);
                
                dossiersEmploye.add(dossierEmploye);
            }
            
            
        } catch (SQLException e) {
            Logger.getLogger(DossierEmployeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return dossiersEmploye;
    }
    
    
    
}
