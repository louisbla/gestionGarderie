/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;


public class Filiation {

    private Enfant e;
    private Parent p;
    private boolean visible;

    public Filiation(){
        
    }
    
    public Filiation(Enfant e, Parent p){
        this.e = e;
        this.p = p;
        this.visible = true;
    }
    
    public Enfant getE() {
        return e;
    }

    public void setE(Enfant e) {
        this.e = e;
    }

    public Parent getP() {
        return p;
    }

    public void setP(Parent p) {
        this.p = p;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
  
    
}
