/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import com.mysql.jdbc.Statement;
import garderie.model.LigneFacture;
import garderie.model.ObjetFacturable;
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
public class LigneFactureDAO extends CommonDAO<LigneFacture> {
    public LigneFactureDAO(Connection connection) {
        super(connection);
    }

    @Override
    public LigneFacture create(LigneFacture ligneFacture) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_LIGNE_FACTURE, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setDouble(1, ligneFacture.getTotalHT());
            preparedStatement.setDouble(2, ligneFacture.getTotalTTC());
            preparedStatement.setInt(3, ligneFacture.getQuantite());
            preparedStatement.setInt(4, ligneFacture.getFacture().getIdFacture());
            preparedStatement.setInt(5, ligneFacture.getObjetFacturable().getIdObjetFacturable());
            
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            
            ResultSet resultKeys = preparedStatement.getGeneratedKeys();
            if (resultKeys.next()) {
                int idLigne = resultKeys.getInt(1);
                ligneFacture.setIdLigneFacture(idLigne);
            }
            
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(LigneFactureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return ligneFacture;
    }

    @Override
    public LigneFacture update(LigneFacture ligneFacture) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_LIGNE_FACTURE);
            
            preparedStatement.setDouble(1, ligneFacture.getTotalHT());
            preparedStatement.setDouble(2, ligneFacture.getTotalTTC());
            preparedStatement.setInt(3, ligneFacture.getQuantite());
            preparedStatement.setInt(4, ligneFacture.getFacture().getIdFacture());
            preparedStatement.setInt(5, ligneFacture.getObjetFacturable().getIdObjetFacturable());
            preparedStatement.setInt(6, ligneFacture.getIdLigneFacture());
            
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(LigneFactureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return ligneFacture;
    }

    @Override
    public void delete(LigneFacture ligneFacture) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_LIGNE_FACTURE);
            
            preparedStatement.setInt(1, ligneFacture.getIdLigneFacture());
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(LigneFactureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public LigneFacture findById(int id) {
        LigneFacture ligneFacture = new LigneFacture();
        
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_LIGNE_FACTURE_BY_ID);
            preparedStatement.setInt(1, id);
            
            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();
            
            if (result.first()){
                ligneFacture.setIdLigneFacture(id);
                ligneFacture.setTotalHT(result.getDouble("total_ht"));
                ligneFacture.setTotalTTC(result.getDouble("total_ttc"));
                ligneFacture.setQuantite(result.getInt("quantite"));  
                ObjetFacturableDAO objetFacturableDAO = new ObjetFacturableDAO(connection);
                ObjetFacturable objetFacturable = objetFacturableDAO.findById(result.getInt("objet_facturableId"));
                ligneFacture.setObjetFacturable(objetFacturable);
            }
            
        }catch (SQLException e) {
            Logger.getLogger(LigneFactureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
        return ligneFacture;
    }

    @Override
    public ArrayList<LigneFacture> findAll() {
        ArrayList<LigneFacture> lignesFacture = new ArrayList<>();
        
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_LIGNES_FACTURE);

            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()){
                LigneFacture ligneFacture = new LigneFacture();
                
                ligneFacture.setIdLigneFacture(result.getInt("ligneId"));
                ligneFacture.setTotalHT(result.getDouble("total_ht"));
                ligneFacture.setTotalTTC(result.getDouble("total_ttc"));
                ligneFacture.setQuantite(result.getInt("quantite"));  
                ObjetFacturableDAO objetFacturableDAO = new ObjetFacturableDAO(connection);
                ObjetFacturable objetFacturable = objetFacturableDAO.findById(result.getInt("objet_facturableId"));
                ligneFacture.setObjetFacturable(objetFacturable);
                lignesFacture.add(ligneFacture);
            }
            
        }catch (SQLException e) {
            Logger.getLogger(LigneFactureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return lignesFacture;
    }
    
    public ArrayList<LigneFacture> findAllLignesForFacture(int id) {
        ArrayList<LigneFacture> lignesFacture = new ArrayList<>();
        
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_LIGNE_FOR_FACTURE);
            preparedStatement.setInt(1, id);

            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()){
                LigneFacture ligneFacture = new LigneFacture();
                
                ligneFacture.setIdLigneFacture(result.getInt("ligneId"));
                ligneFacture.setTotalHT(result.getDouble("total_ht"));
                ligneFacture.setTotalTTC(result.getDouble("total_ttc"));
                ligneFacture.setQuantite(result.getInt("quantite"));  
                ObjetFacturableDAO objetFacturableDAO = new ObjetFacturableDAO(connection);
                ObjetFacturable objetFacturable = objetFacturableDAO.findById(result.getInt("objet_facturableId"));
                ligneFacture.setObjetFacturable(objetFacturable);
                lignesFacture.add(ligneFacture);
            }
            
        }catch (SQLException e) {
            Logger.getLogger(LigneFactureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return lignesFacture;
    }
        
    
}
