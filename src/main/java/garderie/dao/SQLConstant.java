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
    protected static final String INSERT_INVENTAIRE_ENFANT = "INSERT INTO inventaires_enfants VALUES()";

    protected static final String SELECT_INVENTAIRE_ENFANT = "SELECT * FROM inventaires_enfant "
            + " WHERE " + VISIBLE;

    protected static final String SELECT_INVENTAIRE_ENFANT_BY_ID = "SELECT * FROM inventaires_enfant "
            + " WHERE inventaireId = ?";

    protected static final String SELECT_ARTICLES_BY_ENFANTID = "SELECT * FROM"
            + " articles WHERE enfantId = ? AND " + VISIBLE;

    protected static final String UPDATE_INVENTAIRE_ENFANT = "UPDATE inventaires_enfant SET "
            + "photo = ?, groupeId = ?, inventaireEnfantId = ?"
            + " WHERE enfantId = ?";

    protected static final String DELETE_INVENTAIRE_ENFANT = "UPDATE inventaires_enfant SET "
            + NOT_VISIBLE + "WHERE inventaireId = ?";

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

    protected static final String DELETE_GROUPE = "UPDATE groupes SET " + NOT_VISIBLE
            + " WHERE groupeId = ?";

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

    //*************************** ARTICLE************************
    protected static final String INSERT_ARTICLE = "INSERT INTO articles (nom, quantite,"
            + " photo, description, inventaireId, categorieId) VALUES"
            + " (?,?,?,?,?,?)";

    protected static final String UPDATE_ARTICLE = "UPDATE articles SET nom = ?, quantite = ?,"
            + " photo = ?, description = ?, inventaireId = ?, categorieId = ? WHERE articleId = ?";

    protected static final String DELETE_ARTICLE = "UPDATE articles SET "
            + NOT_VISIBLE + " WHERE articleId = ?";

    protected static final String SELECT_ARTICLE = "SELECT * FROM articles WHERE "
            + VISIBLE;

    protected static final String SELECT_ARTICLE_BY_ID = "SELECT * FROM articles"
            + " WHERE articleId = ? AND " + VISIBLE;

    protected static final String SELECT_CATEGORIE_FOR_ARTICLE = "SELECT * FROM"
            + " articles WHERE catgeorieId = ? AND " + VISIBLE;

    // ************* CATEGRORIE ARTICLE *****************
    protected static final String INSERT_CATEGORIE_ARTICLE = "INSERT INTO categories_article"
            + " (nom) VALUES (?)";

    protected static final String UPDATE_CATEGORIE_ARTICLE = "UPDATE categories_article SET"
            + " nom = ? WHERE categorieId = ?";

    protected static final String DELETE_CATEGORIE_ARTICLE = "UPDATE categories_article SET "
            + NOT_VISIBLE + " WHERE categorieId = ?";

    protected static final String SELECT_CATEGORIE_ARTICLE_BY_ID = "SELECT * FROM categories_article"
            + " WHERE categorieId = ? AND " + VISIBLE;

    protected static final String SELECT_CATEGORIES_ARTICLE = "SELECT * FROM categories_article"
            + " WHERE " + VISIBLE;

    protected static final String SELECT_ARTICLES_FOR_CATEGORIE = "SELECT * FROM articles"
            + " WHERE categorieId = ? AND " + VISIBLE;

    //*************************** COMPTEUSERDAO **********************
    protected static final String INSERT_COMPTE_USER = "INSERT INTO comptes_user (login,"
            + " password, privilege, personneId) VALUES (?,?,DEFAULT,?)";

    protected static final String UPDATE_COMPTE_USER = "UPDATE comptes_user SET "
            + " login = ?, password = ?, privilege = ?, personneId = ? WHERE userId = ?";

    protected static final String DELETE_COMPTE_USER = "UPDATE comptes_user SET "
            + NOT_VISIBLE + " WHERE userId = ?";

    protected static final String SELECT_COMPTE_USER = "SELECT * FROM comptes_user"
            + " WHERE " + VISIBLE;

    protected static final String SELECT_COMPTE_USER_BY_ID = "SELECT * FROM comptes_user"
            + " WHERE userId = ? AND " + VISIBLE;

    //**************************** PARENT ***************************************
    protected static final String INSERT_PARENT = "INSERT INTO parents (parentId,"
            + " nb_enfants_inscrits, telephone) VALUES (?,?,?)";

    protected static final String SELECT_PARENT = "SELECT * FROM personnes, parents "
            + "WHERE personneId = parentId AND " + VISIBLE;

    protected static final String SELECT_PARENT_BY_ID = "SELECT * FROM personnes,"
            + " parents WHERE personneId = parentId AND personneId = ? AND " + VISIBLE;

    protected static final String UPDATE_PARENT = "UPDATE parents SET "
            + "nb_enfants_inscrits = ?, telephone = ? WHERE parentId = ?";

    protected static final String DELETE_PARENT = "UPDATE personnes SET "
            + NOT_VISIBLE + " WHERE personneId = ?";

    protected static final String SELECT_FACTURE_FOR_PARENT = "SELECT factureId FROM"
            + " parents_factures WHERE personneId = ?";

    //***************************** FILIATION ************************************
    protected static final String INSERT_FILIATION = "INSERT INTO filiation ("
            + " personneId, enfantId, lien_parente) VALUES (?,?,?)";

    protected static final String UPDATE_FILIATION = "UPDATE filiation SET"
            + " personneId = ?, lien_parente = ? WHERE enfantId = ?";

    protected static final String DELETE_FILIATION = "UPDATE filiation SET "
            + NOT_VISIBLE + " WHERE personneId = ? AND enfantId = ?";

    protected static final String SELECT_FILIATION = "SELECT * FROM filiation"
            + " WHERE " + VISIBLE;

    protected static final String SELECT_FILIATION_BY_PARENT_ID = "SELECT * FROM filiation"
            + " WHERE personneId = ? AND " + VISIBLE;

    protected static final String SELECT_FILIATION_ALL_ENFANT_FOR_PARENT = "SELECT * FROM filiation"
            + " WHERE personneId = ? AND " + VISIBLE;

    protected static final String SELECT_FILIATION_ALL_PARENT_FOR_ENFANT = "SELECT * FROM filiation"
            + " WHERE enfantId = ? AND " + VISIBLE;

    //**************************** FACTURE ********************************
    protected static final String INSERT_FACTURE = "INSERT INTO factures ("
            + "date_emission, date_paiement, montant_ttc, statut) VALUES (?,?,?,?)";

    protected static final String UPDATE_FACTURE = "UPDATE factures SET"
            + " date_emission = ?, date_paiement = ?, montant_ttc = ?, statut = ?"
            + " WHERE factureId = ? ";

    protected static final String DELETE_FACTURE = "UPDATE factures SET "
            + NOT_VISIBLE + " WHERE factureId = ? ";

    protected static final String SELECT_FACTURE = "SELECT * FROM factures WHERE "
            + VISIBLE;

    protected static final String SELECT_FACTURE_BY_ID = "SELECT * FROM factures"
            + " WHERE factureId = ? AND " + VISIBLE;

    protected static final String SELECT_LIGNE_FOR_FACTURE = "SELECT * FROM lignes_factures"
            + " WHERE factureId = ?";

    //**************************** PARENT_FACTURE ******************************
    protected static final String INSERT_PARENT_FACTURE = "INSERT INTO parents_factures ("
            + " factureId, personneId ) VALUES (?,?)";

    protected static final String UPDATE_PARENT_FACTURE = "UPDATE parents_factures SET"
            + " factureId = ? WHERE personneId = ?";

    protected static final String DELETE_PARENT_FACTURE = "UPDATE parents_factures SET"
            + NOT_VISIBLE + " WHERE factureId = ? AND  personneId = ? ";

    protected static final String SELECT_PARENT_FACTURE = "SELECT * FROM parents_factures"
            + " WHERE " + VISIBLE;

    protected static final String SELECT_PARENT_FOR_FACTURE_BY_ID = "SELECT * FROM "
            + " parents_fatures  WHERE factureId = ?";

    protected static final String SELECT_FACTURE_FOR_PARENT_BY_ID = "SELECT * FROM parents_factures"
            + " WHERE personneId = ?";

    //*********************** DOCUMENT OFFICIEL ********************************
    protected static final String INSERT_DOCUMENT_OFFICIEL = "INSERT INTO documents_officiels (nom,"
            + " url, dossierId) VALUES (?,?,?)";

    protected static final String DELETE_DOCUMENT_OFFICIEL = "UPDATE documents_officiels SET "
            + NOT_VISIBLE + " WHERE documentId = ?";

    protected static final String UPDATE_DOCUMENT_OFFICIEL = "UPDATE documents_officiels SET nom = ?,"
            + " url = ?, dossierId = ? WHERE documentId = ?";

    protected static final String SELECT_DOCUMENT_OFFICIEL_BY_ID = "SELECT * FROM documents_officiels WHERE"
            + " documentId = ? AND " + VISIBLE;

    protected static final String SELECT_DOCUMENTS = "SELECT * FROM documents_officiels WHERE "
            + VISIBLE;

    //************************** RAPPORT_JOURNALIER ******************************
    protected static final String INSERT_RAPPORT_JOURNALIER = "INSERT INTO rapport_journalier"
            + " (date, present, resume, dossierInscription_id) VALUES (?,?,?,?)";

    protected static final String UPDATE_RAPPORT_JOURNALIER = "UPDATE rapport_journalier SET"
            + " date = ?, present= ?, resume = ?, dossierInscription_id = ? WHERE rapportId = ?";

    protected static final String DELETE_RAPPORT_JOURNALIER = "UPDATE rapport_journalier SET "
            + NOT_VISIBLE + " WHERE rapportId = ?";

    protected static final String SELECT_RAPPORT_JOURNALIER = "SELECT * FROM rapport_journalier WHERE "
            + VISIBLE;

    protected static final String SELECT_RAPPORT_JOURNALIER_BY_ID = "SELECT * FROM rapport_journalier"
            + " WHERE rapportId = ? AND " + VISIBLE;

    //**************************** DOSSIER_INSCRIPTION ******************************
    protected static final String INSERT_DOSSIER_INSCRIPTION = "INSERT INTO dossiers_inscription"
            + " (dateInscription, nb_demi_journees_inscrit, nb_demi_journees_absent, medecin_traitant, enfantId) VALUES (?,?,?,?,?)";
    
    
    //*********************** CONTACT URGENCE ********************************
    
    protected static final String INSERT_CONTACT_URGENCE = "INSERT INTO contacts_urgence"
            + " (contactId, telephone) VALUES (?,?)";
    
    protected static final String UPDATE_CONTACT_URGENCE = "UPDATE contacts_urgence SET "
            + " telephone = ? WHERE contactId = ?";    
    
    protected static final String SELECT_CONTACT_URGENCE_BY_ID = "SELECT * FROM personnes,"
            + " contacts_urgence WHERE personneId = contactId AND personneId = ? AND " + VISIBLE;

    protected static final String SELECT_CONTACT_URGENCE = "SELECT * FROM personnes, contacts_urgence "
            + "WHERE personneId = contactId AND " + VISIBLE;    
    
    //*********************** DOSSIER CONTACT URGENCE ********************************

    protected static final String INSERT_DOSSIER_CONTACT_URGENCE = "INSERT INTO dossier_contact_urgence"
            + " (lien_parente, contactId, dossier_inscription_id) VALUES (?,?,?)";
    
    protected static final String UPDATE_DOSSIER_CONTACT_URGENCE = "UPDATE dossier_contact_urgence SET "
            + " lien_parente = ?, contactId = ?, dossier_inscription_id = ?, WHERE dossierContactUrgenceId = ?";
    
    protected static final String DELETE_DOSSIER_CONTACT_URGENCE = "UPDATE dossier_contact_urgence SET "
            + NOT_VISIBLE + " WHERE dossierContactUrgenceId = ?";
    
    protected static final String SELECT_DOSSIER_CONTACT_URGENCE_BY_ID = "SELECT * FROM dossier_contact_urgence"
            + " WHERE dossierContactUrgenceId = ? AND " + VISIBLE;
    
    protected static final String SELECT_DOSSIER_CONTACT_URGENCE_BY_CONTACT_ID = "SELECT * FROM dossier_contact_urgence"
            + " WHERE contactId = ? AND " + VISIBLE;

    protected static final String SELECT_DOSSIER_CONTACT_URGENCE = "SELECT * FROM dossier_contact_urgence WHERE "
            + VISIBLE;     
    
    
    
    //****************************** MALADIE*************************************
    
    protected static final String INSERT_MALADIE = "INSERT INTO maladies ("
            + " nom, descriptif) VALUES (?,?)";
    
    protected static final String UPDATE_MALADIE = "UPDATE maladies SET"
            + " nom = ?, descriptif = ? WHERE maladieId = ?";
    
    protected static final String DELETE_MALADIE = "UPDATE maladies SET "
            + NOT_VISIBLE + " WHERE maladieId = ?";
    
    protected static final String SELECT_MALADIE = "SELECT * FROM maladies"
            + " WHERE " + VISIBLE;
    
    protected static final String SELECT_MALADIE_BY_ID = "SELECT * FROM maladies"
            + " WHERE maladieId = ? AND " + VISIBLE;
    
}
