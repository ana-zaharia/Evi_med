/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase;


public class Persoana {
   
    private String nume, prenume, cnp, judet, localitate;
    
    public Persoana(){  
    }
    
    public Persoana(String nume, String prenume){
        this.nume=nume;
        this.prenume=prenume;
    }
    
    public Persoana(String nume, String prenume, String cnp, String localitate, String judet){
        this.nume=nume;
        this.prenume=prenume;
        this.cnp=cnp;
        this.localitate=localitate;
        this.judet=judet;
    }
    
    public String getNumeIntreg(){
        return nume + " " + prenume;
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
}
