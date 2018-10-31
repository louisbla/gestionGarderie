/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.Personne;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.List;
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
public class PersonneDAOTest {

    private Connection connection;
    private PersonneDAO personneDAO;

    public PersonneDAOTest() {
    }

    @Before
    public void setUp() {
        connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
        personneDAO = new PersonneDAO(connection);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void selectPersonnes() {
//        PersonneDAO personneDAO = new PersonneDAO(connection);
//        List<Personne> personnes = personneDAO.findAll();
//
//        for (Personne personne : personnes) {
//            System.out.println(personne.getNom());
//        }
//
//        System.out.println("test");

        //assertEquals(20, personnes.size());
    }

    @Test
    public void createPersonneJoseDeLaNoche() {
//        PersonneDAO personneDAO = new PersonneDAO(connection);
//
//        Personne personne = new Personne();
//        personne.setNom("DeLaNoche");
//        personne.setPrenom("Jose");
//        personne.setSexe("masculin");
//
//        LocalDate localDate = LocalDate.of(2017, Month.MARCH, 8);
//        Date date = Date.valueOf(localDate);
//
//        personne.setDateNaissance(date);
//        personne.setNumSecu("NOCHE774864");
//
//        //Personne personneReturned = personneDAO.create(personne);
//        List<Personne> personnes = personneDAO.findAll();
//        //assertEquals(21, personnes.size());

    }

    @Test
    public void updatePersonneJoseDeLaNoche() {
//        PersonneDAO personneDAO = new PersonneDAO(connection);
//        Personne jose = personneDAO.findById(21);
//        if (jose != null) {
//            jose.setNom("De La Noche");
//            jose.setNumSecu("");
//        }
//
//        personneDAO.update(jose);
//        List<Personne> personnes = personneDAO.findAll();

        //assertEquals(21, personnes.size());

    }

    @Test
    public void deletePersonneJoseDeLaNoche() {
//        PersonneDAO personneDAO = new PersonneDAO(connection);
//        Personne jose = personneDAO.findById(21);

        /*if (jose != null)
            personneDAO.delete(jose);*/
        
        /*jose = personneDAO.findById(21);
        
        assertFalse(jose.isVisible());*/
    }
    
    @Test
    public void testFindById() {
//        System.out.println("findById");
//        int id = 1;
//        Personne expResult = new Personne();
//        expResult.setIdPersonne(id);
//        expResult.setNom("Doe");
//        expResult.setPrenom("John");
//        expResult.setSexe("masculin");
//        LocalDate localDate = LocalDate.of(1985, 10, 3);
//        Date date = Date.valueOf(localDate);
//        expResult.setDateNaissance(date);
//        expResult.setNumSecu("DOEJ97441816");
//        
//        Personne result = personneDAO.findById(id);
//        System.out.println(result.getPrenom());
    }
}
