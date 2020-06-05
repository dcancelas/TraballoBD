package traballobd;

/**
 *
 * @author dcancelas
 */
public class TraballoBD {

    public static void main(String[] args) {
        Operacions oper = new Operacions();
        oper.conectar();
        oper.crearTaboa();
        oper.insertar("12345A", "Antonio", 36);
        oper.consultar("select * from taboa1");
        //oper.actualizar("12345A", "Pipo", 42);
        oper.desconectar();
        oper.consultar("select * from taboa1");
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
    
}
