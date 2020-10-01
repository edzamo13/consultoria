/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.orquestrator;

import ec.hcam.data.Dependencia;
import ec.hcam.data.FarmacosPres;
import ec.hcam.entity.Cabplantbl;
import ec.hcam.entity.Detplantbl;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import static javax.ejb.TransactionManagementType.BEAN;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

/**
 *
 * @author Programacion
 */
@Stateless
@TransactionManagement(BEAN)
public class FarmacosPrescritosService extends Basica implements FarmacosPrescritosServiceRemote {

    @Override
    @Asynchronous
    public Future obtenerRegistrosF(String iounme, Integer iofeor, Integer nivel, Integer unidpk, Integer ubicapk) {
        utx = ctx.getUserTransaction();
        System.out.println("Hora Inicio FarmacosPrescritos:" + imprimirHora().toString());
        cargarDependencias(iounme, String.valueOf(iofeor));
        List<Dependencia> lstDependencias = (List<Dependencia>) bagDependecia.get("lstDependencias");
        
        
        for (Dependencia depend : lstDependencias) {
            
            String mesSt = String.valueOf(iofeor).substring(4, 6);
            String diaSt = String.valueOf(iofeor).substring(6, 8);
            String anioSt = String.valueOf(iofeor).substring(0, 4);

            Integer mesI = Integer.parseInt(mesSt);
            Integer diaI = Integer.parseInt(diaSt);
            Integer anioI = Integer.parseInt(anioSt);

            existenciaCabecera(mesI, diaI, anioI, unidpk, ubicapk);

            obtenerTodosLosFarmacos(iounme, String.valueOf(iofeor), depend.getIR2DEP());
        }
        try {
            utx.begin();
            for (Detplantbl detplantbl : listaDetalles) {
                detalleService.createDetplantbl(detplantbl);
            }
            utx.commit();
        } catch (NotSupportedException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException | SystemException ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex1) {
                Logger.getLogger(FarmacosPrescritosService.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(FarmacosPrescritosService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (bag != null) {
            bag.clear();
        }
        if (bagDependecia != null) {
            bagDependecia.clear();
        }
        if (listaDetalles != null) {
            listaDetalles.clear();
        }
        System.out.println("Hora Fin FarmacosPrescritos:" + imprimirHora().toString());
        return new AsyncResult("OK");
    }

    @Override
    public List<FarmacosPres> obtenerTodosLosFarmacos(String iounme, String iofeor, Double depend) {

        
        String sqlString1 = "SELECT C.IOUNME AS PLAUBME, C.IORHIS AS PLAHIC , D.GETIPO || D.GEGRUP || D.GESUBG || D.GEORDI AS PLACOD , TRIM (D.GEDESC) ||' '|| TRIM (E.PSDESC) AS PLACOP, C.IODEPE AS PALDEX, A.IONUOR AS IONUOR, C.IODEPE AS PLADSX , C.IOTISE AS PLATSE, C.IOSBTP AS PLASSE, A.IOCADE AS PLACAN, (B.FFPREC) AS ValorUnitario , C.IONUOR AS PLAORD , C.IOMEDI AS COD_MEDICO, C.IOFEOR AS FECHA_ORDEN FROM CEDDTA.IOFI01 A INNER JOIN INVLIB.INVF35 B ON A.IOUNME = B.FFUNME AND DIGITS(A.IOELE1) = B.FFGRUP AND DIGITS(A.IOELE2) = B.FFSUBG AND DIGITS(A.IOGENE) = B.FFORDI AND B.FFTIPO = '321' and B.FFESPE =' ' INNER JOIN INVLIB.INVF10 D ON A.IOUNME = D.GECDUN AND DIGITS(A.IOELE1) = D.GEGRUP AND DIGITS(A.IOELE2) = D.GESUBG AND DIGITS(A.IOGENE) = D.GEORDI AND D.GETIPO = '321' RIGHT JOIN CEDDTA.IORD01 C ON C.IOUNME = A.IOUNME AND C.IONUOR = A.IONUOR JOIN INVLIB.INVF13 E ON D.GECDUN = E.PSCDUN AND D.GETIPR = E.PSTIPO AND D.GECOPR=E.PSCODI WHERE A.IOUNME=:iounme AND C.IOFEOR=:iofeor AND A.IOSTSI='D' AND C.IODEPE=:iodep";
        
        Map<String, Object> params = new HashMap<>();
        params.put("iounme", iounme);
        params.put("iofeor", iofeor);
        params.put("iodep", depend);
        List<FarmacosPres> farmacosList = queryExecutor.executeQuery(sqlString1, params, FarmacosPres.class);

        
        for (FarmacosPres farmaco : farmacosList) {
            registrarDetallePlanillaje(farmaco, iounme, iofeor);
            
        }
        return farmacosList;
    }

    @Override
    public void registrarDetallePlanillaje(FarmacosPres registro, String uniMed, String iofeor) {

        Detplantbl detalle = new Detplantbl();
        //Datos Cabecera  
        Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");
        // TODO Solicitar a bdd que cree la BDD SEQUENCE para poder autogenrer secuenciales

        //Empieza   
        Calendar c1 = Calendar.getInstance();

        detalle.setReidpk(2);
        detalle.setNumplad(cab.getNumplanilla());
        detalle.setCoditem(registro.getPLACOD());
        detalle.setHistoCli(String.valueOf(registro.getPLAHIC().intValue()));
        detalle.setFechaReg(c1.getTime());
        detalle.setDescItem(registro.getPLACOP().toUpperCase()); //imp
        BigDecimal codDependencia = BigDecimal.valueOf(registro.getPALDEX());
        BigInteger dependenciaBI = codDependencia.toBigInteger(); 
        
        //detalle.setDepRea(NombreDependencia(BigDecimal.valueOf(registro.getPALDEX()).toBigInteger()));
        detalle.setDepRea(NombreDependenciaSQL(dependenciaBI));
        detalle.setCoddepsol(BigDecimal.valueOf(registro.getPALDEX()).toBigInteger());
        detalle.setCoddeprea(BigDecimal.valueOf(registro.getPLADSX()).toBigInteger());
        detalle.setTipSer(registro.getPLATSE().intValue());  //ver este campo
        detalle.setSubtipser(registro.getPLASSE().intValue());
        detalle.setCantidad(registro.getPLACAN().intValue());
        detalle.setValorUnit(registro.getVALORUNITARIO()); //ver este campo
        detalle.setValorTotal(registro.getVALORUNITARIO() * registro.getPLACAN().intValue());
        detalle.setNumOrden(registro.getPLAORD().intValue()); //ver este campo
        detalle.setTipoRubro("FAH"); //Tipo de servicio
        //En farmacos no se ingresan diagnosticos
        detalle.setCodMedico(registro.getCOD_MEDICO().intValue());
        detalle.setTimeAntestesia(Short.parseShort("0"));  //no aplica anestencia en farmacos
        detalle.setCodDerivacion("CD"); //ver este campo
        detalle.setSecDerivacion(Short.parseShort("0")); //ver este campo
        detalle.setContingenCubre(0);
        cab.setDetplantblList(null);
        detalle.setCpidpk(cab);
        //Termina

        listaDetalles.add(detalle);
        registrarPorBloque(listaDetalles);
    }

    public void cargarDependencias(String ir2unm, String ir2cit) {
        String sqlString1 = "SELECT DISTINCT C.IODEPE AS IR2DEP FROM CEDDTA.IOFI01 A INNER JOIN INVLIB.INVF35 B ON A.IOUNME = B.FFUNME AND DIGITS(A.IOELE1) = B.FFGRUP AND DIGITS(A.IOELE2) = B.FFSUBG AND DIGITS(A.IOGENE) = B.FFORDI AND B.FFTIPO = '321' INNER JOIN INVLIB.INVF11 D ON A.IOUNME = D.COCDUN AND DIGITS(A.IOELE1) = D.COGRUP AND DIGITS(A.IOELE2) = D.COSUBG AND DIGITS(A.IOGENE) = D.COORDI AND D.COTIPO = '321' RIGHT JOIN CEDDTA.IORD01 C ON C.IOUNME = A.IOUNME AND C.IONUOR = A.IONUOR WHERE A.IOUNME=:iounme AND C.IOFEOR=:iofeor AND A.IOSTSI='D'";
        Map<String, Object> params = new HashMap<>();
        params.put("iounme", ir2unm);
        params.put("iofeor", ir2cit);
        List<Dependencia> informacionDependenciaList = queryExecutor.executeQuery(sqlString1, params, Dependencia.class);
        if (bagDependecia == null) {
            bagDependecia = new HashMap<>();
        }
        bagDependecia.clear();
        bagDependecia.put("lstDependencias", informacionDependenciaList);
    }
}
