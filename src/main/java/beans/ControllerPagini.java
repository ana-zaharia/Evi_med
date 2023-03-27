/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("controllerPagini")
@RequestScoped
public class ControllerPagini {
   
    public String clickCautaAngajat(){
        return "cautareAngajat.xhtml?faces-redirect=true";
    }
    
    public String clickDosarMedical(){
        return "paginaDosar.xhtml?faces-redirect=true";
    }
    
     public String clickPaginaCNP(){
        return "paginaCNP.xhtml?faces-redirect=true";
    }
       public String clickAdevenrintaMed(){
        return "dosarMedical.xhtml?faces-redirect=true";
    }
       
        public String clickVeziAdevenrintaMed(){
        return "adeverintaMedicala.xhtml?faces-redirect=true";
    }
        public String clickTest(){
        return "sustinereTestPsihologic.xhtml?faces-redirect=true";
    }
        
             public String clickTrimiteRaspunsuri(){
        return "raspunsuriTest.xhtml?faces-redirect=true";
    }
                 public String clickFisaAptitudine(){
        return "completareFisaAptitudine.xhtml?faces-redirect=true";
    }
        
}
