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
import ec.gob.iessHcam.gestion.seguridad.modelo.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>
 *   Dao para tabla usuario.
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>[$Author: Jorge Zúñiga $, $Date: 29-mar-2016]</p>
 */
public class UsuarioDao extends DaoImpl<Usuario>{

    public UsuarioDao() {
        super(Usuario.class);
    }
    
    /**
     *
     * <b>
     * Obtiene una lista de Usuarios.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 29-mar-2016]</p>
     *
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public List<Usuario> obtenerUsuarios() throws ServicioExcepcion {
        
        List<Usuario> usuarios = getDao().listarPorConsultaJpaNombrada(Usuario.OBTENER_USUARIOS, null);
        
        if (usuarios.isEmpty()) {
            return new ArrayList<>();
        } else {
            return usuarios;
        }
    }
    
    
    
    /**
     *
     * <b>
     * Guarda un usuario en la base de datos.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 29-mar-2016]</p>
     *
     * @param usuario
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public boolean guardaUsuario(Usuario usuario) throws ServicioExcepcion {
        
        try{
            getDao().guardar(usuario);

            return true;
        }
        catch(Exception e){
            Log.error(UsuarioDao.class.getName(), "Error al Guardar objeto Usuario", e);
            return false;
        }
    }
    
    
    public boolean guardaImagenUsuario(Usuario usuario) throws ServicioExcepcion {
        
        try{
            
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("1", usuario.getUsFoto());
            parametros.put("2", usuario.getUsIdUsuario());
            
            getDao().ejecutarActualizacion("update seguridad.seg_usuarios_tbl set us_foto = ? where us_id_usuario = ?", parametros);

            return true;
        }
        catch(Exception e){
            Log.error(UsuarioDao.class.getName(), "Error al Guardar objeto Usuario", e);
            return false;
        }
    }
    
    
    /**
     *
     * <b>
     * Obtiene un usuario por su clave primaria.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 30/03/2016]</p>
     *
     * @param idUsuario
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public Usuario obtenerUsuarioPorClavePrimaria(int idUsuario) throws ServicioExcepcion {

        Usuario usuario = getDao().obtenerPorLlavePrimaria(idUsuario);
        
        return usuario;
    }
    
    
    /**
     *
     * <b>
     * Obtiene un usuario por su nombre.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 30/03/2016]</p>
     *
     * @param nomUsuario
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public Usuario obtenerUsuarioPorNombre(String nomUsuario) throws ServicioExcepcion {

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("usuario", nomUsuario);
        
        Usuario usuario = getDao().obtenerPorConsultaJpaNombrada(Usuario.OBTENER_USUARIO_POR_NOMBRE, parametros);
        
        return usuario;
    }
    
    
    /**
     *
     * <b>
     * Obtiene lista de usuarios por su identificación.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 30/03/2016]</p>
     *
     * @param identificacion
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public List<Usuario> obtenerUsuarioPorIdentificacion(String identificacion) throws ServicioExcepcion {

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("identificacion", identificacion);
        
        List<Usuario> usuarios = getDao().listarPorConsultaJpaNombrada(Usuario.OBTENER_USUARIOS_POR_IDENTIFICACION, parametros);
        
        if (usuarios.isEmpty()) {
            return new ArrayList<>();
        } else {
            return usuarios;
        }
    }
}

