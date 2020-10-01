/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.seguridad.jsf.servlet;

import ec.gob.iessHcam.componente.comun.logs.Log;
import ec.gob.iessHcam.componente.seguridad.dao.ClienteRestDao;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Getter;

/**
 *
 * @author christian
 */
@WebServlet(name = "AplicacionEscucha", urlPatterns = {"/aplicacionEscucha"})
public class AplicacionEscucha extends HttpServlet {

    private static final long serialVersionUID = 8342368676481709462L;

    @EJB
    @Getter
    private ClienteRestDao clienteRestDao;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        try {
//            EscuchaEntrada escuchaEntrada = new EscuchaEntrada();
//            escuchaEntrada.setInTrama(request.getParameter("inTrama"));
//            escuchaEntrada.setInUsuario(request.getParameter("inUsuario"));
//            escuchaEntrada.setInCodigoAplicacion(request.getParameter("inCodigoAplicacion"));
//            escuchaEntrada.setInIdUsuario(request.getParameter("inIdUsuario"));
//            escuchaEntrada.setInNumeroDocumento(request.getParameter("inNumeroDocumento"));
//
//            ec.gob.iess.componente.comun.logs.Log.info(AplicacionEscucha.class.getName(), "---" + escuchaEntrada);
//
//            String urlWsValidarAutenticacion = clienteRestDao.obtenerConsultaMetodo(CodigoServicioRestEnum.INFTRA_001.getCodigo());
//
//            Map<String, String> urlsServicios = new HashMap();
//            urlsServicios.put(CodigoServicioRestEnum.POLCOR_002.getCodigo(), clienteRestDao.obtenerConsultaMetodo(CodigoServicioRestEnum.POLCOR_002.getCodigo()));
//            urlsServicios.put(CodigoServicioRestEnum.REGCIV_002.getCodigo(), clienteRestDao.obtenerConsultaMetodo(CodigoServicioRestEnum.REGCIV_002.getCodigo()));
//            urlsServicios.put(CodigoServicioRestEnum.ACCMEN_002.getCodigo(), clienteRestDao.obtenerConsultaMetodo(CodigoServicioRestEnum.ACCMEN_002.getCodigo()));
//            urlsServicios.put(CodigoServicioRestEnum.ACCMEN_003.getCodigo(), clienteRestDao.obtenerConsultaMetodo(CodigoServicioRestEnum.ACCMEN_003.getCodigo()));
//            urlsServicios.put(CodigoServicioRestEnum.ACCMEN_004.getCodigo(), clienteRestDao.obtenerConsultaMetodo(CodigoServicioRestEnum.ACCMEN_004.getCodigo()));
//            urlsServicios.put(CodigoServicioRestEnum.LOGUNI_001.getCodigo(), clienteRestDao.obtenerConsultaMetodo(CodigoServicioRestEnum.LOGUNI_001.getCodigo()));
//            urlsServicios.put(CodigoServicioRestEnum.LOGUNI_002.getCodigo(), clienteRestDao.obtenerConsultaMetodo(CodigoServicioRestEnum.LOGUNI_002.getCodigo()));
//            urlsServicios.put(CodigoServicioRestEnum.INFTRA_002.getCodigo(), clienteRestDao.obtenerConsultaMetodo(CodigoServicioRestEnum.INFTRA_002.getCodigo()));
//            urlsServicios.put(CodigoServicioRestEnum.INAUDI_001.getCodigo(), clienteRestDao.obtenerConsultaMetodo(CodigoServicioRestEnum.INAUDI_001.getCodigo()));
//            urlsServicios.put(CodigoServicioRestEnum.POLCOR_003.getCodigo(), clienteRestDao.obtenerConsultaMetodo(CodigoServicioRestEnum.POLCOR_003.getCodigo()));
//            urlsServicios.put(CodigoServicioRestEnum.INFTRA_001.getCodigo(), urlWsValidarAutenticacion);
//            
//            WsClienteRestful clienteWs = new WsClienteRestful();
//            AutentificacionEntrada autentificacionEntrada = new AutentificacionEntrada();
//            autentificacionEntrada.setCodigoAplicacion(escuchaEntrada.getInCodigoAplicacion());
//            autentificacionEntrada.setNumeroDocumento(escuchaEntrada.getInNumeroDocumento());
//            autentificacionEntrada.setTrama(escuchaEntrada.getInTrama());
//            AutentificacionRespuesta respuesta = clienteWs.invocaWs(urlWsValidarAutenticacion, autentificacionEntrada, AutentificacionRespuesta.class);
//            if (respuesta != null && respuesta.getCuerpo().equals(ec.gob.iess.componente.comun.utilitario.enumeraciones.ComunEnum.AUTENTICACION_OK.getDescripcion())) {
//                request.getSession().setAttribute(EscuchaEnum.CREDENCIAL_OBJETO_SESION.getObjeto(), escuchaEntrada);
//                request.getSession().setAttribute(ObjetoSesionEnum.MAPA_URLS_SERVICIOS.getCodigo(), urlsServicios);
//
//                response.sendRedirect(request.getContextPath() + "/direccion/pagina/principal.jsf");
//            } else {
//                request.getSession().invalidate();
//                context.getRequestDispatcher("/errorWeb/403.jsf").forward(request, response);
//            }
        } catch (RuntimeException e) {
           Log.error(AplicacionEscucha.class.getName(), "Error al ingresar a la aplicacion", e);
            context.getRequestDispatcher("/errorWeb/500.jsf").forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
