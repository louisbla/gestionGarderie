/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.Maladie;
import garderie.model.Traitement;
import garderie.model.CategorieArticle;
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
public class MaladieDAO extends CommonDAO<Maladie>{
    
    public MaladieDAO (Connection connection){
        super(connection);
    }

    @Override
    public Maladie create(Maladie maladie) {
        try{
             //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_MALADIE, Statement.RETURN_GENERATED_KEYS);
            
            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setString(1, maladie.getNom());
            preparedStatement.setString(2, maladie.getDescriptif());
            //traitement
            
            
             System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();

            //Recupere l'id genere par la BDD
            ResultSet resultKeys = preparedStatement.getGeneratedKeys();
            if (resultKeys.next()) {
                int idMaladie = resultKeys.getInt(1);
                maladie.setIdMaladie(idMaladie);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            Logger.getLogger(MaladieDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return maladie;
    }

    @Override
    public Maladie update(Maladie maladie) {
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.UPDATE_MALADIE);
            
            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setString(1, maladie.getNom());
            preparedStatement.setString(2, maladie.getDescriptif());
            preparedStatement.setInt(3, maladie.getIdMaladie());
            //traitement
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();

            
        }catch (SQLException e) {
            Logger.getLogger(MaladieDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return maladie;
    }

    @Override
    public void delete(Maladie maladie) {
           
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_MALADIE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, maladie.getIdMaladie());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (SQLException e) {
            Logger.getLogger(MaladieDAO.class.getName()).log(Level.SEVERE, null, e);
        }   
    }

    @Override
    public Maladie findById(int id) {
        Maladie maladie = new Maladie();
        
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_MALADIE_BY_ID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            if (result.first()) {
                maladie.setIdMaladie(id);
                maladie.setNom(result.getString("nom"));
                maladie.setDescriptif(result.getString("descriptif"));
                //Traitement
            }
            preparedStatement.close();
            
        }catch (SQLException e) {
            Logger.getLogger(MaladieDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return maladie;
    }

    @Override
    public ArrayList<Maladie> findAll() {
        ArrayList<Maladie> listemaladies = new ArrayList<>();
        
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_MALADIE);

            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();
            
            
            
        }catch (SQLException e) {
            Logger.getLogger(MaladieDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listemaladies;
    }

    
}
