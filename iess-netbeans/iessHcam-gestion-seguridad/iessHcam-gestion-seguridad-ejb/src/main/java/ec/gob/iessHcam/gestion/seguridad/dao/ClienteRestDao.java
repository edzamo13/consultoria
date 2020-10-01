/* 
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR.
 * Todos los derechos reservados.
 */
package ec.gob.iessHcam.gestion.seguridad.dao;

import ec.gob.iessHcam.cliente.restful.WsClienteRestful;
import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;
import ec.gob.iessHcam.componente.comun.utilitario.FechasUtil;
import ec.gob.iessHcam.componente.comun.utilitario.base.datos.EjecutaSelectNativos;
import ec.gob.iessHcam.componente.comun.utilitario.base.datos.SqlComun;
import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.CodigoMetodoServicioWebEnum;
import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.CodigoRetornoEnum;
import ec.gob.iessHcam.gestion.seguridad.dao.impl.DaoImpl;
import ec.gob.iessHcam.ws.autentificacion.MenuEntrada;
import ec.gob.iessHcam.ws.autentificacion.MenuRespuesta;
import ec.gob.iessHcam.ws.autentificacion.MetodoxServicioEntrada;
import ec.gob.iessHcam.ws.autentificacion.MetodoxServicioSalida;
import ec.gob.iessHcam.ws.gestionAs400.UnidadMedicaEntrada;
import ec.gob.iessHcam.ws.gestionAs400.UnidadMedicaRespuesta;
import ec.gob.iessHcam.ws.gestionAs400.UnidadMedicaSalida;
import ec.gob.iessHcam.ws.registrocivil.CeduladoEntradaHcam;
import ec.gob.iessHcam.ws.registrocivil.CeduladoRespuesta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * <b> Clase que permite consultar los web services a través del cliente. </b>
 *
 * @author gvega
 * @version $Revision: 1.0 $
 * <p>
 * [$Author: gvega $, $Date: 24/8/2015 $]
 * </p>
 */
@Stateless
public class ClienteRestDao extends DaoImpl<Object> {
    
    /**
     * <b>
     * Obtiene el menú de la aplicación por los permisos del usuario.
     * </b>
     *
     * @author Jorge Zúñiga
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 29-feb-2016]</p>
     * @param entrada
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public MenuRespuesta obtenerMenu(MenuEntrada entrada) throws ServicioExcepcion {
         //obtengo url del servidor
        MetodoxServicioSalida url=this.obtenerUrlServicioWeb(CodigoMetodoServicioWebEnum.WS_IESS_HCAM_SEGURIDAD_OBTENER_MENU.getCodigo());

        
        WsClienteRestful cliente = new WsClienteRestful();
        MenuRespuesta respuesta = cliente.invocaWs(url.getUrl(), entrada, MenuRespuesta.class);
        
        if (respuesta != null
                && CodigoRetornoEnum.validarRespuesta(respuesta.getCodigo(), respuesta.getMensaje()) != null) {
            respuesta.setMensaje(CodigoRetornoEnum.validarRespuesta(respuesta.getCodigo(), respuesta.getMensaje()));
        }
        return respuesta;
    }

    /**
     * <b>
     * Obtiene el nombre completo de una unida médica por su código.
     * </b>
     *
     * @author Jorge Zúñiga
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 22-mar-2016]</p>
     * @param entrada
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public UnidadMedicaSalida obtenerDescripcionUnme(UnidadMedicaEntrada entrada) throws ServicioExcepcion {
         //obtengo url del servidor
        MetodoxServicioSalida url=this.obtenerUrlServicioWeb(CodigoMetodoServicioWebEnum.WS_IESS_HCAM_UTILITARIO_OBTENER_NOMBRE_UMIDAD_MEDICA.getCodigo());

        
        WsClienteRestful cliente = new WsClienteRestful();
        UnidadMedicaSalida respuesta = cliente.invocaWs(url.getUrl(), entrada, UnidadMedicaSalida.class);
        if (respuesta != null
                && CodigoRetornoEnum.validarRespuesta(respuesta.getCodigo(), respuesta.getMensaje()) != null) {
            respuesta.setMensaje(CodigoRetornoEnum.validarRespuesta(respuesta.getCodigo(), respuesta.getMensaje()));
        }
        return respuesta;
    }

    /**
     * <b>
     * Obtiene una lista de todas las unidaes médicas. Su código y nombre
     * completo.
     * </b>
     *
     * @author Jorge Zúñiga
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 31-mar-2016]</p>
     * @return
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public List<UnidadMedicaSalida> obtenerUnidadesMedicas() throws ServicioExcepcion {
         //obtengo url del servidor
        MetodoxServicioSalida url=this.obtenerUrlServicioWeb(CodigoMetodoServicioWebEnum.WS_IESS_HCAM_UTILITARIO_OBTENER_UNIDADES_MEDICAS.getCodigo());

        WsClienteRestful cliente = new WsClienteRestful();
        UnidadMedicaRespuesta respuesta = cliente.invocaWs(url.getUrl(), null, UnidadMedicaRespuesta.class);
        if (respuesta != null
                && CodigoRetornoEnum.validarRespuesta(respuesta.getCodigo(), respuesta.getMensaje()) != null) {
            respuesta.setMensaje(CodigoRetornoEnum.validarRespuesta(respuesta.getCodigo(), respuesta.getMensaje()));
        }
        return respuesta.getCuerpoLista();
    }

    
        /**
     *
     * <b>
     * Incluir aqui­ la descripcion del metodo.
     * </b>
     * <p>
     * [$Author: ezamora, $Date: 28-abr-2016]</p>
     * @param codigoServicioWeb
     * @return 
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public MetodoxServicioSalida obtenerUrlServicioWeb(String codigoServicioWeb) throws ServicioExcepcion {
        
        MetodoxServicioEntrada entrada = new MetodoxServicioEntrada();
        entrada.setCodigo(codigoServicioWeb);
        //MetodoxServicioSalida url =this.obtenerUrlServicioWeb(urlWsEntrada);
        
        
        Query query =  getDao().getEntityManager().createNativeQuery(SqlComun.OBTENER_METODO_X_SERVICIO_WEB);
        query.setParameter(1, entrada.getCodigo());
        List<MetodoxServicioSalida> metodoxServicioSalidas = EjecutaSelectNativos.listarPorSentenciaSql(query, MetodoxServicioSalida.class);
        if (metodoxServicioSalidas.isEmpty()) {
            return new MetodoxServicioSalida();
        } else {
            return metodoxServicioSalidas.get(0);
        }
    }
    
    
    /**
     *  * <b>
     *  *   Metodo de consulta y busqueda de cedulas al registro civil.  * </b>
     *  *
     *  * @author user
 
     * <p>
     * [$Author: fquisiguina $, $Date: date]</p>
 
     * @param cedula
     * @return 
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public CeduladoRespuesta consultarRegistroCivil(String cedula) throws ServicioExcepcion{
        try{
           
            //obtengo url del servidor   
            MetodoxServicioSalida url=this.obtenerUrlServicioWeb(CodigoMetodoServicioWebEnum.WS_IESS_HCAM_DNTI_REGISTRO_CIVIL_OBTENER_CEDULA.getCodigo());

            WsClienteRestful cliente = new WsClienteRestful();            
            CeduladoEntradaHcam entrada = new CeduladoEntradaHcam();
            entrada.setCedula(cedula);
            CeduladoRespuesta respuesta = cliente.invocaWs(url.getUrl(), entrada, CeduladoRespuesta.class);
            
            
            
            
            if (respuesta != null
                    && CodigoRetornoEnum.validarRespuesta(respuesta.getCodigo(), respuesta.getMensaje()) != null) {
                respuesta.setMensaje(CodigoRetornoEnum.validarRespuesta(respuesta.getCodigo(), respuesta.getMensaje()));
            }


            if (respuesta.getCodigo().equals("1")){
                respuesta.getCuerpo().setNombre(respuesta.getCuerpo().getNombre().length()<=40 ? respuesta.getCuerpo().getNombre() : respuesta.getCuerpo().getNombre().substring(0, 39));
                respuesta.getCuerpo().setFechaActualizacionCedula(FechasUtil.establecerFormatoFecha(respuesta.getCuerpo().getFechaActualizacionCedula()));
                respuesta.getCuerpo().setFechaFallecimiento(FechasUtil.establecerFormatoFecha(respuesta.getCuerpo().getFechaFallecimiento()));
                respuesta.getCuerpo().setFechaInscripcionDefuncion(FechasUtil.establecerFormatoFecha(respuesta.getCuerpo().getFechaInscripcionDefuncion()));
                respuesta.getCuerpo().setFechaMatrimonio(FechasUtil.establecerFormatoFecha(respuesta.getCuerpo().getFechaMatrimonio()));
                respuesta.getCuerpo().setFechaNacimiento(FechasUtil.establecerFormatoFecha(respuesta.getCuerpo().getFechaNacimiento()));

            }else{
                respuesta.setCuerpo(null);
            }

            return respuesta;
        }catch(Exception e){
            return null;
        }
            
    }
}
