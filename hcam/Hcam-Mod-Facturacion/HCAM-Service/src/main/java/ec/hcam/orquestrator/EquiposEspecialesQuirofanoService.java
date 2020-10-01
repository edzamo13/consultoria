package ec.hcam.orquestrator;

import ec.hcam.data.EquiposEspecialesQuirofanos;
import ec.hcam.data.Temp;
import ec.hcam.entity.Cabplantbl;
import ec.hcam.entity.Detplantbl;
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

@Stateless
@TransactionManagement(BEAN)
public class EquiposEspecialesQuirofanoService extends Basica implements EquiposEspecialesQuirofanoRemote {

    @Override
    @Asynchronous
    public Future obtenerEquiposEspeciales(String unidadMedica, Integer fecha, Integer nivel, Integer unidpk, Integer ubicapk) {
                
        utx = ctx.getUserTransaction();
        System.out.println("Hora Inicio Equipos Especiales Quirofano:" + imprimirHora().toString());
        String strMes = String.valueOf(fecha).substring(4, 6);
        String strDia = String.valueOf(fecha).substring(6, 8);
        String strAnio = String.valueOf(fecha).substring(0, 4);

        Integer intMes = Integer.parseInt(strMes);
        Integer intDia = Integer.parseInt(strDia);
        Integer intAnio = Integer.parseInt(strAnio);

        existenciaCabecera(intMes, intDia, intAnio,unidpk,ubicapk);

        List<Temp> lstHistorias = obtenerHistoricasClinicas(unidadMedica, String.valueOf(fecha));

        for (Temp lstHistoria : lstHistorias) {
            //System.out.println("ANTES DE INGRESAR A METODO registrarDetallePlanillaje(). historiaclinica: " + lstHistoria.getTemp());
            registrarDetallePlanillaje(lstHistoria.getTemp(), unidadMedica, String.valueOf(fecha));
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
                Logger.getLogger(FarmacosAplicadosService.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(FarmacosAplicadosService.class.getName()).log(Level.SEVERE, null, ex);
        }
        bag.clear();
        listaDetalles.clear();

        System.out.println("Hora Fin Equipos Especiales Quirofano:" + imprimirHora().toString());
        return new AsyncResult("OK");
    }

        public List<EquiposEspecialesQuirofanos> obtenerEquiposPorComplejidad(double historiaClinica, String unidadMedica, String fecha, String complejidad) {
        
        String sqlEquipos = "SELECT EUCODI AS codigoEquipo, EUCOTA AS codigoComplejidad, EXCOIT AS codigoTarifario, eucant AS cantidad, EUDESC AS descripcion, "
                + "EUUSCR AS usuaCrea, EUFECR AS fechCrea, EUHOCR as horaCrea, "
                + "EUPRCR as progCrea, EUPACR as pantCrea, EUUSAC as usuaActu, EUFEAC as fechActu, EUHOAC as horaActu, EUPRAC as progActu, EUPAAC as pantActu, EUHICL as historiaClinica, "
                + "SADEPE as dependenciaSolicita, SADEPE as dependenciaRealiza "
                + "FROM    paclibme.pacf23 inner join paclibme.pacf46 on excodi=eucodi and excota=eucota "
                + "INNER JOIN PACLIBME.PACF08 ON EUUNME= OPUNMe AND EUHICL=OPNUHI AND EUFEOP=OPFEOP AND EUHOOP=OPHOOP "
                + "INNER JOIN PACLIBME.PACF12 ON SAUNME=OPUNME AND OPUNID = SACOUO AND OPSALA = SACOSA  "
                + "WHERE   EUUNME||EUHICL||EUFEOP||EUHOOP in "
                + "          ( SELECT  OPUNMe|| OPNUHI||OPFEOP||OPHOOP  "
                + "            FROM    paclibme.pacf08  "
                + "            WHERE opunme=:unidadMedica AND "
                + "                  OPdata=:fecha AND OPESTA='FIN' AND OPTRAS<>'REP' AND OPOBSF<>' ' "
                + "                  and OPUNME||OPNUHI||OPFEOP||OPHOOP NOT IN "
                + "                      (SELECT   OSUNME||OSNUHI||OSFEOP||OSHOOP  "
                + "                       FROM     paclibme.PACF08S) "
                + "           ) and eutipo='E' "
                + "AND EUCOTA=(    SELECT PADET1 "
                + "                FROM FACWEB.PARANIVETBL "
                + "                WHERE FACWEB.PARANIVETBL.PADESCRI =:complejidad   ) AND "
                + "EUHICL=:historia";

        Map<String, Object> params = new HashMap<>();
        params.put("unidadMedica", unidadMedica);
        params.put("fecha", fecha);
        params.put("historia", historiaClinica);
        params.put("complejidad", complejidad);
        List<EquiposEspecialesQuirofanos> lstEquipos = queryExecutor.executeQuery(sqlEquipos, params, EquiposEspecialesQuirofanos.class);
        return lstEquipos;
    }

    private List<Temp> obtenerHistoricasClinicas(String unidadMedica, String fecha) {
        String sqlHistorias = "SELECT EUHICL AS temp "
                + "FROM paclibme.pacf23 inner join paclibme.pacf46 on excodi=eucodi and excota=eucota "
                + "WHERE   EUUNME||EUHICL||EUFEOP||EUHOOP in "
                + "( SELECT  OPUNMe|| OPNUHI||OPFEOP||OPHOOP "
                + "FROM    paclibme.pacf08 "
                + "WHERE opunme=:unidadMedica AND "
                + "OPdata=:fecha AND OPESTA='FIN' AND OPTRAS<>'REP' AND OPOBSF<>' ' "
                + "and OPUNME||OPNUHI||OPFEOP||OPHOOP NOT IN "
                + "(SELECT   OSUNME||OSNUHI||OSFEOP||OSHOOP "
                + "FROM     paclibme.PACF08S) "
                + ") and eutipo='E' "
                + "GROUP BY EUHICL";

        Map<String, Object> params = new HashMap<>();
        params.put("unidadMedica", unidadMedica);
        params.put("fecha", fecha);
        List<Temp> lstHistorias = queryExecutor.executeQuery(sqlHistorias, params, Temp.class);

        return lstHistorias;

    }

    private void registrarDetallePlanillaje(double historiaClinica, String uniMed, String iofeor) {

        int contador = 0;

        //ALTA COMPLEJIDAD
        
        System.out.println("ANTES DE BUSCAR EQUIPOS:");
        System.out.println("historia: " + historiaClinica);
        System.out.println("unidad: " + uniMed);
        System.out.println("fecha: " + iofeor);       
        
        
        List<EquiposEspecialesQuirofanos> lstEquipos = obtenerEquiposPorComplejidad(historiaClinica, uniMed, iofeor, "ALTA COMPLEJIDAD");
        System.out.println("equipos.size(): " + lstEquipos.size());
        for (EquiposEspecialesQuirofanos equipo : lstEquipos) {

            Calendar clnCalendario = Calendar.getInstance();

            Detplantbl entidadDetalle = new Detplantbl();
            Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");

            entidadDetalle.setCantidad(1);
            entidadDetalle.setNumplad(cab.getNumplanilla());
            
            entidadDetalle.setHistoCli(String.valueOf(equipo.getHistoriaClinica()));
            entidadDetalle.setFechaReg(clnCalendario.getTime());
            entidadDetalle.setDescItem(equipo.getDescripcion());
            entidadDetalle.setDepRea("Quirofano");
            entidadDetalle.setCoddepsol(BigInteger.valueOf( equipo.getDependenciaSolicita()));       //REVISAR EN QUERY
            entidadDetalle.setCoddeprea(BigInteger.valueOf(equipo.getDependenciaRealiza()));        //REVISAR EN QUERY
            entidadDetalle.setTipSer(9901);
            entidadDetalle.setSubtipser(9901);

            String queryString = "SELECT  T.TAVALOR AS temp, T.TACODIGO AS codigo, T.TADESCRIPC as descripcion "
                    + "FROM    FACWEB.PARANIVETBL TBL1, "
                    + "        FACWEB.PANICODTBL TBL2, "
                    + "        FACWEB.TARIFAFTBL T "
                    + "WHERE   TBL1.PANIDPK = TBL2.PANIDPK AND "
                    + "        TBL2.CTIDPK = T.CTIDPK AND "
                    + "        TBL1.PADET1 =:complejidad AND "
                    + "        T.TACODIGO =:codigo";

            Map<String, Object> paramsDatosMedicos = new HashMap();
            paramsDatosMedicos.put("complejidad", equipo.getCodigoComplejidad());
            paramsDatosMedicos.put("codigo", equipo.getCodigoTarifario());

            List<Temp> lstValorEquipo = queryExecutor.executeQuery(queryString, paramsDatosMedicos, Temp.class);

            entidadDetalle.setDescItem(lstValorEquipo.get(0).getDescripcion());
            entidadDetalle.setCoditem(lstValorEquipo.get(0).getCodigo());
            entidadDetalle.setValorUnit(lstValorEquipo.get(0).getTemp());
            entidadDetalle.setValorTotal(lstValorEquipo.get(0).getTemp());
            entidadDetalle.setTipoRubro("EEQ"); //Tipo de servicio

            
            entidadDetalle.setDuracionAtencion(0); //ver este campo
            entidadDetalle.setEstado('A');

            cab.setDetplantblList(null);
            entidadDetalle.setCpidpk(cab);

            // TODO Completar el objeto detalle para que pueda ser almacenado correctamente sin restriccionescab.setDetplantblList(null);
            cab.setDetplantblList(null);
            entidadDetalle.setCpidpk(cab);

            listaDetalles.add(entidadDetalle);
            System.out.println("Descripcion " + entidadDetalle.getDescItem() + " Valor: " + entidadDetalle.getValorTotal());
            registrarPorBloque(listaDetalles);

            contador++;
            if (contador == 6) {
                break;
            }

        }

        //MUY ALTA COMPLEJIDAD
        lstEquipos = obtenerEquiposPorComplejidad(historiaClinica, uniMed, iofeor, "MUY ALTA COMPLEJIDAD");
        for (EquiposEspecialesQuirofanos equipo : lstEquipos) {

            Calendar clnCalendario = Calendar.getInstance();

            Detplantbl entidadDetalle = new Detplantbl();
            Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");

            entidadDetalle.setCantidad(1);
            entidadDetalle.setNumplad(cab.getNumplanilla());
            
            entidadDetalle.setHistoCli(String.valueOf(equipo.getHistoriaClinica()));
            entidadDetalle.setFechaReg(clnCalendario.getTime());
            
            entidadDetalle.setDepRea("Quirofano");
            entidadDetalle.setCoddepsol(BigInteger.valueOf(equipo.getDependenciaSolicita()));       //REVISAR EN QUERY
            entidadDetalle.setCoddeprea(BigInteger.valueOf(equipo.getDependenciaRealiza()));        //REVISAR EN QUERY
            entidadDetalle.setTipSer(9901);
            entidadDetalle.setSubtipser(9901);

            String queryString = "SELECT  T.TAVALOR AS temp, T.TACODIGO AS codigo, T.TADESCRIPC as descripcion "
                    + "FROM    FACWEB.PARANIVETBL TBL1, "
                    + "        FACWEB.PANICODTBL TBL2, "
                    + "        FACWEB.TARIFAFTBL T "
                    + "WHERE   TBL1.PANIDPK = TBL2.PANIDPK AND "
                    + "        TBL2.CTIDPK = T.CTIDPK AND "
                    + "        TBL1.PADET1 =:complejidad AND "
                    + "        T.TACODIGO =:codigo";

            Map<String, Object> paramsDatosMedicos = new HashMap();
            paramsDatosMedicos.put("complejidad", equipo.getCodigoComplejidad());
            paramsDatosMedicos.put("codigo", equipo.getCodigoTarifario());

            List<Temp> lstValorEquipo = queryExecutor.executeQuery(queryString, paramsDatosMedicos, Temp.class);

            entidadDetalle.setDescItem(lstValorEquipo.get(0).getDescripcion());
            entidadDetalle.setCoditem(lstValorEquipo.get(0).getCodigo());
            entidadDetalle.setValorUnit(lstValorEquipo.get(0).getTemp());
            entidadDetalle.setValorTotal(lstValorEquipo.get(0).getTemp());
            entidadDetalle.setTipoRubro("EEQ"); //Tipo de servicio

            entidadDetalle.setDuracionAtencion(0); //ver este campo
            entidadDetalle.setEstado('A');

            cab.setDetplantblList(null);
            entidadDetalle.setCpidpk(cab);

            // TODO Completar el objeto detalle para que pueda ser almacenado correctamente sin restriccionescab.setDetplantblList(null);
            cab.setDetplantblList(null);
            entidadDetalle.setCpidpk(cab);

            listaDetalles.add(entidadDetalle);
            System.out.println("Descripcion " + entidadDetalle.getDescItem() + " Valor: " + entidadDetalle.getValorTotal());
            registrarPorBloque(listaDetalles);

        }

        //MEDIA COMPLEJIDAD
        contador = 0;
        lstEquipos = obtenerEquiposPorComplejidad(historiaClinica, uniMed, iofeor, "MEDIA COMPLEJIDAD");
        for (EquiposEspecialesQuirofanos equipo : lstEquipos) {

            Calendar clnCalendario = Calendar.getInstance();

            Detplantbl entidadDetalle = new Detplantbl();
            Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");

            entidadDetalle.setCantidad(1);
            entidadDetalle.setNumplad(cab.getNumplanilla());            
            entidadDetalle.setHistoCli(String.valueOf(equipo.getHistoriaClinica()));
            entidadDetalle.setFechaReg(clnCalendario.getTime());
            
            entidadDetalle.setDepRea("Quirofano");
            entidadDetalle.setCoddepsol(BigInteger.valueOf(equipo.getDependenciaSolicita()));       //REVISAR EN QUERY
            entidadDetalle.setCoddeprea(BigInteger.valueOf(equipo.getDependenciaRealiza()));        //REVISAR EN QUERY
            entidadDetalle.setTipSer(9901);
            entidadDetalle.setSubtipser(9901);

            String queryString = "SELECT  T.TAVALOR AS temp, T.TACODIGO AS codigo, T.TADESCRIPC AS descripcion "
                    + "FROM    FACWEB.PARANIVETBL TBL1, "
                    + "        FACWEB.PANICODTBL TBL2, "
                    + "        FACWEB.TARIFAFTBL T "
                    + "WHERE   TBL1.PANIDPK = TBL2.PANIDPK AND "
                    + "        TBL2.CTIDPK = T.CTIDPK AND "
                    + "        TBL1.PADET1 =:complejidad AND "
                    + "        T.TACODIGO =:codigo";

            Map<String, Object> paramsDatosMedicos = new HashMap();
            paramsDatosMedicos.put("complejidad", equipo.getCodigoComplejidad());
            paramsDatosMedicos.put("codigo", equipo.getCodigoTarifario());

            List<Temp> lstValorEquipo = queryExecutor.executeQuery(queryString, paramsDatosMedicos, Temp.class);

            entidadDetalle.setDescItem(lstValorEquipo.get(0).getDescripcion());
            entidadDetalle.setCoditem(lstValorEquipo.get(0).getCodigo());
            entidadDetalle.setValorUnit(lstValorEquipo.get(0).getTemp());
            entidadDetalle.setValorTotal(lstValorEquipo.get(0).getTemp());
            entidadDetalle.setTipoRubro("EEQ"); //Tipo de servicio

            
            entidadDetalle.setDuracionAtencion(0); //ver este campo
            entidadDetalle.setEstado('A');

            cab.setDetplantblList(null);
            entidadDetalle.setCpidpk(cab);

            // TODO Completar el objeto detalle para que pueda ser almacenado correctamente sin restriccionescab.setDetplantblList(null);
            cab.setDetplantblList(null);
            entidadDetalle.setCpidpk(cab);

            listaDetalles.add(entidadDetalle);
            System.out.println("Descripcion " + entidadDetalle.getDescItem() + " Valor: " + entidadDetalle.getValorTotal());
            registrarPorBloque(listaDetalles);

            contador++;
            if (contador == 4) {
                break;
            }

        }

        //BAJA COMPLEJIDAD
        contador = 0;
        lstEquipos = obtenerEquiposPorComplejidad(historiaClinica, uniMed, iofeor, "BAJA COMPLEJIDAD");
        for (EquiposEspecialesQuirofanos equipo : lstEquipos) {

            Calendar clnCalendario = Calendar.getInstance();

            Detplantbl entidadDetalle = new Detplantbl();
            Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");

            entidadDetalle.setCantidad(1);
            entidadDetalle.setNumplad(cab.getNumplanilla());
            
            entidadDetalle.setHistoCli(String.valueOf(equipo.getHistoriaClinica()));
            entidadDetalle.setFechaReg(clnCalendario.getTime());
            
            entidadDetalle.setDepRea("Quirofano");
            entidadDetalle.setCoddepsol(BigInteger.valueOf(equipo.getDependenciaSolicita()));       //REVISAR EN QUERY
            entidadDetalle.setCoddeprea(BigInteger.valueOf(equipo.getDependenciaRealiza()));        //REVISAR EN QUERY
            entidadDetalle.setTipSer(9901);
            entidadDetalle.setSubtipser(9901);

            String queryString = "SELECT  T.TAVALOR AS temp, T.TACODIGO AS codigo, T.TADESCRIPC AS descripcion "
                    + "FROM    FACWEB.PARANIVETBL TBL1, "
                    + "        FACWEB.PANICODTBL TBL2, "
                    + "        FACWEB.TARIFAFTBL T "
                    + "WHERE   TBL1.PANIDPK = TBL2.PANIDPK AND "
                    + "        TBL2.CTIDPK = T.CTIDPK AND "
                    + "        TBL1.PADET1 =:complejidad AND "
                    + "        T.TACODIGO =:codigo";

            Map<String, Object> paramsDatosMedicos = new HashMap();
            paramsDatosMedicos.put("complejidad", equipo.getCodigoComplejidad());
            paramsDatosMedicos.put("codigo", equipo.getCodigoTarifario());

            List<Temp> lstValorEquipo = queryExecutor.executeQuery(queryString, paramsDatosMedicos, Temp.class);

            entidadDetalle.setDescItem(lstValorEquipo.get(0).getDescripcion());
            entidadDetalle.setValorUnit(lstValorEquipo.get(0).getTemp());
            entidadDetalle.setValorTotal(lstValorEquipo.get(0).getTemp());
            entidadDetalle.setCoditem(lstValorEquipo.get(0).getCodigo());
            entidadDetalle.setTipoRubro("EEQ"); //Tipo de servicio

            entidadDetalle.setDuracionAtencion(0); //ver este campo
            entidadDetalle.setEstado('A');

            cab.setDetplantblList(null);
            entidadDetalle.setCpidpk(cab);

            // TODO Completar el objeto detalle para que pueda ser almacenado correctamente sin restriccionescab.setDetplantblList(null);
            cab.setDetplantblList(null);
            entidadDetalle.setCpidpk(cab);

            listaDetalles.add(entidadDetalle);
            System.out.println("Descripcion " + entidadDetalle.getDescItem() + " Valor: " + entidadDetalle.getValorTotal());
            registrarPorBloque(listaDetalles);

            contador++;
            if (contador == 2) {
                break;
            }

        }

    }
}
