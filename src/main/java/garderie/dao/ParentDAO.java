/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import com.mysql.jdbc.Statement;
import garderie.model.Enfant;
import garderie.model.Parent;
import garderie.model.Personne;
import garderie.model.Facture;
import garderie.model.Filiation;
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
public class ParentDAO extends CommonDAO<Parent> {

    public ParentDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Parent create(Parent parent) {
        try {
            //Insertion du parent dans la table personnes de la BDD
            PersonneDAO personneDAO = new PersonneDAO(connection);
            Personne personne = personneDAO.create(parent);

            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_PARENT, Statement.RETURN_GENERATED_KEYS);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, personne.getIdPersonne());
            preparedStatement.setInt(2, parent.getNbEnfantsInscrits());
            preparedStatement.setString(3, parent.getNumTel());

            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();

            //Recupere l'id genere par la BDD
            ResultSet resultKeys = preparedStatement.getGeneratedKeys();
            if (resultKeys.next()) {
                int idParent = resultKeys.getInt(1);
                parent.setIdPersonne(idParent);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            Logger.getLogger(ParentDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return parent;
    }

    @Override
    public Parent update(Parent parent) {

        try {
            //Insertion du parent dans la table personnes de la BDD
            PersonneDAO personneDAO = new PersonneDAO(connection);
            Personne personne = personneDAO.create(parent);

            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.UPDATE_PARENT);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, parent.getNbEnfantsInscrits());
            preparedStatement.setString(2, parent.getNumTel());
            preparedStatement.setInt(3, personne.getIdPersonne());

            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            Logger.getLogger(ParentDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return parent;

    }

    @Override
    public void delete(Parent parent) {
        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_PARENT);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, parent.getIdPersonne());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            Logger.getLogger(ParentDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Parent findById(int id) {
        Parent parent = new Parent();

        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_PARENT_BY_ID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, id);

            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();

            if (result.first()) {
                parent.setIdPersonne(id);
                parent.setNom(result.getString("nom"));
                parent.setPrenom(result.getString("prenom"));
                parent.setSexe(result.getString("sexe"));
                parent.setDateNaissance(result.getDate("date_naissance"));
                parent.setNumSecu(result.getString("numSecu"));
                parent.setNbEnfantsInscrits(result.getInt("nb_enfants_inscrits"));
                parent.setNumTel(result.getString("telephone"));

                // Recuperation de ses filiations
                /*FiliationDAO filiationDAO = new FiliationDAO(connection);
                ArrayList<Filiation> filiations = filiationDAO.getAllByParentId(id);
                parent.setListeEnfants(filiations);
                
                ParentFactureDAO parentfactureDAO = new ParentFactureDAO(connection);             
                parent.setFactures(parentfactureDAO.getAllFactureByIdParent(id));
                ArrayList<Filiation> filiations = this.findAllEnfantsById(parent);
                parent.setListeEnfants(filiations);*/
            }

            preparedStatement.close();

        } catch (SQLException e) {
            Logger.getLogger(ParentDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return parent;
    }

    public ArrayList<Filiation> findAllEnfantsById(Parent parent) {
        ArrayList<Filiation> filiations = new ArrayList<>();

        try {
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_FILIATION_ALL_ENFANT_FOR_PARENT);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, parent.getIdPersonne());

            //Recupere les resultats de la requete
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                Filiation filiation = new Filiation();

                this.findById(result.getInt("personneId"));

                EnfantDAO enfantDAO = new EnfantDAO(connection);
                Enfant enfant = enfantDAO.findById(result.getInt("enfantId"));

                filiation.setE(enfant);
                filiation.setP(parent);
                filiation.setLien(result.getString("lien_parente"));

            }
        } catch (SQLException e) {
            Logger.getLogger(FiliationDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return filiations;
    }

    @Override
    public ArrayList<Parent> findAll() {
        ArrayList<Parent> listeparent = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_PARENT);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                Parent parent = new Parent();

                PersonneDAO personneDAO = new PersonneDAO(connection);
                Personne personne = personneDAO.findById(result.getInt("parentId"));

                parent.setIdPersonne(personne.getIdPersonne());
                parent.setNom(personne.getNom());
                parent.setPrenom(personne.getPrenom());
                parent.setSexe(personne.getSexe());
                parent.setDateNaissance(personne.getDateNaissance());
                parent.setNumSecu(personne.getNumSecu());

                parent.setNbEnfantsInscrits(result.getInt("nb_enfants_inscrits"));
                parent.setNumTel(result.getString("telephone"));

                // Recuperation de ses filiations
                FiliationDAO filiationDAO = new FiliationDAO(connection);
                ArrayList<Filiation> filiations = filiationDAO.getAllByParentId(parent.getIdPersonne());
                parent.setListeEnfants(filiations);

                ParentFactureDAO parentfactureDAO = new ParentFactureDAO(connection);
                parent.setFactures(parentfactureDAO.getAllFactureByIdParent(parent.getIdPersonne()));

                listeparent.add(parent);
            }

        } catch (SQLException e) {
            Logger.getLogger(ParentDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listeparent;

    }

    public ArrayList<Facture> getFactureForParent(int id) {
        ArrayList<Facture> listefacture = new ArrayList<>();
        Facture facture;
        FactureDAO factureDAO = new FactureDAO(connection);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_FACTURE_FOR_PARENT);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                facture = factureDAO.findById(result.getInt("factureId"));
                listefacture.add(facture);
            }

        } catch (SQLException e) {
            Logger.getLogger(ParentDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listefacture;
    }

}
