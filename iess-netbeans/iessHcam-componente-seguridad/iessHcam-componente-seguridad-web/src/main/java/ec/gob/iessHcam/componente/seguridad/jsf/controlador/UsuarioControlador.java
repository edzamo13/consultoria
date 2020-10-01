/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/
package ec.gob.iessHcam.componente.seguridad.jsf.controlador;

import ec.gob.iessHcam.componente.comun.encriptaciones.ClaveEncriptada;
import ec.gob.iessHcam.componente.comun.logs.Log;
import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ComunEnum;
import ec.gob.iessHcam.componente.comun.utilitario.jsf.UtilitarioJsf;
import ec.gob.iessHcam.componente.seguridad.jsf.bb.AplicacionBb;
import ec.gob.iessHcam.componente.seguridad.jsf.bb.UsuarioForm;
import ec.gob.iessHcam.componente.seguridad.modelo.Usuario;
import ec.gob.iessHcam.componente.seguridad.modelo.Usuarioshist;
import ec.gob.iessHcam.componente.seguridad.servicio.ClienteRestServicio;
import ec.gob.iessHcam.componente.seguridad.servicio.UsuarioServicio;
import ec.gob.iessHcam.ws.autentificacion.UsuarioRespuesta;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.context.RequestContext;

/**
 * <b>
 * Clase que controla la la actualización de datos del usuario.
 * /pages/private/gestionAplicaciones.xhtml
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>
 * [$Author: Jorge Zúñiga $, $Date: 19-abr-2016]</p>
 */
@Named
@ViewScoped
public class UsuarioControlador extends UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = 162915581869504377L;
    
    @Inject
    @Getter
    @Setter
    private UsuarioForm usuarioForm;
    
    @Inject
    @Getter
    @Setter
    private AplicacionBb aplicacionBb;
    
    @EJB
    @Getter
    @Setter
    private UsuarioServicio usuarioDaoObj;
    
    @EJB
    @Getter
    @Setter
    private ClienteRestServicio restDaoObj;
    
    
    @PostConstruct
    public void inicializar() {

    }

  
    
    /**
     *
     * <b>
     * Guarda en la base de datos la información ingresada en el formulario.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 19/04/2016]</p>
     */
    public void guardaUsuario() {
        try {
           
            if(validaCedula(getUsuarioForm().getIdentificacion())){
                
                if(getUsuarioForm().getNuevoPass().equals(getUsuarioForm().getRepitePass())){
                    
                    getAplicacionBb().setRespuesta((UsuarioRespuesta) devolverObjetosSesion("usuarioRespuesta"));
       
                    if(!getAplicacionBb().getRespuesta().getCuerpo().getUsuario().equals(getUsuarioForm().getNuevoPass())){
                        
                        Usuario usuario = getUsuarioDaoObj().obtenerUsuario(getAplicacionBb().getRespuesta().getCuerpo().getUsuario());

                        usuario.setUsNombrePersona(getUsuarioForm().getNombrePersona());
                        usuario.setUsNumDocumento(getUsuarioForm().getIdentificacion());
                        usuario.setUsCorreo(getUsuarioForm().getEmail());
                        usuario.setUsTelefono(getUsuarioForm().getTelefono());
                        usuario.setUsIdUsuarioAct(usuario.getUsIdUsuario());
                        usuario.setUsFecActualizacion(new Date());
                        usuario.setUsClaveAnterior(usuario.getUsClave());
                        usuario.setUsClave(ClaveEncriptada.claveEncriptadaMd5(getUsuarioForm().getNuevoPass()));
                        usuario.setUsEsBloqueo(null);
                        
                        Usuarioshist historico = new Usuarioshist();
                        historico.setUsIdUsuario(usuario);
                        historico.setUsClaveAnterior(usuario.getUsClaveAnterior());
                        historico.setUsClaveActual(usuario.getUsClave());
                        historico.setUsDireccionIp(obtenerIpHost());
                        historico.setUsFecActualizacion(new Date());

                        usuario.getSegUsuarioshistTblList().add(historico);
                            
                        boolean respuesta = getUsuarioDaoObj().guardaUsuario(usuario);

                        if (respuesta) {
                            RequestContext.getCurrentInstance().execute("PF('dlgActualUsuario').hide();");
                            RequestContext.getCurrentInstance().execute("PF('dlgCierraUsuario').show();");
                        } else {
                            ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
                        }
                    }else{
                        ponerMensajeError("El nombre de usuario y la contraseña no pueden ser las mismas");
                    }
                }else{
                    ponerMensajeError("Las contraseñas Ingresadas no Coinciden");
                }
                
            }else{
                ponerMensajeError("Ingrese una cédula Válida");
            }
        } catch (Exception e) {
            Log.error(UsuarioControlador.class.getName(), "Error al guardar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
        }

    }
    
        
    /**
     *
     * <b>
     * Muestra el dialog de confirmación al guardar un registro.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga$, $Date: 19-abr-2016]</p>
     * @param dialogo
     */
    public void muestraConfirmacion(String dialogo) {
        RequestContext.getCurrentInstance().execute("PF('"+dialogo+"').show();");
    }
    
     
    /**
     *
     * <b>
     * Cierra la session del usuario al actualizar su información.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga$, $Date: 19-abr-2016]</p>
     */
    public void cierraSession(){
        cerrarSesion();
    }
    
    
    
    
    /**
     *
     * <b>
     * Valida que la cédula sea correcta.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga$, $Date: 19-abr-2016]</p>
     */
    private boolean validaCedula(String ced){
       boolean resultado=false;
        String cedula = ced;

            if (cedula.length() == 10)
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    // Coeficientes de validación cédula
                    // El decimo digito se lo considera dígito verificador
                     int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
                     int verificador = Integer.parseInt(cedula.substring(9,10));
                     int suma = 0;
                     int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                     digito = Integer.parseInt(cedula.substring(i, i + 1))* coefValCedula[i];
                     suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        resultado = true;
                    }
                    else if ((10 - (suma % 10)) == verificador) {
                        resultado = true;
                    } else {
                        resultado = false;
                    }
                    
                } else {
                    resultado = false;
                }
            } else {
                resultado = false;
            }
       
        
        return resultado;      
        
    }
    
    
    
    
    
    
    /**
     *
     * <b>
     * Guarda en la base de datos la nueva contraseña
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 19/04/2016]</p>
     */
    public void cambiarPassword() {
        try {
            
            if(validaCedula(getUsuarioForm().getIdentificacion())){
                
                if(getUsuarioForm().getNuevoPass().equals(getUsuarioForm().getRepitePass())){
                    
                    Usuario usuario=getUsuarioDaoObj().obtenerUsuario(getUsuarioForm().getUsuario());
           
                    if(usuario != null){

                        if(usuario.getUsNumDocumento().equals(getUsuarioForm().getIdentificacion())){
                        
                            if(!usuario.getUsUsuario().equals(getUsuarioForm().getNuevoPass())){

                                usuario.setUsIdUsuarioAct(usuario.getUsIdUsuario());
                                usuario.setUsFecActualizacion(new Date());
                                usuario.setUsClaveAnterior(usuario.getUsClave());
                                usuario.setUsClave(ClaveEncriptada.claveEncriptadaMd5(getUsuarioForm().getNuevoPass()));
                                usuario.setUsEsBloqueo(null);

                                Usuarioshist historico = new Usuarioshist();
                                historico.setUsIdUsuario(usuario);
                                historico.setUsClaveAnterior(usuario.getUsClaveAnterior());
                                historico.setUsClaveActual(usuario.getUsClave());
                                historico.setUsDireccionIp(obtenerIpHost());
                                historico.setUsFecActualizacion(new Date());

                                usuario.getSegUsuarioshistTblList().add(historico);

                                boolean respuesta = getUsuarioDaoObj().guardaUsuario(usuario);

                                if (respuesta) {
                                    RequestContext.getCurrentInstance().execute("PF('dlgCambPass').hide();");
                                    RequestContext.getCurrentInstance().execute("PF('dlgCierraUsuario').show();");
                                } else {
                                    ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
                                }
                            }else{
                                ponerMensajeError("El nombre de usuario y la contraseña no pueden ser las mismas");
                            }
                        }else{
                            ponerMensajeError("El número de cédula ingresado no coincide con el que se encuentra registrado");
                        }
                        
                    }else{
                        ponerMensajeError("El Usuario Ingresado no Existe");
                    }
            
                }else{
                    ponerMensajeError("Las contraseñas Ingresadas no Coinciden");
                }
                
            }else{
                ponerMensajeError("Ingrese una cédula Válida");
            }
        } catch (Exception e) {
            Log.error(UsuarioControlador.class.getName(), "Error al guardar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
        }

    }
    
    
    
    
    public void seteaUsuario(String usuario){
        getUsuarioForm().setUsuario(usuario);
    }
}
