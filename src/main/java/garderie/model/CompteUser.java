/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;


public class CompteUser {
    private int idUser;
    private String login;
    private String mdp;
    private boolean privilege;

    public CompteUser(String login, String mdp, boolean privilege) {
        this.login = login;
        this.mdp = mdp;
        this.privilege = privilege;
    }

    public int getIdUser() {
        return idUser;
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