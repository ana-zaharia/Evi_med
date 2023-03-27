
package clase;

import beans.ControllerLogin;
import java.sql.*;


public final class ManagerAngajat {
    
    
    
    public static Angajat getAngajatDupaEmailParola(String email, String parola){
        ConexiuneBazaDeDate cb=ConexiuneBazaDeDate.getInstanta();
        cb.deschideConexiune();
        Connection conexiune=cb.getConexiune();
        String nume, prenume, cnp, localitate, judet, hashParola=ClaseUtilitare.hashParola(parola);
        int id, idDepartament;
        
         try {
            //try to find teacher in database
            PreparedStatement ps = conexiune.prepareStatement("select * from angajat where email=? and parola=?");
            ps.setString(1, email);
            ps.setString(2, hashParola);
            ResultSet rs = ps.executeQuery();
           
            if (!rs.next()) {
                cb.inchideConexiune();
                return null;
            }
            
            id=rs.getInt(1);
            cnp = rs.getString(2);
            nume = rs.getString(3);
            prenume = rs.getString(4);
            localitate=rs.getString(5);
            judet=rs.getString(6);
            idDepartament = rs.getInt(7);
          

            Boolean esteManager=false;
            ps=conexiune.prepareStatement("select * from departament where id_manager =? ");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) esteManager = true;
            
            cb.inchideConexiune();
            return new Angajat(nume, prenume, cnp, localitate, judet, email, esteManager);
        } catch (SQLException ignored) {
            ignored.printStackTrace();
            cb.inchideConexiune();
            return null;
        }
}
    
    public static int getAngajatIdDepartament(String departament){
        ConexiuneBazaDeDate cb=ConexiuneBazaDeDate.getInstanta();
        cb.deschideConexiune();
        Connection conexiune=cb.getConexiune();
         try {
            PreparedStatement ps = conexiune.prepareStatement(
                    "select id_departament from  departament where denumire=?");
            ps.setString(1, departament);
            ResultSet rs = ps.executeQuery();
            rs.first();
            int idDepartament = rs.getInt(1);
            cb.inchideConexiune();
            return idDepartament;
        } catch (SQLException e) {
            e.printStackTrace();
        }
           cb.inchideConexiune();
            return -1;
        
    }
    
    public static String getDepartamentAngajat(String email){
        ConexiuneBazaDeDate cb=ConexiuneBazaDeDate.getInstanta();
        cb.deschideConexiune();
        Connection conexiune=cb.getConexiune();
        try {
            PreparedStatement ps = conexiune.prepareStatement(
                    "select departament.denumire from angajat inner join departament on"+
                            " angajat.id_departament=departament.id_departament where angajat.email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next()) {
                String numeDepartament = rs.getString(1);
                cb.inchideConexiune();
                return numeDepartament;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
           cb.inchideConexiune();
            return null;
        }
    
    public static Integer creazaCont(String nume, String prenume, String cnp, String localitate, String judet, int idDepartament, String email, StringBuffer bufferParola){
        ConexiuneBazaDeDate cb=ConexiuneBazaDeDate.getInstanta();
        cb.deschideConexiune();
        Connection conexiune=cb.getConexiune();
        String parolaGenerata=ClaseUtilitare.genereazaParola(cnp);
        if (bufferParola != null) bufferParola.append(parolaGenerata);
        
        try {
            PreparedStatement ps = conexiune.prepareStatement(
                    "insert into angajat (nume, prenume, cnp, localitate, judet, id_departament, email, parola) values (?,?,?,?,?,?,?,?)",  Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nume);
            ps.setString(2, prenume);
            ps.setString(3, cnp);
            ps.setString(4, localitate);
            ps.setString(5, judet);
            ps.setInt(6, idDepartament);
            ps.setString(7, email);
            ps.setString(8, ClaseUtilitare.hashParola(parolaGenerata));
            
            ps.executeUpdate();
            
            ResultSet rsId = ps.getGeneratedKeys();
            if (rsId.next()) {
                Integer id = rsId.getInt(1);
                cb.inchideConexiune();
                return id;
            }
            
        } catch (SQLException e) { 
            e.printStackTrace();
            cb.inchideConexiune();
        }
        cb.inchideConexiune();
        return null;
    }
    
    public static String returneazaNumePrenumeUser(String email){
        ConexiuneBazaDeDate cb=ConexiuneBazaDeDate.getInstanta();
        cb.deschideConexiune();
        Connection conexiune=cb.getConexiune();
        try {
            PreparedStatement ps = conexiune.prepareStatement("select * from angajat where email=?");
            
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            
              if (rs.next()) {
                String numeUser = rs.getString(2)+" "+rs.getString(3);
                cb.inchideConexiune();
                return numeUser;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
          cb.inchideConexiune();
            return null;    
    }
    
       public static String returneazaAdresaAngajat(String email){
        ConexiuneBazaDeDate cb=ConexiuneBazaDeDate.getInstanta();
        cb.deschideConexiune();
        Connection conexiune=cb.getConexiune();
        try {
            PreparedStatement ps = conexiune.prepareStatement("select * from angajat where email=?");
            
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            
              if (rs.next()) {
                String adresaAngajat = rs.getString(5)+", "+rs.getString(6);
                cb.inchideConexiune();
                return adresaAngajat;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
          cb.inchideConexiune();
            return null;    
    }
       
       public static String getNumeAngajatDupaCNP(String cnp){
           ConexiuneBazaDeDate cb=ConexiuneBazaDeDate.getInstanta();
        cb.deschideConexiune();
        Connection conexiune=cb.getConexiune();
        try {
            PreparedStatement ps = conexiune.prepareStatement("select * from angajat where cnp=?");
            
            ps.setString(1, cnp);
            ResultSet rs = ps.executeQuery();
            
              if (rs.next()) {
                String numeAngajat = rs.getString(2)+", "+rs.getString(3);
                cb.inchideConexiune();
                return numeAngajat;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
          cb.inchideConexiune();
            return null;    
       }
       
       public static int getAngajatIdDupaCNP(String cnp){
        ConexiuneBazaDeDate cb=ConexiuneBazaDeDate.getInstanta();
        cb.deschideConexiune();
        Connection conexiune=cb.getConexiune();
         try {
            PreparedStatement ps = conexiune.prepareStatement(
                    "select id_angajat from  angajat where cnp=?");
            ps.setString(1, cnp);
            ResultSet rs = ps.executeQuery();
            rs.first();
            int idAngajat = rs.getInt(1);
            cb.inchideConexiune();
            return idAngajat;
        } catch (SQLException e) {
            e.printStackTrace();
        }
           cb.inchideConexiune();
            return -1;
    }
    
        public static Integer completeazaAdeverintaMedicala(int idDosar, int nr, String data, String boli, String recomandari, String servire, String medic ){
        ConexiuneBazaDeDate cb=ConexiuneBazaDeDate.getInstanta();
        cb.deschideConexiune();
        Connection conexiune=cb.getConexiune();
        
        try {
            PreparedStatement ps = conexiune.prepareStatement(
                    "insert into adeverinta_medicala (numar, data, id_dosar, boli, recomandari, servire, medic) values (?,?,?,?,?,?,?)",  Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, nr);
            ps.setString(2, data);
            ps.setInt(3, idDosar);
            ps.setString(4, boli);
            ps.setString(5, recomandari);
            ps.setString(6, servire);
            ps.setString(7, medic);
          
            
            ps.executeUpdate();
            
            ResultSet rsId = ps.getGeneratedKeys();
            if (rsId.next()) {
                Integer id = rsId.getInt(1);
                cb.inchideConexiune();
                return id;
            }
            
        } catch (SQLException e) { 
            e.printStackTrace();
            cb.inchideConexiune();
        }
        cb.inchideConexiune();
        return null;
    }
}

