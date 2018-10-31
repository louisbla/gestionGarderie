/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;
import garderie.model.Employe;
import garderie.model.Enfant;
import garderie.model.Groupe;
import garderie.model.RapportJournalier;
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
public class RapportJournalierDAO extends CommonDAO<RapportJournalier>{
    public RapportJournalierDAO(Connection connection){
        super(connection);
    }

    @Override
    public RapportJournalier create(RapportJournalier rapport) {
        try{
            
        }catch (SQLException e) {
            Logger.getLogger(GroupeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return rapport;
    }

    @Override
    public RapportJournalier update(RapportJournalier obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(RapportJournalier obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RapportJournalier findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<RapportJournalier> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
