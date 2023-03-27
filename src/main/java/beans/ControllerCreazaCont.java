/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import clase.ManagerAngajat;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("controllerCreazaCont")
@RequestScoped
public class ControllerCreazaCont implements Serializable {

    private String nume, prenume, cnp, localitate, judet, departamentSelectat="", email, mesaj = "";
    
    

    public void clickConfirma() {
       
        StringBuffer pr = new StringBuffer();
        Integer idContAngajat = ManagerAngajat.creazaCont(nume, prenume, cnp, localitate, judet, Integer.parseInt(departamentSelectat), email, pr);
        
        if (idContAngajat == null) {
           mesaj="Creare cont eșuată. Email sau CNP deja existente!";
            return;
        }
        golireCampuri();
        mesaj="Cont creat cu succes!";
    }

    private void golireCampuri() {
        nume = "";
        prenume = "";
        cnp = "";
        localitate = "";
        judet = "";
        departamentSelectat = "1";
        email = "";
    }

    /**
     * @return the nume
     */
    public String getNume() {
        return nume;
    }

    /**
     * @param nume the nume to set
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * @return the prenume
     */
    public String getPrenume() {
        return prenume;
    }

    /**
     * @param prenume the prenume to set
     */
    public void setPrenume(String prenume) {
        this.prenume = prenume;
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
     * @return the localitate
     */
    public String getLocalitate() {
        return localitate;
    }

    /**
     * @param localitate the localitate to set
     */
    public void setLocalitate(String localitate) {
        this.localitate = localitate;
    }

    /**
     * @return the judet
     */
    public String getJudet() {
        return judet;
    }

    /**
     * @param judet the judet to set
     */
    public void setJudet(String judet) {
        this.judet = judet;
    }

    /**
     * @return the departament
     */
    public String getDepartamentSelectat() {
        return departamentSelectat;
    }

    /**
     * @param departament the departament to set
     */
    public void setDepartamentSelectat(String departament) {
        this.departamentSelectat = departament;
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
     * @return the mesaj
     */
    public String getMesaj() {
        return mesaj;
    }

    /**
     * @param mesaj the mesaj to set
     */
    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

}
