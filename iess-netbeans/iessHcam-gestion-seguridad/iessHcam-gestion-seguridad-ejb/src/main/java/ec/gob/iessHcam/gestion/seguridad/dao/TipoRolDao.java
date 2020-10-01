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
import ec.gob.iessHcam.gestion.seguridad.modelo.Tiporol;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>
 *   Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>[$Author: Jorge Zúñiga $, $Date: 07-mar-2016]</p>
 */
public class TipoRolDao extends DaoImpl<Tiporol>{

    public TipoRolDao() {
        super(Tiporol.class);
    }
    
    /**
     *
     * <b>
     * Obtiene una lista de Tipos de Roles Activos.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 07/mar/2016]</p>
     *
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public List<Tiporol> obtenerListaTiposRoles() throws ServicioExcepcion {
        
        List<Tiporol> listTiposRoles = getDao().listarPorConsultaJpaNombrada(Tiporol.OBTENER_TIPOS_ROL_ACTIVAS, null);
        
        if (listTiposRoles.isEmpty()) {
            return new ArrayList<>();
        } else {
            return listTiposRoles;
        }
    }
    
    
    
    /**
     *
     * <b>
     * Guarda un objeto institucion en la base de datos.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 26/02/2016]</p>
     *
     * @param tiporol
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public boolean guardarTiporol(Tiporol tiporol) throws ServicioExcepcion {
        
        try{
            getDao().guardar(tiporol);

            return true;
        }
        catch(Exception e){
            Log.error(TipoRolDao.class.getName(), "Error al Guardar objeto Tipo Rol", e);
            return false;
        }
       
    }
}

