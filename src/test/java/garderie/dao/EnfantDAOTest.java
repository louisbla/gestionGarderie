/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.Adresse;
import garderie.model.Article;
import garderie.model.CategorieArticle;
import garderie.model.ContactUrgence;
import garderie.model.DossierContactUrgence;
import garderie.model.DossierInscription;
import garderie.model.Enfant;
import garderie.model.Filiation;
import garderie.model.Groupe;
import garderie.model.InventaireEnfant;
import garderie.model.PersonneAdresse;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dendaneys
 */
public class EnfantDAOTest {

    private Connection connection;

    public EnfantDAOTest() {
    }

    @Before
    public void setUp() {
        connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void findById() {
        /*EnfantDAO enfantDAO = new EnfantDAO(connection);
        Enfant enfant = enfantDAO.findById(5);

        System.out.println(enfant.getNom());
        System.out.println(enfant.getPrenom());
        System.out.println(enfant.getDossier().getMedecinTraitant());

        for (DossierContactUrgence obj : enfant.getDossier().getContactsUrgences()) {
            System.out.println(obj.getDossierInscription().getNbDemiJourneeInscrit());
            System.out.println(obj.getContactUrgence().getPrenom());
        }

        for (Filiation filiation : enfant.getListeParents()) {
            System.out.println(filiation.getP().getPrenom() + " est " + filiation.getLien());

        }

        for (Article article : enfant.getInventaire().getListeArticleEnfant()) {
            System.out.println("Article : " + article.getNom());
        }*/
    }

    @Test
    public void createEnfant() {
        EnfantDAO enfantDAO = new EnfantDAO(connection);
        Enfant enfant = new Enfant();

        // Informations de l'enfant
        enfant.setNom("Baltimore");
        enfant.setPrenom("Jefferson");
        enfant.setDateNaissance(Date.valueOf(LocalDate.of(2018, Month.MARCH, 4)));
        enfant.setNumSecu("JEFFB176362");
        enfant.setSexe("masculin");
        enfant.setPhoto("http://jeff.com");
        

        // Adresse et PersonneAdresse
        Adresse adresse = new Adresse();
        adresse.setCodePostal("467HRU");
        adresse.setLigne1("Rue Poivre");
        adresse.setPays("Canada");
        adresse.setVille("Chicoutimi");

        PersonneAdresse personneAdresse = new PersonneAdresse();
        personneAdresse.setDomicile(true);
        personneAdresse.setFacturation(true);
        personneAdresse.setPersonne(enfant);
        personneAdresse.setAdresse(adresse);

        // Article
        ArrayList<Article> listeArticleEnfant = new ArrayList<>();
        Article article = new Article();
        article.setDescription("Crosse de hockey");
        article.setNom("Au cas ou");
        article.setPhoto("http://ceossehockey.com");
        article.setQuantite(2);

        listeArticleEnfant.add(article);

        // Categorie d'article
        CategorieArticle categorieArticle = new CategorieArticle();
        categorieArticle.setIdCategorie(2);
        article.setCategorie(categorieArticle);

        // Inventaire d'enfant
        InventaireEnfant inventaireEnfant = new InventaireEnfant();
        inventaireEnfant.setListeArticleEnfant(listeArticleEnfant);
        enfant.setInventaire(inventaireEnfant); // referencement

        InventaireEnfantDAO inventaireEnfantDAO = new InventaireEnfantDAO(connection);
        //inventaireEnfantDAO.create(inventaireEnfant);

        // Groupe
        Groupe groupe = new Groupe();
        groupe.setIdGroupe(2);
        enfant.setGroupe(groupe);

        // Creation DossierInscription
        DossierInscription dossierInscription = new DossierInscription();
        dossierInscription.setDateInscription(Date.valueOf(LocalDate.of(2018, Month.OCTOBER, 24)));
        dossierInscription.setMedecinTraitant("Dr. DRE");
        dossierInscription.setNbDemiJourneeInscrit(42);
        dossierInscription.setNbDemiJourneeAbsent(0);

        //enfantDAO.create(enfant);
        dossierInscription.setEnfant(enfant);

        DossierInscriptionDAO dossierInscriptionDAO = new DossierInscriptionDAO(connection);
        //dossierInscriptionDAO.create(dossierInscription);
        enfant.setDossier(dossierInscription);
    }
    
    @Test
    public void getEnfantsByGroupe() {
       GroupeDAO groupeDAO = new GroupeDAO(connection);
       ArrayList<Enfant> groupes = groupeDAO.getEnfantsForGroupe(2);
       
        System.out.println(groupes.size());
    }
}
