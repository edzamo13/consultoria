/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.seguridad.dao;

import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;
import ec.gob.iessHcam.componente.seguridad.dao.impl.DaoImpl;
import ec.gob.iessHcam.componente.seguridad.modelo.Aplicacion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * <b>
 * Clase que maneja el dao de aplicación.
 * </b>
 *
 * @author ezamora
 * <p>
 * [$Author: ezamora $, $Date: 08/02/2016]</p>
 */
@LocalBean
@Stateless
public class AplicacionDao extends DaoImpl<Aplicacion> {

    /**
     *
     * <b> Constructor del AplicacionDao. </b>
     * <p>
     * [Author: ezamoram, Date: 08/02/2016]
     * </p>
     *
     */
    public AplicacionDao() {
        super(Aplicacion.class);
    }

    /**
     *
     * <b>
     * obtenerUsuario.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 08/02/2016]</p>
     *
     * @param usuario
     * @return Usuario
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public List<Aplicacion> obtenerUsuario(Integer usuario) throws ServicioExcepcion {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("usuario", usuario);
        List<Aplicacion> aplicacions = getDao().listarPorConsultaJpaNombrada(Aplicacion.OBTENER_APLICACION_POR_USUSUARIO, parametros);
        if (aplicacions.isEmpty()) {
            return new ArrayList<>();
        } else {
            return aplicacions;
        }
    }
    
    /**
     *
     * <b>
     * obtenerUsuario.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 08/02/2016]</p>
     *
     * @param usuario
     * @return Usuario
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public List<Aplicacion> obtenerUsuarioAplicaciones(Integer usuario) throws ServicioExcepcion {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("usuario", usuario);
        List<Aplicacion> aplicacions = getDao().listarPorConsultaJpaNombrada(Aplicacion.OBTENER_APLICACION_POR_USUARIO_Y_VISIBLES_EN_PANTALLA, parametros);
        if (aplicacions.isEmpty()) {
            return new ArrayList<>();
        } else {
            return aplicacions;
        }
    }
    
    /**
     *
     * <b>
     * obtenerAplicacionPorClavePrimaria.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 02/03/2016]</p>
     *
     * @param idAplicacion
     * @return objeto Aplicacion
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public Aplicacion obtenerAplicacionPorClavePrimaria(Integer idAplicacion) throws ServicioExcepcion {

        Aplicacion aplicacion = getDao().obtenerPorLlavePrimaria(idAplicacion);
        
        return aplicacion;
    }
}
