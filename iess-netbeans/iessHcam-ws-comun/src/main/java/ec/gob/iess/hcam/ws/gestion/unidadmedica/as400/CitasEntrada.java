/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.gestion.unidadmedica.as400;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>clase .</b>
 *
 * @author jsaltosbm@iess.gob.ec
 * <p>
 * [Author: Gabriel Saltos, Date: 13/06/2017]
 * </p>
 */
public class CitasEntrada implements Serializable {

    private static final long serialVersionUID = 7701162006043622759L;

    @Getter
    @Setter
    private String codUME;

    @Getter
    @Setter
    private String tipoIdent;

    @Getter
    @Setter
    private String dato;

    @Getter
    @Setter
    private String fecha;

    /**
     * <b>método constructor.</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 13/06/2017]
     * </p>
     *
     */
    public CitasEntrada() {
        //vacio
    }

}
