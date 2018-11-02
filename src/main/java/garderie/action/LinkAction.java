/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Katsuo
 */
public class LinkAction extends ActionSupport {
    
    public String welcome()
	{
		return "welcome";		
	}
	
    public String planning()
    {
            return "planning";		
    }

    public String inscription()
    {
            return "inscription";		
    }

    public String inventaire()
    {
        return "inventaire";
    }

    public String facturation() 
    {
        return "facturation";
    }
    

    
}
