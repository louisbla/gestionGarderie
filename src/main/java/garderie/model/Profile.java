/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;
import javax.servlet.http.HttpSession;  
import org.apache.struts2.ServletActionContext;  
/**
 *
 * @author Maryline
 */
public class Profile{  
  
    public String execute(){  
        HttpSession session=ServletActionContext.getRequest().getSession(false);  
        if(session==null || session.getAttribute("login")==null){  
            return "login";  
        }  
        else{  
            return "success";  
        }  
    }  
}  
