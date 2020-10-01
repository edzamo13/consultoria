/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iessHcam.gestion.seguridad.jsf.servlet;

import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;
import ec.gob.iessHcam.componente.comun.logs.Log;
import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.EscuchaEnum;
import ec.gob.iessHcam.gestion.seguridad.servicio.ClienteRestServicio;
import ec.gob.iessHcam.ws.autentificacion.MenuEntrada;
import ec.gob.iessHcam.ws.autentificacion.MenuRespuesta;
import ec.gob.iessHcam.ws.autentificacion.UsuarioSalida;
import ec.gob.iessHcam.ws.gestionAs400.UnidadMedicaEntrada;
import ec.gob.iessHcam.ws.gestionAs400.UnidadMedicaSalida;
import iesshcam.plantilla.jsf.bb.PlantillaBb;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ezamora
 */
@WebServlet(name = "ClienteEscucha", urlPatterns = {"/clienteEscucha"})
public class ClienteEscucha extends HttpServlet {

    private static final long serialVersionUID = -9053810305719461525L;

    @Inject
    @Getter
    @Setter
    private PlantillaBb principalBb;

    @EJB
    @Getter
    private ClienteRestServicio clienteRestServicio;
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
        // TODO Auto-generated method stub
        ServletContext context = getServletContext();
        try {
            
            getPrincipalBb().setSalida(new UsuarioSalida());
            getPrincipalBb().getSalida().setIdUsuario(request.getParameter("INidUsuario"));
            getPrincipalBb().getSalida().setUsuario(request.getParameter("INusuario"));
            getPrincipalBb().getSalida().setNumDocumento(request.getParameter("INnumeroDocumento"));
            getPrincipalBb().getSalida().setIpUsuario(request.getParameter("INipUsuario"));
            getPrincipalBb().getSalida().setIdAplicacion(request.getParameter("INidAplicacion"));
            getPrincipalBb().getSalida().setCodUnme(request.getParameter("INcodUnme"));
            getPrincipalBb().getSalida().setNombrePersona(request.getParameter("INnombrePersona"));
            getPrincipalBb().getSalida().setAplicativo(request.getParameter("INaplicativo"));
            
            /*
            getPrincipalBb().setSalida(new UsuarioSalida());
            getPrincipalBb().getSalida().setIdUsuario("1");
            getPrincipalBb().getSalida().setUsuario("EZAMORAM");
            getPrincipalBb().getSalida().setNumDocumento("1722624226");
            getPrincipalBb().getSalida().setIpUsuario("localHost");
            getPrincipalBb().getSalida().setIdAplicacion("2");
            getPrincipalBb().getSalida().setCodUnme("1110100000");
            getPrincipalBb().getSalida().setNombrePersona("Jorge Zúñiga");*/
            
            try {
                MenuEntrada entradaMenu = new MenuEntrada();
                UnidadMedicaEntrada entradaUnidad = new UnidadMedicaEntrada();
                entradaMenu.setCodigoAplicacion(getPrincipalBb().getSalida().getIdAplicacion());
                entradaMenu.setIdUsuario(getPrincipalBb().getSalida().getIdUsuario());
                entradaUnidad.setCodigoUnme(getPrincipalBb().getSalida().getCodUnme());
                MenuRespuesta respuestaMenu = getClienteRestServicio().obtenerMenu(entradaMenu);
                UnidadMedicaSalida respuestaUnidad = getClienteRestServicio().obtenerDescripcionUnme(entradaUnidad);
                getPrincipalBb().getSalida().setMenuSalidas(respuestaMenu.getCuerpoLista());
                getPrincipalBb().getSalida().setUnidadMedicaSalida(respuestaUnidad);

            } catch (ServicioExcepcion ex) {
                Logger.getLogger(ClienteEscucha.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("" + getPrincipalBb().getSalida().toString());
            if (getPrincipalBb().getSalida() != null) {
                request.getSession().setAttribute(EscuchaEnum.CREDENCIAL_OBJETO_SESION.getObjeto(), getPrincipalBb().getSalida());
                response.sendRedirect(request.getContextPath() + "/pages/private/principal.jsf");
                System.out.println("Set Variables");
            } else {
                request.getSession().invalidate();
                context.getRequestDispatcher("/error/403.jsf").forward(request, response);
            }

//
//            if (getPrincipalBb().getSalida().getIdUsuario().isEmpty()) {
//                request.getSession().setAttribute(EscuchaEnum.CREDENCIAL_OBJETO_SESION.getObjeto(), getPrincipalBb().getSalida());
//                response.sendRedirect(request.getContextPath() + "pages/private/menu.jsf");
//            } else {
//                request.getSession().invalidate();
//                context.getRequestDispatcher("/error/403.jsf").forward(request, response);
//            }
        } catch (RuntimeException e) {
            Log.error(UsuarioSalida.class.getName(), "Error al ingresar a la aplicacion", e);
            context.getRequestDispatcher("/error/500.jsf").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
