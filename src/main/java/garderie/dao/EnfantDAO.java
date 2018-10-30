/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.DossierInscription;
import garderie.model.Enfant;
import garderie.model.Groupe;
import garderie.model.Inventaire;
import garderie.model.InventaireEnfant;
import garderie.model.Personne;
import garderie.model.Traitement;
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
 * @author dendaneys
 */
public class EnfantDAO extends CommonDAO<Enfant> {

    public EnfantDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Enfant create(Enfant obj) {
        try {
            // Creation de la personne
            PersonneDAO personneDAO = new PersonneDAO(connection);
            Personne personneReturned = personneDAO.create(obj);

            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.INSERT_ENFANT);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, personneReturned.getIdPersonne());
            preparedStatement.setString(2, obj.getPhoto());
            preparedStatement.setInt(3, obj.getGroupe().getIdGroupe());
            preparedStatement.setInt(4, obj.getInventaire().getIdInventaire());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            Logger.getLogger(EnfantDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return obj;
    }

    @Override
    public Enfant update(Enfant obj) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_ENFANT);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setString(1, obj.getPhoto());
            preparedStatement.setInt(2, obj.getGroupe().getIdGroupe());
            preparedStatement.setInt(3, obj.getInventaire().getIdInventaire());
            preparedStatement.setInt(4, obj.getIdPersonne());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(EnfantDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return obj;
    }

    @Override
    public void delete(Enfant obj) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_PERSONNE);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, obj.getIdPersonne());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(EnfantDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Enfant findById(int enfantId) {
        Enfant enfant = null;
        Personne personne = null;

        try {
            PersonneDAO personneDAO = new PersonneDAO(connection);
            personne = personneDAO.findById(enfantId);

            if (personne != null) {
                //Creation of the PreparedStatement
                PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_ENFANT_BY_ID);
                preparedStatement.setInt(1, enfantId);

                ResultSet result = preparedStatement.executeQuery();

                if (result.first()) {
                    enfant = new Enfant();
                    // Informations relatives en tant que personne
                    enfant.setIdPersonne(result.getInt("enfantId"));
                    enfant.setNom(personne.getNom());
                    enfant.setPrenom(personne.getPrenom());
                    enfant.setSexe(personne.getSexe());
                    enfant.setDateNaissance(personne.getDateNaissance());
                    enfant.setNumSecu(personne.getNumSecu());

                    // Informations relatives en tant qu'enfant
                    enfant.setPhoto(result.getString("photo"));

                    // Recuperation de son dossier inscription
                    DossierInscriptionDAO dossierDAO = new DossierInscriptionDAO(connection);
                    DossierInscription dossierInscription = dossierDAO.findByEnfantId(result.getInt(enfantId));
                    enfant.setDossier(dossierInscription);

                    // Recuperation de son inventaire
                    InventaireEnfantDAO inventaireEnfantDAO = new InventaireEnfantDAO(connection);
                    InventaireEnfant inventaireEnfant = inventaireEnfantDAO.findById(result.getInt("inventaire_enfantId"));
                    enfant.setInventaire(inventaireEnfant);

                    // Recuperation de son traitement
                    TraitementDAO traitementDAO = new TraitementDAO(connection);
                    ArrayList<Traitement> traitements = traitementDAO.findByEnfantId(enfantId);
                    enfant.setTraitement(traitements);

                    // Recuperation de son groupe
                    GroupeDAO groupeDAO = new GroupeDAO(connection);
                    Groupe groupe = groupeDAO.findById(result.getInt("groupeId"));
                    enfant.setGroupe(groupe);
                }

            }
        } catch (SQLException e) {
            Logger.getLogger(EnfantDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return enfant;
    }

    @Override
    public ArrayList<Enfant> findAll() {
        ArrayList<Enfant> enfants = new ArrayList<>();

        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_ENFANT);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                Enfant enfant = new Enfant();

                enfant = this.findById(result.getInt("enfantId"));

                enfants.add(enfant);
            }
        } catch (SQLException e) {
            Logger.getLogger(EnfantDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return enfants;
    }

}
