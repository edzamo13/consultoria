/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ComunEnum;

/**
 * <b> Clase utilitaria para trabajar con valores numericos. </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 21/8/2015 $]
 *          </p>
 */
public class NumerosUtil {
    /**
     * Grupos de mil
     */
    private static final String[] GRUPOS = { "", "millon", "billon", "trillon" };
    /**
     * Unidades
     */
    private static final String[] UNIDADES = { "", "un", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve" };
    /**
     * Decenas
     */
    private static final String[] DECENA = { "", "once", "doce", "trece", "catorce", "quince", "dieciseis", "diecisiete", "dieciocho", "diecinueve" };
    /**
     * Unidades de decenas
     */
    private static final String[] DECENAS = { "", "diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa" };
    /**
     * UNidades de centenas
     */
    private static final String[] CENTENAS = { "", "ciento", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos", "ochocientos", "novecientos" };
    /**
     * Numero magico para convertir de caracter 5 a su equivalente 5 como entero
     */
    private static final int NUMERO_MAGICO = 48;

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 10/9/2015]
     * </p>
     *
     */
    private NumerosUtil() {
        super();
    }

    /**
     * <b> Metodo utilitario para redondear un numero decimal al numero de decimales que se necesite </b>
     * <p>
     * [$Author: fochoac $, $Date: 22/07/2015]
     * </p>
     *
     * @param valor
     *            a redondear
     * @return valor redondeado
     *
     */
    public static final BigDecimal redondearDecimales(final BigDecimal valor, final int numeroDecimales) {

        return valor.setScale(numeroDecimales, ComunEnum.MODO_REDONDEO);
    }

    /**
     * <b> Metodo para validar si una cadena es de tipo entero. </b>
     * <p>
     * [Author: fochoac, Date: 29/7/2015]
     * </p>
     *
     * @param cadena
     *            que contiene numeros
     * @return true si es entero
     */
    public static final boolean validarNumeroEntero(String cadena) {
        try {
            if (null != cadena && !cadena.isEmpty()) {
                Long.valueOf(cadena).longValue();
            } else {
                return false;
            }

            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * <b> Metodo para validar si una cadena es de tipo decimal. </b>
     * <p>
     * [Author: fochoac, Date: 29/7/2015]
     * </p>
     *
     * @param cadena
     *            que contiene numeros decimales: 1.0
     * @return true si es decimal
     */
    public static final boolean validarNumeroDecimal(String cadena) {
        try {
            if (null != cadena && !cadena.isEmpty()) {
                Double.parseDouble(cadena);
            } else {
                return false;
            }

            return true;
        } catch (NumberFormatException nfe) {

            return false;
        }
    }

    /**
     * <b> Metodo para convertir una cadena de texto a un entero. </b>
     * <p>
     * [Author: fochoac, Date: 29/7/2015]
     * </p>
     *
     * @param cadenaNumerica
     *            que contiene solo numeros
     * @return numero convertido
     */
    public static final Integer convertirCadenaNumero(String cadenaNumerica) {
        if (validarNumeroEntero(cadenaNumerica)) {
            return Integer.parseInt(cadenaNumerica);
        }
        return null;
    }

    /**
     * <b> Metodo para convertir una cadena de texto a un arreglo de numeros. </b>
     * <p>
     * [Author: fochoac, Date: 29/7/2015]
     * </p>
     *
     * @param cadenaNumerica
     *            que contiene solo numeros
     * @return arreglo de enteros
     */
    public static final Integer[] convertirCadenaArrayNumeros(String cadenaNumerica) {
        if (validarNumeroEntero(cadenaNumerica)) {
            Integer[] arreglo = new Integer[cadenaNumerica.length()];
            for (int i = 0; i < cadenaNumerica.length(); i++) {
                arreglo[i] = new Integer(cadenaNumerica.charAt(i)) - NUMERO_MAGICO;
            }
            return arreglo;
        }
        return new Integer[0];
    }

    /**
     * <b> Metodo para rellenar a la izquierda una cadena con el caracter ingresado hasta completar el numero de carcateres totales. completar el numero. </b>
     * <p>
     * Ejemplo: NumerosUtil.completarCadenaCerosIzquierda("54", 5,'A')
     * </p>
     * <p>
     * <b>Resultado: </b>AAA54
     * </p>
     * <p>
     * [Author: fochoac, Date: 30/7/2015]
     * </p>
     *
     * @param cadena
     *            a rellenar
     * @param numeroCaracteres
     *            total a completar
     * @param caracter
     *            con el cual se va a rellenar
     * @return cadena rellenada
     * @return cadena rellanda
     */
    public static final String completarCadenaIzquierda(String cadena, int numeroCaracteres, char caracter) {
        char[] patron = obtenerPatronRelleno(cadena, numeroCaracteres, caracter);
        StringBuilder builder = new StringBuilder();
        builder.append(patron);
        builder.append(cadena);
        return builder.toString();
    }

    /**
     * <b> Metodo para rellenar una cadena a la derecha con un caracter ingresado hasta completar el numero de caracteres necesarios. </b>
     * 
     * <p>
     * Ejemplo: NumerosUtil.completarCadenaCerosDerecha("54", 5,'0')
     * </p>
     * <p>
     * <b>Resultado: 54000</b>
     * </p>
     * [Author: fochoac, Date: 30/7/2015] </p>
     *
     * @param cadena
     *            a rellenar
     * @param numeroCaracteres
     *            total a completar
     * @param caracter
     *            con el cual se va a rellenar
     * @return cadena rellenada
     */
    public static final String completarCadenaDerecha(String cadena, int numeroCaracteres, char caracter) {
        char[] patron = obtenerPatronRelleno(cadena, numeroCaracteres, caracter);
        StringBuilder builder = new StringBuilder();
        builder.append(cadena);
        builder.append(patron);
        return builder.toString();
    }

    /**
     * <b> Metodfo utilitario para obtener el patron de relleno </b>
     * <p>
     * [Author: fochoac, Date: 21/8/2015]
     * </p>
     *
     * @param cadena
     *            a rellenar
     * @param numeroCeros
     *            a poner
     * @param caracter
     *            a colocar en relleno
     * @return cadena rellenada
     */
    private static final char[] obtenerPatronRelleno(String cadena, int numeroCeros, char caracter) {
        int cerosAgregar = numeroCeros - cadena.length();
        char[] ceros = new char[cerosAgregar];
        for (int i = 0; i < cerosAgregar; i++) {
            ceros[i] = caracter;
        }
        return ceros;
    }

    /**
     * <b> Metodo utilitario para transformar un numero a su representacion en idioma castellano </b>
     * <p>
     * [Author: fochoac, Date: 21/8/2015]
     * </p>
     *
     * @param valor
     *            a convertir
     * @return cadena de texto
     */
    public static final String numeroACastellano(final double valor) {
        long n = (long) valor;
        double sobrante = Math.round((valor - n) * 100);
        long m = (long) sobrante;

        String datoDec = m > 0 ? String.valueOf(m) : "00";
        StringBuilder sb = new StringBuilder();
        sb.append("CON ").append(datoDec).append("/100");
        String adicional = sb.toString();
        String resultado = "";

        int grupo = 0;
        while (n != 0 && grupo < GRUPOS.length) {
            long fragmento = n % 1000000;
            int millarAlto = (int) (fragmento / 1000);
            int millarBajo = (int) (fragmento % 1000);
            n = n / 1000000;
            String nombreGrupo = GRUPOS[grupo];
            if (fragmento > 1 && grupo > 0) {
                nombreGrupo = nombreGrupo.concat("es");
            }
            if ((millarAlto != 0) || (millarBajo != 0)) {
                sb = new StringBuilder();
                if (millarAlto >= 1) {
                    sb.append(millarAlto == 1 ? "" : millarATexto(millarAlto)).append(" mil ").append(millarATexto(millarBajo)).append(" ").append(nombreGrupo).append(" ").append(resultado);
                    resultado = sb.toString();
                } else {
                    sb.append(millarATexto(millarBajo)).append(" ").append(nombreGrupo).append(" ").append(resultado);
                    resultado = sb.toString();
                }
            }
            grupo++;
        }
        return resultado.toUpperCase() + adicional;
    }

    /**
     * <b> Metodo para obtener la representacion en castellano de cifras con millares </b>
     * <p>
     * [Author: fochoac, Date: 21/8/2015]
     * </p>
     *
     * @param valor
     *            a convertir
     * @return cadena
     */
    public static final String millarATexto(final int valor) {
        int n = valor;
        if (n == 0) {
            return "";
        }

        int centenas = n / 100;
        n = n % 100;
        int decenas = n / 10;
        int unidades = n % 10;

        String sufijo = "";

        if (unidades == 0) {
            sufijo = DECENAS[decenas];
            if (decenas == 0 && centenas == 1) {
                return "cien";
            }
        } else {
            switch (decenas) {
            case 0:
                sufijo = UNIDADES[unidades];
                break;

            case 1:
                sufijo = DECENA[unidades];
                break;

            case 2:
                sufijo = "veinti" + UNIDADES[unidades];
                break;

            default:
                sufijo = DECENAS[decenas] + " y " + UNIDADES[unidades];
                break;
            }
        }

        if (centenas != 1) {
            return CENTENAS[centenas] + " " + sufijo;
        }

        return "ciento " + sufijo;
    }

    /**
     * <b> Metodo utilitario para convertir un valor decimal a una cadena de texto. </b>
     * <p>
     * [Author: fochoac, Date: 10/11/2015]
     * </p>
     *
     * @param valor
     *            {@link BigDecimal}, {@link Double}, {@link Float} y sus derivados primitivos.
     * @param patron
     *            por defecto es ############0.00 pero se puede especificar uno diferente en base al {@link DecimalFormat}.
     * @return cadena convertida
     */
    public static final String devolverCantidadEnMoneda(final Object valor, final String patron) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setPatternSeparator(',');
        NumberFormat formato;
        if (patron != null && !patron.isEmpty()) {
            formato = new DecimalFormat(patron, simbolo);

        } else {
            formato = new DecimalFormat("############0.00", simbolo);
        }

        return formato.format(valor);
    }

}
