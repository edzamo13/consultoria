/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author programacion
 */
public class ParteOperatorio implements Serializable {
    
    private int FECHAFINCIRUGIA;
    private int HORAENTRADAQUIROFANO;
    private int HORASALIDAQUIROFANO;
    private String UNIDADMEDICA;
    private int HISTORIACLINICA;
    private int FECHAOPERACION;
    private int HORAOPERACION;
    private String TIPOCIRUGIA;
    private String RIESGOANESTESIA;
    private int FECINICIAANEST;
    private int HORAINICIAANEST;
    private int FECFINANEST;
    private int HORAFINANEST;
    private int CIRUJANO1;
    private int CIRUJANO2;
    private int CIRUJANO3;
    private int CIRUJANO4;
    private int AYUDANTECC1;
    private int AYUDANTECC2;
    private int AYUDANTECC3;
    private int PERSONALAPOYO1;
    private int PERSONALAPOYO2;
    private int PERSONALAPOYO3;
    private String AYUDANTECCE1;
    private String AYUDANTECCE2;
    private String AYUDANTECCE3;
    private int ANESTESIOLOGO;
    private int ANESTESIOLOGO1;
    private int ANESTESIOLOGO2;
    private int ANESTESIOLOGO3;
    private String AYUDANTEANES1;
    private String AYUDANTEANES2;
    private String AYUDANTEANES3;
    private int INSTRUMENTISTA1;
    private int INSTRUMENTISTA2;
    private int CIRCULANTE1;
    private int CIRCULANTE2;
    private int PERFUSIONISTA;
    private String ESTADO;
    private String TRASLADO;
    private String APROBACIONPARTE;
    private String USUARIOACTUALIZA;
    private String PROGRAMA;
    private int FECHA;
    private int HORA;
    private Double DEPEQUIROFANO;
    private Double DEPECIRU;    

    public int getFECHAFINCIRUGIA() {
        return FECHAFINCIRUGIA;
    }

    public void setFECHAFINCIRUGIA(int FECHAFINCIRUGIA) {
        this.FECHAFINCIRUGIA = FECHAFINCIRUGIA;
    }

    public int getHORAENTRADAQUIROFANO() {
        return HORAENTRADAQUIROFANO;
    }

    public void setHORAENTRADAQUIROFANO(int HORAENTRADAQUIROFANO) {
        this.HORAENTRADAQUIROFANO = HORAENTRADAQUIROFANO;
    }

    public int getHORASALIDAQUIROFANO() {
        return HORASALIDAQUIROFANO;
    }

    public void setHORASALIDAQUIROFANO(int HORASALIDAQUIROFANO) {
        this.HORASALIDAQUIROFANO = HORASALIDAQUIROFANO;
    }

    public int getFECHAOPERACION() {
        return FECHAOPERACION;
    }

    public void setFECHAOPERACION(int FECHAOPERACION) {
        this.FECHAOPERACION = FECHAOPERACION;
    }

    public int getHORAOPERACION() {
        return HORAOPERACION;
    }

    public void setHORAOPERACION(int HORAOPERACION) {
        this.HORAOPERACION = HORAOPERACION;
    }

    public String getTIPOCIRUGIA() {
        return TIPOCIRUGIA;
    }

    public void setTIPOCIRUGIA(String TIPOCIRUGIA) {
        this.TIPOCIRUGIA = TIPOCIRUGIA;
    }

    public String getRIESGOANESTESIA() {
        return RIESGOANESTESIA;
    }

    public void setRIESGOANESTESIA(String RIESGOANESTESIA) {
        this.RIESGOANESTESIA = RIESGOANESTESIA;
    }
   
    public int getFECINICIAANEST() {
        return FECINICIAANEST;
    }

    public void setFECINICIAANEST(int FECINICIAANEST) {
        this.FECINICIAANEST = FECINICIAANEST;
    }

    public int getHORAINICIAANEST() {
        return HORAINICIAANEST;
    }

    public void setHORAINICIAANEST(int HORAINICIAANEST) {
        this.HORAINICIAANEST = HORAINICIAANEST;
    }

    public int getFECFINANEST() {
        return FECFINANEST;
    }

    public void setFECFINANEST(int FECFINANEST) {
        this.FECFINANEST = FECFINANEST;
    }

    public int getHORAFINANEST() {
        return HORAFINANEST;
    }

    public void setHORAFINANEST(int HORAFINANEST) {
        this.HORAFINANEST = HORAFINANEST;
    }

    public int getCIRUJANO1() {
        return CIRUJANO1;
    }

    public void setCIRUJANO1(int CIRUJANO1) {
        this.CIRUJANO1 = CIRUJANO1;
    }

    public int getCIRUJANO2() {
        return CIRUJANO2;
    }

    public void setCIRUJANO2(int CIRUJANO2) {
        this.CIRUJANO2 = CIRUJANO2;
    }

    public int getCIRUJANO3() {
        return CIRUJANO3;
    }

    public void setCIRUJANO3(int CIRUJANO3) {
        this.CIRUJANO3 = CIRUJANO3;
    }

    public int getCIRUJANO4() {
        return CIRUJANO4;
    }

    public void setCIRUJANO4(int CIRUJANO4) {
        this.CIRUJANO4 = CIRUJANO4;
    }

    public int getAYUDANTECC1() {
        return AYUDANTECC1;
    }

    public void setAYUDANTECC1(int AYUDANTECC1) {
        this.AYUDANTECC1 = AYUDANTECC1;
    }

    public int getAYUDANTECC2() {
        return AYUDANTECC2;
    }

    public void setAYUDANTECC2(int AYUDANTECC2) {
        this.AYUDANTECC2 = AYUDANTECC2;
    }

    public int getAYUDANTECC3() {
        return AYUDANTECC3;
    }

    public void setAYUDANTECC3(int AYUDANTECC3) {
        this.AYUDANTECC3 = AYUDANTECC3;
    }

    public int getPERSONALAPOYO1() {
        return PERSONALAPOYO1;
    }

    public void setPERSONALAPOYO1(int PERSONALAPOYO1) {
        this.PERSONALAPOYO1 = PERSONALAPOYO1;
    }

    public int getPERSONALAPOYO2() {
        return PERSONALAPOYO2;
    }

    public void setPERSONALAPOYO2(int PERSONALAPOYO2) {
        this.PERSONALAPOYO2 = PERSONALAPOYO2;
    }

    public int getPERSONALAPOYO3() {
        return PERSONALAPOYO3;
    }

    public void setPERSONALAPOYO3(int PERSONALAPOYO3) {
        this.PERSONALAPOYO3 = PERSONALAPOYO3;
    }

    public String getUNIDADMEDICA() {
        return UNIDADMEDICA;
    }
    
    public void setUNIDADMEDICA(String UNIDADMEDICA) {
        this.UNIDADMEDICA = UNIDADMEDICA;
    }

    public int getHISTORIACLINICA() {
        return HISTORIACLINICA;
    }

    public void setHISTORIACLINICA(int HISTORIACLINICA) {
        this.HISTORIACLINICA = HISTORIACLINICA;
    }
    
    public String getAYUDANTECCE1() {
        return AYUDANTECCE1;
    }

    public void setAYUDANTECCE1(String AYUDANTECCE1) {
        this.AYUDANTECCE1 = AYUDANTECCE1;
    }

    public String getAYUDANTECCE2() {
        return AYUDANTECCE2;
    }

    public void setAYUDANTECCE2(String AYUDANTECCE2) {
        this.AYUDANTECCE2 = AYUDANTECCE2;
    }

    public String getAYUDANTECCE3() {
        return AYUDANTECCE3;
    }

    public void setAYUDANTECCE3(String AYUDANTECCE3) {
        this.AYUDANTECCE3 = AYUDANTECCE3;
    }    

    public int getANESTESIOLOGO() {
        return ANESTESIOLOGO;
    }

    public void setANESTESIOLOGO(int ANESTESIOLOGO) {
        this.ANESTESIOLOGO = ANESTESIOLOGO;
    }

    public int getANESTESIOLOGO1() {
        return ANESTESIOLOGO1;
    }

    public void setANESTESIOLOGO1(int ANESTESIOLOGO1) {
        this.ANESTESIOLOGO1 = ANESTESIOLOGO1;
    }

    public int getANESTESIOLOGO2() {
        return ANESTESIOLOGO2;
    }

    public void setANESTESIOLOGO2(int ANESTESIOLOGO2) {
        this.ANESTESIOLOGO2 = ANESTESIOLOGO2;
    }

    public int getANESTESIOLOGO3() {
        return ANESTESIOLOGO3;
    }

    public void setANESTESIOLOGO3(int ANESTESIOLOGO3) {
        this.ANESTESIOLOGO3 = ANESTESIOLOGO3;
    }    

    public String getAYUDANTEANES1() {
        return AYUDANTEANES1;
    }

    public void setAYUDANTEANES1(String AYUDANTEANES1) {
        this.AYUDANTEANES1 = AYUDANTEANES1;
    }

    public String getAYUDANTEANES2() {
        return AYUDANTEANES2;
    }

    public void setAYUDANTEANES2(String AYUDANTEANES2) {
        this.AYUDANTEANES2 = AYUDANTEANES2;
    }

    public String getAYUDANTEANES3() {
        return AYUDANTEANES3;
    }

    public void setAYUDANTEANES3(String AYUDANTEANES3) {
        this.AYUDANTEANES3 = AYUDANTEANES3;
    }

    public int getINSTRUMENTISTA1() {
        return INSTRUMENTISTA1;
    }

    public void setINSTRUMENTISTA1(int INSTRUMENTISTA1) {
        this.INSTRUMENTISTA1 = INSTRUMENTISTA1;
    }

    public int getINSTRUMENTISTA2() {
        return INSTRUMENTISTA2;
    }

    public void setINSTRUMENTISTA2(int INSTRUMENTISTA2) {
        this.INSTRUMENTISTA2 = INSTRUMENTISTA2;
    }

    public int getCIRCULANTE1() {
        return CIRCULANTE1;
    }

    public void setCIRCULANTE1(int CIRCULANTE1) {
        this.CIRCULANTE1 = CIRCULANTE1;
    }

    public int getCIRCULANTE2() {
        return CIRCULANTE2;
    }

    public void setCIRCULANTE2(int CIRCULANTE2) {
        this.CIRCULANTE2 = CIRCULANTE2;
    }

    public int getPERFUSIONISTA() {
        return PERFUSIONISTA;
    }

    public void setPERFUSIONISTA(int PERFUSIONISTA) {
        this.PERFUSIONISTA = PERFUSIONISTA;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    public String getTRASLADO() {
        return TRASLADO;
    }

    public void setTRASLADO(String TRASLADO) {
        this.TRASLADO = TRASLADO;
    }

    public String getAPROBACIONPARTE() {
        return APROBACIONPARTE;
    }

    public void setAPROBACIONPARTE(String APROBACIONPARTE) {
        this.APROBACIONPARTE = APROBACIONPARTE;
    }

    public String getUSUARIOACTUALIZA() {
        return USUARIOACTUALIZA;
    }

    public void setUSUARIOACTUALIZA(String USUARIOACTUALIZA) {
        this.USUARIOACTUALIZA = USUARIOACTUALIZA;
    }

    public String getPROGRAMA() {
        return PROGRAMA;
    }

    public void setPROGRAMA(String PROGRAMA) {
        this.PROGRAMA = PROGRAMA;
    }

    public int getFECHA() {
        return FECHA;
    }

    public void setFECHA(int FECHA) {
        this.FECHA = FECHA;
    }

    public int getHORA() {
        return HORA;
    }

    public void setHORA(int HORA) {
        this.HORA = HORA;
    }

    public Double getDEPEQUIROFANO() {
        return DEPEQUIROFANO;
    }

    public void setDEPEQUIROFANO(Double DEPEQUIROFANO) {
        this.DEPEQUIROFANO = DEPEQUIROFANO;
    }   

    public Double getDEPECIRU() {
        return DEPECIRU;
    }

    public void setDEPECIRU(Double DEPECIRU) {
        this.DEPECIRU = DEPECIRU;
    }
    
    
}
