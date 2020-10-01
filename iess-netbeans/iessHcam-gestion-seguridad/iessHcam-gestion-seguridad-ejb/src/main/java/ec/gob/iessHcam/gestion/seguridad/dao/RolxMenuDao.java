/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iessHcam.gestion.seguridad.dao;

import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;
import ec.gob.iessHcam.componente.comun.logs.Log;
import ec.gob.iessHcam.gestion.seguridad.dao.impl.DaoImpl;
import ec.gob.iessHcam.gestion.seguridad.modelo.Rolxmenu;
import java.util.List;

/**
 *
 * @author HCAM
 */
public class RolxMenuDao extends DaoImpl<Rolxmenu> {

    public RolxMenuDao() {
        super(Rolxmenu.class);
    }

    /**
     *
     * <b>
     * Guarda un objeto institucion en la base de datos.
     * </b>
     * <p>
     * [$Author: Jorge ZÃºÃ±iga $, $Date: 21/03/2016]</p>
     *
     * @param rolxMenus
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public boolean guardarRolxMenu(List<Rolxmenu> rolxMenus) throws ServicioExcepcion {

        try {
            
            getDao().guardarLote(rolxMenus);

            return true;
        } catch (Exception e) {
            Log.error(TipoRolDao.class.getName(), "Error al Guardar objeto Rol x Menu", e);
            return false;
        }

    }
    
    
    public boolean inactivarRolxMenu(int idAplicacion, int idRol) throws ServicioExcepcion {

        try {
            
            getDao().getEntityManager().createNativeQuery("update seguridad.seg_rolxmenu_tbl set rm_estado = 'I' "
                    + " where me_id_opcion in (select me_id_opcion from seguridad.seg_menu_tbl"
                    + "                         where ap_id_aplicacion = "+ idAplicacion+ ")"
                    + "                         and ro_id_rol = "+ idRol).executeUpdate();
            
            return true;
        } catch (Exception e) {
            Log.error(TipoRolDao.class.getName(), "Error al Guardar objeto Rol x Menu", e);
            return false;
        }

    }
   
    
}

