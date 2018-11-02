/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

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
public class TVADAO extends CommonDAO<TVA> {
    public TVADAO (Connection connection) {
        super(connection);
    }

    @Override
    public TVA create(TVA tva) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_TVA, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString(1, tva.getNom());
            preparedStatement.setDouble(2, tva.getMontant());
            
            preparedStatement.executeUpdate();
            
            ResultSet resultKeys = preparedStatement.getGeneratedKeys();
            if (resultKeys.next()) {
                int idTVA = resultKeys.getInt(1);
                tva.setIdTVA(idTVA);
            }
            
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(TVADAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return tva;
    }

    @Override
    public TVA update(TVA tva) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_TVA);
            
            preparedStatement.setString(1, tva.getNom());
            preparedStatement.setDouble(2, tva.getMontant());
            preparedStatement.setInt(3, tva.getIdTVA());
            
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(TVADAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return tva;
    }

    @Override
    public void delete(TVA tva) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_TVA);
            
            preparedStatement.setInt(1, tva.getIdTVA());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(TVADAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public TVA findById(int id) {
        TVA tva = new TVA();
        
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_TVA_BY_ID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, id);
            
            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();
            
            if (result.first()){
                tva.setIdTVA(id);
                tva.setMontant(result.getDouble("valeur"));
                tva.setNom(result.getString("nom"));
            }
            
            preparedStatement.close();
            
        }catch (SQLException e) {
            Logger.getLogger(TVADAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return tva;
    }

    @Override
    public ArrayList<TVA> findAll() {
        ArrayList<TVA> tvas = new ArrayList<>();
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_TVAS);
            
            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()){
                TVA tva = new TVA();
                tva.setIdTVA(result.getInt("tvaId"));
                tva.setMontant(result.getDouble("valeur"));
                tva.setNom(result.getString("nom"));
                tvas.add(tva);
            }
            
            preparedStatement.close();
            
        }catch (SQLException e) {
            Logger.getLogger(TVADAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return tvas;
    }
    
    
}
