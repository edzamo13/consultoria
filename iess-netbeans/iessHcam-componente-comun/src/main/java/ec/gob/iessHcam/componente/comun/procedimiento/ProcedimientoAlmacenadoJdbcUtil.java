/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.procedimiento;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import ec.gob.iessHcam.componente.comun.logs.Log;

/**
 * <b> Clase utilitaria para ejecutar un procedimiento almacenado. </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 11/8/2015 $]
 *          </p>
 */
public class ProcedimientoAlmacenadoJdbcUtil {
    private static final String NOMBRE_CLASE = ProcedimientoAlmacenadoJdbcUtil.class.getName();
    private CallableStatement sentencia = null;

    /**
     * <b> Metodo utilitario encargado de ejecutar el procedimeinto. </b>
     * <p>
     * [Author: fochoac, Date: 21/8/2015]
     * </p>
     *
     * @param listaParametros
     *            a enviar
     * @param dataSource
     *            para la conexion
     * @param nombreProcedimiento
     *            a llamar
     * @param tieneRetorno
     *            true si lo tiene
     * @return lista de resultados
     */
    public List<ParametroProcedimiento> execute(List<ParametroProcedimiento> listaParametros, DataSource dataSource,
            String nombreProcedimiento, boolean tieneRetorno) {
        Connection conexion = null;
        try {
            conexion = dataSource.getConnection();
            if (conexion != null) {
                sentencia = conexion.prepareCall(construirLlamada(nombreProcedimiento, listaParametros.size(),
                        tieneRetorno));
                configurarParametros(listaParametros);
                sentencia.execute();
                obtenerResultados(listaParametros);
            }
        } catch (SQLException e) {
            Log.error(NOMBRE_CLASE, "Error al ejecutar el SP " + nombreProcedimiento, e);
        } finally {
            try {
                sentencia.close();
                conexion.close();
            } catch (Exception ignore) {
                Log.error(NOMBRE_CLASE, "Error al cerrar conexion y sentencia para el SP " + nombreProcedimiento,
                        ignore);
            }
        }
        return listaParametros;
    }

    /**
     * <b> Metodo utilitario para construir la llamada al procedimiento almacenado. </b>
     * <p>
     * [Author: fochoac, Date: 21/8/2015]
     * </p>
     *
     * @param nombreSp
     *            nombre del procedimiento
     * @param numeroParametros
     *            a colocar
     * @param tieneRetorno
     *            true si lo tiene
     * @return cadena sql construida
     */
    private String construirLlamada(String nombreSp, int numeroParametros, boolean tieneRetorno) {
        StringBuffer bufferLlamada = new StringBuffer();
        if (nombreSp != null && !nombreSp.equals("")) {
            if (tieneRetorno) {
                bufferLlamada.append("? = ");
            }
            bufferLlamada.append("{call ");
            bufferLlamada.append(nombreSp);
            bufferLlamada.append("(");
        } else {
            return null;
        }
        if (numeroParametros > 0) {
            for (int i = 0; i < numeroParametros; i++) {
                if (i != numeroParametros - 1) {
                    bufferLlamada.append("?,");
                } else {
                    bufferLlamada.append("?)}");
                }
            }
        } else {
            return null;
        }
        return bufferLlamada.toString();
    }

    /**
     * <b> Metodo encargado de configurar los parametros. </b>
     * <p>
     * [Author: fochoac, Date: 21/8/2015]
     * </p>
     *
     * @param listaParametros
     *            a configurar
     */
    private void configurarParametros(List<ParametroProcedimiento> listaParametros) {
        try {
            for (ParametroProcedimiento parametro : listaParametros) {
                if (parametro.isEntrada()) {
                    switch (parametro.getTipo()) {
                    case Types.VARCHAR:
                        sentencia.setString(parametro.getNombreParametro(), (String) parametro.getValor());
                        break;

                    case Types.INTEGER:
                        sentencia.setInt(parametro.getNombreParametro(), (Integer) parametro.getValor());
                        break;

                    case Types.DATE:
                        sentencia.setDate(parametro.getNombreParametro(),
                                parametro.getValor() instanceof java.sql.Date ? (java.sql.Date) parametro.getValor()
                                        : new java.sql.Date(((java.util.Date) parametro.getValor()).getTime()));
                        break;

                    case Types.DECIMAL:
                        sentencia.setBigDecimal(parametro.getNombreParametro(), (BigDecimal) parametro.getValor());
                        break;

                    default:
                        sentencia.setObject(parametro.getNombreParametro(), parametro.getValor());
                        break;
                    }
                } else {
                    sentencia.registerOutParameter(parametro.getNombreParametro(), parametro.getTipo());
                }
            }
        } catch (SQLException ex) {
            Log.error(NOMBRE_CLASE, "Error al mapear un tipo de dato", ex);
        }
    }

    /**
     * <b> Metodo utilitario para mapear los resultados. </b>
     * <p>
     * [Author: fochoac, Date: 21/8/2015]
     * </p>
     *
     * @param listaParametros
     *            a mapear
     */
    private void obtenerResultados(List<ParametroProcedimiento> listaParametros) {
        try {
            for (ParametroProcedimiento parametro : listaParametros) {
                if (!parametro.isEntrada()) {
                    parametro.setValor(sentencia.getObject(parametro.getNombreParametro()));
                }
            }
        } catch (SQLException ex) {
            Log.error(NOMBRE_CLASE, "Error al asignar los valores consultados del SP", ex);
        }
    }
}
