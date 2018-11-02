/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;
import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.dao.CompteUserDAO;
import garderie.model.CompteUser;
import java.sql.Connection;
import java.util.Map;  
import org.apache.struts2.interceptor.SessionAware;  
import org.apache.struts2.interceptor.validation.SkipValidation;
/**
 *
 * @author Maryline
 */
public class LoginAction extends ActionSupport implements SessionAware, ParameterNameAware {
    private CompteUser compteUser;
    private String login;
    private String mdp;
    private Map<String, Object> userSession;  

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public CompteUser getCompteUser() {
        return compteUser;
    }

    public void setCompteUser(CompteUser compteUser) {
        this.compteUser = compteUser;
    }

    public Map<String, Object> getUserSession() {
        return userSession;
    }
    
    @Override
    public void setSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }
    
    public String doLogin() {
        Connection connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
        String result = INPUT;
        if(login.length()>0 && mdp.length()>0) {
            CompteUserDAO compteUserDAO = new CompteUserDAO(connection);
            compteUser = compteUserDAO.validate(login, mdp);
            if (compteUser != null) {
                this.userSession.put("user", compteUser);
                addActionMessage("Vous êtes bien connecté(e)!");
                result = SUCCESS;
            }
        } else {
            addActionError("Erreur d'identifiants!");
        }
        return result ;
    }
    
    @SkipValidation
    public String doLogout() {
        this.userSession.remove("user");
        addActionMessage("A bientot!");
        return SUCCESS;
    }
    
    @Override
    public void validate() {
        if (login.length() == 0) {
            addFieldError("login", "Veuillez remplir le champs");
        }
        if (mdp.length() == 0) {
            addFieldError("mdp", "Veuillez remplir le champs");
        }
    }
    
    public boolean acceptableParameterName(String parameterName) {
        boolean allowedParameterName = true ;

        if ( parameterName.contains("session")  || parameterName.contains("request") ) {
            allowedParameterName = false ;
        } 

        return allowedParameterName;
    }
}
