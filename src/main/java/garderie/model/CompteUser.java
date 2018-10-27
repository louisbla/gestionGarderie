/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;


public class CompteUser implements Serializable {
    private int idUser;
    private String login;
    private String mdp;
    private boolean privilege;

    public CompteUser() {
    }

    
    public CompteUser(String login, String mdp, boolean privilege) {
        this.login = login;
        this.mdp = mdp;
        this.privilege = privilege;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }

    public boolean isPrivilege() {
        return privilege;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setPrivilege(boolean privilege) {
        this.privilege = privilege;
    }
    
    
}
