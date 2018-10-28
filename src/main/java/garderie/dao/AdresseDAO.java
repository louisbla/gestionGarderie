/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.Adresse;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP_LOUIS
 */
public class AdresseDAO extends CommonDAO<Adresse>{

    @Override
    public Adresse create(Adresse adresse) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.INSERT_ADRESSE);
            
            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setString(1, "ligne_1");
            preparedStatement.setString(2, "ligne_2");
            preparedStatement.setString(3, "ligne_3");
            preparedStatement.setString(4, "ville");
            preparedStatement.setString(5, "code_postal");
            preparedStatement.setString(6, "pays");
            
            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdresseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return adresse;
    }

    @Override
    public Adresse update(Adresse adresse) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_ADRESSE);
            
            preparedStatement.setString(1, adresse.getLigne1());
            preparedStatement.setString(2, adresse.getLigne2());
            preparedStatement.setString(3, adresse.getLigne3());
            preparedStatement.setString(4, adresse.getVille());
            preparedStatement.setString(5, adresse.getCodePostal());
            preparedStatement.setString(6, adresse.getPays());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            
        }
    }

    @Override
    public void delete(Adresse obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Adresse findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Adresse> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
