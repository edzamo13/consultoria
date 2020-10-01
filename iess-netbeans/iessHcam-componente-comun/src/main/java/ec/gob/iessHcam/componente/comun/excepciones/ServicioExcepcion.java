/* 
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados 
 */
package ec.gob.iessHcam.componente.comun.excepciones;

/**
 * <b> Clase de excepción de tipo aplicación que hace rollback al encontrar un fallo en la transacción. </b>
 *
 * @author christian
 *         <p>
 *         [$Author: christian $, $Date: 06/07/2015]
 *         </p>
 */
public class ServicioExcepcion extends Exception {

    private static final long serialVersionUID = -5401498301486094378L;

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 10/9/2015]
     * </p>
     *
     */
    public ServicioExcepcion() {
    }

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 10/9/2015]
     * </p>
     *
     * @param message
     *            del error
     */
    public ServicioExcepcion(String message) {
        super(message);
    }

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 10/9/2015]
     * </p>
     *
     * @param cause
     *            del error
     */
    public ServicioExcepcion(Throwable cause) {
        super(cause);
    }

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 10/9/2015]
     * </p>
     *
     * @param message
     *            del error
     * @param cause
     *            del error
     */
    public ServicioExcepcion(String message, Throwable cause) {
        super(message, cause);
    }

}
