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
    
    protected static final String INSERT_ACTIVITE = "INSERT INTO activites("
            + "nom, date, description, nb_enfant_max, lieu, prix) VALUES ?,?,?,?,?,? ";
    
    protected static final String UPDATE_ACTIVITE = "UPDATE activites SET "
            + "nom = ?, date = ?, description = ?, nb_enfant_max = ?, lieu = ?,"
            + " prix = ? WHERE activiteId = ?";
    
    protected static final String DELETE_ACTIVITE = "DELETE activites WHERE "
            + "activiteId = ?" ;
    
    protected static final String SELECT_ACTIVITE_BY_ID = "SELECT * FROM activites"
            + "WHERE activiteId = ?";
    
    protected static final String SELECT_ACTIVITES = "SELECT * FROM activites";
}
