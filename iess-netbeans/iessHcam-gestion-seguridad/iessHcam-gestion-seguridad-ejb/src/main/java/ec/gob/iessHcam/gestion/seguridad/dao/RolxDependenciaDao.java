/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iessHcam.gestion.seguridad.dao;

import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;
import ec.gob.iessHcam.componente.comun.logs.Log;
import ec.gob.iessHcam.gestion.seguridad.dao.impl.DaoImpl;
import ec.gob.iessHcam.gestion.seguridad.modelo.Rolxdependencia;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HCAM
 */
public class RolxDependenciaDao extends DaoImpl<Rolxdependencia> {

    public RolxDependenciaDao() {
        super(Rolxdependencia.class);
    }

    /**
     *
     * <b>
     * Guarda un objeto institucion en la base de datos.
     * </b>
     * <p>
     * [$Author: Jorge ZÃºÃ±iga $, $Date: 21/03/2016]</p>
     *
     * @param rolxdependencia
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public boolean guardarRolxDependencia(Rolxdependencia rolxdependencia) throws ServicioExcepcion {

        try {
            
            getDao().guardar(rolxdependencia);

            return true;
        } catch (Exception e) {
            Log.error(TipoRolDao.class.getName(), "Error al Guardar objeto Rol x Dependencia", e);
            return false;
        }

    }
    
    
    
    public boolean eliminaRolxDependencia(Rolxdependencia rolxdependencia) throws ServicioExcepcion {

        try {
            
            rolxdependencia=getDao().obtenerPorLlavePrimaria(rolxdependencia.getRdIdRolxdep());
            
            getDao().remover(rolxdependencia);

            return true;
        } catch (Exception e) {
            Log.error(TipoRolDao.class.getName(), "Error al Remover objeto Rol x Dependencia", e);
            return false;
        }
    }
    
    
    public boolean validaRolxDependencia(Rolxdependencia rolxdependencia) throws ServicioExcepcion {

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("idRol", rolxdependencia.getRoIdRol().getRoIdRol());
        parametros.put("idDependencia", rolxdependencia.getDeIdDependencia().getDeIdDependencia());

        rolxdependencia = getDao().obtenerPorConsultaJpaNombrada(Rolxdependencia.OBTENER_ROLXDEPENDENCIA_POR_IDDEPENDENCI_IDROL,parametros);

        if(rolxdependencia == null){
            return true;
        }
        else{
            return false;
        }
    }
}

