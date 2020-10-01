/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.seguridad.dao;

import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;
import ec.gob.iessHcam.componente.comun.logs.Log;
import ec.gob.iessHcam.componente.seguridad.dao.impl.DaoImpl;
import ec.gob.iessHcam.componente.seguridad.modelo.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * <b>
 * Clase que maneja el dao de aplicación.
 * </b>
 *
 * @author ezamora
 * <p>
 * [$Author: ezamora $, $Date: 02/02/2016]</p>
 */
@LocalBean
@Stateless
public class UsuarioDao extends DaoImpl<Usuario> {

    /**
     *
     * <b> Constructor del UsuarioDao. </b>
     * <p>
     * [Author: gvega, Date: 08/02/2016]
     * </p>
     *
     */
    public UsuarioDao() {
        super(Usuario.class);
    }

    /**
     *
     * <b>
     * obtenerUsuario.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 08/02/2016]</p>
     *
     * @param nombreUsuario usuairo
     * @return Usuario
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public Usuario obtenerUsuario(String nombreUsuario) throws ServicioExcepcion {
        List<Usuario> usuarioList= new ArrayList<>();
        Usuario usrTmp = new Usuario();
        usrTmp.setUsUsuario(nombreUsuario);
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombreUsuario", usrTmp.getUsUsuario());
        usuarioList = getDao().listarPorConsultaJpaNombrada(Usuario.OBTENER_POR_USUSUARIO, parametros);
        if (usuarioList.isEmpty()) {
            return null;
        } else {
            return usuarioList.get(0);
        }
    }
    
    
    public boolean guardaUsuario(Usuario usuario) throws ServicioExcepcion {
        
        try{
            getDao().getEntityManager().merge(usuario);

            return true;
        }
        catch(Exception e){
            Log.error(UsuarioDao.class.getName(), "Error al Guardar objeto Usuario", e);
            return false;
        }
    }
}
