///*
//* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
//* Todos los derechos reservados
//*/
//package ec.gob.iessHcam.ws.login;
//
//import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
//
///**
// * <b>
// *   Clase con métodos para encriptar y desencriptar usuario de AS400
// * </b>
// *
// * @author LENIN
// * <p>[$Author: LENIN $, $Date: 04-mar-2016]</p>
// */
//public class Encripta {
//    
//    /**
//     * <b> Constructor de la clase</b>
//     * <p>
//     * [Author: lennin, Date: 04/03/2016]
//     * </p>
//     *
//     * 
//     */
//    
//    public  Encripta() { 
//        super();
//    }
//    
//     /**
//     * <b> Metodo utilitario para Encriptar una clave con la libreria jasypt 1.9.2</b>
//     * <p>
//     * [Author: lennin, Date: 04/03/2016]
//     * </p>
//     *
//     * @param cadena
//     *            a desencriptar
//     * @return cadena desencriptada
//     * 
//     */
//    
//    public String cifra(String cadena) { 
//        StandardPBEStringEncryptor s = new StandardPBEStringEncryptor();
//        s.setPassword("HcAm");
//        String res =  s.encrypt(cadena);
//        return res; 
//    }
//    
//    /**
//     * <b> Metodo utilitario para Desencriptar una clave con la libreria jasypt 1.9.2 </b>
//     * <p>
//     * [Author: lennin, Date: 04/03/2016]
//     * </p>
//     *
//     * @param cadena
//     *            a desencriptar
//     * @return cadena desencriptada
//     * 
//     */
//    public String desencripta(String cadena) { 
//        StandardPBEStringEncryptor s = new StandardPBEStringEncryptor(); 
//        s.setPassword("HcAm"); 
//        String devuelve = ""; 
//        try { 
//            devuelve = s.decrypt(cadena); 
//        } catch (Exception e) { 
//        } 
//        return devuelve; 
//    }
//
//}
//
