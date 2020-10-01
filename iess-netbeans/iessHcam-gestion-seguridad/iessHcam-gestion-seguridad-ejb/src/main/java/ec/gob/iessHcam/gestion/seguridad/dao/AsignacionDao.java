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
import ec.gob.iessHcam.gestion.seguridad.modelo.AsignacionTbl;
import ec.gob.iessHcam.gestion.seguridad.modelo.ImpresoraTbl;
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
 * <p>[$Author: Desarrollo $, $Date: 01-jul-2016]</p>
 */
public class AsignacionDao extends DaoImpl<AsignacionTbl>{

    public AsignacionDao() {
        super(AsignacionTbl.class);
    }
    
    /**
     *
     * <b>
     * Obtiene una lista de impresoras asignadas en una unidad médica.
     * </b>
     * <p>
     * [$Author: jzuniGa $, $Date: 01-jul-2016]</p>
     *
     * @param codUnme
     * @param ipUsuario
     * @param ipImpresora
     * @param idTipoManilla
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public AsignacionTbl obtenerAsignacionImpresora(Long codUnme, String ipUsuario, String ipImpresora, Long idTipoManilla) throws ServicioExcepcion {
        
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("codUnme", codUnme);
        parametros.put("ipUsuario", ipUsuario);
        parametros.put("ipImpresora", ipImpresora);
        parametros.put("idTipoManilla", idTipoManilla);
        
        List<AsignacionTbl> impresorasAsignadas = getDao().listarPorConsultaJpaNombrada(AsignacionTbl.OBTENER_IMPRESORAS_ASIGNADAS_POR_UNME_IP_USUARIO_IP_IMPRESORA, parametros);
        
        if (impresorasAsignadas.isEmpty()) {
            return null;
        } else {
            return impresorasAsignadas.get(0);
        }
    }
 
    
    /**
     *
     * <b>
     * Guarda una asignacion de una impresora en la base de datos.
     * </b>
     * <p>
     * [$Author: jzuniga $, $Date: 01-jul-2016]</p>
     *
     * @param impresoraAsignada
     * @return
     */
    public AsignacionTbl guardarImpresoraAsignada(AsignacionTbl impresoraAsignada) {
        
        try{
            return getDao().guardarRetorno(impresoraAsignada);
        }
        catch(Exception e){
            Log.error(AsignacionDao.class.getName(), "Error al Guardar objeto impresora asignada", e);
            return null;
        }
       
    }
}

