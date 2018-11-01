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
//import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;  
import org.apache.struts2.dispatcher.SessionMap;  
import org.apache.struts2.interceptor.SessionAware;  
/**
 *
 * @author Maryline
 */
public class LoginAction implements SessionAware{
    
    Connection connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
    private String name;
    private String password;
    CompteUserDAO compteDAO = new CompteUserDAO(connection);  
    SessionMap<String,Object> sessionMap;  

    public String getNamme() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String userpass) {
        this.password = userpass;
    }

    /**
    public String execute(){  
        if(compteDAO.validate(username, userpass)){  
            return "success";  
        }  
        else{  
            return "error";  
        }  
    }  */
  
    public String execute(){  
        if(password.equals("admin")){  
            sessionMap.put("login","true");  
            sessionMap.put("name",name);  

            return "success";  
        }  
        else{  
            return "login";  
        }  
    }  
    
    public void setSession(Map<String, Object> map) {  
        sessionMap =(SessionMap)map;  
    } 

    public String logout(){  
        if(sessionMap!=null){  
            sessionMap.invalidate();  
        }  
        return "success";  
    } 
    
    /**
    public String logout(){  
        sessionMap.invalidate();  
        return "success";  
    }  **/
}
