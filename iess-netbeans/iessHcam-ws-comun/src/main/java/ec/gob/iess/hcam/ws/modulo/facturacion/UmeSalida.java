/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.modulo.facturacion;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>clase .</b>
 *
 * @author jsaltosbm@iess.gob.ec
 * <p>
 * [Author: Gabriel Saltos, Date: 28/06/2017]
 * </p>
 */
public class UmeSalida implements Serializable {

    private static final long serialVersionUID = -3578398546404834272L;

    @Getter
    @Setter
    private String codUme;

    @Getter
    @Setter
    private String archivoUme;

    @Getter
    @Setter
    private String nombreUme;

    @Getter
    @Setter
    private String direccionUme;

    /**
     * <b>método .</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 28/06/2017]
     * </p>
     *
     */
    public UmeSalida() {
        //vacio
    }

    /**
     * <b>método .</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 28/06/2017]
     * </p>
     *
     * @param codUme codigo unidad médica
     * @param archivoUme nombre archivo unidad médica
     * @param nombreUme nombre unidad médica
     * @param direccionUme dirección unidad médica
     */
    public UmeSalida(String codUme, String archivoUme, String nombreUme, String direccionUme) {
        this.codUme = codUme;
        this.archivoUme = archivoUme;
        this.nombreUme = nombreUme;
        this.direccionUme = direccionUme;
    }
}
