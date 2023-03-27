/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import clase.ManagerAngajat;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Ana
 */
@Named("controllerDosarMedical")
@SessionScoped
public class ControllerDosarMedical implements Serializable {
    private String cnp, numeAngajat,  boli, recomandari, servire, medic, numar, data;
    private int idDosar, numarAd;
    

    
    public void completeazaDosar(){
        numeAngajat=ManagerAngajat.getNumeAngajatDupaCNP(cnp);
        Integer idAdeverinta=ManagerAngajat.completeazaAdeverintaMedicala(numarAd, idDosar , data, boli, recomandari, servire, medic);
        if (idAdeverinta !=null) return;
    }
    /**
     * @return the cnp
     */
    public String getCnp() {
        return cnp;
    }

    /**
     * @param cnp the cnp to set
     */
    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    /**
     * @return the numeAngajat
     */
    public String getNumeAngajat() {
        return numeAngajat;
    }

    /**
     * @param numeAngajat the numeAngajat to set
     */
    public void setNumeAngajat(String numeAngajat) {
        this.numeAngajat = numeAngajat;
    }

    /**
     * @return the numarAd
     */
    public int getNumarAd() {
        return numarAd;
    }

    /**
     * @param numarAd the numarAd to set
     */
    public void setNumarAd(int numarAd) {
        this.numarAd = numarAd;
    }

    /**
     * @return the boli
     */
    public String getBoli() {
        return boli;
    }

    /**
     * @param boli the boli to set
     */
    public void setBoli(String boli) {
        this.boli = boli;
    }

    /**
     * @return the recomandari
     */
    public String getRecomandari() {
        return recomandari;
    }

    /**
     * @param recomandari the recomandari to set
     */
    public void setRecomandari(String recomandari) {
        this.recomandari = recomandari;
    }

    /**
     * @return the servire
     */
    public String getServire() {
        return servire;
    }

    /**
     * @param servire the servire to set
     */
    public void setServire(String servire) {
        this.servire = servire;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the medic
     */
    public String getMedic() {
        return medic;
    }

    /**
     * @param medic the medic to set
     */
    public void setMedic(String medic) {
        this.medic = medic;
    }
    
    
}
