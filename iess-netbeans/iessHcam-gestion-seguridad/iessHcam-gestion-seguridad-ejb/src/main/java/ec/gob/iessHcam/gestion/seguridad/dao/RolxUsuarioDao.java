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
import ec.gob.iessHcam.gestion.seguridad.modelo.Rolxusuario;
import java.util.List;

/**
 * <b>
 * Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>
 * [$Author: Jorge Zúñiga $, $Date: 01-abril-2016]</p>
 */
public class RolxUsuarioDao extends DaoImpl<Rolxusuario> {

    public RolxUsuarioDao() {
        super(Rolxusuario.class);
    }

   /**
     *
     * <b>
     * Guarda un objeto institucion en la base de datos.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 01-abr-2016]</p>
     *
     * @param rolesxUsuario
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public boolean guardarRolxUsuario(List<Rolxusuario> rolesxUsuario) throws ServicioExcepcion {

        try {
            
            getDao().guardarLote(rolesxUsuario);

            return true;
        } catch (Exception e) {
            Log.error(TipoRolDao.class.getName(), "Error al Guardar objeto Rol x Usuario", e);
            return false;
        }

    }
}
