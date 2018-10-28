/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

/**
 *
 * @author Katsuo
 */
public class SQLConstant {

    protected static final String VISIBLE = "visible = 1";

    protected static final String NOT_VISIBLE = "visible = 0";

    protected static final String INSERT_ACTIVITE = "INSERT INTO activites("
            + "nom, date, description, nb_enfant_max, lieu, prix) VALUES ?,?,?,?,?,? ";

    protected static final String UPDATE_ACTIVITE = "UPDATE activites SET "
            + "nom = ?, date = ?, description = ?, nb_enfant_max = ?, lieu = ?,"
            + " prix = ? WHERE activiteId = ?";

    protected static final String DELETE_ACTIVITE = "UPDATE activites SET "
            + NOT_VISIBLE + " WHERE activiteId = ?";

    protected static final String SELECT_ACTIVITE_BY_ID = "SELECT * FROM activites"
            + "WHERE activiteId = ? AND" + VISIBLE;

    protected static final String SELECT_ACTIVITES = "SELECT * FROM activites WHERE"
            + VISIBLE;

    protected static final String INSERT_ADRESSE = "INSERT INTO adresses("
            + "ligne_1, ligne_2, ligne_3, ville, code_postal, pays) "
            + "VALUES ?,?,?,?,?,?,?,? ";

    protected static final String UPDATE_ADRESSE = "UPDATE adresses SET "
            + "ligne_1 = ?, ligne_2 = ? ligne_3 = ?,"
            + "ville = ?, code_postal = ?, pays = ? WHERE adresseId = ?";

    protected static final String DELETE_ADRESSE = "UPDATE adresses SET "
            + NOT_VISIBLE + " WHERE adresseId = ?";

    protected static final String SELECT_ADRESSE_BY_ID = "SELECT * FROM adresses"
            + "WHERE adresseId = ? AND " + VISIBLE;

    protected static final String SELECT_ADRESSES = "SELECT * FROM adresses WHERE " + VISIBLE;

    protected static final String INSERT_PERSONNE = "INSERT INTO personnes "
            + "(nom, prenom, sexe, date_naissance, numSecu) VALUES ?,?,?,?,?";

    protected static final String SELECT_PERSONNE = "SELECT * FROM personnes WHERE " + VISIBLE;

    protected static final String UPDATE_PERSONNE = "UPDATE personnes SET "
            + "nom = ?, prenom = ? sexe = ?,"
            + "date_naissance = ?, numSecu = ? WHERE personneId = ?";

    protected static final String DELETE_PERSONNE = "UPDATE personnes SET "
            + NOT_VISIBLE + "WHERE personneId = ?";

    protected static final String SELECT_PERSONNE_BY_ID = "SELECT * FROM personnes"
            + "WHERE personneId = ? AND " + VISIBLE;

}
