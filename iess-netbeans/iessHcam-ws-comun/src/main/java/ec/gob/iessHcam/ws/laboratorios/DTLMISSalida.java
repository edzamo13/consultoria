/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.laboratorios;

import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Parámetro de entrada para descarga de la orden en CEDDTA.MISDTL3
 * </b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>
 * [$Author: fsalazarn@iess.gob.ec $, $Date: 25/02/2016]</p>
 */
public class DTLMISSalida {

    @Getter
    @Setter
    private String dlnuor;
    @Getter
    @Setter
    private int dlfecd;
    @Getter
    @Setter
    private int dlhoam;
    @Getter
    @Setter
    private String dlfil2;
    @Getter
    @Setter
    private String dlusla;
    @Getter
    @Setter
    private String dlsta1;
    @Getter
    @Setter
    private String dlcexa;
    @Getter
    @Setter
    private String dlunme;

    @Override
    public String toString() {

        System.out.println(dlnuor);
        System.out.println(dlfecd);
        System.out.println(dlhoam);
        System.out.println(dlfil2);
        System.out.println(dlusla);
        System.out.println(dlsta1);
        System.out.println(dlcexa);
        System.out.println(dlunme);

        return  dlnuor + dlfecd + "" + dlhoam + "" + dlfil2 + "" + dlusla + "" + dlsta1 + "" + dlcexa + "" + dlunme;

    }

}
