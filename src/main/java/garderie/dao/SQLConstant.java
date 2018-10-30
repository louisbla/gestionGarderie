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

    // ************* ACTIVITE *****************
    protected static final String INSERT_ACTIVITE = "INSERT INTO activites("
            + "nom, description, nb_enfant_max, lieu) VALUES (?,?,?,?) ";

    protected static final String UPDATE_ACTIVITE = "UPDATE activites SET "
            + "nom = ?, description = ?, nb_enfant_max = ?, lieu = ?,"
            + " WHERE activiteId = ?";

    protected static final String DELETE_ACTIVITE = "UPDATE activites SET "
            + NOT_VISIBLE + " WHERE activiteId = ?";

    protected static final String SELECT_ACTIVITE_BY_ID = "SELECT * FROM activites"
            + "WHERE activiteId = ? AND" + VISIBLE;

    protected static final String SELECT_ACTIVITES = "SELECT * FROM activites WHERE"
            + VISIBLE;

    // ************* ADRESSE *****************
    protected static final String INSERT_ADRESSE = "INSERT INTO adresses("
            + "ligne_1, ligne_2, ligne_3, ville, code_postal, pays) "
            + "VALUES (?,?,?,?,?,?) ";

    protected static final String UPDATE_ADRESSE = "UPDATE adresses SET "
            + "ligne_1 = ?, ligne_2 = ? ligne_3 = ?,"
            + "ville = ?, code_postal = ?, pays = ? WHERE adresseId = ?";

    protected static final String DELETE_ADRESSE = "UPDATE adresses SET "
            + NOT_VISIBLE + " WHERE adresseId = ?";

    protected static final String SELECT_ADRESSE_BY_ID = "SELECT * FROM adresses "
            + "WHERE adresseId = ? AND " + VISIBLE;

    protected static final String SELECT_ADRESSES = "SELECT * FROM adresses WHERE " + VISIBLE;

    // ************* PERSONNE *****************
    protected static final String INSERT_PERSONNE = "INSERT INTO personnes "
            + "(nom, prenom, sexe, date_naissance, numSecu) VALUES (?,?,?,?,?)";

    protected static final String SELECT_PERSONNE = "SELECT * FROM personnes WHERE " + VISIBLE;

    protected static final String UPDATE_PERSONNE = "UPDATE personnes SET "
            + "nom = ?, prenom = ?, sexe = ?,"
            + "date_naissance = ?, numSecu = ? WHERE personneId = ?";

    protected static final String DELETE_PERSONNE = "UPDATE personnes SET "
            + NOT_VISIBLE + " WHERE personneId = ?";

    protected static final String SELECT_PERSONNE_BY_ID = "SELECT * FROM personnes "
            + "WHERE personneId = ? AND " + VISIBLE;

    // ************* PERSONNE ADRESSE *****************
    protected static final String INSERT_PERSONNE_ADRESSE = "INSERT INTO personnes_adresses "
            + "(adresseId, personneId, domicile, facturation) VALUES (?,?,?,?)";

    protected static final String SELECT_PERSONNE_ADRESSE = "SELECT * FROM personnes WHERE " + VISIBLE;

    protected static final String UPDATE_PERSONNE_ADRESSE = "UPDATE personnes_adresses SET "
            + "adresseId = ?, domicile = ?, facture = ?,"
            + "WHERE personneId = ?";

    protected static final String DELETE_PERSONNE_ADRESSE = "UPDATE personnes_adresses SET "
            + NOT_VISIBLE + "WHERE adresseId = ? AND personneId = ?";

    protected static final String SELECT_PERSONNE_ADRESSE_BY_PERSONNE_ID = "SELECT * FROM personnes_adresses "
            + "WHERE personneId = ?";

    // ************* ENFANT *****************
    protected static final String INSERT_ENFANT = "INSERT INTO enfants "
            + "(enfantId, photo, groupeId, inventaire_enfantId) VALUES (?,?,?,?)";

    protected static final String SELECT_ENFANT = "SELECT * FROM enfants ";

    protected static final String SELECT_ENFANT_BY_ID = "SELECT * FROM enfants "
            + " WHERE enfantId = ?";

    protected static final String UPDATE_ENFANT = "UPDATE enfants SET "
            + "photo = ?, groupeId = ?, inventaireEnfantId = ?"
            + " WHERE enfantId = ?";

    // ************* INVENTAIRE ENFANT *****************
    protected static final String SELECT_INVENTAIRE_ENFANT_BY_ID = "SELECT * FROM inventaires_enfant "
            + " WHERE inventaireId = ?";
    
    // ************* EMPLOYE *****************
    
//    protected static final String INSERT_EMPLOYE = "INSERT INTO employes (employeId, poste, "
//            + "externe, telephone, dossierId) VALUES (?,?,?,?,?)";
    
    protected static final String INSERT_EMPLOYE = "INSERT INTO employes (employeId, poste, "
            + "externe, telephone) VALUES (?,?,?,?)";
    
    protected static final String SELECT_EMPLOYES = "SELECT * FROM personnes, employes "
            + "WHERE personneId = employeId AND " + VISIBLE;
    
    protected static final String SELECT_EMPLOYE_BY_ID = "SELECT * FROM personnes,"
            + " employes WHERE personneId = employeId AND personneId = ? AND " + VISIBLE;
    
//    protected static final String UPDATE_EMPLOYE = "UPDATE employes SET "
//            + "poste = ?, externe = ?, telephone = ?, dossierId = ? "
//            + "WHERE employeId = ?";
    
    protected static final String UPDATE_EMPLOYE = "UPDATE employes SET "
            + "poste = ?, externe = ?, telephone = ? "
            + "WHERE employeId = ?";
    
    protected static final String DELETE_EMPLOYE = "UPDATE personnes SET "
            + NOT_VISIBLE + " WHERE personneId = ?";
    
    // ************* DOSSIER EMPLOYE *****************
    
    protected static final String INSERT_DOSSIER_EMPLOYE = "INSERT INTO dossiers_employe "
            + "(date_entree, nb_mois_anciennete, taux_horaire_brut, type_contrat, employe_id) "
            + "VALUES (?,?,?,?,?)";
    
    protected static final String SELECT_DOSSIERS_EMPLOYE = "SELECT * FROM dossiers_employe "
            + "WHERE " + VISIBLE;
    
    protected static final String SELECT_DOSSIER_EMPLOYE_ID = "SELECT * FROM dossiers_employe "
            + "WHERE dossierId = ? AND " + VISIBLE;
    
    protected static final String UPDATE_DOSSIER_EMPLOYE = "UPDATE dossiers_employe SET "
            + "taux_horaire_brut = ?, type_contrat = ? WHERE dossierId = ?";
    
    protected static final String DELETE_DOSSIER_EMPLOYE = "UPDATE dossiers_employe SET "
            + NOT_VISIBLE + " WHERE dossierId = ?";
    
    protected static final String SELECT_DOSSIER_EMPLOYE_BY_EMPLOYE_ID = ""
            + "SELECT * FROM dossiers_employe WHERE employe_id = ?";
    
    // ************* GROUPE *****************
    
    protected static final String INSERT_GROUPE = "INSERT INTO groupes (descriptif,"
            + " referant, nom_groupe) VALUES (?,?,?)";
    
    protected static final String UPDATE_GROUPE = "UPDATE groupes SET descriptif = ?, "
            + "referant = ?, nom_groupe = ? WHERE groupeId = ?";
    
    protected static final String DELETE_GROUPE = "UPDATE groupes SET " + NOT_VISIBLE +
            " WHERE groupeId = ?";
    
    protected static final String SELECT_GROUPE_BY_ID = "SELECT * FROM groupes WHERE"
            + " groupeId = ? AND " + VISIBLE;
    
    protected static final String SELECT_GROUPES = "SELECT * FROM groupes WHERE " 
            + VISIBLE;
    
    protected static final String SELECT_REFERANT_GROUPE = "SELECT referant FROM groupes "
            + "WHERE groupeId = ?";
    
    protected static final String SELECT_ENFANTS_FOR_GROUPE = "SELECT * FROM enfants"
            + " WHERE groupeId = ?";
    
    protected static final String SELECT_EMPLOYES_FOR_GROUPE = "SELECT employeId FROM "
            + "gerer WHERE groupeId = ?";
    
     // ************* INVENTAIRE *****************
    
    protected static final String INSERT_INVENTAIRE = "INSERT INTO inventaires (stock_max,"
            + " stock_actuel, employeId) VALUES (?,?,?)";
    
    protected static final String UPDATE_INVENTAIRE = "UPDATE inventaires SET stock_max = ?,"
            + " stock_actuel = ?, employeId = ? WHERE inventaireId = ?";
    
    protected static final String DELETE_INVENTAIRE = "UPDATE inventaires SET " 
            + NOT_VISIBLE + " WHERE inventaireId = ?";
    
    protected static final String SELECT_INVENTAIRE_BY_ID = "SELECT * FROM inventaires"
            + " WHERE inventaireId = ? AND " + VISIBLE;
    
    protected static final String SELECT_INVENTAIRES = "SELECT * FROM inventaires"
            + " WHERE " + VISIBLE;
    
    protected static final String SELECT_ARTICLES_FOR_INVENTAIRE = "SELECT * FROM"
            + " articles WHERE inventaireId = ? AND " + VISIBLE;


}
