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
import ec.gob.iessHcam.gestion.seguridad.modelo.Dependencia;
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
 * <p>[$Author: Jorge Zúñiga $, $Date: 04-mar-2016]</p>
 */
public class DependenciaDao extends DaoImpl<Dependencia>{

    public DependenciaDao() {
        super(Dependencia.class);
    }

    /**
     *
     * <b>
     * Guarda un objeto aplicación en la base de datos.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 26/02/2016]</p>
     *
     * @param dependencia
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public boolean guardarDependencia(Dependencia dependencia) throws ServicioExcepcion {
        
        try{
            getDao().guardar(dependencia);

            return true;
        }
        catch(Exception e){
            Log.error(DependenciaDao.class.getName(), "Error al Guardar objeto Dependencia", e);
            return false;
        }
    }
    
    
    
    
    /**
     *
     * <b>
     * Valida si la dependencia que se va a crear no existe previamente.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 11/03/2016]</p>
     *
     * @param dependencia
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public boolean validaDependencia(Dependencia dependencia) throws ServicioExcepcion {

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", dependencia.getDeNombre().trim());

        Dependencia depeAux = getDao().obtenerPorConsultaJpaNombrada(Dependencia.OBTENER_DEPENDENCIA_POR_NOMBRE,parametros);

        if(depeAux == null){
            return true;
        }
        else{
            if(dependencia.getDeIdDependencia()==null && depeAux == null){
                return true;
            }
            else if(dependencia.getDeIdDependencia()==null && depeAux != null){
                return false;
            }
            else{
                depeAux = getDao().obtenerPorLlavePrimaria(dependencia.getDeIdDependencia());
                
                if(depeAux.getDeNombre().equals(dependencia.getDeNombre())){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
    }
    
    
    /**
     *
     * <b>
     * Obtiene una lista de dependencias que son activas y no estan asignadas al rol.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 26/02/2016]</p>
     *
     * @param idRol
     * @param idInstitucion
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public List<Dependencia> obtenerListaDependenciasNoAsignadas(int idRol, int idInstitucion) throws ServicioExcepcion {
        
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("idRol", idRol);
        parametros.put("idInstitucion", idInstitucion);
        
        List<Dependencia> dependencias = getDao().listarPorConsultaJpaNombrada(Dependencia.OBTENER_DEPENDENCIA_NO_ASIGNADAS_ROL, parametros);
        
        if (dependencias.isEmpty()) {
            return new ArrayList<>();
        } else {
            return dependencias;
        }
    }
}

