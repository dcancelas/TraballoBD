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
}
