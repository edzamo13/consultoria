/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.partes.operatorios;

import java.io.Serializable;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>clase .</b>
 *
 * @author jsaltosbm@iess.gob.ec
 * <p>
 * [Author: Gabriel Saltos, Date: 10/07/2017]
 * </p>
 */
public class PartesEntrada implements Serializable {

    private static final long serialVersionUID = 150676954179535419L;

    @Getter
    @Setter
    private String codUME;

    @Getter
    @Setter
    private String fechaIni;

    @Getter
    @Setter
    private String fechaFin;

    /**
     * <b>método .</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 10/07/2017]
     * </p>
     *
     */
    public PartesEntrada() {
        //vacio
    }

}
