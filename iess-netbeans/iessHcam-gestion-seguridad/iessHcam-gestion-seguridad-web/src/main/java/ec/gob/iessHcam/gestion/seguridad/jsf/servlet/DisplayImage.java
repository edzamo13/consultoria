/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iessHcam.gestion.seguridad.jsf.servlet;

import ec.gob.iessHcam.componente.comun.logs.Log;
import ec.gob.iessHcam.gestion.seguridad.modelo.Aplicacion;
import ec.gob.iessHcam.gestion.seguridad.modelo.Usuario;
import ec.gob.iessHcam.gestion.seguridad.servicio.AplicacionServicio;
import ec.gob.iessHcam.gestion.seguridad.servicio.UsuarioServicio;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.ejb.EJB;
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
@WebServlet(name = "DisplayImage", urlPatterns = {"/DisplayImage"})
public class DisplayImage extends HttpServlet {

    private static final long serialVersionUID = -9053810305719461525L;

    
    @EJB
    @Getter
    @Setter
    private AplicacionServicio aplicacionDaoObj;
    
    @EJB
    @Getter
    @Setter
    private UsuarioServicio usuarioDaoObj;
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
        

        InputStream sImage;
        byte[] apImagen = null;
        
        try {
 
            Integer idAplicacion = Integer.parseInt(request.getParameter("idAplicacion"));
            Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            
            if(idAplicacion != null && idAplicacion != 0){
                Aplicacion aplicacion = getAplicacionDaoObj().obtenerAplicacionPorClavePrimaria(idAplicacion);
            
                apImagen = aplicacion.getApImagen();
            }
            else if(idUsuario != null && idUsuario != 0){
                Usuario usuario = getUsuarioDaoObj().obtenerUsuarioPorClavePrimaria(idUsuario);
            
                apImagen = usuario.getUsFoto();
            }
            
            if(apImagen!=null){
                byte[] bytearray = new byte[2000000];

                int size = 0;
                sImage = new ByteArrayInputStream(apImagen);

                response.reset();
                response.setContentType("image/jpeg");

                while ((size = sImage.read(bytearray)) != -1) {
                    response.getOutputStream().
                    write(bytearray, 0, size);
                }
            }
        } catch (Exception e) {
            Log.error(DisplayImage.class.getName(), "Error al Recuperar Imagen de la Base de Datos", e);
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
