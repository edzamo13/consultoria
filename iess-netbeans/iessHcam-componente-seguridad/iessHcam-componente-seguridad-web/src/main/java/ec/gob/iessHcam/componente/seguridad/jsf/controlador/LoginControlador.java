/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.seguridad.jsf.controlador;

import ec.gob.iessHcam.componente.comun.encriptaciones.ClaveEncriptada;
import ec.gob.iessHcam.componente.comun.encriptaciones.EncriptacionBase64;
import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;
import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ComunEnum;
import ec.gob.iessHcam.componente.comun.utilitario.jsf.UtilitarioJsf;
import ec.gob.iessHcam.componente.seguridad.jsf.bb.LoginBb;
import ec.gob.iessHcam.componente.seguridad.modelo.Intentos;
import ec.gob.iessHcam.componente.seguridad.modelo.Usuario;
import ec.gob.iessHcam.componente.seguridad.servicio.UsuarioServicio;
import ec.gob.iessHcam.ws.autentificacion.UsuarioRespuesta;
import ec.gob.iessHcam.ws.autentificacion.UsuarioSalida;
import java.io.IOException;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.context.RequestContext;

/**
 * <b>
 * Clase LoginControlador clase controladora que maneja la información con JSF.
 * </b>
 *
 * @author ezamora
 * <p>
 * [$Author: ezamora $, $Date: 26/01/2016]</p>
 */
@Named
@ViewScoped
public class LoginControlador extends UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = -5081868162717892871L;

    @Inject
    @Getter
    @Setter
    private LoginBb loginBb;
    @EJB
    @Getter
    private UsuarioServicio usuarioServicio;

    @PostConstruct
    public void inicializar() {
        getLoginBb().setUsuario(new Usuario());
        getLoginBb().setContrasenia(new String());
        getLoginBb().setNombreUsuario(new String());

    }

    /**
     *
     * <b>
     * Metodo para Login.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 18/11/2015]</p>
     *
     */
    public void login() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlgWait').show();");
        
        try {
            
            System.out.println("clave encriptada :" + ClaveEncriptada.claveEncriptadaMd5(getLoginBb().getContrasenia()));
            getLoginBb().setUsuario(getUsuarioServicio().obtenerUsuario(getLoginBb().getNombreUsuario()));

            if (getLoginBb().getNombreUsuario().equals(getLoginBb().getUsuario().getUsUsuario())) {

                if ((ClaveEncriptada.claveEncriptadaMd5(getLoginBb().getContrasenia()).equals(getLoginBb().getUsuario().getUsClave()) && getLoginBb().getUsuario().getUsEsBloqueo() == null)
                        || (getLoginBb().getNombreUsuario().equals(getLoginBb().getUsuario().getUsUsuario()) && getLoginBb().getContrasenia().equals(getLoginBb().getUsuario().getUsClave()))) {
                    try {

                        UsuarioSalida salida = new UsuarioSalida();
                        salida.setUsuario(getLoginBb().getUsuario().getUsUsuario());
                        salida.setNumDocumento(getLoginBb().getUsuario().getUsNumDocumento());
                        salida.setIdUsuario(Integer.toString(getLoginBb().getUsuario().getUsIdUsuario()));
                        salida.setCodUnme(getLoginBb().getUsuario().getUsCodUnme());
                        salida.setIpUsuario(obtenerIpHost());
                        salida.setNombrePersona(getLoginBb().getUsuario().getUsNombrePersona());
                        UsuarioRespuesta respuesta = new UsuarioRespuesta();
                        respuesta.setCodigo(ComunEnum.EXITO.getDescripcion());
                        respuesta.setMensaje(ComunEnum.USUARIO_EXISTENTE.getDescripcion());
                        respuesta.setCuerpo(salida);
                        getRequest().getSession().setAttribute("usuarioRespuesta", respuesta);

                        if ((!salida.getUsuario().equals("")) && (getLoginBb().getUsuario().getUsClaveAnterior() == null || getLoginBb().getUsuario().getUsCorreo() == null || getLoginBb().getUsuario().getUsNumDocumento() == null || getLoginBb().getUsuario().getUsTelefono() == null)) {
                            context.execute("PF('dlgActualUsuario').show();");
                        } else {

                            getLoginBb().getUsuario().setIntentosList(new ArrayList<Intentos>());
                            getUsuarioServicio().guardaUsuario(getLoginBb().getUsuario());

                            String url = "/pages/private/default.jsf";
//                                                getExternalContext().redirect(getRequest().getContextPath() + encodedURL1);

                            //getExternalContext().redirect(getRequest().getContextPath() + url);
                            
                            getExternalContext().redirect(getRequest().getContextPath() + "/app/" + EncriptacionBase64.cifrarCadena("/pages/private/default.jsf"));
                        }

                        //System.out.println("id Session : " + getSession().getId());
                    } catch (IOException ex) {
                        Logger.getLogger(LoginControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {

                    if (getLoginBb().getUsuario().getUsEsBloqueo() != null) {
                        context.execute("PF('dlgCambPass').show();");                        
                        ponerMensajeError("Usuario Bloqueado, Actualize su contraseña");
                    } else if ((getLoginBb().getUsuario().getUsCorreo() == null || getLoginBb().getUsuario().getUsNumDocumento() == null || getLoginBb().getUsuario().getUsTelefono() == null)) {
                        ponerMensajeError("Usuario o Contraseña Incorrecta");
                    } else {
                        ponerMensajeError("Usuario o Contraseña Incorrecta");

                        registrarIntento(getLoginBb().getUsuario());
                    }
                }
            } else {
                ponerMensajeError("Usuario o Contraseña Incorrecta");
            }
        } catch (Exception ex) {
            ponerMensajeError("Usuario o Contraseña Incorrecta");
        }
        
        
        context.execute("PF('dlgWait').hide();");

    }

    public void registrarIntento(Usuario usuario) throws ServicioExcepcion {

        if (usuario.getIntentosList().size() >= 2) {
            usuario.setUsEsBloqueo("DEF");
        }

        Intentos intento = new Intentos();
        intento.setUsIdUsuario(usuario);
        usuario.getIntentosList().add(intento);

        getUsuarioServicio().guardaUsuario(usuario);
    }
    
    
    
    
    public void dormir(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(LoginControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
