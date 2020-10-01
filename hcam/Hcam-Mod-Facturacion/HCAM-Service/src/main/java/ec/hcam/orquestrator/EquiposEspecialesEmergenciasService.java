package ec.hcam.orquestrator;

import ec.hcam.data.EquiposEspeciales;
import ec.hcam.data.Temp;
import ec.hcam.entity.Cabplantbl;
import ec.hcam.entity.Detplantbl;
import java.sql.Date;
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
 * Session Bean implementation class verficarEstancia
 */
@Stateless
@TransactionManagement(BEAN)
public class EquiposEspecialesEmergenciasService extends Basica implements EquiposEspecialesEmergenciasRemote {

    @Override
    @Asynchronous
    public Future obtenerEquiposEspeciales(String unidMedica, Integer fecha, Integer nivel, Integer unidpk, Integer ubicapk) {

        utx = ctx.getUserTransaction();
        System.out.println("Hora Inicio Equipos Especiales Emergencias:" + imprimirHora().toString());
        //Long unidadMedica = Integer.parseInt(unidMedica);
        String strMes = String.valueOf(fecha).substring(4, 6);
        String strDia = String.valueOf(fecha).substring(6, 8);
        String strAnio = String.valueOf(fecha).substring(0, 4);

        Integer intMes = Integer.parseInt(strMes);
        Integer intDia = Integer.parseInt(strDia);
        Integer intAnio = Integer.parseInt(strAnio);

        existenciaCabecera(intMes, intDia, intAnio, unidpk, ubicapk);
        //verificarExistenciaCabecera(intMes, intDia, intAnio, unidpk, ubicapk);

        List<Temp> lstHistorias = obtenerHistoricasClinicas(unidMedica, String.valueOf(fecha));

        for (Temp lstHistoria : lstHistorias) {
            registrarDetallePlanillaje(lstHistoria.getTemp(), unidMedica, String.valueOf(fecha));
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

        System.out.println("Hora Fin Equipos Especiales Emergencias:" + imprimirHora().toString());
        return new AsyncResult("OK");
    }

    public List<EquiposEspeciales> obtenerEquiposPorComplejidad(double historiaClinica, String unidadMedica, String fecha, String complejidad) {

        String sqlEquipos = "SELECT A.IOUNME as unidadMedica, A.IONUOR as numeroOrden, A.IOTISE as tipoServicio, A.IOSBTP as subTipoServicio, "
                + "A.IOITEM as codigoTarifario, A.IOCAOR as cantidad, A.IOXDAT as fechActu, A.IOXTIM as horaActu "
                + ",B.IORHIS as historiaClinica, B.IOORIG as origen, B.IOMEDI as codigoMedico, B.IODEPE as dependenciaSolicita, "
                + "B.IODEPE as dependenciaRealiza, p.excota as codigoComplejidad, p.EXCODI as codigoEquipo "
                + "FROM CEDDTA.IOXI01 A "
                + "JOIN CEDDTA.IORD01 B "
                + "ON A.IOUNME = B.IOUNME "
                + "AND A.IONUOR = B.IONUOR "
                + "inner join paclibme.pacf46 p on A.IOITEM=p.excoit "
                + "WHERE "
                + "A.IOUNME = :unidadMedica "
                + "AND A.IOTISE = 7  and A.IOSBTP=10 "
                + "AND A.IOXDAT = :fecha "
                + "AND B.IOORIG = 'EM' "
                + "AND p.excota=(  SELECT PADET1 "
                + "                FROM FACWEB.PARANIVETBL "
                + "                WHERE FACWEB.PARANIVETBL.PADESCRI =:complejidad   ) AND "
                + "B.IORHIS=:historia";

        Map<String, Object> params = new HashMap<>();
        params.put("unidadMedica", unidadMedica);
        params.put("fecha", fecha);
        params.put("historia", historiaClinica);
        params.put("complejidad", complejidad);
        List<EquiposEspeciales> lstEquipos = queryExecutor.executeQuery(sqlEquipos, params, EquiposEspeciales.class);
        return lstEquipos;
    }

    private List<Temp> obtenerHistoricasClinicas(String unidadMedica, String fecha) {

        String sqlHistorias = "SELECT "
                + "B.IORHIS AS temp "
                + "FROM CEDDTA.IOXI01 A "
                + "JOIN CEDDTA.IORD01 B "
                + "ON A.IOUNME = B.IOUNME "
                + "AND A.IONUOR = B.IONUOR "
                + "inner join paclibme.pacf46 p on A.IOITEM=p.excoit "
                + "WHERE "
                + "A.IOUNME = :unidadMedica "
                + "AND A.IOTISE = 7  and A.IOSBTP=10 "
                + "AND A.IOXDAT = :fecha "
                + "AND B.IOORIG = 'CE' "
                + "GROUP BY B.IORHIS";

        Map<String, Object> params = new HashMap<>();
        params.put("unidadMedica", unidadMedica);
        params.put("fecha", fecha);
        List<Temp> lstHistorias = queryExecutor.executeQuery(sqlHistorias, params, Temp.class);

        return lstHistorias;
    }

    private void registrarDetallePlanillaje(double historiaClinica, String uniMed, String iofeor) {

        int contador = 0;

        //ALTA COMPLEJIDAD
        List<EquiposEspeciales> lstEquipos = obtenerEquiposPorComplejidad(historiaClinica, uniMed, iofeor, "ALTA COMPLEJIDAD");

        for (EquiposEspeciales equipo : lstEquipos) {

            Calendar clnCalendario = Calendar.getInstance();

            Detplantbl entidadDetalle = new Detplantbl();
            Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");

            //Equipo
            entidadDetalle.setCantidad(equipo.getCantidad());
            entidadDetalle.setNumplad(cab.getNumplanilla());
            //    entidadDetalle.setNumOrden(equipo.getNumeroOrden());
            //    entidadDetalle.setCodMedico(equipo.getCodigoMedico());

            entidadDetalle.setHistoCli(String.valueOf(equipo.getHistoriaClinica()));
            entidadDetalle.setFechaReg(clnCalendario.getTime());

            entidadDetalle.setDepRea("Emergencias");
            entidadDetalle.setCoddepsol(equipo.getDependenciaSolicita());
            entidadDetalle.setCoddeprea(equipo.getDependenciaRealiza());
            //   entidadDetalle.setTipSer(equipo.getTipoServicio());
            // entidadDetalle.setSubtipser(equipo.getSubTipoServicio());

            String queryString = "SELECT  T.TAVALOR AS temp, T.TADESCRIPC as descripcion, T.TACODIGO AS codigo  "
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

            List<Temp> registroTarifario = queryExecutor.executeQuery(queryString, paramsDatosMedicos, Temp.class);

            entidadDetalle.setDescItem(registroTarifario.get(0).getDescripcion());
            entidadDetalle.setCoditem(registroTarifario.get(0).getCodigo());
            entidadDetalle.setValorUnit(registroTarifario.get(0).getTemp());
            entidadDetalle.setValorTotal(registroTarifario.get(0).getTemp() * equipo.getCantidad());
            entidadDetalle.setTipoRubro("EEH"); //Tipo de servicio

            entidadDetalle.setFecNacBenef(Date.valueOf("1954-02-04")); //ver este campo
            entidadDetalle.setDuracionAtencion(0); //ver este campo
            entidadDetalle.setEstado('A');

            cab.setDetplantblList(null);
            entidadDetalle.setCpidpk(cab);

            // TODO Completar el objeto detalle para que pueda ser almacenado correctamente sin restriccionescab.setDetplantblList(null);
            cab.setDetplantblList(null);
            entidadDetalle.setCpidpk(cab);

            listaDetalles.add(entidadDetalle);
            registrarPorBloque(listaDetalles);

            contador++;
            if (contador == 6) {
                break;
            }

        }

        //MUY ALTA COMPLEJIDAD
        lstEquipos.clear();
        lstEquipos = obtenerEquiposPorComplejidad(historiaClinica, uniMed, iofeor, "MUY ALTA COMPLEJIDAD");
        for (EquiposEspeciales equipo : lstEquipos) {

            Calendar clnCalendario = Calendar.getInstance();

            Detplantbl entidadDetalle = new Detplantbl();
            Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");

            //Equipo
            entidadDetalle.setCantidad(equipo.getCantidad());
            entidadDetalle.setNumplad(cab.getNumplanilla());

            entidadDetalle.setHistoCli(String.valueOf(equipo.getHistoriaClinica()));
            entidadDetalle.setFechaReg(clnCalendario.getTime());
            entidadDetalle.setDepRea("Emergencias");
            entidadDetalle.setCoddepsol(equipo.getDependenciaSolicita());
            entidadDetalle.setCoddeprea(equipo.getDependenciaRealiza());

            String queryString = "SELECT  T.TAVALOR AS temp, T.TADESCRIPC as descripcion, T.TACODIGO AS codigo  "
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
            entidadDetalle.setValorTotal(lstValorEquipo.get(0).getTemp() * equipo.getCantidad());
            entidadDetalle.setTipoRubro("EEH"); //Tipo de servicio

            entidadDetalle.setFecNacBenef(Date.valueOf("1954-02-04")); //ver este campo
            entidadDetalle.setDuracionAtencion(0); //ver este campo
            entidadDetalle.setEstado('A');

            cab.setDetplantblList(null);
            entidadDetalle.setCpidpk(cab);

            // TODO Completar el objeto detalle para que pueda ser almacenado correctamente sin restriccionescab.setDetplantblList(null);
            cab.setDetplantblList(null);
            entidadDetalle.setCpidpk(cab);

            listaDetalles.add(entidadDetalle);
            registrarPorBloque(listaDetalles);

        }

        //MEDIA COMPLEJIDAD
        contador = 0;
        lstEquipos.clear();
        lstEquipos = obtenerEquiposPorComplejidad(historiaClinica, uniMed, iofeor, "MEDIA COMPLEJIDAD");
        for (EquiposEspeciales equipo : lstEquipos) {

            Calendar clnCalendario = Calendar.getInstance();

            Detplantbl entidadDetalle = new Detplantbl();
            Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");

            //Equipo
            entidadDetalle.setCantidad(equipo.getCantidad());
            entidadDetalle.setNumplad(cab.getNumplanilla());

            entidadDetalle.setHistoCli(String.valueOf(equipo.getHistoriaClinica()));
            entidadDetalle.setFechaReg(clnCalendario.getTime());
            entidadDetalle.setDepRea("Emergencias");
            entidadDetalle.setCoddepsol(equipo.getDependenciaSolicita());
            entidadDetalle.setCoddeprea(equipo.getDependenciaRealiza());

            String queryString = "SELECT  T.TAVALOR AS temp, T.TADESCRIPC as descripcion, T.TACODIGO AS codigo  "
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
            entidadDetalle.setValorTotal(lstValorEquipo.get(0).getTemp() * equipo.getCantidad());
            entidadDetalle.setTipoRubro("EEH"); //Tipo de servicio

            entidadDetalle.setDuracionAtencion(0); //ver este campo
            entidadDetalle.setEstado('A');

            cab.setDetplantblList(null);
            entidadDetalle.setCpidpk(cab);

            // TODO Completar el objeto detalle para que pueda ser almacenado correctamente sin restriccionescab.setDetplantblList(null);
            cab.setDetplantblList(null);
            entidadDetalle.setCpidpk(cab);

            listaDetalles.add(entidadDetalle);
            registrarPorBloque(listaDetalles);

            contador++;
            if (contador == 4) {
                break;
            }

        }

        //BAJA COMPLEJIDAD
        contador = 0;
        lstEquipos.clear();
        lstEquipos = obtenerEquiposPorComplejidad(historiaClinica, uniMed, iofeor, "BAJA COMPLEJIDAD");
        for (EquiposEspeciales equipo : lstEquipos) {

            Calendar clnCalendario = Calendar.getInstance();

            Detplantbl entidadDetalle = new Detplantbl();
            Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");

            //Equipo
            entidadDetalle.setCantidad(equipo.getCantidad());
            entidadDetalle.setNumplad(cab.getNumplanilla());

            entidadDetalle.setHistoCli(String.valueOf(equipo.getHistoriaClinica()));
            entidadDetalle.setFechaReg(clnCalendario.getTime());
            entidadDetalle.setDepRea("Emergencias");
            entidadDetalle.setCoddepsol(equipo.getDependenciaSolicita());
            entidadDetalle.setCoddeprea(equipo.getDependenciaRealiza());

            String queryString = "SELECT  T.TAVALOR AS temp, T.TADESCRIPC as descripcion, T.TACODIGO as codigo  "
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
            entidadDetalle.setValorTotal(lstValorEquipo.get(0).getTemp() * equipo.getCantidad());
            entidadDetalle.setTipoRubro("EEH"); //Tipo de servicio

            entidadDetalle.setDuracionAtencion(0); //ver este campo
            entidadDetalle.setEstado('A');

            cab.setDetplantblList(null);
            entidadDetalle.setCpidpk(cab);

            // TODO Completar el objeto detalle para que pueda ser almacenado correctamente sin restriccionescab.setDetplantblList(null);
            cab.setDetplantblList(null);
            entidadDetalle.setCpidpk(cab);

            listaDetalles.add(entidadDetalle);
            registrarPorBloque(listaDetalles);

            contador++;
            if (contador == 2) {
                break;
            }

        }
    }

}
