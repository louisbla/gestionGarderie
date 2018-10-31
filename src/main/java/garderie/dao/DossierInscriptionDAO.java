/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import com.mysql.jdbc.Statement;
import garderie.model.DossierInscription;
import garderie.model.Personne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dendaneys
 */
public class DossierInscriptionDAO extends CommonDAO<DossierInscription> {

    public DossierInscriptionDAO(Connection connection) {
        super(connection);
    }

    @Override
    public DossierInscription create(DossierInscription obj) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.INSERT_DOSSIER_INSCRIPTION, Statement.RETURN_GENERATED_KEYS);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setDate(1, obj.getDateInscription());
            preparedStatement.setInt(2, obj.getNbDemiJourneeInscrit());
            preparedStatement.setInt(3, obj.getNbDemiJourneeAbsent());
            preparedStatement.setString(4, obj.getMedecinTraitant());
            preparedStatement.setInt(5, obj.getEnfant().getIdPersonne());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();

            ResultSet resultKeys = preparedStatement.getGeneratedKeys();
            int idDossierInscription;

            if (resultKeys.next()) {
                idDossierInscription = resultKeys.getInt(1);
                obj.setIdDossier(idDossierInscription);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            Logger.getLogger(EnfantDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return obj;
    }

    @Override
    public DossierInscription update(DossierInscription obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(DossierInscription obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DossierInscription findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DossierInscription> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DossierInscription findByEnfantId(int enfantId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    }

}
