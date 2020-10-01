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
import ec.gob.iessHcam.gestion.seguridad.modelo.Rol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>
 *   Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>[$Author: Jorge Zúñiga $, $Date: 07-mar-2016]</p>
 */
public class RolDao extends DaoImpl<Rol>{

    public RolDao() {
        super(Rol.class);
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
    public List<Rol> obtenerListaRoles() throws ServicioExcepcion {
        
        List<Rol> listRoles = getDao().listarPorConsultaJpaNombrada(Rol.OBTENER_ROLES, null);
        
        if (listRoles.isEmpty()) {
            return new ArrayList<>();
        } else {
            return listRoles;
        }
    }
    
    
    /**
     *
     * <b>
     * Obtiene una lista de Roles no asignados al usuario.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 01/apr/2016]</p>
     *
     * @param idUsuario
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public List<Rol> obtenerListaRolesnoAsignados(int idUsuario) throws ServicioExcepcion {
        
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("idUsuario", idUsuario);

        List<Rol> listRoles = getDao().listarPorConsultaJpaNombrada(Rol.OBTENER_ROLES_NO_ASIGNADOS, parametros);
        
        if (listRoles.isEmpty()) {
            return new ArrayList<>();
        } else {
            return listRoles;
        }
    }
    
    /**
     *
     * <b>
     * Guarda un objeto Rol en la base de datos.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 26/02/2016]</p>
     *
     * @param rol
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public boolean guardaRol(Rol rol) throws ServicioExcepcion {
        
        try{
            getDao().guardar(rol);

            return true;
        }
        catch(Exception e){
            Log.error(RolDao.class.getName(), "Error al Guardar objeto Rol", e);
            return false;
        }
       
    }
}

