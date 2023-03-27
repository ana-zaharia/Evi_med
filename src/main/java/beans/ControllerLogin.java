/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import clase.Angajat;
import clase.ManagerAngajat;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named("controllerLogin")
@SessionScoped
public class ControllerLogin implements Serializable {
    private Angajat angajat;
    private String email, parola, numeDepartament, numeUtilizator="", adresa;
    private boolean esteLogat=false;
    private int idDepartament;
    
    public String clickLogin(){
         Angajat angajat = ManagerAngajat.getAngajatDupaEmailParola(email, parola);
        if (angajat != null) {
            this.angajat=angajat;
            this.idDepartament=ManagerAngajat.getAngajatIdDepartament(email);
            this.numeDepartament=ManagerAngajat.getDepartamentAngajat(email);
            this.adresa=ManagerAngajat.returneazaAdresaAngajat(email);
            esteLogat=true;
            numeUtilizator=ManagerAngajat.returneazaNumePrenumeUser(email);
          
            if (angajat.getManager()) return "paginaManager?faces-redirect=true";
            else return "pagins?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Autentificare esuata", null));
            return null;
        }
        
    }
    
        public String clickLogout() {
        angajat=null;
        esteLogat=false;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        session.invalidate();
        return "paginaLogin.xhtml?faces-redirect=true";
    }
   
        public String clickContulMeu(){
            return "paginaManager.xhtml?faces-redirect=true";
        }
        
        public String clickCreezaCont(){
           return "creazaCont.xhtml?faces-redirect=true";
        }
      
   

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the parola
     */
    public String getParola() {
        return parola;
    }

    /**
     * @param parola the parola to set
     */
    public void setParola(String parola) {
        this.parola = parola;
    }

    public void setNumeDepartament(String numeDepartament){
        this.numeDepartament=numeDepartament;
    }
    
    public String getNumeDepartament(){
        return numeDepartament;
    }

    /**
     * @return the idDepartament
     */
    public int getIdDepartament() {
        return idDepartament;
    }

    /**
     * @param idDepartament the idDepartament to set
     */
    public void setIdDepartament(int idDepartament) {
        this.idDepartament = idDepartament;
    }

    /**
     * @return the numeUtilizator
     */
    public String getNumeUtilizator() {
        return numeUtilizator;
    }

    /**
     * @param numeUtilizator the numeUtilizator to set
     */
    public void setNumeUtilizator(String numeUtilizator) {
        this.numeUtilizator = numeUtilizator;
    }

    /**
     * @return the adresa
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * @param adresa the adresa to set
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
