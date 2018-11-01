/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.Activite;
import garderie.model.ObjetFacturable;
import garderie.model.TVA;
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
public class ObjetFacturableDAO extends CommonDAO<ObjetFacturable> {
    public ObjetFacturableDAO(Connection connection) {
        super(connection);
    }

    @Override
    public ObjetFacturable create(ObjetFacturable obj) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_OBJET_FACTURABLE, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setDouble(1, obj.getPrixHT());
            preparedStatement.setString(2, obj.getNom());
            preparedStatement.setInt(3, obj.getTva().getIdTVA());
            if (obj.getActivite() != null) {
                preparedStatement.setInt(4, obj.getActivite().getIdActivite());
            } else {
                preparedStatement.setNull(4, java.sql.Types.INTEGER);
            }
            
            preparedStatement.executeUpdate();
            
            ResultSet resultKeys = preparedStatement.getGeneratedKeys();
            if (resultKeys.next()) {
                int idObjetFacturable = resultKeys.getInt(1);
                obj.setIdObjetFacturable(idObjetFacturable);
            }
            
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(ObjetFacturableDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return obj;
    }

    @Override
    public ObjetFacturable update(ObjetFacturable obj) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_OBJET_FACTURABLE);
            
            preparedStatement.setDouble(1, obj.getPrixHT());
            preparedStatement.setString(2, obj.getNom());
            preparedStatement.setInt(3, obj.getTva().getIdTVA());
            if (obj.getActivite() != null) {
                preparedStatement.setInt(4, obj.getActivite().getIdActivite());
            } else {
                preparedStatement.setNull(4, java.sql.Types.INTEGER);
            }
            preparedStatement.setInt(5, obj.getIdObjetFacturable());
            
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(ObjetFacturableDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return obj;
    }

    @Override
    public void delete(ObjetFacturable obj) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_OBJET_FACTURABLE);
            
            preparedStatement.setInt(1, obj.getIdObjetFacturable());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(ObjetFacturableDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public ObjetFacturable findById(int id) {
        ObjetFacturable objetFacturable = new ObjetFacturable();
        
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_OBJET_FACTURABLE_BY_ID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, id);
            
            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();
            
            if (result.first()){
                objetFacturable.setIdObjetFacturable(id);
                objetFacturable.setNom(result.getString("nom"));
                objetFacturable.setPrixHT(result.getDouble("prix_ht"));
                
                TVADAO tvaDAO = new TVADAO(connection);
                TVA tva = tvaDAO.findById(result.getInt("tvaId"));
                objetFacturable.setTva(tva);
                
                ActiviteDAO activiteDAO = new ActiviteDAO(connection);
                if (result.getInt("activiteId") != 0) {
                    Activite activite = activiteDAO.findById(result.getInt("activiteId"));
                    objetFacturable.setActivite(activite);
                }
            }
            
            preparedStatement.close();
            
        }catch (SQLException e) {
            Logger.getLogger(ObjetFacturableDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return objetFacturable;
    }

    @Override
    public ArrayList<ObjetFacturable> findAll() {
        ArrayList<ObjetFacturable> objetsFacturables = new ArrayList<>();
        
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_OBJETS_FACTURABLES);

            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()){
                ObjetFacturable objetFacturable = new ObjetFacturable();
                
                objetFacturable.setIdObjetFacturable(result.getInt("objet_facturableId"));
                objetFacturable.setNom(result.getString("nom"));
                objetFacturable.setPrixHT(result.getDouble("prix_ht"));
                
                TVADAO tvaDAO = new TVADAO(connection);
                TVA tva = tvaDAO.findById(result.getInt("tvaId"));
                objetFacturable.setTva(tva);
                
                ActiviteDAO activiteDAO = new ActiviteDAO(connection);
                if (result.getInt("activiteId") != 0) {
                    Activite activite = activiteDAO.findById(result.getInt("activiteId"));
                    objetFacturable.setActivite(activite);
                }  
                
                objetsFacturables.add(objetFacturable);
            }
            
        }catch (SQLException e) {
            Logger.getLogger(ObjetFacturableDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
        return objetsFacturables;
    }
    
}
