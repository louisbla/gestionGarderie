/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.DossierInscription;
import java.sql.Connection;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dendaneys
 */
public class DossierInscriptionDAOTest {
    
    private Connection connection;

    public DossierInscriptionDAOTest() {
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
         DossierInscriptionDAO dossierInscriptionDAO  = new DossierInscriptionDAO(connection);
         DossierInscription dossierInscription = dossierInscriptionDAO.findById(3);
         
         System.out.println(dossierInscription.getEnfant().getNom());
         System.out.println(dossierInscription.getEnfant().getPrenom());
         System.out.println(dossierInscription.getContactsUrgences().get(0).getContactUrgence().getNom());
     }
}
