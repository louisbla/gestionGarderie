/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.action;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author HP_LOUIS
 */
public class logoutAction implements SessionAware{
    private Map<String, Object> session;
    
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = ActionContext.getContext().getSession();    
    }
    
    public void deleteSession(){
        session.clear();
    }
    
}
