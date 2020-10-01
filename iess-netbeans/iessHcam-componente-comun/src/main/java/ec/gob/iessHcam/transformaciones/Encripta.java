//package ec.gob.iessHcam.transformaciones;
//
//import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
//
//public class Encripta {
//	private String pwd = "HcAm";
//	
//	public  String cifra(String cadena) { 
//		
//        StandardPBEStringEncryptor s = new StandardPBEStringEncryptor(); 
//        s.setPassword(pwd); 
//        String res =  s.encrypt(cadena);
//        return res; 
//    } 
// 
//	public String desencripta(String cadena) { 
//        StandardPBEStringEncryptor s = new StandardPBEStringEncryptor(); 
//        s.setPassword(pwd); 
//        String devuelve = ""; 
//        try { 
//            devuelve = s.decrypt(cadena); 
//        } catch (Exception e) { 
//        } 
//        return devuelve; 
//    } 
//    
//   
//	
//}
