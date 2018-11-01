/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.action;

import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.dao.CompteUserDAO;
import java.sql.Connection;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;  
import org.apache.struts2.dispatcher.SessionMap;  
import org.apache.struts2.interceptor.SessionAware;  
/**
 *
 * @author Maryline
 */
public class LoginAction implements SessionAware{
    
    Connection connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
    private String username;
    private String userpass;
    CompteUserDAO compteDAO = new CompteUserDAO(connection);  
    SessionMap<String,String> sessionmap;  

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String execute(){  
        if(compteDAO.validate(username, userpass)){  
            return "success";  
        }  
        else{  
            return "error";  
        }  
    }  
  
    public void setSession(Map map) {  
        sessionmap = (SessionMap)map;  
        sessionmap.put("login","true");  
    }  

    public String logout(){  
        sessionmap.invalidate();  
        return "success";  
    }  
}
