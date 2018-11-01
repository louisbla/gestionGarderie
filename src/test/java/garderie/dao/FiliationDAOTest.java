/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
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
public class FiliationDAOTest {

    private Connection connection;

    public FiliationDAOTest() {
    }

    @Before
    public void setUp() {
        connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
    }

    @Test
    public void testFindAllByParentId() {
        FiliationDAO filiationDAO = new FiliationDAO(connection);
        
        filiationDAO.getAllByParentId(12);
    }
}
