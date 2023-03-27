
package clase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexiuneBazaDeDate {
   private static ConexiuneBazaDeDate instanta;
   private Connection conexiune;
   
   public ConexiuneBazaDeDate(){ 
   }
   
   
   public static ConexiuneBazaDeDate getInstanta(){
       if (instanta == null)
           instanta = new ConexiuneBazaDeDate();
       return instanta;
   }
   
   public Boolean deschideConexiune() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexiune = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/evimed", "root", "");
            return Boolean.TRUE;
        } catch (ClassNotFoundException | SQLException ignored) {
            return Boolean.FALSE;
        }
    }
   
    public Boolean inchideConexiune() {
        try {
            if (conexiune != null) conexiune.close();
            return Boolean.TRUE;
        } catch (SQLException ignored) {
            return Boolean.FALSE;
        }
    }

    public Connection getConexiune() {
        return conexiune;
    }

    public void setConexiune(Connection conexiune) {
        this.conexiune = conexiune;
    }
}
