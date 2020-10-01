/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.encriptaciones;

import java.io.Serializable;
import java.util.Date;

import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;
import ec.gob.iessHcam.componente.comun.utilitario.FechasUtil;

/**
 * <b> Clase utilitaria para encriptar la cuenta bancaria del afiliado </b>
 * 
 * @author gvega
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: gvega $, $Date: 9/9/2015 $]
 *          </p>
 */
public class EncriptacionCuentaBancaria implements Serializable {

    private static final long serialVersionUID = 7078667503957365689L;
    private static final char ALFABETO[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7' };
    private static final String PATRON_CEDULA = "ddDGyyD";
    private static final String PATRON_TOKEN = "GDddyyD";
    private static final String IESS = "IESS";

    /**
     * <b> Metodo para encriptar la cuenta del afiliado </b>
     * <p>
     * [Author: fochoac, Date: 9/9/2015]
     * </p>
     *
     * @param cedula
     *            del afiliado
     * @return cadena encriptada
     * @throws ServicioExcepcion
     *             en caso de error
     */
    public static final String encriptaCuenta( final String cedula) throws ServicioExcepcion {

        EncriptacionCuentaBancaria prueba = new EncriptacionCuentaBancaria();
        String token = encode(IESS);
        String path = "?" + prueba.obtenerNombreParametroCedula() + "=" + encodeWithDate(cedula);
        path = path + "&" + prueba.obtenerNombreParametroToken() + "=" + token;
        return path;
    }

    /**
     * <b> Metodo para codificar la cedula. </b>
     * <p>
     * [Author: fochoac, Date: 9/9/2015]
     * </p>
     *
     * @param cedula
     *            del afiliado
     * @return cedula codificada
     */
    public static final String encode(final String cedula) {
        return encode(cedula.getBytes());
    }

    /**
     * <b> Metodo para codificar la cedula con fecha y hora. </b>
     * <p>
     * [Author: fochoac, Date: 9/9/2015]
     * </p>
     *
     * @param cedula
     *            del afiliado
     * @return cadena codificada
     */
    public static final String encodeWithDate(final String cedula) {
        return encode(cedula + (new Date()).getTime());
    }

    /**
     * <b> Metodo utilitario para obtener el nombre del parametro de la cedula </b>
     * <p>
     * [Author: fochoac, Date: 9/9/2015]
     * </p>
     *
     * @return
     */
    private String obtenerNombreParametroCedula() {
        return FechasUtil.formateadorfechaAString(PATRON_CEDULA, new Date());
    }

    /**
     * <b> Metodo utilitario para obtener el patron nombre del token </b>
     * <p>
     * [Author: fochoac, Date: 9/9/2015]
     * </p>
     *
     * @return cadena del token
     */
    private String obtenerNombreParametroToken() {
        return FechasUtil.formateadorfechaAString(PATRON_TOKEN, new Date());
    }

    /**
     * <b> Metodo para codificar un arreglo de bytes. </b>
     * <p>
     * [Author: fochoac, Date: 9/9/2015]
     * </p>
     *
     * @param data
     *            a codificar
     * @return cadena codificada
     */
    private static final  String encode(final byte data[]) {
        char chars[] = new char[(data.length * 8) / 5 + (data.length % 5 == 0 ? 0 : 1)];
        int i = 0;
        int j = 0;
        int index = 0;
        for (; i < chars.length; i++)
            if (index > 3) {
                int b = data[j] & 255 >> index;
                index = (index + 5) % 8;
                b <<= index;
                if (j < data.length - 1)
                    b |= (data[j + 1] & 0xff) >> 8 - index;
                chars[i] = ALFABETO[b];
                j++;
            } else {
                chars[i] = ALFABETO[data[j] >> 8 - (index + 5) & 0x1f];
                index = (index + 5) % 8;
                if (index == 0)
                    j++;
            }

        return new String(chars);
    }
}
