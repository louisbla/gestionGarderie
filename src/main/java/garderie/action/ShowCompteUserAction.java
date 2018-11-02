/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.action;

import com.opensymphony.xwork2.ActionSupport;
import garderie.dao.CompteUserDAO;
import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.CompteUser;
import java.sql.Connection;

/**
 *
 * @author Katsuo
 */
public class ShowCompteUserAction extends ActionSupport {
    private CompteUser compteUser;
    private Connection connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
    private CompteUserDAO compteUserDAO = new CompteUserDAO(connection);

    public CompteUser getCompteUser() {
        return compteUser;
    }

    public void setCompteUser(CompteUser compteUser) {
        this.compteUser = compteUser;
    }

    @Override
    public String execute() throws Exception {
        
        return SUCCESS;
    }
    
    
    
}
