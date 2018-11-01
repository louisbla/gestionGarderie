/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;
import garderie.model.Facture;
import garderie.model.ParentFacture;
import garderie.model.Personne;
import garderie.model.Parent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Maryline
 */
public class ParentFactureDAO extends CommonDAO<ParentFacture>{
    
    public ParentFactureDAO(Connection connection){
        super(connection);
    }

    @Override
    public ParentFacture create(ParentFacture obj) {
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.INSERT_PARENT_FACTURE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, obj.getFacture().getIdFacture());
            preparedStatement.setInt(2, obj.getParent().getIdPersonne());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
             preparedStatement.close();
                
        } catch (SQLException e) {
            Logger.getLogger(ParentFactureDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return obj;
    }

    
    
    @Override
    public ParentFacture update(ParentFacture obj) {
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_PARENT_FACTURE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, obj.getFacture().getIdFacture());
            preparedStatement.setInt(2, obj.getParent().getIdPersonne());
            
            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
           
        }catch (SQLException e) {
            Logger.getLogger(ParentFactureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return obj;
    }

    @Override
    public void delete(ParentFacture obj) {
        try{
            
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_PARENT_FACTURE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, obj.getFacture().getIdFacture());
            preparedStatement.setInt(2, obj.getParent().getIdPersonne());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        }catch (SQLException e) {
            Logger.getLogger(ParentFactureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public ParentFacture findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public ArrayList<ParentFacture> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Parent> getAllParentByIdFacture(int idFacture){
        ArrayList<Parent> parents = new ArrayList<>();
        try{
             //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_PARENT_FOR_FACTURE_BY_ID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, idFacture);
            System.out.println(preparedStatement.toString());
             //Recupere les resultats de la requete
            ResultSet result = preparedStatement.executeQuery();
   
            while (result.next()) {
                 ParentDAO parentDAO = new ParentDAO(connection);
                 Parent parent = parentDAO.findById(result.getInt("personneId"));
                  
                 parents.add(parent);
             }
 
        }catch (SQLException e) {
            Logger.getLogger(ParentFactureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return parents;
    }
    
    
    public ArrayList<ParentFacture> findAllFactureByIdPersonne(int idPersonne){
        ArrayList<ParentFacture> listefacture = new ArrayList<>();
        
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_FACTURE_FOR_PARENT_BY_ID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, idPersonne);

            //Recupere les resultats de la requete
            ResultSet result = preparedStatement.executeQuery();

             while (result.next()) {
                FactureDAO factureDAO = new FactureDAO(connection);
                Facture facture = factureDAO.findById(result.getInt("factureId"));
                
                ParentFacture parentFacture = new ParentFacture();
                parentFacture.setFacture(facture);
                listefacture.add(parentFacture);
            }
            
            
        }catch (SQLException e) {
            Logger.getLogger(ParentFactureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return listefacture;
    }
   
}
