package ec.hcam.orquestrator;

import ec.hcam.data.DatosPaciente;
import ec.hcam.data.Dependencia;
import ec.hcam.data.Imagen;
import ec.hcam.entity.Cabplantbl;
import ec.hcam.entity.Detplantbl;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
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
public class ImagenologiaService extends Basica implements ImagenologiaServiceRemote {

    Imagen objeto = new Imagen();

    public Imagen getObjeto() {
        return objeto;
    }

    public void setObjeto(Imagen objeto) {
        this.objeto = objeto;
    }

    @Override
    @Asynchronous
    public Future obtenerRegistrosI(int nivel, String iounme, int ioxdat, Integer unidpk, Integer ubicapk) {

        utx = ctx.getUserTransaction();
        System.out.println("Hora Inicio de Imagenologia:" + imprimirHora().toString());
        //obtenemos todas las dependencias, 
        List<Dependencia> listaDep;
        
        //listaDep = obtenerDependencias(nivel, iounme, ioxdat);
        //System.out.println("Numero de Dependencias: " + listaDep.size());
        //procesarDependenciasUnaAUna(nivel, iounme, ioxdat, listaDep, unidpk, ubicapk);
        
        String fechaSt = Integer.toString(ioxdat);
        String mesSt = fechaSt.substring(4, 6);
        String diaSt = fechaSt.substring(6, 8);
        String anioSt = fechaSt.substring(0, 4);

        Integer mesI = Integer.parseInt(mesSt);
        Integer diaI = Integer.parseInt(diaSt);
        int anioI = Integer.parseInt(anioSt);
        existenciaCabecera(mesI, diaI, anioI, unidpk, ubicapk);
        
        System.out.println("unidad medica: " + iounme);
        System.out.println("fecha: " + ioxdat);
        
        List<Imagen> listaImagen;
            listaImagen = obtenerListaImagenesDeUnaDependencia(nivel, iounme, ioxdat);   //dependenciaObtenidaBi  
            System.out.println("Paso el select.");
            procesarTodasLasImagenesDeUnaDependencia(iounme, ioxdat, listaImagen, unidpk, ubicapk);

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
                Logger.getLogger(DerechosSalaRecuperacionService.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DerechosSalaRecuperacionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        bag.clear();
        listaDetalles.clear();
        System.out.println("Hora Fin de Imagenologia:" + imprimirHora().toString());
        return new AsyncResult("OK");
    }

    //obtener lista de dependencias de la unidad medica solicitada 1
    public List<Dependencia> obtenerDependencias(int ctidpk, String ir2unm, int ir2cit) {

        //String sqlString = "SELECT ir2dep as IR2DEP FROM CEDDTA.IRSI02 i join facweb.tarifaftbl t on i.ir2ite=t.tacodigo and t.ctidpk=:ctidpk WHERE IR2UNM=:ir2unm AND IR2CIT=:ir2cit GROUP BY IR2DEP";
        String sqlString = "select DISTINCT a.iodepe AS ir2dep from ceddta.ioxr01 I left join ceddta.ioxr06 J on I.iounme=J.i6unme and I.ionuor=J.i6nuor and ioitem=i6item and I.iotise=J.i6tise and I.iosbtp=J.i6sbtp and I.IOTPOR =J.i6tpor and i6fecc <=:ir2cit join CEDDTA.iord01 a on a.iounme=I.iounme and a.ionuor=I.ionuor join CEDDTA.iser01 b on b.isdunm=I.iounme and b.isdcod=I.iocosd left join facweb.tarifaftbl t on I.ioitem=t.tacodigo and t.ctidpk=:ctidpk where I.iounme=:ir2unm and I.iotise=3 and I.iosbtp=1 and I.IOSTDE<> 'I' AND (I.ioxdat=:ir2cit OR i6fecc=:ir2cit)";
        Map<String, Object> params = new HashMap<>();
        params.put("ctidpk", ctidpk);
        params.put("ir2unm", ir2unm);
        //params.put("ir2dep", ir2dep);
        params.put("ir2cit", ir2cit);
        List<Dependencia> informacionDependenciaList = queryExecutor.executeQuery(sqlString, params, Dependencia.class);

        return informacionDependenciaList;
    }

    //obtenertodaslasimagenesdeunadependencia 2
    public List<Imagen> obtenerListaImagenesDeUnaDependencia(int ctidpk, String iounme, int ioxdat) {

        String sqlString = "select I.IOUNME AS UNIDAD_MEDICA, I.IONUOR AS NUM_ORDEN, I.IOCOSD AS SERVICIO_REALIZA, I.IOHIST AS HISTORIA_CLINICA, I.IOTISE AS TIPO_SERVICIO, I.IOSBTP AS SUBTIPO_SERVICIO, I.IOITEM AS ITEM_TARIFARIO, I.IOSTDE AS STS_VERIFICA,I.IOXDAT AS FECHA_RESULTADO, COALESCE(J.I6STAS, ' ') AS STS_ASISTENCIA, COALESCE(J.I6FECC, 0) AS FECHA_ASISTENCIA , a.iodepe AS depe_solicita, a.iomedi AS medico_solicita , b.isddep AS depe_realiza, coalesce(t.tadescripc, 'TARIFARIO ANTERIOR SIN VALOR') AS DESCRIPCION, COALESCE(t.tavalor, 0) AS VALOR  from ceddta.ioxr01 I left join ceddta.ioxr06 J on I.iounme=J.i6unme and I.ionuor=J.i6nuor and ioitem=i6item and I.iotise=J.i6tise and I.iosbtp=J.i6sbtp and I.IOTPOR =J.i6tpor and i6fecc <=:ioxdat join CEDDTA.iord01 a on a.iounme=I.iounme and a.ionuor=I.ionuor join CEDDTA.iser01 b on b.isdunm=I.iounme and b.isdcod=I.iocosd left join facweb.tarifaftbl t on I.ioitem=t.tacodigo and t.ctidpk=:ctidpk where I.iounme=:iounme and I.iotise=3 and I.iosbtp=1 and I.IOSTDE<> 'I' AND (I.ioxdat=:ioxdat OR i6fecc=:ioxdat) FOR READ ONLY";
        
        Map<String, Object> params = new HashMap<>();
        params.put("ctidpk", ctidpk);
        params.put("iounme", iounme);
        params.put("ioxdat", ioxdat);
        //params.put("iodepe", iodepe);

        List<Imagen> ImagenList = queryExecutor.executeQuery(sqlString, params, Imagen.class);        
        return ImagenList;
    }

    public void procesarDependenciasUnaAUna(int nivel, String iounme, int ioxdat, List<Dependencia> listaDependencia, Integer unidpk, Integer ubicapk) {

        // Hacer una lista para moverse dependencia a dependencia y empesar el procesamiento...
        

        BigInteger dependenciaObtenidaBi = new BigInteger("0");

        String fechaSt = Integer.toString(ioxdat);
        String mesSt = fechaSt.substring(4, 6);
        String diaSt = fechaSt.substring(6, 8);
        String anioSt = fechaSt.substring(0, 4);

        Integer mesI = Integer.parseInt(mesSt);
        Integer diaI = Integer.parseInt(diaSt);
        int anioI = Integer.parseInt(anioSt);

        existenciaCabecera(mesI, diaI, anioI, unidpk, ubicapk);
        //existenciaCabecera(mesI, diaI, anioI);

        for (Dependencia dependenciaa : listaDependencia) {
            System.out.println("entro en la dependencia: " + dependenciaa.getIR2DEP());
             BigDecimal dependeciaObtenidaBd = BigDecimal.valueOf(dependenciaa.getIR2DEP());
            dependenciaObtenidaBi = dependeciaObtenidaBd.toBigInteger();
            
            List<Imagen> listaImagen;
            listaImagen = obtenerListaImagenesDeUnaDependencia(nivel, iounme, ioxdat);            
            procesarTodasLasImagenesDeUnaDependencia(iounme, ioxdat, listaImagen, unidpk, ubicapk);       
        }
    }

    public void procesarTodasLasImagenesDeUnaDependencia(String iounme, int ioxdat, List<Imagen> listaImagen, Integer unidpk, Integer ubicapk) {

        String fechaSt = Integer.toString(ioxdat);
        String mesSt = fechaSt.substring(4, 6);
        String diaSt = fechaSt.substring(6, 8);
        String anioSt = fechaSt.substring(0, 4);

        Integer mesI = Integer.parseInt(mesSt);
        Integer diaI = Integer.parseInt(diaSt);
        int anioI = Integer.parseInt(anioSt);

        //existenciaCabecera(mesI, diaI, anioI, unidpk, ubicapk);

        for (Imagen img : listaImagen) {
            objeto = img;            
            aplicarRegla(objeto, iounme, ioxdat);            
        }

    }

    @Override
    public void aplicarRegla(Imagen objeto, String ir2unm, int ir2cit) {

        //Como se si la fecha de hoy es hoy
        int bandera = 0;        
        int fr;
        int fa;

        fr = (int) objeto.getFECHA_RESULTADO();
        fa = (int) objeto.getFECHA_ASISTENCIA();
        
        if ("V".equals(objeto.getSTS_VERIFICA()) && fr == ir2cit && fa < ir2cit && fa != 0) {            
            double valorFacturar = objeto.getVALOR() * 0.25;
            objeto.setVALOR(valorFacturar);
            bandera = 1;
            
        } else if ("V".equals(objeto.getSTS_VERIFICA()) && fr == ir2cit && ((fa == ir2cit) || (fa == 0))) {
            
            //revisarle pero si esta
            double valorFacturar = objeto.getVALOR() * 1;
            objeto.setVALOR(valorFacturar);
            bandera = 1;
            
        } //no debe cobrar
        else if ("V".equals(objeto.getSTS_VERIFICA()) && fr == ir2cit && fa > ir2cit) {
            double valorFacturar = objeto.getVALOR() * 0;
            objeto.setVALOR(valorFacturar);
            bandera = 0;
        } 
        //implementamos la nueva regla
        else if ("V".equals(objeto.getSTS_VERIFICA()) && fr > ir2cit && fa == ir2cit) {
            double valorFacturar = objeto.getVALOR() * 0.75;
            objeto.setVALOR(valorFacturar);
            bandera = 1;
        }
         else if ("V".equals(objeto.getSTS_VERIFICA()) && fr < ir2cit && fa == ir2cit) {
            double valorFacturar = objeto.getVALOR() * 0;
            objeto.setVALOR(valorFacturar);
            bandera = 0;
        }
        else if (!"V".equals(objeto.getSTS_VERIFICA()) && fr < ir2cit && fa == ir2cit) {
            double valorFacturar = objeto.getVALOR() * 0.75;
            objeto.setVALOR(valorFacturar);
            bandera = 1;
        } //no debe cobrar
        else if (!"V".equals(objeto.getSTS_VERIFICA()) && fr == ir2cit && fa > ir2cit) {
            double valorFacturar = objeto.getVALOR() * 0;
            objeto.setVALOR(valorFacturar);
            bandera = 0;
        } else if (!"V".equals(objeto.getSTS_VERIFICA()) && fr == ir2cit && fa == ir2cit) {
            double valorFacturar = objeto.getVALOR() * 0.75;
            objeto.setVALOR(valorFacturar);
            bandera = 1;
        } //no se debe cobrar
        else if (!"V".equals(objeto.getSTS_VERIFICA()) && fr == ir2cit && fa == 0) {
            double valorFacturar = objeto.getVALOR() * 0;
            objeto.setVALOR(valorFacturar);
            bandera = 0;
        }
        

        if (bandera == 1) {
            registrarDetallePlanillaje(objeto, ir2unm, ir2cit);            
        }
    }

    @Override
    public void registrarDetallePlanillaje(Imagen objeto, String ir2unm, int ir2cit) {
        int banderaEjecucion = 1;
        if (banderaEjecucion == 0) {
        
            String queryPaciente = "SELECT COALESCE(B.IACNOM, A.IAFNOM) as NOMBREAFILIADO, "
                    + "COALESCE(B.IACCED, A.IAFCED) as CEDULAAFILIADO, CASE WHEN A.IAFCRE = '  ' "
                    + "THEN 'MA' ELSE A.IAFCRE END PARENTESCO, "
                    + "TIMESTAMPDIFF ( 256 , CHAR ( CURRENT TIMESTAMP - TO_DATE ( CHAR ( A.IAFFNA ) , 'YYYYMMDD' ) ) ) as EDADPACIENTE, "
                    + "A.IAFSEX as GENEROPACIENTE, A.IAFFNA as FECNACIMIENTO, A.IAFNOM as NOMBREPACIENTE, "
                    + "A.IAFCED as CEDULAPACIENTE, CASE WHEN A.IAFCRE ='  ' THEN 'MA' ELSE A.IAFCRE END as RELACIONFAMILIAR "
                    + "FROM CEDDTA.IAFI01 A LEFT JOIN CEDDTA.IAFI03 B ON  A.IAFCED=B.IACCED WHERE A.IAFUNM =:ir2unm AND "
                    + "A.IAFHIS =:irhis";

            Map<String, Object> paramsDatosPaciente = new HashMap();

            paramsDatosPaciente.put("irhis", objeto.getHISTORIA_CLINICA());
            paramsDatosPaciente.put("ir2unm", ir2unm);

            List<DatosPaciente> datosPaciente = queryExecutor.executeQuery(queryPaciente, paramsDatosPaciente, DatosPaciente.class);

            //Consultar datos cliente
            Detplantbl detalle = new Detplantbl();

            String fechaSt = Integer.toString(ir2cit);
            String mesSt = fechaSt.substring(4, 6);
            String diaSt = fechaSt.substring(6, 8);
            String anioSt = fechaSt.substring(0, 4);

            Integer mesI = Integer.parseInt(mesSt);
            Integer diaI = Integer.parseInt(diaSt);
            int anioI = Integer.parseInt(anioSt);

            Calendar c1 = Calendar.getInstance();

            Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");

            Double codepsold, codepread, codmedid;
            int codmedii;
            BigDecimal codepsolBd, codepreaBd;

            codepsold = objeto.getDEPE_SOLICITA();
            codepread = objeto.getDEPE_REALIZA();
            codmedid = objeto.getMEDICO_SOLICITA();

            BigDecimal dependeciaObtenidaBd = 
            codepsolBd = BigDecimal.valueOf(codepsold);
            codepreaBd = BigDecimal.valueOf(codepread);
            codmedii = codmedid.intValue();

            detalle.setNumplad(cab.getNumplanilla());
            detalle.setCoditem(objeto.getITEM_TARIFARIO()); //verificar cual va
            detalle.setHistoCli(String.valueOf(objeto.getHISTORIA_CLINICA()));
            detalle.setFechaReg(c1.getTime());
            detalle.setDescItem(objeto.getDESCRIPCION()); //con el codigo del tarifario descripcion

            BigInteger codepsolbi = codepsolBd.toBigInteger();
            BigInteger codepreabi = codepreaBd.toBigInteger();
            
             String nombreDependenciaRealiza = NombreDependenciaSQL(codepsolbi);
            detalle.setDepRea(nombreDependenciaRealiza); ////busco con el codigo
            
            detalle.setCoddepsol(codepsolbi);
            detalle.setCoddeprea(codepreabi); //ver esta campo
            
            detalle.setTipSer(3);  //ver este campo
            detalle.setSubtipser(1);
            detalle.setCantidad(1);
            detalle.setValorUnit(objeto.getVALOR()); //ver este campo
            detalle.setValorTotal(objeto.getVALOR());
            detalle.setNumOrden(1); //ver este campo
            detalle.setTipoRubro("IMA");
            //detalle.setCodMedico(objeto.)

            detalle.setCodMedico(codmedii);
            detalle.setNomMedico(" ");

            detalle.setDiagnostico1(" ");
            detalle.setDiagnostico2(" ");
            detalle.setDiagnostico3(" ");
            detalle.setDiagnostico4(" ");
            detalle.setDiagnostico5(" ");
            detalle.setDiagnostico6(" ");
            detalle.setTipoDiag1(' ');
            detalle.setTipoDiag2(' ');
            detalle.setTipoDiag3(' ');
            detalle.setTipoDiag4(' ');
            detalle.setTipoDiag5(' ');
            detalle.setTipoDiag6(' ');

            detalle.setTimeAntestesia(Short.parseShort("0"));  //no aplica anestencia en honorarios
            detalle.setCodDerivacion("CD"); //ver este campo
            detalle.setSecDerivacion(Short.parseShort("0")); //ver este campo
            detalle.setContingenCubre(0);

            detalle.setNombreAfiliado(datosPaciente.get(0).getNOMBREAFILIADO());
            detalle.setCedulaAfiliado(datosPaciente.get(0).getCEDULAAFILIADO());
            detalle.setParentesco(datosPaciente.get(0).getPARENTESCO());
            detalle.setCedulaBeneficia(datosPaciente.get(0).getCEDULAPACIENTE());
            detalle.setNombreBeneficia(datosPaciente.get(0).getNOMBREPACIENTE());

            //Se agrega
            detalle.setTipoBeneficia(datosPaciente.get(0).getTIPOBENEFICIARIO()); //ver este campo

            //Para sacar la fecha de nacimiento se ejecuta lo siguiente
            String fechaNa = datosPaciente.get(0).getFECNACIMIENTO();
            String mesNa = fechaNa.substring(4, 6);
            String diaNa = fechaNa.substring(6, 8);
            String anioNa = fechaNa.substring(0, 4);

            String fechaNac = anioNa + "-" + mesNa + "-" + diaNa;

            detalle.setFecNacBenef(Date.valueOf(fechaNac));

            //detalle.setFecNacBenef(Date.valueOf("1954-02-04")); //ver este campo
            detalle.setEdadBenefic(datosPaciente.get(0).getEDADPACIENTE());
            detalle.setGeneroBenef(datosPaciente.get(0).getGENEROPACIENTE().charAt(0));
            detalle.setDuracionAtencion(0); //ver este campo
            detalle.setEstado('A');

            cab.setDetplantblList(null);
            detalle.setCpidpk(cab);

            listaDetalles.add(detalle);

        }
        if (banderaEjecucion == 1) {
            Detplantbl detalle = new Detplantbl();
            //Datos Cabecera        
            int prueba = 1;
            Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");

            Map<String, Object> paramsDatosPaciente = new HashMap();

            paramsDatosPaciente.put("irhis", objeto.getHISTORIA_CLINICA());
            paramsDatosPaciente.put("ir2unm", ir2unm);

            List<DatosPaciente> datosPaciente = new ArrayList<>();

            //Consultar datos cliente
            // Detplantbl detalle = new Detplantbl();
            String fechaSt = Integer.toString(ir2cit);
            String mesSt = fechaSt.substring(4, 6);
            String diaSt = fechaSt.substring(6, 8);
            String anioSt = fechaSt.substring(0, 4);

            Integer mesI = Integer.parseInt(mesSt);
            Integer diaI = Integer.parseInt(diaSt);
            int anioI = Integer.parseInt(anioSt);

            Calendar c1 = Calendar.getInstance();

            //Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");
            Double codepsold, codepread, codmedid;
            int codepsoli, codepreai, codmedii;

            codepsold = objeto.getDEPE_SOLICITA();
            codepread = objeto.getDEPE_REALIZA();
            codmedid = objeto.getMEDICO_SOLICITA();

            codepsoli = codepsold.intValue();
            codepreai = codepread.intValue();
            codmedii = codmedid.intValue();

            //Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");
            detalle.setNumplad(cab.getNumplanilla());

            //detalle.setNumplad(cab.getNumplanilla());
            detalle.setCoditem(objeto.getITEM_TARIFARIO()); //verificar cual va

            double historiaClinicad = objeto.getHISTORIA_CLINICA();
            int historiaClinicai = (int) historiaClinicad;

            detalle.setHistoCli(String.valueOf(historiaClinicai));
            detalle.setFechaReg(c1.getTime());
            detalle.setDescItem(objeto.getDESCRIPCION()); //con el codigo del tarifario descripcion

            //Este se podria quitar
            

            BigInteger codepsolbi = BigInteger.valueOf(codepsoli);
            BigInteger codepreabi = BigInteger.valueOf(codepreai);
            
            String nombreDependenciaRealiza = NombreDependenciaSQL(codepsolbi);
            detalle.setDepRea(nombreDependenciaRealiza); ////busco con el codigo
            
            detalle.setCoddepsol(codepsolbi);
            detalle.setCoddeprea(codepreabi); //ver esta campo
            
            detalle.setTipSer(2);  //ver este campo
            detalle.setSubtipser(1);
            detalle.setCantidad(1);
            detalle.setValorUnit(objeto.getVALOR()); //ver este campo
            detalle.setValorTotal(objeto.getVALOR());
            detalle.setNumOrden(1); //ver este campo
            detalle.setTipoRubro("IMA");
            //detalle.setCodMedico(objeto.)

            detalle.setCodMedico(codmedii);
            detalle.setNomMedico(" ");

            detalle.setDiagnostico1(" ");
            detalle.setDiagnostico2(" ");
            detalle.setDiagnostico3(" ");
            detalle.setDiagnostico4(" ");
            detalle.setDiagnostico5(" ");
            detalle.setDiagnostico6(" ");
            detalle.setTipoDiag1(' ');
            detalle.setTipoDiag2(' ');
            detalle.setTipoDiag3(' ');
            detalle.setTipoDiag4(' ');
            detalle.setTipoDiag5(' ');
            detalle.setTipoDiag6(' ');

            detalle.setTimeAntestesia(Short.parseShort("0"));  //no aplica anestencia en honorarios
            detalle.setCodDerivacion("CD"); //ver este campo
            detalle.setSecDerivacion(Short.parseShort("0")); //ver este campo
            detalle.setContingenCubre(0);

            detalle.setNombreAfiliado("Usuario 1");
            detalle.setCedulaAfiliado(" ");
            detalle.setParentesco(" ");
            detalle.setCedulaBeneficia(" ");
            detalle.setNombreBeneficia(" ");

            //Se agrega
            detalle.setTipoBeneficia("JU"); //ver este campo

            //Para sacar la fecha de nacimiento se ejecuta lo siguiente
            String fechaNa; //= datosPaciente.get(0).getFECNACIMIENTO();
            String mesNa = "11"; //= fechaNa.substring(4, 6);
            String diaNa = "11";//fechaNa.substring(6, 8);
            String anioNa = "1963"; //fechaNa.substring(0, 4);

            String fechaNac = anioNa + "-" + mesNa + "-" + diaNa;

            detalle.setFecNacBenef(Date.valueOf(fechaNac));

            //detalle.setFecNacBenef(Date.valueOf("1954-02-04")); //ver este campo
            detalle.setEdadBenefic(62);
            detalle.setGeneroBenef('M');
            detalle.setDuracionAtencion(0); //ver este campo
            detalle.setEstado('A');

            // if ( && bag != null && bag.get("cabplantbl") == null){
            cab.setDetplantblList(null);
            detalle.setCpidpk(cab);

            listaDetalles.add(detalle);
            
            registrarPorBloque(listaDetalles);
            
        }

    }

}
