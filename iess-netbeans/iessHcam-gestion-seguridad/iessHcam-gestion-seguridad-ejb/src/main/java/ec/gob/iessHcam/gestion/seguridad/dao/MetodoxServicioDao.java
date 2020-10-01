/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/
package ec.gob.iessHcam.gestion.seguridad.dao;

import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;
import ec.gob.iessHcam.componente.comun.logs.Log;
import ec.gob.iessHcam.gestion.seguridad.dao.impl.DaoImpl;
import ec.gob.iessHcam.gestion.seguridad.modelo.Aplicacion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>
 *   Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author Desarrollo
 * <p>[$Author: Desarrollo $, $Date: 23-feb-2016]</p>
 */
public class MetodoxServicioDao extends DaoImpl<Aplicacion>{

    public MetodoxServicioDao() {
        super(Aplicacion.class);
    }
    
    /**
     *
     * <b>
     * Obtiene una lista de aplicaciones por la dependencia a la cual pertenece.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 26/02/2016]</p>
     *
     * @param idDependencia
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public List<Aplicacion> obtenerListaAplicaciones(int idDependencia) throws ServicioExcepcion {
        
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("idDependencia", idDependencia);
        
        List<Aplicacion> ListAplicaciones = getDao().listarPorConsultaJpaNombrada(Aplicacion.OBTENER_APLICACIONES_POR_DEPENDENCIA, parametros);
        
        if (ListAplicaciones.isEmpty()) {
            return new ArrayList<>();
        } else {
            return ListAplicaciones;
        }
    }
    
    /**
     *
     * <b>
     * Obtiene un objeto aplicación por su clave primaria.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 26/02/2016]</p>
     *
     * @param idAplicacion
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public Aplicacion obtenerAplicacionPorClavePrimaria(int idAplicacion) throws ServicioExcepcion {

        Aplicacion aplicacion = getDao().obtenerPorLlavePrimaria(idAplicacion);
        
        return aplicacion;
    }
    
    /**
     *
     * <b>
     * Guarda un objeto aplicación en la base de datos.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 26/02/2016]</p>
     *
     * @param aplicacion
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public boolean guardarAplicacion(Aplicacion aplicacion) throws ServicioExcepcion {
        
        try{
            getDao().guardar(aplicacion);

            return true;
        }
        catch(Exception e){
            Log.error(MetodoxServicioDao.class.getName(), "Error al Guardar objeto Aplicación", e);
            return false;
        }
       
    }
}

