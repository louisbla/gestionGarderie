/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.Conge;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP_LOUIS
 */
public class CongeDAO extends CommonDAO<Conge>{

    public CongeDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Conge create(Conge conge) {
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_CONGE, Statement.RETURN_GENERATED_KEYS);
            
            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setDate(1, (Date)conge.getDebutConge());
            preparedStatement.setInt(2, conge.getDureeCongeJour());
            preparedStatement.setInt(3, conge.getTypeConge().getId());
            preparedStatement.setInt(4, conge.getIdEmploye());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            
            //Recupere l'id genere par la BDD
            ResultSet resultKeys = preparedStatement.getGeneratedKeys();
            if (resultKeys.next()) {
                int idConge = resultKeys.getInt(1);
                conge.setIdConge(idConge);
            }
            
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(CongeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return conge;      }

    @Override
    public Conge update(Conge conge) {
 try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.UPDATE_CONGE);
            
            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setDate(1, (Date) conge.getDebutConge());
            preparedStatement.setInt(2, conge.getDureeCongeJour());
            preparedStatement.setInt(3, conge.getTypeConge().getId());
            preparedStatement.setInt(4, conge.getIdEmploye());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(CongeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return conge; 
    }

    @Override
    public void delete(Conge conge) {
try{
             //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_CONGE);
            
            //Insert parameter at the location of the question mark in the SQL Query
             preparedStatement.setInt(1, conge.getIdConge());
           
            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        }catch (SQLException e) {
            Logger.getLogger(CongeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Conge findById(int id) {
        Conge conge = new Conge();
        
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_CONGE_BY_ID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, id);
            
            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();
            
            if (result.first()){
                conge.setIdConge(result.getInt("congeId"));
                conge.setDebutConge(result.getDate("debut"));
                conge.setDureeCongeJour(result.getInt("duree"));
                
                //int typeCongeId = result.getInt("type_congeId");
                //conge.setTypeConge(TypeCongeDAO.findById(typeCongeId));
                
            }
            
            preparedStatement.close();
            
        }catch (SQLException e) {
            Logger.getLogger(CongeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return conge;
    }

    @Override
    public ArrayList<Conge> findAll() {
        ArrayList<Conge> listConge = new ArrayList<>();
        
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_FACTURE);

            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()){
                Conge conge = new Conge();
                
                conge.setIdConge(result.getInt("congeId"));
                conge.setDebutConge(result.getDate("debut"));
                conge.setDureeCongeJour(result.getInt("duree"));
                
                //int typeCongeId = result.getInt("type_congeId");
                //conge.setTypeConge(TypeCongeDAO.findById(typeCongeId));
                
                listConge.add(conge);
            }
            
        }catch (SQLException e) {
            Logger.getLogger(FactureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return listConge;
    }
    
}
