/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.DossierEmploye;
import garderie.model.Employe;
import garderie.model.TypeContrat;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Katsuo
 */
public class DossierEmployeDAOTest {
    private Connection connection;
    private DossierEmploye dossierEmploye;
    private DossierEmployeDAO dossierEmployeDAO;
    private Employe employe;
    private TypeContrat typeContrat;
    
    public DossierEmployeDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
//        connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
//        dossierEmployeDAO = new DossierEmployeDAO(connection);
//        
//        employe = new Employe();
//        
//        employe.setNom("McKenzie");
//        employe.setPrenom("Eloise");
//        employe.setSexe("feminin");
//        LocalDate localDate = LocalDate.of(1988, 12, 3);
//        Date date = Date.valueOf(localDate);
//        employe.setDateNaissance(date);
//        employe.setNumSecu("MCKE88441326");
//        employe.setPoste("Puericultrice");
//        employe.setExterne(false);
//        employe.setNumTel("(418)651-1238");
//        
//        typeContrat = TypeContrat.CDD;
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class DossierEmployeDAO.
     */
    @Test
    public void testCreate() {
//        System.out.println("create");
//        EmployeDAO employeDAO = new EmployeDAO(connection);
//        employeDAO.create(employe);
//        Employe employeInsere = employeDAO.findById(22);
//        LocalDate localDate = LocalDate.of(2018, 1, 3);
//        Date dateEntree = Date.valueOf(localDate);
//        DossierEmploye dossierEmploye = new DossierEmploye(employeInsere, dateEntree, 9, typeContrat, 20);
//        DossierEmploye expResult = new DossierEmploye(employeInsere, dateEntree, 9, typeContrat, 20);
//        DossierEmploye result = dossierEmployeDAO.create(dossierEmploye);
//        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class DossierEmployeDAO.
     */
    @Test
    public void testUpdate() {
//        System.out.println("update");
//        dossierEmploye = dossierEmployeDAO.findById(1);
//        dossierEmploye.setTauxHoraireBrut(30);
//        DossierEmploye result = dossierEmployeDAO.update(dossierEmploye);
//        dossierEmploye = dossierEmployeDAO.findById(1);
//        assertEquals(dossierEmploye.getTauxHoraireBrut(), result.getTauxHoraireBrut(), 0.1);
    }

    /**
     * Test of delete method, of class DossierEmployeDAO.
     */
    @Test
    public void testDelete() {
//        System.out.println("delete");
//        dossierEmploye = dossierEmployeDAO.findById(6);
//        dossierEmployeDAO.delete(dossierEmploye);
    }

    /**
     * Test of findById method, of class DossierEmployeDAO.
     */
    @Test
    public void testFindById() {
//        System.out.println("findById");
//        int id = 1;
//        DossierEmploye expResult = new DossierEmploye();
//        expResult.setNbMoisAnciennete(15);
//        expResult.setTauxHoraireBrut(17);
//        LocalDate localDate = LocalDate.of(2015, 9, 5);
//        Date dateEntree = Date.valueOf(localDate);
//        expResult.setDateEntree(dateEntree);
//        DossierEmploye result = dossierEmployeDAO.findById(id);
//        assertEquals(expResult.getDateEntree(), result.getDateEntree());
    }

    /**
     * Test of findAll method, of class DossierEmployeDAO.
     */
    @Test
    public void testFindAll() {
//        System.out.println("findAll");
//        ArrayList<DossierEmploye> result = dossierEmployeDAO.findAll();
//        assertEquals(6, result.size());
    }
    
}
