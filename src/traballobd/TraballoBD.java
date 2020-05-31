package traballobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

/**
 *
 * @author dcancelas
 */
public class TraballoBD {
    
    public static void main(String[] args) {
        crearBD();
        Operacions.crearTaboa();
        Operacions.insertar("12345A", "Antonio", 36);
        Operacions.consultar("select * from taboa1");
        Operacions.actualizar("12345A", "Pipo", 42);
        Operacions.consultar("select * from taboa1");
    }
    
    /*public static void crearBD() {

        String url = "jdbc:sqlite:E:/DANIE/Documents/NetBeansProjects/TraballoBD/proba.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("O nome do driver é " + meta.getDriverName());
                System.out.println("A base de datos creouse correctamente");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/

    public static void crearBD() {
        try (Connection conn = conectar();) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("O nome do driver é " + meta.getDriverName());
                System.out.println("A base de datos creouse correctamente");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static Connection conectar() {
        String url = "jdbc:sqlite:E:/DANIE/Documents/NetBeansProjects/TraballoBD/proba.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("A conexión coa base de datos realizouse correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
  
}
