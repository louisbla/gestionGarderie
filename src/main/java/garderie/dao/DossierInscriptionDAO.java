/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import com.mysql.jdbc.Statement;
import garderie.model.DossierInscription;
import garderie.model.Enfant;
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
            Logger.getLogger(DossierInscriptionDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return obj;
    }

    @Override
    public DossierInscription update(DossierInscription obj) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_ENFANT);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setDate(1, obj.getDateInscription());
            preparedStatement.setInt(2, obj.getNbDemiJourneeInscrit());
            preparedStatement.setInt(3, obj.getNbDemiJourneeAbsent());
            preparedStatement.setString(4, obj.getMedecinTraitant());
            preparedStatement.setInt(5, obj.getEnfant().getIdPersonne());
            preparedStatement.setInt(6, obj.getIdDossier());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(DossierInscriptionDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return obj;
    }

    @Override
    public void delete(DossierInscription obj) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_DOSSIER_INSCRIPTION);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, obj.getIdDossier());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(DossierInscriptionDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public DossierInscription findById(int dossierInscriptionId) {
        DossierInscription dossierInscription = null;

        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_DOSSIER_INSCRIPTION_BY_ID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, dossierInscriptionId);

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();

            ResultSet result = preparedStatement.executeQuery();

            if (result.first()) {
                dossierInscription = new DossierInscription();
                dossierInscription.setIdDossier(dossierInscriptionId);
                dossierInscription.setDateInscription(result.getDate("dateInscription"));
                dossierInscription.setNbDemiJourneeAbsent(result.getInt("nb_demi_journees_inscrit"));
                dossierInscription.setDateInscription(result.getDate("nb_demi_journees_absent"));
                dossierInscription.setDateInscription(result.getDate("medecin_traitant"));

                EnfantDAO enfantDAO = new EnfantDAO(connection);
                Enfant enfant = enfantDAO.findById(result.getInt("enfantId"));

                dossierInscription.setEnfant(enfant);
            }

        } catch (SQLException e) {
            Logger.getLogger(DossierInscriptionDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return dossierInscription;
    }

    @Override
    public ArrayList<DossierInscription> findAll() {
        ArrayList<DossierInscription> dossiersInscription = new ArrayList<>();

        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_DOSSIER_INSCRIPTION);

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();

            ResultSet result = preparedStatement.executeQuery();

            if (result.first()) {
                DossierInscription dossierInscription = this.findById(result.getInt("dossierId"));
                dossiersInscription.add(dossierInscription);
            }
        } catch (SQLException e) {
            Logger.getLogger(DossierInscriptionDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return dossiersInscription;

    }

    public DossierInscription findByEnfantId(int enfantId) {
        DossierInscription dossierInscription = null;

        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_DOSSIER_INSCRIPTION_BY_ENFANTID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, enfantId);

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();

            ResultSet result = preparedStatement.executeQuery();

            if (result.first()) {
                dossierInscription = this.findById(result.getInt("dossierId"));
            }

        } catch (SQLException e) {
            Logger.getLogger(DossierInscriptionDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return dossierInscription;
    }

}
