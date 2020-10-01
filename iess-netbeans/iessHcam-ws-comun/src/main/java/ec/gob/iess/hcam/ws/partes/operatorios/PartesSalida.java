/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.partes.operatorios;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>clase .</b>
 *
 * @author jsaltosbm@iess.gob.ec
 * <p>
 * [Author: Gabriel Saltos; Date: 10/07/2017]
 * </p>
 */
public class PartesSalida implements Serializable {

    private static final long serialVersionUID = -2126481295256961929L;

    @Getter
    @Setter
    private String CODUNME;
    @Getter
    @Setter
    private String nomume;
    @Getter
    @Setter
    private String CODDEPEN_ing_pac;
    @Getter
    @Setter
    private String nomDEPEN_ING_PAC;
    @Getter
    @Setter
    private String COD_DEPE_opera;
    @Getter
    @Setter
    private String nomDEPENDENCIA_OPERA;
    @Getter
    @Setter
    private String HIS;
    @Getter
    @Setter
    private String TIP_DOC;
    @Getter
    @Setter
    private String IDENTIFICACION;
    @Getter
    @Setter
    private String NOMBRE;
    @Getter
    @Setter
    private String FECHAOPERACION;
    @Getter
    @Setter
    private String HORAOPERACION;
    @Getter
    @Setter
    private String codUNIDAD;
    @Getter
    @Setter
    private String SALA;
    @Getter
    @Setter
    private String DESCRICPION;
    @Getter
    @Setter
    private String codTIPOOPERACION;
    @Getter
    @Setter
    private String TIPOOPERACION;
    @Getter
    @Setter
    private String CODNIVELCOMPLEJIDAD;
    @Getter
    @Setter
    private String NIVELCOMPLEJIDAD;
    @Getter
    @Setter
    private String codDIAGPREOP;
    @Getter
    @Setter
    private String DIAGPREOP;
    @Getter
    @Setter
    private String codDIAFPOST;
    @Getter
    @Setter
    private String DIAGPOST;
    @Getter
    @Setter
    private String CODTARIFARIO;
    @Getter
    @Setter
    private String DESCRIPTARIFARIO;
    @Getter
    @Setter
    private String FECHAINGQUIROFANO;
    @Getter
    @Setter
    private String HORAINGQUIROFANO;
    @Getter
    @Setter
    private String FECHASALQUIROFANO;
    @Getter
    @Setter
    private String HORASALQUIROFANO;
    @Getter
    @Setter
    private String TIEMPOQUIROFANO;
    @Getter
    @Setter
    private String FECHAINICIRUGIA;
    @Getter
    @Setter
    private String HORAINICIRUGIA;
    @Getter
    @Setter
    private String FECHAFINCIRUGIA;
    @Getter
    @Setter
    private String HORAFINCIRUGIA;
    @Getter
    @Setter
    private String TIEMPOCIRUGIA;
    @Getter
    @Setter
    private String codCIRUJANO;
    @Getter
    @Setter
    private String NOMBRECIRUJANO;
    @Getter
    @Setter
    private String codAYUDANTECIRUJANO;
    @Getter
    @Setter
    private String nomAYUDANTECIRUJANO;
    @Getter
    @Setter
    private String CIRUJANO2;
    @Getter
    @Setter
    private String NOMBRECIRUJANO2;
    @Getter
    @Setter
    private String CIRUJANO3;
    @Getter
    @Setter
    private String NOMBRECIRUJANO3;
    @Getter
    @Setter
    private String AYUDANTE1;
    @Getter
    @Setter
    private String NOMBREAYUDANTE1;
    @Getter
    @Setter
    private String AYUDANTE2;
    @Getter
    @Setter
    private String NOMBREAYUDANTE2;
    @Getter
    @Setter
    private String AYUDANTE3;
    @Getter
    @Setter
    private String NOMBREAYUDANTE3;
    @Getter
    @Setter
    private String ANESTESIOLOGO;
    @Getter
    @Setter
    private String NOMBREANESTESIOLOGO;
    @Getter
    @Setter
    private String codcirculante;
    @Getter
    @Setter
    private String NOMBRECIRCULANTE;
    @Getter
    @Setter
    private String ESTADOOPERACION;
    @Getter
    @Setter
    private String ESTADOOPERACION2;

    /**
     * <b>método .</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 10/07/2017]
     * </p>
     *
     */
    public PartesSalida() {
        //vacio
    }

    /**
     * <b>método .</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 10/07/2017]
     * </p>
     *
     * @param CODUNME texto
     * @param nomume texto
     * @param CODDEPEN_ing_pac texto
     * @param nomDEPEN_ING_PAC texto
     * @param COD_DEPE_opera texto
     * @param nomDEPENDENCIA_OPERA texto
     * @param HIS texto
     * @param TIP_DOC texto
     * @param IDENTIFICACION texto
     * @param NOMBRE texto
     * @param FECHAOPERACION texto
     * @param HORAOPERACION texto
     * @param codUNIDAD texto
     * @param SALA texto
     * @param DESCRICPION texto
     * @param codTIPOOPERACION texto
     * @param TIPOOPERACION texto
     * @param CODNIVELCOMPLEJIDAD texto
     * @param NIVELCOMPLEJIDAD texto
     * @param codDIAGPREOP texto
     * @param DIAGPREOP texto
     * @param codDIAFPOST texto
     * @param DIAGPOST texto
     * @param CODTARIFARIO texto
     * @param DESCRIPTARIFARIO texto
     * @param FECHAINGQUIROFANO texto
     * @param HORAINGQUIROFANO texto
     * @param FECHASALQUIROFANO texto
     * @param HORASALQUIROFANO texto
     * @param TIEMPOQUIROFANO texto
     * @param FECHAINICIRUGIA texto
     * @param HORAINICIRUGIA texto
     * @param FECHAFINCIRUGIA texto
     * @param HORAFINCIRUGIA texto
     * @param TIEMPOCIRUGIA texto
     * @param codCIRUJANO texto
     * @param NOMBRECIRUJANO texto
     * @param codAYUDANTECIRUJANO texto
     * @param nomAYUDANTECIRUJANO texto
     * @param CIRUJANO2 texto
     * @param NOMBRECIRUJANO2 texto
     * @param CIRUJANO3 texto
     * @param NOMBRECIRUJANO3 texto
     * @param AYUDANTE1 texto
     * @param NOMBREAYUDANTE1 texto
     * @param AYUDANTE2 texto
     * @param NOMBREAYUDANTE2 texto
     * @param AYUDANTE3 texto
     * @param NOMBREAYUDANTE3 texto
     * @param ANESTESIOLOGO texto
     * @param NOMBREANESTESIOLOGO texto
     * @param codcirculante texto
     * @param NOMBRECIRCULANTE texto
     * @param ESTADOOPERACION texto
     * @param ESTADOOPERACION2 texto
     */
    public PartesSalida(String CODUNME, String nomume, String CODDEPEN_ing_pac, String nomDEPEN_ING_PAC, String COD_DEPE_opera, String nomDEPENDENCIA_OPERA, String HIS, String TIP_DOC, String IDENTIFICACION, String NOMBRE, String FECHAOPERACION, String HORAOPERACION, String codUNIDAD, String SALA, String DESCRICPION, String codTIPOOPERACION, String TIPOOPERACION, String CODNIVELCOMPLEJIDAD, String NIVELCOMPLEJIDAD, String codDIAGPREOP, String DIAGPREOP, String codDIAFPOST, String DIAGPOST, String CODTARIFARIO, String DESCRIPTARIFARIO, String FECHAINGQUIROFANO, String HORAINGQUIROFANO, String FECHASALQUIROFANO, String HORASALQUIROFANO, String TIEMPOQUIROFANO, String FECHAINICIRUGIA, String HORAINICIRUGIA, String FECHAFINCIRUGIA, String HORAFINCIRUGIA, String TIEMPOCIRUGIA, String codCIRUJANO, String NOMBRECIRUJANO, String codAYUDANTECIRUJANO, String nomAYUDANTECIRUJANO, String CIRUJANO2, String NOMBRECIRUJANO2, String CIRUJANO3, String NOMBRECIRUJANO3, String AYUDANTE1, String NOMBREAYUDANTE1, String AYUDANTE2, String NOMBREAYUDANTE2, String AYUDANTE3, String NOMBREAYUDANTE3, String ANESTESIOLOGO, String NOMBREANESTESIOLOGO, String codcirculante, String NOMBRECIRCULANTE, String ESTADOOPERACION, String ESTADOOPERACION2) {
        this.CODUNME = CODUNME;
        this.nomume = nomume;
        this.CODDEPEN_ing_pac = CODDEPEN_ing_pac;
        this.nomDEPEN_ING_PAC = nomDEPEN_ING_PAC;
        this.COD_DEPE_opera = COD_DEPE_opera;
        this.nomDEPENDENCIA_OPERA = nomDEPENDENCIA_OPERA;
        this.HIS = HIS;
        this.TIP_DOC = TIP_DOC;
        this.IDENTIFICACION = IDENTIFICACION;
        this.NOMBRE = NOMBRE;
        this.FECHAOPERACION = FECHAOPERACION;
        this.HORAOPERACION = HORAOPERACION;
        this.codUNIDAD = codUNIDAD;
        this.SALA = SALA;
        this.DESCRICPION = DESCRICPION;
        this.codTIPOOPERACION = codTIPOOPERACION;
        this.TIPOOPERACION = TIPOOPERACION;
        this.CODNIVELCOMPLEJIDAD = CODNIVELCOMPLEJIDAD;
        this.NIVELCOMPLEJIDAD = NIVELCOMPLEJIDAD;
        this.codDIAGPREOP = codDIAGPREOP;
        this.DIAGPREOP = DIAGPREOP;
        this.codDIAFPOST = codDIAFPOST;
        this.DIAGPOST = DIAGPOST;
        this.CODTARIFARIO = CODTARIFARIO;
        this.DESCRIPTARIFARIO = DESCRIPTARIFARIO;
        this.FECHAINGQUIROFANO = FECHAINGQUIROFANO;
        this.HORAINGQUIROFANO = HORAINGQUIROFANO;
        this.FECHASALQUIROFANO = FECHASALQUIROFANO;
        this.HORASALQUIROFANO = HORASALQUIROFANO;
        this.TIEMPOQUIROFANO = TIEMPOQUIROFANO;
        this.FECHAINICIRUGIA = FECHAINICIRUGIA;
        this.HORAINICIRUGIA = HORAINICIRUGIA;
        this.FECHAFINCIRUGIA = FECHAFINCIRUGIA;
        this.HORAFINCIRUGIA = HORAFINCIRUGIA;
        this.TIEMPOCIRUGIA = TIEMPOCIRUGIA;
        this.codCIRUJANO = codCIRUJANO;
        this.NOMBRECIRUJANO = NOMBRECIRUJANO;
        this.codAYUDANTECIRUJANO = codAYUDANTECIRUJANO;
        this.nomAYUDANTECIRUJANO = nomAYUDANTECIRUJANO;
        this.CIRUJANO2 = CIRUJANO2;
        this.NOMBRECIRUJANO2 = NOMBRECIRUJANO2;
        this.CIRUJANO3 = CIRUJANO3;
        this.NOMBRECIRUJANO3 = NOMBRECIRUJANO3;
        this.AYUDANTE1 = AYUDANTE1;
        this.NOMBREAYUDANTE1 = NOMBREAYUDANTE1;
        this.AYUDANTE2 = AYUDANTE2;
        this.NOMBREAYUDANTE2 = NOMBREAYUDANTE2;
        this.AYUDANTE3 = AYUDANTE3;
        this.NOMBREAYUDANTE3 = NOMBREAYUDANTE3;
        this.ANESTESIOLOGO = ANESTESIOLOGO;
        this.NOMBREANESTESIOLOGO = NOMBREANESTESIOLOGO;
        this.codcirculante = codcirculante;
        this.NOMBRECIRCULANTE = NOMBRECIRCULANTE;
        this.ESTADOOPERACION = ESTADOOPERACION;
        this.ESTADOOPERACION2 = ESTADOOPERACION2;
    }

}
