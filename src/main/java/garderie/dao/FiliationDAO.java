/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.Filiation;
import garderie.model.Parent;
import garderie.model.Enfant;
import garderie.model.Facture;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maryline
 */
public class FiliationDAO extends CommonDAO<Filiation> {

    public FiliationDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Filiation create(Filiation obj) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.INSERT_FILIATION);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, obj.getP().getIdPersonne());
            preparedStatement.setInt(2, obj.getE().getIdPersonne());
            preparedStatement.setString(3, obj.getLien());

            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            Logger.getLogger(FiliationDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return obj;
    }

    @Override
    public Filiation update(Filiation obj) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_FILIATION);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, obj.getP().getIdPersonne());
            preparedStatement.setString(2, obj.getLien());
            preparedStatement.setInt(3, obj.getE().getIdPersonne());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            Logger.getLogger(FiliationDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return obj;
    }

    @Override
    public void delete(Filiation obj) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_FILIATION);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, obj.getP().getIdPersonne());
            preparedStatement.setInt(2, obj.getE().getIdPersonne());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(FiliationDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Filiation findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Filiation> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Filiation> findAllById() {
        ArrayList<Filiation> listefiliation = new ArrayList();

        return listefiliation;
    }
    
    public ArrayList<Filiation> findAllEnfantsForParent(int idPersonne){
        ArrayList<Filiation> filiations = new ArrayList<>();
        
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_FILIATION_ALL_ENFANT_FOR_PARENT);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, idPersonne);

            //Recupere les resultats de la requete
            ResultSet result = preparedStatement.executeQuery();

             while (result.next()) {
                EnfantDAO enfantDAO = new EnfantDAO(connection);
                Enfant enfant = new Enfant();
                enfant = enfantDAO.findById(result.getInt("enfantId"));
                
                String lienParente = result.getString("lien_parente");
                Filiation filiation = new Filiation();
                
                filiation.setE(enfant);
                filiation.setLien(lienParente);

                filiations.add(filiation);
            }
            
            
        }catch (SQLException e) {
            Logger.getLogger(FiliationDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return filiations;
    }
    
    public ArrayList<Filiation> findAllParentsForEnfant(int idEnfant){
        ArrayList<Filiation> filiations = new ArrayList<>();
        
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_FILIATION_ALL_PARENT_FOR_ENFANT);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, idEnfant);
            System.out.println(preparedStatement.toString());
            //Recupere les resultats de la requete
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                ParentDAO parentDAO = new ParentDAO(connection);
                Parent parent = new Parent();
                parent = parentDAO.findById(result.getInt("parentId"));

                String lienParente = result.getString("lien_parente");
                Filiation filiation = new Filiation();

                filiation.setP(parent);
                filiation.setLien(lienParente);

                filiations.add(filiation);
            }
            
            
        }catch (SQLException e) {
            Logger.getLogger(FiliationDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return filiations;
    }

}
