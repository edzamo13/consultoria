///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package ec.gob.iessHcam.componente.comun.as400;
//
//import com.ibm.as400.access.*;
//import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpServletRequest;
//
//
///**
// *
// * @author HCAM no se si debi haber creado esta clase
// *
// */
//public class ConexionAS400 {
//
//    private String usuario;
//    private String contraseña;
//    private String url;
//    private String libreria;
//    private String programa;
//    private AS400 as400;
//
//
//    public ConexionAS400(String usuario, String contraseña, String url,String libreria,String programa) {
//        
//        this.usuario = usuario;   //Usuario con el que se conectará
//        this.contraseña = contraseña;  //Contraseña del usuario
//        this.url = url;                //direción ip del servidor as400 puede ser: //172.16.7.11  o   AS400.IESS.GOV.EC
//                                       //también puede ser un odbc: jdbc:odbc:nombre_delODBC
//        
//        this.libreria=libreria;        //la librería donde se encuentra el programa rpg : LIBHTTP.LIB
//        this.programa=programa;        //El nombre del programa rpg: PROGRAMA1.PGM
//                 
//        this.as400 = new AS400(this.url, this.usuario, this.contraseña);  //Se crea un objeto as400 
//
//        this.as400.disconnectAllServices();
//    }
//
//    public String llamarRpg(String parm1, String parm2) {   //lO QUE ESTE MÉTODO HACE ES LLAMAR UN PROGRAMA RPG, ENVIANDOLE UNA CADENA DE TEXTO, 
//                                                            //EL PROGRAMA RPG RECIBE ESTA CADENA, LA PROCESA  Y DEVUELVE UN MENSAJE SI HA TENIDO ÉXITO O NO
//
//        
//        try {
//
//            String iplocal ;
//            
//            HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        
//
//            iplocal=request.getRemoteAddr();
//       
//            
//            AS400Text txt80 = new AS400Text(900);          //SE CREA LA CADENA DE TEXTO TIPO AS400
//
//            ProgramParameter[] parmList = new ProgramParameter[1];    //CREAMOS UN ARREGLO DE ESPACIO 1, QUE SIGNIFICA QUE SOLO ENVIAREMOS UN PARÁMETRO YA QUE EL RPG EN ESTE CASO TAN SOLO RECIBE UN PARÁMETRO
//
//            parmList[0] = new ProgramParameter(txt80.toBytes(parm1 + parm2 + iplocal), 900); //CARGAMOS LA CADENA DE TEXTO EN STRING DE JAVA EN EL AS400TEXT Y LO TRANSFORMAMOS EN BYTE, ESTO LO CARGAMOS EN EL ARREGLO TIPO PARÁMERO
//
//            ProgramCall program = new ProgramCall(as400);    //CREAMOS UNA LLAMADA A UN PROGRAMA AS400 INSTANCIANDOLO SOLO CON EL USUARIO, CONTRASEÑA Y LA DIRECCIÓN DEL SERVIDOR
//
//            program.setProgram("/QSYS.LIB/" + libreria + "/" + programa, parmList);   //llamamos al programa  QUE SE ENCUENTRA EN DENTRO DE UNA LIBRERÍA y enviamos la lista de parámetros
//
//
//            
//            program.run();    //CORREMOS AL PROGRAMA
//
//            String msg = (String) txt80.toObject(parmList[0].getOutputData());    //EL RPG DEBERÁ ENVIARNOS UNA RESPUESTA DE TIPO TXT QUE LA PASAMOS A STRING DE JAVA
//
//            this.as400.disconnectAllServices();  //NOS DESCONECTAMOS
//            
//            return msg;
//
//        } catch (Exception e) {
//
//            String msg="";
//            return msg;
//        }
//    }
//
//    
//    
//}