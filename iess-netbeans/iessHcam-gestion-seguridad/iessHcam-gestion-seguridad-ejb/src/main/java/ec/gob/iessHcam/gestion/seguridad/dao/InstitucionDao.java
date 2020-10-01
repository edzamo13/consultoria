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
import ec.gob.iessHcam.gestion.seguridad.modelo.Institucion;
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
 * <p>[$Author: Desarrollo $, $Date: 23-feb-2016]</p>
 */
public class InstitucionDao extends DaoImpl<Institucion>{

    public InstitucionDao() {
        super(Institucion.class);
    }
    
    /**
     *
     * <b>
     * Obtiene una lista de instituciones activas.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 26/02/2016]</p>
     *
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public List<Institucion> obtenerListaInstituciones() throws ServicioExcepcion {
        
        List<Institucion> ListInstituciones = getDao().listarPorConsultaJpaNombrada(Institucion.OBTENER_INSTITUCIONES_ACTIVAS, null);
        
        if (ListInstituciones.isEmpty()) {
            return new ArrayList<>();
        } else {
            return ListInstituciones;
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
     * @param institucion
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public boolean guardarInstitucion(Institucion institucion) throws ServicioExcepcion {
        
        try{
            getDao().guardar(institucion);

            return true;
        }
        catch(Exception e){
            Log.error(InstitucionDao.class.getName(), "Error al Guardar objeto Institución", e);
            return false;
        }
       
    }
    
    
    /**
     *
     * <b>
     * Valida si la institución que se va a crear no existe previamente.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 10/03/2016]</p>
     *
     * @param institucion
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public boolean validaInstitucion(Institucion institucion) throws ServicioExcepcion {

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", institucion.getInNombre().trim());

        Institucion instAux = getDao().obtenerPorConsultaJpaNombrada(Institucion.OBTENER_INSTITUCION_POR_NOMBRE,parametros);

        if(instAux == null){
            return true;
        }
        else{
            if(institucion.getInIdInstitucion()==null && instAux == null){
                return true;
            }
            else if(institucion.getInIdInstitucion()==null && instAux != null){
                return false;
            }
            else{
                instAux = getDao().obtenerPorLlavePrimaria(institucion.getInIdInstitucion());
                
                if(instAux.getInNombre().equals(institucion.getInNombre())){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
    }
    
}

