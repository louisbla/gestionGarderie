/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import static org.apache.struts2.ServletActionContext.getRequest;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author HP_LOUIS
 */
public class LoginAction extends ActionSupport implements SessionAware{
    
    private Map<String, Object> session;
    
    public void getAttributes(){
        HttpServletRequest request = getRequest();
        
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        session.put("login", login);
    }
    
    public String tryConnect(String login, String password){
        if(login.equals("admin") && password.equals("")){
            session.put("login", login);
            return SUCCESS;
        }else{
            return INPUT;
        }
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = ActionContext.getContext().getSession();
    }
}
