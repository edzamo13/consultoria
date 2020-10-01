///*
//* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
//* Todos los derechos reservados
//*/
//package ec.gob.iessHcam.ws.login;
///**
// * <b>
// *  Clase que gestiona el acceso a la aplicacion a Triage
// * </b>
// *
// * @author LENIN
// * <p>[$Author: LENIN $, $Date: 04-mar-2016]</p>
// * 
// * 
// */
//
//import java.io.IOException;
//
//import com.ibm.as400.access.AS400;
//import com.ibm.as400.access.AS400SecurityException;
//
//public class Login {
//    
//     /*Variables de Conexión*/
//    
//    private String usuario;
//    private String contrasenia;
//    private String url;
//    private AS400 as400;
//    
//    
//    
//    /**
//     * <b> Constructor de la clase </b>
//     * <p>
//     * [Author: lennin, Date: 04/03/2016]
//     * </p>
//     *
//     * @param usuario 
//     * @param contrasenia 
//     */
//    public Login(String usuario, String contrasenia, String amb) {
//
//        try {
//
//           
//            this.usuario = usuario;
//            this.contrasenia = contrasenia;
//            
//            if (amb.equals("PRO"))
//                this.url="as400.iess.gob.ec";
//            else if (amb.equals("DES"))   
//                this.url="172.16.4.28";
//             
//            as400 = new AS400(url, this.usuario , this.contrasenia);
//
//            as400.disconnectAllServices();
//            
//        } catch (Exception e) {
//
//        }
//    }
//    
//    /**
//     * <b> Método se encarga de retornar el estado del logueo:
//     * Si tuvo éxito = 1
//     * Usuario desconocido o contraseña erronea = 0
//     * Contraseña expirada = 2
//     * Usuario desabilitado = 3
//     * </b>
//     * <p>
//     * [Author: lennin, Date: 04/03/2016]
//     * </p>
//     *
//     * @param usuario 
//     * @param contrasenia 
//     * @return cadena codificada
//     * @throws IOException  en caso de error
//     * @throws AS400SecurityException  en caso de error
//     * 
//     */
//    public int getEstadoLogeo() throws AS400SecurityException, IOException{
//       int res=-1;
//       String resultado="";
//       boolean logueado=false;
//       
//       if(usuario.equals("ADMIN")){
//       	return 1;
//       }else{
//     
//    	   logueado=as400.authenticate(usuario , contrasenia);
//       
//        if(logueado==true){
//            res=1;
//        }
//        if(resultado.equalsIgnoreCase("User ID is not known") || resultado.equalsIgnoreCase("Password is incorrect")){
//            res=0;
//        }
//        if(resultado.equalsIgnoreCase("Password is expired")){
//            res=2;
//        }
//        if(resultado.equalsIgnoreCase("User ID is disabled")){
//            res=3;
//        }
//         as400.disconnectAllServices();
//         return res;
//        }
//        
//    }
//
//}
//
