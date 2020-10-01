/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario;

import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import ec.gob.iessHcam.componente.comun.logs.Log;
import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ComunEnum;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <b> Metodo utilitario para trabajar con fechas. </b>
 *
 * @author fochoac
 * @version $Revision: 1.0 $
 * <p>
 * [$Author: fochoac $, $Date: 21/8/2015 $]
 * </p>
 */
public class FechasUtil {

    final static long MILISEGUNDOS_POR_DIA = 24 * 60 * 60 * 1000;
    public static final Map<Integer, String> CATALOGO_MESES;

    static {
        CATALOGO_MESES = new HashMap<Integer, String>();
        CATALOGO_MESES.put(1, "ENERO");
        CATALOGO_MESES.put(2, "FEBRERO");
        CATALOGO_MESES.put(3, "MARZO");
        CATALOGO_MESES.put(4, "ABRIL");
        CATALOGO_MESES.put(5, "MAYO");
        CATALOGO_MESES.put(6, "JUNIO");
        CATALOGO_MESES.put(7, "JULIO");
        CATALOGO_MESES.put(8, "AGOSTO");
        CATALOGO_MESES.put(9, "SEPTIEMBRE");
        CATALOGO_MESES.put(10, "OCTUBRE");
        CATALOGO_MESES.put(11, "NOVIEMBRE");
        CATALOGO_MESES.put(12, "DICIEMBRE");

    }

    /**
     * <b> Constructor de la clase </b>
     * <p>
     * [$Author: fochoac $, $Date: 22/07/2015]
     */
    private FechasUtil() {
        super();
    }

    /**
     * <b> Metodo utilitario para convertir un cadena de texto a un tipo DATE
     * </b>
     * <p>
     * [$Author: fochoac $, $Date: 22/07/2015]
     * </p>
     *
     * @param patron a utilizar obtenido de {@link ComunEnum}
     * @param cadenaTexto a formatear
     * @return fecha convertida
     *
     */
    public static final Date formateadorStringAFecha(final String patron, final String cadenaTexto) {
        SimpleDateFormat formateador = new SimpleDateFormat(patron, ComunEnum.LOCALE_ECUADOR);
        try {
            return formateador.parse(cadenaTexto);
        } catch (ParseException e) {
            Log.error(FechasUtil.class.getSimpleName(), "No se pudo convertir la cadena de texto a la fecha dada con el patron " + patron, e);
            return null;
        }
    }

    /**
     * <b> Metodo utilitario para convertir una fecha a su equivalente de
     * texto.. </b>
     * <p>
     * Ejemplo: 12/12/2013 = 12 de diciembre de 2015
     * </p>
     * <p>
     * [Author: fochoac, Date: 31/12/2015]
     * </p>
     *
     * @param fecha a convertir
     * @return
     */
    public static String obtenerFechaTexto(Date fecha) {
        Integer[] array = obtenerArrayFecha(fecha);
        return array[2] + " de " + CATALOGO_MESES.get(array[1]).toLowerCase() + " de " + array[0];
    }

    /**
     * <b> Metodo utilitario para convertir una fecha a string en base a un
     * patron </b>
     * <p>
     * [$Author: fochoac $, $Date: 22/07/2015]
     * </p>
     *
     * @param patron a utilizar obtenido de {@link ComunEnum}
     * @param fecha a convertir
     * @return cadena de texto de la fecha
     *
     */
    public static final String formateadorfechaAString(final String patron, final Date fecha) {
        SimpleDateFormat formateador = new SimpleDateFormat(patron, ComunEnum.LOCALE_ECUADOR);
        return formateador.format(fecha);
    }

    /**
     * <b> Metodo utilitario para obtener el primer dia del mes en curso </b>
     * <p>
     * [$Author: fochoac $, $Date: 22/07/2015]
     * </p>
     *
     *
     * @return primer dia del mes en curso
     *
     */
    public static final Date obtenerPrimerDiaDelMes() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMinimum(Calendar.DAY_OF_MONTH), cal.getMinimum(Calendar.HOUR_OF_DAY), cal.getMinimum(Calendar.MINUTE), cal.getMinimum(Calendar.SECOND));
        return cal.getTime();
    }

    /**
     * <b> Metodo utilitario para obtener el primer dia del mes en curso pero
     * restando o sumando un numero de anios . </b>
     * <p>
     * [Author: fochoac, Date: 30/10/2015]
     * </p>
     *
     * @param numeroAniosConSigno numero de anios sumados (+) o restados(-)
     * @return
     */
    public static final Date obtenerPrimerDiaDelMesActualPorAnio(final int numeroAniosConSigno) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, numeroAniosConSigno);
        return cal.getTime();
    }

    /**
     * <b> Metodo utilitario para obtener el primer dia del mes dado + el numero
     * de dias que se requiera </b>
     * <p>
     * [$Author: fochoac $, $Date: 22/07/2015]
     * </p>
     *
     * @param fecha a validar
     * @param sumarDias numero de dias a agregar
     *
     * @return fecha sumada el numero de dias adicional
     *
     */
    public static final Date obtenerPrimerDiaDelMes(final Date fecha, final int sumarDias) {
        Calendar cal = Calendar.getInstance(ComunEnum.TIMEZONE_ECUADOR, ComunEnum.LOCALE_ECUADOR);
        cal.setTime(fecha);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMinimum(Calendar.DAY_OF_MONTH), cal.getMinimum(Calendar.HOUR_OF_DAY), cal.getMinimum(Calendar.MINUTE), cal.getMinimum(Calendar.SECOND));
        cal.add(Calendar.DAY_OF_MONTH, sumarDias);
        return cal.getTime();
    }

    /**
     * <b> Metodo utilitario para obtener el ultimo dia del mes en curso </b>
     * <p>
     * [$Author: fochoac $, $Date: 22/07/2015]
     * </p>
     *
     *
     * @return fecha con el ultimo dia del mes
     *
     */
    public static Date obtenerUltimoDiaDelMes() {
        Calendar cal = Calendar.getInstance(ComunEnum.TIMEZONE_ECUADOR, ComunEnum.LOCALE_ECUADOR);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMaximum(Calendar.DAY_OF_MONTH), cal.getMaximum(Calendar.HOUR_OF_DAY), cal.getMaximum(Calendar.MINUTE), cal.getMaximum(Calendar.SECOND));
        return cal.getTime();
    }

    /**
     * <b> Metodo utilitario para obtener el ultimo dia del mes de una fecha
     * dada </b>
     * <p>
     * [$Author: fochoac $, $Date: 22/07/2015]
     * </p>
     *
     * @param fecha fecha a validar
     *
     * @return fecha del ultimo dia
     *
     */
    public static final Date obtenerUltimoDiaDelMes(final Date fecha) {
        Calendar cal = Calendar.getInstance(ComunEnum.TIMEZONE_ECUADOR, ComunEnum.LOCALE_ECUADOR);
        cal.setTime(fecha);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMaximum(Calendar.DAY_OF_MONTH), cal.getMaximum(Calendar.HOUR_OF_DAY), cal.getMaximum(Calendar.MINUTE), cal.getMaximum(Calendar.SECOND));
        return cal.getTime();
    }

    /**
     * <b> Metodo utilitario para obtener el ultimo dia del mes menos el numero
     * de dias especificado </b>
     * <p>
     * [$Author: fochoac $, $Date: 22/07/2015]
     * </p>
     *
     * @param fecha a validar
     * @param restarDias numero de dias a restart
     * @return ultimo dia del mes - dias restados
     *
     */
    public static final Date obtenerUltimoDiaDelMes(final Date fecha, final int restarDias) {
        Calendar cal = Calendar.getInstance(ComunEnum.TIMEZONE_ECUADOR, ComunEnum.LOCALE_ECUADOR);
        cal.setTime(fecha);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMaximum(Calendar.DAY_OF_MONTH), cal.getMaximum(Calendar.HOUR_OF_DAY), cal.getMaximum(Calendar.MINUTE), cal.getMaximum(Calendar.SECOND));
        cal.add(Calendar.DAY_OF_WEEK, -(restarDias));
        return cal.getTime();
    }

    /**
     * <b> Metodo utilitario para obtener el ultimo dia del mes pasado </b>
     * <p>
     * [$Author: fochoac $, $Date: 22/07/2015]
     * </p>
     *
     * @return fecha con el ultimo dia del mes anterior
     *
     */
    public static final Date obtenerUltimoDiaDelMesAnterior() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMaximum(Calendar.DAY_OF_MONTH), cal.getMaximum(Calendar.HOUR_OF_DAY), cal.getMaximum(Calendar.MINUTE), cal.getMaximum(Calendar.SECOND));
        cal.add(Calendar.DAY_OF_WEEK, -1);
        return cal.getTime();
    }

    /**
     * <b> Metodo para convertir un timestamp de BASE DE DATOS a un formato
     * estandar de JAVA . </b>
     * <p>
     * [Author: fochoac, Date: 24/7/2015]
     * </p>
     *
     * @param value objecto a validar
     * @param patron patron a utilizar en la conversion
     * @return estampilla de tiempo en formato SQL
     * @throws ParseException error generado en caso de algun error
     */
    public static final Timestamp convertirStringATimestampSql(final Object value, final String patron) throws ParseException {
        final DateFormat formateador = new SimpleDateFormat(patron);
        if (value == null) {
            return null;
        }
        if (value instanceof Timestamp) {
            return (Timestamp) value;
        }
        if (value instanceof String) {
            if ("".equals((String) value)) {
                return null;
            }
            return new Timestamp(formateador.parse((String) value).getTime());
        }

        return new Timestamp(formateador.parse(value.toString()).getTime());
    }

    /**
     * <b> Metodo para obtener la diferencia en dias entre dos fechas. </b>
     * <p>
     * [Author: fochoac, Date: 28/7/2015]
     * </p>
     *
     * @param fechaInicio fecha a validar
     * @param fechaFin fecha a validar mayor que la fecha de inicio
     * @return numero de dias entre la fechafin y fechainicio
     */
    public static final double obtenerDiferenciaDias(final Date fechaInicio, final Date fechaFin) {
        long fechaInicial = fechaInicio.getTime();
        long fechaFinal = fechaFin.getTime();
        long diferencia = fechaFinal - fechaInicial;
        return new Double(diferencia / (1000 * 60 * 60 * 24)) + 1;
    }

    /**
     * <b> Metodo utilitario para obtener una fecha sin horas, minutos y
     * segundos. </b>
     * <p>
     * [Author: fochoac, Date: 29/7/2015]
     * </p>
     *
     * @param fechaEliminarTiempo fecha a suprimir el tiempo
     * @return fecha sin tiempo
     */
    public static final Date obtenerFechaSinTiempo(final Date fechaEliminarTiempo) {
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(fechaEliminarTiempo);
        fecha.set(Calendar.SECOND, 0);
        fecha.set(Calendar.MILLISECOND, 0);
        fecha.set(Calendar.HOUR, 0);
        fecha.set(Calendar.MINUTE, 0);
        return fecha.getTime();

    }

    /**
     *
     * <b> Metodo para comparar dos fechas </b>
     * <p>
     * [Author: fochoac, Date: 28/7/2015]
     * </p>
     *
     * @param fechaInicio fecha de inicio
     * @param fechaFin fecha de fin
     * @param compararTiempo true si se desea que valider la fecha sin horas,
     * minutos, segundos, false para considerar todos los datos
     * @return 1 si la fechaFin es mayor que la fechaInicio, -1 si la fecha fin
     * es menor que la fecha de inicio y 0 si son iguales
     */
    public static final int compararFechas(final Date fechaInicio, final Date fechaFin, boolean compararTiempo) {
        Calendar fecha1 = Calendar.getInstance();
        Calendar fecha2 = Calendar.getInstance();
        if (compararTiempo) {
            fecha1.setTime(obtenerFechaSinTiempo(fechaInicio));
            fecha2.setTime(obtenerFechaSinTiempo(fechaFin));

        } else {
            fecha1.setTime(fechaInicio);
            fecha2.setTime(fechaFin);

        }
        return fecha2.compareTo(fecha1);

    }

    /**
     *
     * <b> Metodo para obtener el numero de anios que posee una persona en la
     * actualidad. </b>
     * <p>
     * [Author: fochoac, Date: 28/7/2015]
     * </p>
     *
     * @param fechaNacimiento fecha de nacimiento
     * @return numero de años
     */
    public static final int obtenerAnios(final Date fechaNacimiento) {
        int edadnumero = 0;
        Date ahora = new Date();
        Calendar calendarioUtil = new GregorianCalendar();
        if (fechaNacimiento != null) {
            calendarioUtil.setTimeInMillis(ahora.getTime() - fechaNacimiento.getTime());
            edadnumero = calendarioUtil.get(Calendar.YEAR) - 1970;
        }

        if (edadnumero < 0) {
            edadnumero = 0;
        }

        return edadnumero;
    }

    /**
     * <b> Metodo utilitario para retornar el anio(0), mes(1), dia(2). </b>
     * <p>
     * [Author: fochoac, Date: 6/8/2015]
     * </p>
     *
     * @param fecha a convertir
     * @return arreglo con el anio, mes, dia respectivamente
     */
    public static final Integer[] obtenerArrayFecha(Date fecha) {
        String[] lista = formateadorfechaAString(ComunEnum.PATRON_FECHA1.getDescripcion(), fecha).split("/");
        Integer[] resultado = new Integer[lista.length];
        for (int i = 0; i < lista.length; i++) {
            resultado[i] = Integer.valueOf(lista[i]);
        }
        return resultado;
    }

    /**
     * Metodo que determina si una fecha esta entre dos fechas.
     *
     * @param fechaInicio fecha inicial para la comparacion
     * @param fechaHasta fecha final del rango de comparacion
     * @param fecha fecha a comparar
     * @return retorna verdadero si esta entre fecha y falso si no lo esta
     * @throws RuntimeException
     * @author Cristian Villarreal
     */
    public static final boolean estaEntreDosFecha(final Date fechaInicio, final Date fechaHasta, final Date fecha) throws RuntimeException {
        try {
            if (fecha.after(fechaHasta) || fecha.before(fechaInicio)) {
                return false;
            }
            return true;

        } catch (NullPointerException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Determina el primer d&iacute;a del mes siguinete de una fecha.
     * <p>
     *
     * @param fecha fecha base para determinar el mes siguiente.
     * @return retorna el primer d&iacute;a del mes siguiente.
     * @throws RuntimeException
     */
    public static final Date calcularMesSiguiente(final Date fecha) throws RuntimeException {
        Calendar calendario = new GregorianCalendar();
        try {
            calendario.setTime(fecha);
            calendario.add(Calendar.MONTH, 1);
            calendario.set(Calendar.DATE, 1);
        } catch (RuntimeException e) {
            throw new RuntimeException("ERROR AL CALCULAR MES SIGUIENTE. \\ \n" + e.getMessage(), e);
        }
        return calendario.getTime();
    }

    /**
     * Obtiene los mese cumplidos de una persona
     * <p>
     *
     * @param fechaDesde a validar
     * @param fechaHasta a validar
     *
     * @return Numero de meses cumplidos.
     */
    public static final int mesesCumplidos(Date fechaDesde, Date fechaHasta) {

        int anios = aniosCumplidos(fechaDesde, fechaHasta);

        int meses = dateDiff(fechaDesde, fechaHasta).get(Calendar.MONTH);

        return anios * 12 + meses;
    }

    /**
     * Obtiene los anios cumplidos de una persona.
     * <p>
     *
     * @param fechaDesde a validar
     * @param fechaHasta a validar
     *
     * @return Numero de anios cumplidos.
     */
    public static final int aniosCumplidos(Date fechaDesde, Date fechaHasta) {
        return dateDiff(fechaDesde, fechaHasta).get(Calendar.YEAR) - 1970;
    }

    /**
     * Determina diferencia de fechas.
     * <p>
     *
     * @param fechaDesde a validar
     * @param fechaHasta a validar
     *
     * @return {@link Calendar}.
     */
    public static final Calendar dateDiff(Date fechaDesde, Date fechaHasta) {

        Calendar dateDiff = new GregorianCalendar();

        dateDiff.setTimeInMillis(fechaHasta.getTime() - fechaDesde.getTime());

        return dateDiff;

    }

    public static final Date obtenerFechaDesde(Date fechaDesde) {
        Calendar fechaDesdeAux = Calendar.getInstance();
        fechaDesdeAux.setTime(fechaDesde);
        fechaDesdeAux.set(Calendar.HOUR_OF_DAY, 0);
        fechaDesdeAux.set(Calendar.MINUTE, 0);
        fechaDesdeAux.set(Calendar.SECOND, 0);
        return fechaDesdeAux.getTime();
    }

    /**
     * Obtiene una fecha hasta las 23 : 59 : 59
     *
     * @param fechaHasta
     * @return
     */
    public static final Date obtenerFechaHasta(Date fechaHasta) {
        Calendar fechaHastaAux = Calendar.getInstance();
        fechaHastaAux.setTime(fechaHasta);
        fechaHastaAux.set(Calendar.HOUR_OF_DAY, 23);
        fechaHastaAux.set(Calendar.MINUTE, 59);
        fechaHastaAux.set(Calendar.SECOND, 59);
        return fechaHastaAux.getTime();
    }

    /**
     * <b> Metodo utilitario para obtener la fecha en formato EPOCH. </b>
     * <p>
     * [Author: fochoac, Date: 26/10/2015]
     * </p>
     *
     * @return fecha actual en formato EPOCH
     */
    public static final long obtenerFechaUnixEpoch() {
        return System.currentTimeMillis() / 1000L;
    }

    public static String devuelveFechaEnLetrasSinHora(Date fechaParametro) {
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(fechaParametro);
        return devuelveDiaSemana(fecha.get(Calendar.DAY_OF_WEEK)) + fecha.get(Calendar.DAY_OF_MONTH) + " de " + devuelveMes(fecha.get(Calendar.MONTH)) + " " + fecha.get(Calendar.YEAR);
    }

    private static String devuelveDiaSemana(int dia) {
        switch (dia) {
            case 1:
                return "Domingo ";
            case 2:
                return "Lunes ";
            case 3:
                return "Martes ";
            case 4:
                return "Miércoles ";
            case 5:
                return "Jueves ";
            case 6:
                return "Viernes ";
            case 7:
                return "Sabado ";
            default:
                return "";

        }
    }

    private static String devuelveMes(int mes) {
        switch (mes) {
            case 0:
                return "Enero";
            case 1:
                return "Febrero";
            case 2:
                return "Marzo";
            case 3:
                return "Abril";
            case 4:
                return "Mayo";
            case 5:
                return "Junio";
            case 6:
                return "Julio";
            case 7:
                return "Agosto";
            case 8:
                return "Septiembre";
            case 9:
                return "Octubre";
            case 10:
                return "Noviembre";
            case 11:
                return "Diciembre";
            default:
                return "";
        }
    }

    /**
     * calcula la edad de una persona
     *
     * @param nacimiento
     * @return
     */
    public static EdadPojo calculaEdad(Date nacimiento) {

        int anios = 0;
        int meses = 0;
        int dias = 0;
        int factor = 0;

        String descEdad = "";

        EdadPojo edadObj = new EdadPojo();

        Calendar fechaNacimiento = new GregorianCalendar();
        Calendar fechaActual = new GregorianCalendar();

        fechaNacimiento.setTime(nacimiento);
        fechaActual.setTime(new Date());

        if (fechaActual.get(Calendar.MONTH) <= fechaNacimiento.get(Calendar.MONTH)) {
            if (fechaActual.get(Calendar.MONTH) == fechaNacimiento.get(Calendar.MONTH)) {
                if (fechaActual.get(Calendar.DAY_OF_MONTH) < fechaNacimiento.get(Calendar.DAY_OF_MONTH)) {
                    factor = -1; //Aun no celebra su cumpleaños
                }
            } else {
                factor = -1; //Aun no celebra su cumpleaños
            }
        }

        anios = (fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR)) + factor;
        meses = (fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR)) * 12 + (fechaActual.get(Calendar.MONTH) - fechaNacimiento.get(Calendar.MONTH))
                + (fechaActual.get(Calendar.DAY_OF_MONTH) >= fechaNacimiento.get(Calendar.DAY_OF_MONTH) ? 0 : -1);
        dias = (int) ((fechaActual.getTimeInMillis() - fechaNacimiento.getTimeInMillis()) / MILISEGUNDOS_POR_DIA);

        if (meses == 0) {
            if (dias == 1) {
                descEdad = dias + " día";
            } else {
                descEdad = dias + " días";
            }
        } else if (anios == 0) {
            if (meses == 1) {
                descEdad = meses + " mes";
            } else {
                descEdad = meses + " meses";
            }
        } else {
            if (anios == 1) {
                descEdad = anios + " año";
            } else {
                descEdad = anios + " años";
            }
        }

        edadObj.setAnios(anios);
        edadObj.setMeses(meses);
        edadObj.setDias(dias);
        edadObj.setDescripcionEdad(descEdad);

        return edadObj;
    }

    /**
     * calcula la edad de una persona con respecto a una fecha
     *
     * @param nacimiento
     * @return
     */
    public static EdadPojo calculaEdadRango(Date nacimiento, Date fecha) {

        int anios = 0;
        int meses = 0;
        int dias = 0;
        int factor = 0;

        String descEdad = "";

        EdadPojo edadObj = new EdadPojo();

        Calendar fechaNacimiento = new GregorianCalendar();
        Calendar fechaActual = new GregorianCalendar();

        fechaNacimiento.setTime(nacimiento);
        fechaActual.setTime(fecha);

        if (fechaActual.get(Calendar.MONTH) <= fechaNacimiento.get(Calendar.MONTH)) {
            if (fechaActual.get(Calendar.MONTH) == fechaNacimiento.get(Calendar.MONTH)) {
                if (fechaActual.get(Calendar.DAY_OF_MONTH) < fechaNacimiento.get(Calendar.DAY_OF_MONTH)) {
                    factor = -1; //Aun no celebra su cumpleaños
                }
            } else {
                factor = -1; //Aun no celebra su cumpleaños
            }
        }

        anios = (fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR)) + factor;
        meses = (fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR)) * 12 + (fechaActual.get(Calendar.MONTH) - fechaNacimiento.get(Calendar.MONTH))
                + (fechaActual.get(Calendar.DAY_OF_MONTH) >= fechaNacimiento.get(Calendar.DAY_OF_MONTH) ? 0 : -1);
        dias = (int) ((fechaActual.getTimeInMillis() - fechaNacimiento.getTimeInMillis()) / MILISEGUNDOS_POR_DIA);

        if (meses == 0) {
            if (dias == 1) {
                descEdad = dias + " día";
            } else {
                descEdad = dias + " días";
            }
        } else if (anios == 0) {
            if (meses == 1) {
                descEdad = meses + " mes";
            } else {
                descEdad = meses + " meses";
            }
        } else {
            if (anios == 1) {
                descEdad = anios + " año";
            } else {
                descEdad = anios + " años";
            }
        }

        edadObj.setAnios(anios);
        edadObj.setMeses(meses);
        edadObj.setDias(dias);
        edadObj.setDescripcionEdad(descEdad);

        return edadObj;
    }

    /**
     *  * <b>
     *  *   Define el tipo de edad de una persona. 1 edad en horas, 2 edad en
     * dias, 3 edad en meses, 4 edad en años  * </b>
     *  *
     *  * @author user  
     * <p>
     * [$Author: fquisiguina $, $Date: date]</p>  
     */
    public static EdadPojo calculaEdadEntreDosFechas(Date nacimiento, Date fecha) {

        String tipoEdad = "";
        int anios = 0;
        int meses = 0;
        int dias = 0;
        int factor = 0;

        String descEdad = "";

        EdadPojo edadObj = new EdadPojo();

        Calendar fechaNacimiento = new GregorianCalendar();
        Calendar fechaActual = new GregorianCalendar();

        fechaNacimiento.setTime(nacimiento);
        fechaActual.setTime(fecha);

        if (fechaActual.get(Calendar.MONTH) <= fechaNacimiento.get(Calendar.MONTH)) {
            if (fechaActual.get(Calendar.MONTH) == fechaNacimiento.get(Calendar.MONTH)) {
                if (fechaActual.get(Calendar.DAY_OF_MONTH) < fechaNacimiento.get(Calendar.DAY_OF_MONTH)) {
                    factor = -1; //Aun no celebra su cumpleaños
                }
            } else {
                factor = -1; //Aun no celebra su cumpleaños
            }
        }

        anios = (fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR)) + factor;
        meses = (fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR)) * 12 + (fechaActual.get(Calendar.MONTH) - fechaNacimiento.get(Calendar.MONTH))
                + (fechaActual.get(Calendar.DAY_OF_MONTH) >= fechaNacimiento.get(Calendar.DAY_OF_MONTH) ? 0 : -1);
        dias = (int) ((fechaActual.getTimeInMillis() - fechaNacimiento.getTimeInMillis()) / MILISEGUNDOS_POR_DIA);

        if (anios == 0 & meses == 0 & dias == 0) {
            tipoEdad = "1";
            edadObj.setAnios(anios);
            edadObj.setMeses(meses);
            edadObj.setDias(dias);
            edadObj.setDescripcionEdad(tipoEdad);

            return edadObj;
        }

        if (meses == 0) {
            tipoEdad = "2";
            if (dias == 1) {
                descEdad = dias + " día";
            } else {
                descEdad = dias + " días";
            }
        } else if (anios == 0) {
            tipoEdad = "3";
            if (meses == 1) {
                descEdad = meses + " mes";
            } else {
                descEdad = meses + " meses";
            }
        } else {
            tipoEdad = "4";
            if (anios == 1) {
                descEdad = anios + " año";
            } else {
                descEdad = anios + " años";
            }
        }

        edadObj.setAnios(anios);
        edadObj.setMeses(meses);
        edadObj.setDias(dias);
        edadObj.setDescripcionEdad(tipoEdad);

        return edadObj;
    }

    /**
     * calcula el tiempo de espera
     *
     * @param ingreso
     * @return
     */
    public static String calculaTiempoEspera(Date ingreso) {
        String tiempoEspera = "0 minutos";
        String descHora, descMinu;

        int minutosEspera;
        int horasEspera;

        long diferenciaLong = new Date().getTime() - ingreso.getTime();

        minutosEspera = (int) (diferenciaLong / (1000 * 60));

        horasEspera = minutosEspera / 60;
        minutosEspera = (minutosEspera - (60 * horasEspera));

        if (minutosEspera == 1) {
            descMinu = "MINUTO";
        } else {
            descMinu = "MINUTOS";
        }

        if (horasEspera == 1) {
            descHora = "HORA";
        } else {
            descHora = "HORAS";
        }

        if (horasEspera >= 1) {
            tiempoEspera = horasEspera + " " + descHora + " " + minutosEspera + " " + descMinu;
        } else {
            tiempoEspera = minutosEspera + " " + descMinu;
        }

        return tiempoEspera;
    }

    /**
     * calcula el tiempo de espera en minutos
     *
     * @param ingreso
     * @return minutos de espera
     */
    public static int calculaMinutosEspera(Date ingreso) {

        int minutosEspera;

        long diferenciaLong = new Date().getTime() - ingreso.getTime();

        minutosEspera = (int) (diferenciaLong / (1000 * 60));

        return minutosEspera;
    }

    /**
     * transforma un date a String en formato yyyy/MM/dd HH:mm:ss.
     *
     * @param fecha
     * @return yyyy/MM/dd HH:mm:ss
     */
    public static String transformarFechaACadena(Date fecha) {
        List<Long> resultado = null;
        Calendar ca = Calendar.getInstance();
        ca.setTime(fecha);

        Date di = null;
        DateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String fInicial = "";

        try {
            String fi = ca.get(Calendar.YEAR) + "/" + (ca.get(Calendar.MONTH) + 1) + "/" + ca.get(Calendar.DAY_OF_MONTH) + " " + ca.get(Calendar.HOUR_OF_DAY) + ":" + ca.get(Calendar.MINUTE) + ":" + ca.get(Calendar.SECOND);
            //String fi =  ca.get(Calendar.YEAR)+(ca.get(Calendar.MONTH)+1)+ca.get(Calendar.DAY_OF_MONTH)+ca.get(Calendar.HOUR_OF_DAY)+ca.get(Calendar.MINUTE)+ca.get(Calendar.SECOND)+"";
            di = formato.parse(fi);
            fInicial = formato.format(di);

        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return fInicial;
    }

    /**
     * transdforma una STRING con formato yyyy-MM-dd a Date.
     *
     * @param fecha
     * @return date
     */
    public static Date stringToDate(String fecha) {
        Date fech = null;
        try {
            //    Date fech = null;
            DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            fech = formato.parse(fecha);
        } catch (ParseException ex) {
            return null;
        }

        return fech;
    }

    /**
     *  * <b>
     *  *   metodo que transforma las fechas   * a formato yyyyMMddHHmmss.
     *  * </b>
     *  *
     *  * @author user  
     * <p>
     * [$Author: fquisiguina $, $Date: date]</p>  
     *
     * @param fechaIngreso
     * @return
     */
    public static String transformaFechaAS400(Date fechaIngreso) {
        Date fechaTomaSignos = fechaIngreso;
        String fecha = transformarFechaACadena(fechaTomaSignos);
        fecha = fecha.replace(" ", "").replace("-", "").replace(":", "").replace("/", "");
        return fecha;
    }

    /**
     *  * <b>
     *  *   metodo que transforma las fechas   * a formato yyyyMMdd.
     *  * </b>
     *  *
     *  * @author user  
     * <p>
     * [$Author: fquisiguina $, $Date: date]</p>  
     *
     *
     */
    public static String getHoyAs400() {
        SimpleDateFormat sdfAno = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
        SimpleDateFormat sdfDia = new SimpleDateFormat("dd");
        String ano = sdfAno.format(new java.util.Date());
        String mes = sdfMes.format(new java.util.Date());
        String dia = sdfDia.format(new java.util.Date());
        String hoy = ano + mes + dia;
        return hoy;
    }

    /**
     *  * <b>
     *  *   metodo que transforma las fechas   * a formato HHmmss.
     *  * </b>
     *  *
     *  * @author user  
     * <p>
     * [$Author: fquisiguina $, $Date: date]</p>  
     *
     *
     */
    public static String getHoraAs400() {
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH");
        SimpleDateFormat sdfMin = new SimpleDateFormat("mm");
        SimpleDateFormat sdfSeg = new SimpleDateFormat("ss");
        String hora = sdfHora.format(new java.util.Date());
        String min = sdfMin.format(new java.util.Date());
        String seg = sdfSeg.format(new java.util.Date());
        String tiempo = hora + min + seg;
        return tiempo;
    }

    /**
     * Convierte un decimal que representa a una fecha en AS400 con el formato
     * yyyy-MM-dd.
     *
     * @param fechaAs400
     * @return
     */
    public static final String fechaAS400toDate(String fechaAs400) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strfecha = fechaAs400.substring(0, 4) + "-" + fechaAs400.substring(4, 6) + "-" + fechaAs400.substring(6, 8);
        java.util.Date fecha = new java.util.Date();
        try {
            fecha = sdf.parse(strfecha);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Date sqlFecha = new Date(fecha.getTime());
        return sdf.format(sqlFecha);
    }

    /**
     * Convierte un decimal que representa a una hora en AS400 con el formato
     * hh-mm.
     *
     * @param horaAs400
     * @return
     */
    public static final String horaAs400toTime(String horaAs400) {
        String horaIn = null;
        if (horaAs400.length() == 3) {
            horaIn = "0" + horaAs400;
        } else if (horaAs400.length() == 4) {
            horaIn = horaAs400;
        }

        String hora = null;
        try {
            if (horaIn.length() == 4) {
                hora = horaIn.substring(0, 2) + ":" + horaIn.substring(2, 4);
            } else {
                hora = horaAs400;
            }
        } catch (Exception e) {

        }
        return hora;
    }

    /**
     *  * <b>
     *  *   metodo que transforma 20161010 al formato 2016-10-10  * recibe una
     * fecha sin formato y la establece en formato yyyy-MM-dd * Recibe string y
     * devuelve string.  * @author user  
     * <p>
     * [$Author: fquisiguina $, $Date: date]</p>  
     *
     * @param fecha
     * @return
     */
    public static String establecerFormatoFecha(String fecha) {
        String dato = "";
        if (!fecha.equals("")) {
            dato = fecha.substring(0, 4) + "-" + fecha.substring(4, 6) + "-" + fecha.substring(6, 8);
        }
        return dato;
    }

    /**
     *  * <b>
     *  *   Metodo para aumentar dias a una fecha.  * </b>
     *  *
     *  * @author user  
     * <p>
     * [$Author: fquisiguina $, $Date: date]</p>  
     *
     * @param fecha
     * @param dias
     * @return
     */
    public static Date aumentarDias(Date fecha, int dias) throws ServicioExcepcion {
        try {
            SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = sm.format(fecha);
            fecha = sm.parse(strDate);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha); // Configuramos la fecha que se recibe
            calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
            Date fechaFin = calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos

            return fechaFin;

        } catch (Exception ex) {
            Logger.getLogger(FechasUtil.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServicioExcepcion("Error: " + ex.getMessage());

        }
    }

    /**
     *  * <b>
     *  *   metodo que transforma una fecha String de formato yyyy-MM-dd
     * HH:mm:ss * a formato yyyyMMddHHmmss.
     *  * </b>
     *  *
     *  * @author user  
     * <p>
     * [$Author: fquisiguina $, $Date: date]</p>  
     *
     * @param fechaIngreso
     * @return
     */
    public static String transformaFechaAs400(String fechaIngreso) {
        String fecha = fechaIngreso;
        fecha = fecha.replace(" ", "").replace("-", "").replace(":", "").replace("/", "");
        return fecha;
    }

    /**
     *  * <b>
     *  *   metodo que transforma una fecha String de formato yyyyMMddHHmmss * a
     * formato yyyy-MM-dd hh:mm. * </b>
     *  *
     *  * @author user  
     * <p>
     * [$Author: fquisiguina $, $Date: date]</p>  
     *
     * @param fechaIngreso
     * @return
     */
    public static String transformaFechaAs400SinFormato(String fechaIngreso) {
        //String fecha = fechaIngreso;
        String anio = fechaIngreso.substring(0, 4);
        String mes = fechaIngreso.substring(4, 6);
        String dia = fechaIngreso.substring(6, 8);
        String hora = fechaIngreso.substring(8, 10);
        String minuto = fechaIngreso.substring(10, 12);

        return anio + "-" + mes + "-" + dia + " " + hora + ":" + minuto;
    }

    /**
     * <b>método devuelve el nombre del mes.</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 28/06/2017]
     * </p>
     *
     * @param mes entero numero de mes
     * @return texto mes
     */
    public static String devuelveNombreMes(String mes) {
        switch (Integer.parseInt(mes)) {
            case 1:
                return "Enero";
            case 2:
                return "Febrero";
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
            case 5:
                return "Mayo";
            case 6:
                return "Junio";
            case 7:
                return "Julio";
            case 8:
                return "Agosto";
            case 9:
                return "Septiembre";
            case 10:
                return "Octubre";
            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";
            default:
                return "No válido";
        }
    }
}
