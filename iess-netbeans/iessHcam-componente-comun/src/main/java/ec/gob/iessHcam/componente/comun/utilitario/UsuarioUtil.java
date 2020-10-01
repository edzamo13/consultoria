/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario;

import java.math.BigDecimal;

import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;
import ec.gob.iessHcam.componente.comun.logs.Log;

/**
 * <b> Clase utilitario para validar los datos del usuario. </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 28/10/2015 $]
 *          </p>
 */
public class UsuarioUtil {

    private UsuarioUtil() {
        super();
    }

    /**
     * <b> Metodo utilitario para validar la cedula del afiliado. </b>
     * <p>
     * [Author: fochoac, Date: 28/10/2015]
     * </p>
     *
     * @param cedula
     *            del afiliado
     * @return true si es valida
     */
    private static boolean validaCedula(String cedula) {
        if (cedula != null && cedula.length() > 10) {
            cedula = cedula.substring(0, 10);
        }

        int[] modulo9 = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
        boolean valorRetorno = true;
        BigDecimal verif = new BigDecimal(0);
        if (cedula.length() != 10)
            valorRetorno = false;
        else {
            for (int i = 0; i < 9; i++) {
                BigDecimal temp = new BigDecimal(new BigDecimal(cedula.substring(i, (i + 1))).multiply(new BigDecimal(modulo9[i])).toString());
                if (temp.doubleValue() > 9)
                    temp = temp.subtract(new BigDecimal("9"));
                verif = verif.add(temp);
            }
            if (verif.doubleValue() % 10 == 0)
                if (Integer.parseInt(cedula.substring(9, 10)) == 0)
                    valorRetorno = true;
                else
                    valorRetorno = false;
            else if ((10 - (verif.doubleValue() % 10)) == Integer.parseInt(cedula.substring(9, 10)))
                valorRetorno = true;
            else
                valorRetorno = false;
        }
        return valorRetorno;
    }

    /**
     * <b> Metodo utilitario para validar el ruc de la persona. </b>
     * <p>
     * [Author: fochoac, Date: 28/10/2015]
     * </p>
     *
     * @param ruc
     *            del afiliado
     * @return true si cumple
     */
    private static boolean validacionRUC(String ruc) {
        final int NUM_PROVINCIAS = 24;
        int[] coeficientes = { 4, 3, 2, 7, 6, 5, 4, 3, 2 };
        int constante = 11;
        boolean resp_dato = false;

        final int prov = Integer.parseInt(ruc.substring(0, 2));
        if (!((prov < 0) && (prov <= NUM_PROVINCIAS))) {
            resp_dato = false;
        }

        int[] d = new int[10];
        int suma = 0;

        for (int i = 0; i < d.length; i++) {
            d[i] = Integer.parseInt(ruc.charAt(i) + "");
        }

        for (int i = 0; i < d.length - 1; i++) {
            d[i] = d[i] * coeficientes[i];
            suma += d[i];
        }

        int aux, resp;

        aux = suma % constante;
        resp = constante - aux;

        resp = (aux == 0) ? 0 : resp;

        if (resp == d[9]) {
            resp_dato = true;
        } else {
            resp_dato = false;
        }
        return resp_dato;
    }

    /**
     * <b> Metodo utilitario para validar el ruc y la cedula. </b>
     * <p>
     * [Author: fochoac, Date: 28/10/2015]
     * </p>
     *
     * @param identificacion
     *            cedula o ruc
     * @return true so es valido
     * @throws ServicioExcepcion
     *             en caso de error
     */
    public static boolean validarIdentificacion(String identificacion) throws ServicioExcepcion {
        try {
            if (identificacion != null && identificacion.length() == 10) {
                return validaCedula(identificacion);
            } else if (identificacion != null && identificacion.length() == 13) {
                boolean valido = false;
                valido = validacionRUC(identificacion);
                if (!valido) {
                    valido = validaCedula(identificacion);
                }
                return valido;
            } else {
                return false;
            }
        } catch (Exception e) {
            Log.error(UsuarioUtil.class.getName(), "No se pudo validar el documento.", e);
            throw new ServicioExcepcion(e);
        }

    }
}
