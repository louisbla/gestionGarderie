/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;
import com.mysql.jdbc.Statement;
import garderie.model.CompteUser;
import garderie.model.Personne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Maryline
 */
public class CompteUserDAO extends CommonDAO<CompteUser>{
    
    public CompteUserDAO(Connection connection){
        super(connection);
    }

    @Override
    public CompteUser create(CompteUser compte) {
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_COMPTE_USER, Statement.RETURN_GENERATED_KEYS);
            
            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setString(1, compte.getLogin());
            preparedStatement.setString(2, compte.getMdp());
            preparedStatement.setBoolean(3, compte.isPrivilege());
            preparedStatement.setInt(4, compte.getPersonne().getIdPersonne());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            
            
            //Recupere l'id genere par la BDD
            ResultSet resultKeys = preparedStatement.getGeneratedKeys();
            if (resultKeys.next()) {
                int idUser = resultKeys.getInt(1);
                compte.setIdUser(idUser);
            }
            
            preparedStatement.close();

        }catch (SQLException e) {
            Logger.getLogger(CompteUserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return compte;
    
    }

    @Override
    public CompteUser update(CompteUser compte) {
        
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.UPDATE_COMPTE_USER); 
            
            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setString(1, compte.getLogin());
            preparedStatement.setString(2, compte.getMdp());
            preparedStatement.setBoolean(3, compte.isPrivilege());
            preparedStatement.setInt(4, compte.getPersonne().getIdPersonne());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        }catch (SQLException e) {
            Logger.getLogger(CompteUserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return compte;
    }
    
    
    
    @Override
    public void delete(CompteUser compte) {
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_COMPTE_USER);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, compte.getIdUser());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        }catch (SQLException e) {
            Logger.getLogger(CompteUserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    
    @Override
    public CompteUser findById(int id) {
        CompteUser compte = new CompteUser();
        
        try{
             //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_COMPTE_USER_BY_ID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, id);
            
            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();  
            
            
            
            if(result.first()){
                PersonneDAO personneDAO = new PersonneDAO(connection);
                Personne personne = personneDAO.findById(result.getInt("personneId"));
                compte.setIdUser(id);
                compte.setLogin(result.getString("login"));
                compte.setMdp(result.getString("password"));
                compte.setPrivilege(result.getBoolean("privilege"));
                compte.setPersonne(personne);
            }  
        }catch (SQLException e) {
            Logger.getLogger(CompteUserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    
        return compte;
    }

    
    
    @Override
    public ArrayList<CompteUser> findAll() {
    
        ArrayList<CompteUser> listecompte = new ArrayList<>();
        
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_COMPTE_USER);

            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next()){
                CompteUser compte = new CompteUser();
                PersonneDAO personneDAO = new PersonneDAO(connection);
                Personne personne = personneDAO.findById(result.getInt("personneId"));
                
                compte.setIdUser(result.getInt("userId"));
                compte.setLogin(result.getString("login"));
                compte.setMdp(result.getString("password"));
                compte.setPrivilege(result.getBoolean("privilege"));
                compte.setPersonne(personne);
                
                listecompte.add(compte);
            }
            
        }catch (SQLException e) {
            Logger.getLogger(CompteUserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    
        return listecompte;
    }

}
