/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.encriptaciones;

import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * <b> Clase para generar la encriptacion y desencriptacion de una cadena de
 * texto en base 64 </b>
 *
 * @author fochoac
 * @version $Revision: 1.0 $
 * <p>
 * [$Author: fochoac $, $Date: 15/9/2015 $]
 * </p>
 */
public class EncriptacionBase64 implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * <b> Metodo para desencriptar una cadena encriptada a un arreglo de bytes.
     * </b>
     * <p>
     * [Author: fochoac, Date: 15/9/2015]
     * </p>
     *
     * @param cadena encriptada en base 64
     * @return arreglo de bytes
     */
    @SuppressWarnings("restriction")
    public static final byte[] convertirCadenaAArregloBytes(final String cadena) {
        BASE64Decoder based = new BASE64Decoder();
        try {
            return based.decodeBuffer(cadena);
        } catch (IOException e) {

        }
        return null;
        // return cadena.getBytes(Charset.forName(CHARSET));

    }

    /**
     * <b> Metodo para convertir un arreglo a una cadena encriptada en base 64.
     * </b>
     * <p>
     * [Author: fochoac, Date: 15/9/2015]
     * </p>
     *
     * @param arreglo de bytes
     * @return cadena encriptada
     */
    @SuppressWarnings("restriction")
    public static final String convertirArregloACadena(final byte[] arreglo) {
        BASE64Encoder basee = new BASE64Encoder();
        return basee.encode(arreglo);
    }

    /**
     *
     * <b>
     * Metodo para convertir una cadena en encriptada en base 64.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 01/03/2017 ]  </p>
     */
    public static final String cifrarCadena(String cadena) {
        try {
            Encoder bs64URLEncoder = Base64.getUrlEncoder();
            String encodedURLString = bs64URLEncoder.encodeToString(cadena.getBytes());
            return encodedURLString;
        } catch (Exception e) {
            return null;
        }

    }

    /**
     *
     * <b>
     * Metodo para decofificar una cadena en encriptada en base 64.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 01/03/2017 ]  </p>
     *
     * @param cadena
     * @return
     */
    public static final String descifrarCadena(String cadena) {
        try {
            Decoder bs64URLDecoder = Base64.getUrlDecoder();
            return new String(bs64URLDecoder.decode(cadena));
        } catch (Exception e) {
            return null;
        }

    }

}
