/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dendaneys
 */
public class BDDManagerMySQL implements Manager {

    private static final String HOST = "jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9262676";
    private static final String USER = "sql9262676";
    private static final String PASSWORD = "5D8CqKGLXb";
    private static Connection connection = null;
    
    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(HOST, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return connection;
    }
}
