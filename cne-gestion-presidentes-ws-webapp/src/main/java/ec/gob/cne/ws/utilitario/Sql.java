
package ec.gob.cne.ws.utilitario;


public class Sql {


    public static final String SQL_USUARIO_POR_USR = "SELECT idusuario,usr_usuario,usr_password FROM usuario u where u.usr_usuario=?";
  

    /**
     * Constructor.
     */
    private Sql() {
    }
}
