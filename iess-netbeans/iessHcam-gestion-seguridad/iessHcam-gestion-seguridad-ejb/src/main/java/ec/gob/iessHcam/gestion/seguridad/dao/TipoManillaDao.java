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
import ec.gob.iessHcam.gestion.seguridad.modelo.TipoManillaTbl;
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
 * <p>[$Author: Desarrollo $, $Date: 03-jul-2016]</p>
 */
public class TipoManillaDao extends DaoImpl<TipoManillaTbl>{

    public TipoManillaDao() {
        super(TipoManillaTbl.class);
    }
    
    /**
     *
     * <b>
     * Obtiene una lista de tipos de manillas de las impresoras.
     * </b>
     * <p>
     * [$Author: jzuniGa $, $Date: 03-jul-2016]</p>
     *
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public List<TipoManillaTbl> obtenerListaTiposManillas() throws ServicioExcepcion {
        
        Map<String, Object> parametros = new HashMap<>();
        
        List<TipoManillaTbl> tiposManllas = getDao().listarPorConsultaJpaNombrada(TipoManillaTbl.OBTENER_TIPO_MANILLA, parametros);
        
        if (tiposManllas.isEmpty()) {
            return new ArrayList<>();
        } else {
            return tiposManllas;
        }
    }
 
    
}

