///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package ec.gob.iessHcam.componente.comun.utilitario;
//
//import com.zebra.sdk.comm.Connection;
//import com.zebra.sdk.comm.ConnectionException;
//import com.zebra.sdk.comm.TcpConnection;
//import com.zebra.sdk.printer.PrinterLanguage;
//import com.zebra.sdk.printer.ZebraPrinterFactory;
//import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;
//import ec.gob.iessHcam.componente.comun.logs.Log;
//import java.io.UnsupportedEncodingException;
//import java.net.URL;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.cups4j.CupsClient;
//import org.cups4j.CupsPrinter;
//import org.cups4j.PrintJob;
//import org.cups4j.PrintRequestResult;
///**
// *
// * @author HCAM
// */
//public class ImpresionManillas {
//    
//      /**
//     *
//     * <b>
//     * Imprime una manilla.
//     * </b>
//     * <p>
//     * [$Author: Jorge Zúñiga $, $Date: 15/04/2016]</p>
//     *
//     * @param ipImpresora
//     * @param textoImprime
//     * @return
//     */
//    public static boolean imprimirManilla(String ipImpresora, String textoImprime) {
//        
//        Connection printerConnection=null;
//        
//        try{
//            
//            TcpConnection tcpCone=new TcpConnection(ipImpresora, 9100);
//            printerConnection = tcpCone;
//
//            printerConnection.open();
//
//            PrinterLanguage printerLanguage = ZebraPrinterFactory.getInstance(printerConnection).getPrinterControlLanguage();
//
//            printerConnection.write(dibujarManilla(printerLanguage, textoImprime));
//            
//            return true;
//        }
//        catch(ConnectionException | ZebraPrinterLanguageUnknownException e){
//            Log.error(ImpresionManillas.class.getName(), "Error al imprimir manilla", e);
//            return false;
//        }
//        finally{
//            try {
//
//                if (printerConnection != null)
//                    printerConnection.close();
//
//            } catch (ConnectionException e) {
//                Log.error(ImpresionManillas.class.getName(), "Error al imprimir manilla", e);
//            }
//        }
//        
//
//    }
//    
//    
//    
//     /**
//     *
//     * <b>
//     * Imprime a un servidor de impresion.
//     * </b>
//     * <p>
//     * [$Author: Jorge Zúñiga $, $Date: 31/10/2016]</p>
//     * @param host Ejem: http://172.16.98.253:631/printers/ZebraGT800
//     * @param documento 
//     * @return
//     */
//    public static boolean imprimirServerPrinter(String host,  byte[] documento, int numImpre) {
//        try {
//            String ip = host.substring(host.indexOf("//")+2, host.indexOf(":", 10));
//            
//            int puerto = Integer.parseInt(host.substring(host.indexOf(":",10)+1, host.indexOf("/", 10)));
//            
//            CupsClient cupsClient = new CupsClient(ip, puerto);
//            CupsPrinter printer = cupsClient.getPrinter(new URL(host));
//            
//            PrintJob job = new PrintJob.Builder(documento).jobName("job").userName("root").copies(numImpre).build();
//            
//            printer.print(job);
//            
//            return true;
//        } catch (Exception ex) {
//            Logger.getLogger(ImpresionManillas.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//            
//        }
//    }
//    
//    
//    
//    /**
//     *
//        PrintJob job = builder.jobName("job").userName("root"
//     * <b>
//     * Dibuja la manilla que se va a imprimir.
//     * </b>
//     * <p>
//     * [$Author: Jorge Zúñiga $, $Date: 15/04/2016]</p>
//     *
//     * @param printerLanguage
//     * @param textoImprime
//     * @return 
//     */
//     public static byte[] dibujarManilla(PrinterLanguage printerLanguage, String textoImprime) {
//
//        byte[] configLabel = null;
//        
//        if (printerLanguage == PrinterLanguage.ZPL) {
//
//            try {
//                configLabel = textoImprime.getBytes("UTF-8");
//            } catch (UnsupportedEncodingException ex) {
//                String cpclConfigLabel = "! 0 200 200 406 1\r\n" + "ON-FEED IGNORE\r\n" + "BOX 20 20 380 380 8\r\n" + "T 0 6 137 177 TEST\r\n" + "PRINT\r\n";
//                configLabel = cpclConfigLabel.getBytes();
//            }
//   
//        } else if (printerLanguage == PrinterLanguage.CPCL) {
//            String cpclConfigLabel = "! 0 200 200 406 1\r\n" + "ON-FEED IGNORE\r\n" + "BOX 20 20 380 380 8\r\n" + "T 0 6 137 177 TEST\r\n" + "PRINT\r\n";
//            configLabel = cpclConfigLabel.getBytes();
//        }
//        return configLabel;
//    }
// 
//}
