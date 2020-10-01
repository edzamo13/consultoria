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
public class UmeEntrada implements Serializable {

    private static final long serialVersionUID = 3158241433074717649L;

    @Getter
    @Setter
    private int tipoDato; //0nada, 1archivo, 2codume

    @Getter
    @Setter
    private String dato;

    /**
     * <b>método .</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 28/06/2017]
     * </p>
     *
     */
    public UmeEntrada() {
        //vacio
    }

}
