/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.Adresse;
import garderie.model.Personne;
import garderie.model.PersonneAdresse;
import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dendaneys
 */
public class PersonneAdresseDAOTest {

    private Connection connection;

    public PersonneAdresseDAOTest() {
    }

    @Before
    public void setUp() {
        connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createPersonneAdresseForJoseInRueBegin() {
//        PersonneAdresseDAO paDAO = new PersonneAdresseDAO(connection);
//
//        PersonneDAO personneDAO = new PersonneDAO(connection);
//        Personne jose = personneDAO.findById(21);
//
//        AdresseDAO adresseDAO = new AdresseDAO(connection);
//        Adresse adresse = adresseDAO.findById(1);
//
//        PersonneAdresse pa = new PersonneAdresse(true, true, adresse, jose);
        //paDAO.create(pa);
    }
}
