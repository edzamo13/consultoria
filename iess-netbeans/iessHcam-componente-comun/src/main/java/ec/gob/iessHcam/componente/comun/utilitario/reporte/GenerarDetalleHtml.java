/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.reporte;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import ec.gob.iessHcam.componente.comun.logs.Log;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 *
 * @author fochoac
 * @version $Revision: 1.0 $
 * <p>
 * [$Author: fochoac $, $Date: 14/9/2015 $]
 * </p>
 */
public class GenerarDetalleHtml {

    private static final String TD_ANCHO = "<td style=\" ";
    private static final String BR_SPAN = "<br/></span></td>";
    private static final String CIERRA_FILA = "</tr>";
    private static final String GET = "get";

    /**
     * <b> Metodo utilitario para deolver el detalle de una tabla en html. </b>
     * <p>
     * [Author: fochoac, Date: 14/9/2015]
     * </p>
     *
     * @param cabeza cabecer
     * @param columnas del detalle
     * @param listaFilas del detalle
     * @param ordenColumnas del detalle
     * @param alinearTexto center, left, right,etc
     * @return cadena html
     */
    @Deprecated
    public static String devolverDetalle(String cabeza, final String[] columnas,
            final List<? extends Object> listaFilas, final String[] ordenColumnas, String alinearTexto) {// NOSONAR
        try {
            StringBuilder tablaStandar = new StringBuilder();
            String alineacion = "center";
            if (alinearTexto != null) {
                alineacion = alinearTexto;
            }
            if (cabeza != null) {
                tablaStandar
                        .append("<table align=\"left\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width:100%\">");
                tablaStandar.append("<tbody><tr>");
                tablaStandar
                        .append(TD_ANCHO)
                        .append(100)
                        .append("%; text-align: left\"> <span style=\"font-size: small;font-weight: bold;background-color: inherit;\">");
                tablaStandar.append(cabeza);
                tablaStandar.append(BR_SPAN);
                tablaStandar.append(CIERRA_FILA);
                tablaStandar.append("</tbody></table>");
            }
            tablaStandar
                    .append("<table align=\"left\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width:100%\">");
            tablaStandar.append("<tbody><tr>");
            int tamanio = 100 / columnas.length;
            for (String s : columnas) {
                tablaStandar.append(TD_ANCHO)
                        .append("text-align: center\"> <span style=\"font-size: small\">");
                tablaStandar.append(s);
                tablaStandar.append(BR_SPAN);
            }
            tablaStandar.append(CIERRA_FILA);
            for (Object o : listaFilas) {
                tablaStandar.append(reemplazoReflexionDetalle(o, tamanio, alineacion, ordenColumnas, null));
            }
            tablaStandar.append("</tbody></table>");
            return tablaStandar.toString();
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            Log.error(GenerarDetalleHtml.class.getName(), "no se puede construir el detalle", e);
            return null;
        }
    }

    /**
     * <b> Metodo para convertir objeto a cadena por reflexion. </b>
     * <p>
     * [Author: fochoac, Date: 14/9/2015]
     * </p>
     *
     * @param o a convertir
     * @param tamanio del objeto
     * @param alineacion del objeto
     * @param ordenColumnas de la lista
     * @return cadena html
     * @throws IllegalAccessException en caso de error
     * @throws InvocationTargetException en caso de error
     */
    private static String reemplazoReflexionDetalle(Object o, int tamanio, String alineacion, String[] ordenColumnas, String tamanioLetra)
            throws IllegalAccessException, InvocationTargetException {
        StringBuilder tablaStandar = new StringBuilder();
        tablaStandar.append("<tr>");
        Class claseR = o.getClass();
        Method[] campos = claseR.getMethods();
        for (String s : ordenColumnas) {
            for (Method f : campos) {
                if (f.getName().startsWith(GET) && f.getName().contains(s)) {
                    tablaStandar.append(TD_ANCHO).append(tamanio).append("%; text-align: ").append(alineacion)
                            .append("\"> <span style=\"" + tamanioLetra + "\">");
                    tablaStandar.append(f.invoke(o, null));
                    tablaStandar.append("<br/></span></td>");
                    break;
                }
            }
        }
        tablaStandar.append(CIERRA_FILA);
        return tablaStandar.toString();
    }

    /**
     * <b> Metodo utilitario para deolver el detalle de una tabla en html. </b>
     * <p>
     * [Author: fochoac, Date: 14/9/2015]
     * </p>
     *
     * @param cabeza cabecer
     * @param columnas del detalle
     * @param listaFilas del detalle
     * @param ordenColumnas del detalle
     * @param alinearTexto center, left, right,etc
     * @return cadena html
     */
    @Deprecated
    public static String devolverDetalle(String cabeza, final String[] columnas,
            final List<? extends Object> listaFilas, final String[] ordenColumnas, String alinearTexto, boolean estiloCabecera) {// NOSONAR
        try {
            StringBuilder tablaStandar = new StringBuilder();
            String alineacion = "center";
            if (alinearTexto != null) {
                alineacion = alinearTexto;
            }
            if (cabeza != null) {
                tablaStandar
                        .append("<table align=\"left\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width:100%\">");
                tablaStandar.append("<tbody><tr>");
                tablaStandar
                        .append(TD_ANCHO)
                        .append(100)
                        .append("%; text-align: left\"> <span style=\"font-size: small;font-weight: bold;background-color: inherit;\">");
                tablaStandar.append(cabeza);
                tablaStandar.append(BR_SPAN);
                tablaStandar.append(CIERRA_FILA);
                tablaStandar.append("</tbody></table>");
            }
            tablaStandar
                    .append("<table align=\"left\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width:100%\">");
            tablaStandar.append("<tbody><tr>");
            int tamanio = 100 / columnas.length;
            for (String s : columnas) {
                if (estiloCabecera) {
                    tablaStandar.append(TD_ANCHO).append(tamanio)
                            .append("%; text-align: center; background-color: #CED2FF;font-weight: bold;\"> <span style=\"font-size: small\">");
                } else {
                    tablaStandar.append(TD_ANCHO).append(tamanio)
                            .append("%; text-align: center\"> <span style=\"font-size: small\">");
                }
                tablaStandar.append(s);
                tablaStandar.append(BR_SPAN);
            }
            tablaStandar.append(CIERRA_FILA);
            for (Object o : listaFilas) {
                tablaStandar.append(reemplazoReflexionDetalle(o, tamanio, alineacion, ordenColumnas, null));
            }
            tablaStandar.append("</tbody></table>");
            return tablaStandar.toString();
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            Log.error(GenerarDetalleHtml.class.getName(), "no se puede construir el detalle", e);
            return null;
        }
    }

    /**
     * <b> Metodo utilitario para deolver el detalle de una tabla en html. </b>
     * <p>
     * [Author: fochoac, Date: 14/9/2015]
     * </p>
     *
     * @param cabeza cabecer
     * @param columnas del detalle
     * @param mapaDatos
     * @param ordenColumnas del detalle
     * @param alinearTexto center, left, right,etc
     * @param estiloCabecera
     * @return cadena html
     */
    public static String devolverDetalleGrupo(String cabeza, final String[] columnas,
            final Object mapaDatos, final String[] ordenColumnas, String alinearTexto, boolean estiloCabecera) {// NOSONAR
        try {
            StringBuilder tablaStandar = new StringBuilder();
            Map<String, List<Object>> mapa = (Map<String, List<Object>>) mapaDatos;

            for (String grupo : mapa.keySet()) {
                String alineacion = "center";
                if (alinearTexto != null) {
                    alineacion = alinearTexto;
                }
                if (cabeza != null) {
                    tablaStandar
                            .append("<table align=\"left\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width:100%\">");
                    tablaStandar.append("<tbody><tr>");
                    tablaStandar
                            .append(TD_ANCHO)
                            .append(100)
                            .append("%; text-align: left\"> <span style=\"font-size: small;font-weight: bold;background-color: inherit;\">");
                    tablaStandar.append(cabeza);
                    tablaStandar.append(BR_SPAN);
                    tablaStandar.append(CIERRA_FILA);
                    tablaStandar.append("</tbody></table>");
                }

                String grupoTabla = "<b>" + grupo + "</b><br />";
                tablaStandar
                        .append(grupoTabla);
                tablaStandar
                        .append("<table align=\"left\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width:100%\">");
                tablaStandar.append("<tbody><tr>");
                int tamanio = 100 / columnas.length;
                for (String s : columnas) {
                    if (estiloCabecera) {
                        tablaStandar.append(TD_ANCHO).append(tamanio)
                                .append("%; text-align: center; background-color: #CED2FF;font-weight: bold;\"> <span style=\"font-size: small\">");
                    } else {
                        tablaStandar.append(TD_ANCHO).append(tamanio)
                                .append("%; text-align: center\"> <span style=\"font-size: small\">");
                    }
                    tablaStandar.append(s);
                    tablaStandar.append(BR_SPAN);
                }
                tablaStandar.append(CIERRA_FILA);

                for (Object o : mapa.get(grupo)) {
                    tablaStandar.append(reemplazoReflexionDetalle(o, tamanio, alineacion, ordenColumnas, null));
                }
                tablaStandar.append("</tbody></table>");
            }

            return tablaStandar.toString();
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            Log.error(GenerarDetalleHtml.class.getName(), "no se puede construir el detalle", e);
            return null;
        }
    }

    /**
     * <b> Metodo utilitario para deolver el detalle de una tabla en html. </b>
     * <p>
     * [Author: fochoac, Date: 14/9/2015]
     * </p>
     *
     * @param cabeza cabecer
     * @param columnas del detalle
     * @param listaFilas del detalle
     * @param ordenColumnas del detalle
     * @param alinearTexto center, left, right,etc
     * @param estiloCabecera
     * @param listaPieTabla
     * @return cadena html
     */
    public static String devolverDetalle(String cabeza, final String[] columnas,
            final List<? extends Object> listaFilas, final String[] ordenColumnas, String alinearTexto,
            boolean estiloCabecera, final String htmlPieTabla, Integer tamanioLetra) {// NOSONAR
        try {
            StringBuilder tablaStandar = new StringBuilder();
            String alineacion = "center";
            if (alinearTexto != null) {
                alineacion = alinearTexto;
            }

            String htmlTamanioLetra = "font-size: small";
            if (tamanioLetra != null) {
                htmlTamanioLetra = "font-size: " + tamanioLetra + "px";
            }

            if (cabeza != null) {
                tablaStandar
                        .append("<table align=\"left\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width:100%\">");
                tablaStandar.append("<tbody><tr>");
                tablaStandar
                        .append(TD_ANCHO)
                        .append(100)
                        .append("%; text-align: left\"> <span style=\"" + htmlTamanioLetra + ";font-weight: bold;background-color: inherit;\">");
                tablaStandar.append(cabeza);
                tablaStandar.append(BR_SPAN);
                tablaStandar.append(CIERRA_FILA);
                tablaStandar.append("</tbody></table>");
            }
            tablaStandar
                    .append("<table align=\"left\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width:100%\">");
            tablaStandar.append("<tbody>");
            int tamanio = 100 / ordenColumnas.length;
            if (columnas.length != 0) {
                tablaStandar.append("<tr>");
            }
            for (String s : columnas) {
                if (estiloCabecera) {
                    tablaStandar.append(TD_ANCHO).append(tamanio)
                            .append("%; text-align: center; background-color: #CED2FF;font-weight: bold;\"> <span style=\"" + htmlTamanioLetra + "\">");
                } else {
                    tablaStandar.append(TD_ANCHO).append(tamanio)
                            .append("%; text-align: center\"> <span style=\"" + htmlTamanioLetra + "\">");
                }
                tablaStandar.append(s);
                tablaStandar.append(BR_SPAN);
            }

            if (columnas.length != 0) {
                tablaStandar.append(CIERRA_FILA);
            }

            for (Object o : listaFilas) {
                tablaStandar.append(reemplazoReflexionDetalle(o, tamanio, alineacion, ordenColumnas, htmlTamanioLetra));
            }

            if (htmlPieTabla != null) {
                tablaStandar.append(htmlPieTabla);
            }

            tablaStandar.append("</tbody></table>");
            return tablaStandar.toString();
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            Log.error(GenerarDetalleHtml.class.getName(), "no se puede construir el detalle", e);
            return null;
        }
    }

}
