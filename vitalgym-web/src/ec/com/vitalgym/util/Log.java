
package ec.com.vitalgym.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 *
 * @author christian
 *         <p>
 *         [$Author: christian $, $Date: 07/07/2015]
 *         </p>
 */
public class Log {

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 10/9/2015]
     * </p>
     *
     */
    private Log() {
        super();
    }

    /**
     * <b> Metodo utilitario para colocar un mensaje de informacion. </b>
     * <p>
     * [Author: fochoac, Date: 21/8/2015]
     * </p>
     *
     * @param clase
     *            a loguear
     * @param mensaje
     *            a loguear
     */
    public static void info(String clase, String mensaje) {
        Logger.getLogger(clase).log(Level.INFO, mensaje.toUpperCase());
    }

    /**
     * <b> Metodo utilitario para colocar un mensaje de advertencia. </b>
     * <p>
     * [Author: fochoac, Date: 21/8/2015]
     * </p>
     *
     * @param clase
     *            a loguear
     * @param mensaje
     *            a loguear
     * @param e
     *            excepcion a registrar
     */
    public static void advertencia(String clase, String mensaje, Exception e) {
        Logger.getLogger(clase).log(Level.WARNING, mensaje.toUpperCase(), e);
    }

    /**
     * <b> Metodo utilitario para colocar un mensaje de error. </b>
     * <p>
     * [Author: fochoac, Date: 21/8/2015]
     * </p>
     *
     * @param clase
     *            a loguear
     * @param mensaje
     *            a loguear
     * @param e
     *            excepcion a registrar
     */
    public static void error(String clase, String mensaje, Exception e) {
        Logger.getLogger(clase).log(Level.SEVERE, mensaje.toUpperCase(), e);
    }

}
