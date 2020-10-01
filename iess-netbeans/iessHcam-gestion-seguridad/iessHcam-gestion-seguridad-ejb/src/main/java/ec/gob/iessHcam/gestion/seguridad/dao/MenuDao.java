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
import ec.gob.iessHcam.gestion.seguridad.modelo.Menu;
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
 * <p>[$Author: Jorge Zúñiga $, $Date: 08-mar-2016]</p>
 */
public class MenuDao extends DaoImpl<Menu>{

    public MenuDao() {
        super(Menu.class);
    }
    
    /**
     *
     * <b>
     * Guarda un objeto aplicación en la base de datos.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 08/mar/2016]</p>
     *
     * @param menu
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public boolean guardarMenu(Menu menu) throws ServicioExcepcion {
        
        try{
            getDao().guardar(menu);

            if(menu.getMeIdOpcionPadre() != null){
                Menu padre=getDao().obtenerPorLlavePrimaria(menu.getMeIdOpcionPadre());
                padre.setMeUrl("#");
                padre.setMeNodoFinal(0);
                
                getDao().guardar(padre);
            }
            
            return true;
        }
        catch(Exception e){
            Log.error(MenuDao.class.getName(), "Error al Guardar objeto Menu", e);
            return false;
        }
    }
    
    
    /**
     *
     * <b>
     * Obtiene el menú de una aplicaciones por su id.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 21/03/2016]</p>
     *
     * @param idAplicacion
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public List<Menu> obtenerMenuxAplicacion(int idAplicacion) throws ServicioExcepcion {
        
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("idAplicacion", idAplicacion);
        
        List<Menu> listMenu = getDao().listarPorConsultaJpaNombrada(Menu.OBTENER_MENU_POR_APLICACION, parametros);
        
        if (listMenu.isEmpty()) {
            return new ArrayList<>();
        } else {
            return listMenu;
        }
    }
    
    
    public List<Menu> obtenerMenuxAplicacionNoAsignado(int idAplicacion, int idRol) throws ServicioExcepcion {
        
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("idAplicacion", idAplicacion);
        parametros.put("idRol", idRol);
        
        List<Menu> listMenu = getDao().listarPorConsultaJpaNombrada(Menu.OBTENER_MENU_POR_APLICACION_NO_ASIGNADOS_A_ROL, parametros);
        
        if (listMenu.isEmpty()) {
            return new ArrayList<>();
        } else {
            return listMenu;
        }
    }
    
}

