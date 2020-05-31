package traballobd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static traballobd.TraballoBD.conectar;
import java.sql.PreparedStatement;

/**
 *
 * @author dcancelas
 */
public class Operacions {
        
    public static void crearTaboa() {        
        String sql = "CREATE TABLE IF NOT EXISTS taboa1 (\n"
                    + "dni text PRIMARY KEY,\n"
                    + "nome text NOT NULL,\n"
                    + "idade integer\n"
                    + ");";
        
        try (Connection conn = conectar();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("A táboa creouse correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void insertar(String dni, String nome, int idade) {
        String sql = "INSERT INTO taboa1(dni,nome,idade) VALUES(?,?,?)";

        try (Connection conn = conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dni);
            pstmt.setString(2, nome);
            pstmt.setInt(3, idade);
            pstmt.executeUpdate();
            System.out.println("Os datos insertáronse correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void actualizar(String dni, String nome, int idade) {
        String sql = "UPDATE taboa1 SET nome=?,idade=? WHERE dni=?";

        try (Connection conn = conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setInt(2, idade);
            pstmt.setString(3, dni);
            pstmt.executeUpdate();
            System.out.println("Os datos actualizáronse correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void consultar(String sql){
        AsciiTable table = new AsciiTable();
        table.setMaxColumnWidth(15);
        table.getColumns().add(new AsciiTable.Column("DNI"));
        table.getColumns().add(new AsciiTable.Column("Nome"));
        table.getColumns().add(new AsciiTable.Column("Idade"));
        
        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                AsciiTable.Row row = new AsciiTable.Row();
                table.getData().add(row);
                row.getValues().add(rs.getString("dni"));
                row.getValues().add(rs.getString("nome"));
                row.getValues().add(rs.getString("idade"));
            }
            
            table.calculateColumnWidth();
            table.render();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*public static void consultar(String sql){
        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                System.out.println(rs.getString("dni") + "\t" +
                                   rs.getString("nome") + "\t" +
                                   rs.getInt("idade"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/
    
}
