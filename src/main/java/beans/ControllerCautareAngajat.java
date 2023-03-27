/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import clase.Angajat;
import clase.ConexiuneBazaDeDate;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;


import javax.inject.Named;
import org.primefaces.event.SelectEvent;

@Named("controllerCautareAngajat")
@ViewScoped
public class ControllerCautareAngajat implements Serializable{
    private  List<Angajat> listaAngajati= new ArrayList<>();
    private Angajat angajatSelectat;
    
    public List getListaAngajati(){
        ConexiuneBazaDeDate cb=ConexiuneBazaDeDate.getInstanta();
        cb.deschideConexiune();
        Connection conexiune=cb.getConexiune();
        try{
            PreparedStatement ps=conexiune.prepareStatement("select * from angajat");
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()){
                listaAngajati.add(new Angajat(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(8)));   
             
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaAngajati;
    }
    

    /**
     * @return the angajatSelectat
     */
    public Angajat getAngajatSelectat() {
        return angajatSelectat;
    }

    /**
     * @param angajatSelectat the angajatSelectat to set
     */
    public void setAngajatSelectat(Angajat angajatSelectat) {
        this.angajatSelectat = angajatSelectat;
    }
    
    
}
