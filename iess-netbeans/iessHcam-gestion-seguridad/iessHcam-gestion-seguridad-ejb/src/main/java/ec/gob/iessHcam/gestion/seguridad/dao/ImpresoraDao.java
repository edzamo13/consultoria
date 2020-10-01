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
public class ImpresoraDao extends DaoImpl<ImpresoraTbl>{

    public ImpresoraDao() {
        super(ImpresoraTbl.class);
    }
    
    /**
     *
     * <b>
     * Obtiene una lista de impresoras de una unidad médica.
     * </b>
     * <p>
     * [$Author: jzuniGa $, $Date: 01-jul-2016]</p>
     *
     * @param codUnme
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public List<ImpresoraTbl> obtenerListaImpresoras(String codUnme) throws ServicioExcepcion {
        
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("codUnme", Long.parseLong(codUnme));
        
        List<ImpresoraTbl> impresoras = getDao().listarPorConsultaJpaNombrada(ImpresoraTbl.OBTENER_IMPRESORAS_POR_UNME, parametros);
        
        if (impresoras.isEmpty()) {
            return new ArrayList<>();
        } else {
            return impresoras;
        }
    }
 
    
    /**
     *
     * <b>
     * Obtiene una lista de impresoras de una unidad médica por direccion ip.
     * </b>
     * <p>
     * [$Author: jzuniGa $, $Date: 04-jul-2016]</p>
     *
     * @param ipImpresora
     * @param codUnme
     * @param idTipoManilla
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public ImpresoraTbl obtenerImpresoraPorIpTipo(String ipImpresora, Long codUnme, long idTipoManilla) throws ServicioExcepcion {
        
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("ipImpresora", ipImpresora);
        parametros.put("codUnme", codUnme);
        parametros.put("tipoManilla", idTipoManilla);
        
        List<ImpresoraTbl> impresoras = getDao().listarPorConsultaJpaNombrada(ImpresoraTbl.OBTENER_IMPRESORAS_POR_IP_TIPO, parametros);
        
        if (impresoras.isEmpty()) {
            return null;
        } else {
            return impresoras.get(0);
        }
    }
 
    
    /**
     *
     * <b>
     * Guarda una impresora en la base de datos.
     * </b>
     * <p>
     * [$Author: jzuniga $, $Date: 01-jul-2016]</p>
     *
     * @param impresora
     * @return
     */
    public ImpresoraTbl guardarImpresora(ImpresoraTbl impresora) {
        
        try{
            return getDao().guardarRetorno(impresora);
        }
        catch(Exception e){
            Log.error(ImpresoraDao.class.getName(), "Error al Guardar objeto impresora", e);
            return null;
        }
       
    }
}

