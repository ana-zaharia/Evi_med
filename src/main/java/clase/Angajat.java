
package clase;

import java.io.Serializable;

public class Angajat implements Serializable {
    
    private Persoana persoana;
    private String email;
    private Boolean esteManager;
    private int id;
    private String nume, prenume, cnp, judet, localitate;
    
    public Angajat(){
    }
    
    
    public Angajat(Persoana persoana, String email){
        this.persoana=persoana;
        this.email=email;
     
    }
    public Angajat(int id, String nume, String prenume, String cnp, String localitate, String judet, String email){
      this.id=id;
      this.nume=nume;
      this.prenume=prenume;
      this.cnp=cnp;
      this.localitate=localitate;
      this.judet=judet;
      this.email=email;
    }
    
    public Angajat(String nume, String prenume, String cnp, String localitate, String judet, String email, Boolean esteManager) {
        persoana=new Persoana(nume, prenume, cnp, localitate, judet);
        this.email = email;
        this.esteManager=esteManager;
    }
    
    public Persoana getPersoana(){
        return persoana;
    }
    
    public void setPersoana(Persoana persoana){
        this.persoana=persoana;
    }
    
    public String getEmial(){
        return email;
    }
    
    public void setEmail(String email){
        this.email=email;
    }
    
   
    public Boolean getManager() {
        return esteManager;
    }

    public void setDirector(Boolean manager) {
        esteManager = manager;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNume(){
        return nume;
    }
    
    public void setNume(String nume){
        this.nume=nume;
    }
    
    public String getPrenume(){
        return prenume;
    }
    
    public void setPrenume(String prenume){
        this.prenume=prenume;
    }
    
    public String getCnp(){
        return cnp;
    }
    
    public void setCnp(String cnp){
        this.cnp=cnp;
    }
    
    public String getJudet(){
        return judet;
    }
    
    public void setJudet(String judet){
        this.judet=judet;
    }
    
    public String getLocalitate(){
        return localitate;
    }
    
    public void setLocalitate(String localitate){
        this.localitate=localitate;
    }
    
    public String getEmail(){
        return email;
    }
    
  
}
