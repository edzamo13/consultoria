/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.seguridad.jsf.controlador;

import ec.gob.iessHcam.componente.comun.logs.Log;
import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ComunEnum;
import ec.gob.iessHcam.componente.comun.utilitario.jsf.UtilitarioJsf;
import ec.gob.iessHcam.componente.seguridad.dao.ClienteRestDao;
import iesshcam.plantilla.jsf.bb.PlantillaBb;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author root
 */
@Named
@ViewScoped
public class PrincipalControlador extends UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = 162915581869504377L;

//    @Inject
//    @Getter
//    @Setter
//    private PrincipalBb principalBb;
    @Inject
    @Getter
    @Setter
    private PlantillaBb principalBb;

//    @Inject
//    @Getter
//    @ManagedProperty(value = "#{navegacionControlador}")
//    private NavegacionControlador navegacionControlador;
    @EJB
    @Getter
    private ClienteRestDao clienteRestDao;

    @Getter
    @Setter
    private boolean parada;

    @PostConstruct
    public void inicializar() {
        try {
//            getNavegacionControlador().getNavegacionControladorBb().setEntityManager(getClienteRestDao().getDao().getEntityManager());
            cargarMenu();
        } catch (RuntimeException e) {
            Log.error(PrincipalControlador.class.getName(), "Error al inicilizar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_INICIALIZACION.getDescripcion());
        }
    }

    /**
     *
     * <b>
     * Abre el link para registrar las cuentas bancarias.
     * </b>
     * <p>
     * [Author: gvega, Date: 21/01/2015]</p>
     *
     */
//    public void registrarCuentaBancaria() {
//        try {
//            String cadena = EncriptacionCuentaBancaria.encriptaCuenta(getNavegacionControlador().getNavegacionControladorBb().getUsuarioSesion().getNumeroDocumento());
//
//            PoliticaCorporativaRespuesta corporativasRespuesta = clienteRestDao.obtenerPoliticaCorporativa(PoliticaCorporativaEnum.POLITICA_CUENTA_BANCARIA.getCodigo());
//            if (corporativasRespuesta != null) {
//                String urlCuenta = corporativasRespuesta.getCuerpo().getValorPolitica().concat(cadena).concat("&reqCode=inicio");
//                getResponse().sendRedirect(urlCuenta);
//            } else {
//                ponerMensajeError("No se puede registrar la cuenta bancaria, favor intente mas tarde.");
//            }
//        } catch (ServicioExcepcion | IOException e) {
//            Log.error(PrincipalControlador.class.getName(), "Error al ingresar al registro de cuenta bancaria.", e);
//            ponerMensajeError("No se puede registrar la cuenta bancaria, favor intente mas tarde.");
//        }
//    }
    private void cargarMenu() {
//        MenuEntrada entrada = new MenuEntrada();
//        entrada.setCodigoAplicacion(getNavegacionControlador().getNavegacionControladorBb().getCodigoAplicacion());
//        entrada.setIdUsuario(getNavegacionControlador().getNavegacionControladorBb().getUsuarioSesion().getId());
//
//        WsClienteRestful ws = new WsClienteRestful();
//        MenuRespuesta menuRespuesta = ws.invocaWs(clienteRestDao.obtenerConsultaMetodo(CodigoServicioRestEnum.ACCMEN_001.getCodigo()),
//                entrada, MenuRespuesta.class);
//
//        if (menuRespuesta.getCodigo().equals(CodigoRetornoEnum.CORRECTO.getCodigo())) {
//            getNavegacionControlador().recibeMenu(menuRespuesta.getCuerpoLista(), "");
//        } else {
//            ponerMensajeError("No se lograron cargar los menus");
//        }

    }

    public void pararPoll() {
        setParada(true);
    }
}
