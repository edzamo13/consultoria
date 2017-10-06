
package ec.com.vitalgym.sql;

/**
 * <b>
 * Clase en donde se encuentran los querys nativos.
 * </b>
 *
 * @author ezamoram
 * @version $Revision: 1.0 $
 * <p>
 * [$Author: ezamoram $, $Date: 14/09/2016 $]</p>
 */
public class Sql {

    /**
     * Obtiene el Objeto por Codigo .
     */
    public static final String OBTENER_OPCIONES_MENU_MENU_FALTANTE = "select * from modulos.rh_glb_opciones_menu where opc_codigo not in( select opc_codigo  from modulos.rh_glb_permisos_opciones_menu_perfil  prm where pef_codigo= ? ) order by opc_codigo";

    /**
     *
     */
    private Sql() {

    }

}
