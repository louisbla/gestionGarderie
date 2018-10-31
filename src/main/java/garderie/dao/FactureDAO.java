/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;
import com.mysql.jdbc.Statement;
import garderie.model.ParentFacture;
import garderie.model.Facture;
import garderie.model.LigneFacture;
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
public class FactureDAO extends CommonDAO<Facture>{
    
    public FactureDAO(Connection connection){
        super(connection);
    }

    @Override
    public Facture create(Facture facture) {
       try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.INSERT_FACTURE, Statement.RETURN_GENERATED_KEYS);
            
            //Insert parameter at the location of the question mark in the SQL Query
            //preparedStatement.setDate(1, facture.getDateEmission());
            //preparedStatement.setDate(2, facture.getDatePaiement());
            preparedStatement.setDouble(3, facture.getMontantTTC());
            preparedStatement.setString(4, facture.getStatut().name());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            
            //Recupere l'id genere par la BDD
            ResultSet resultKeys = preparedStatement.getGeneratedKeys();
            if (resultKeys.next()) {
                int idFacture = resultKeys.getInt(1);
                facture.setIdFacture(idFacture);
            }
            
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(FactureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return facture;  
    }

    @Override
    public Facture update(Facture facture) {
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLConstant.UPDATE_FACTURE);
            
            //Insert parameter at the location of the question mark in the SQL Query
            //preparedStatement.setDate(1, facture.getDateEmission());
            //preparedStatement.setDate(2, facture.getDatePaiement());
            preparedStatement.setDouble(3, facture.getMontantTTC());
            preparedStatement.setString(4, facture.getStatut().name());
            preparedStatement.setInt(5, facture.getIdFacture());
            
            System.out.println(preparedStatement.toString());

            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            Logger.getLogger(FactureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return facture; 
    
    }

    @Override
    public void delete(Facture facture) {
    
        try{
             //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_FACTURE);
            
            //Insert parameter at the location of the question mark in the SQL Query
             preparedStatement.setInt(1, facture.getIdFacture());
           
            //Executing the preparedStatement
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        }catch (SQLException e) {
            Logger.getLogger(FactureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }

    @Override
    public Facture findById(int id) {
        Facture facture = new Facture();
        
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_FACTURE_BY_ID);

            //Insert parameter at the location of the question mark in the SQL Query
            preparedStatement.setInt(1, id);
            
            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();
            
            if (result.first()){
                facture.setIdFacture(id);
                facture.setDateEmission(result.getDate("date_emission"));
                facture.setDatePaiement(result.getDate("date_paiement"));
                facture.setMontantTTC(result.getDouble("montant_ttc"));
                //facture.setStatut(result.getString("statut"));
                //facture.setLignesFactures(lignesFactures);
                //facture.setParent(parent);    
            }
            
            preparedStatement.close();
            
        }catch (SQLException e) {
            Logger.getLogger(FactureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return facture;
    }

    @Override
    public ArrayList<Facture> findAll() {
        ArrayList<Facture> listefacture = new ArrayList<>();
        
        try{
            //Creation of the PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_FACTURE);

            System.out.println(preparedStatement.toString());

            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()){
                Facture facture = new Facture();
                
                facture.setIdFacture(result.getInt("factureId"));
                facture.setDateEmission(result.getDate("date_emission"));
                facture.setDatePaiement(result.getDate("date_paiement"));
                facture.setMontantTTC(result.getDouble("montant_ttc"));
                //facture.setStatut(result.getString("statut"));
                //facture.setLignesFactures(lignesFactures);
                //facture.setParent(parent);    
                
                listefacture.add(facture);
            }
            
        }catch (SQLException e) {
            Logger.getLogger(FactureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
        return listefacture;
    }
    
    
    public ArrayList<LigneFacture> getAllLigneForFacture(int id){
        ArrayList<LigneFacture> listelignefacture= new ArrayList<>();
 
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_LIGNE_FOR_FACTURE);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement.toString());
            
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next()){
                LigneFacture ligne = new LigneFacture();
                
                FactureDAO factureDAO = new FactureDAO(connection);
                Facture facture = factureDAO.findById(id);
                
                ligne.setIdLigneFacture(result.getInt("ligneId"));
                ligne.setTotalHT(result.getDouble("total_ht"));
                ligne.setTotalTTC(result.getDouble("total_ttc"));
                ligne.setQuantite(result.getInt("quantite"));
                ligne.setFacture(facture);
                //ligne.setObjetsFacturable(objetFacturable);
                
                listelignefacture.add(ligne);
            }
            
        }catch (SQLException e) {
            Logger.getLogger(FactureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return listelignefacture;
    }
    
}
