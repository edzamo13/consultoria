/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.partes.operatorios;

import java.io.Serializable;
import java.util.List;
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
public class PartesRespuesta implements Serializable {

    private static final long serialVersionUID = -4956120311083914977L;

    @Getter
    @Setter
    private String codigo;

    @Getter
    @Setter
    private List<PartesSalida> cuerpoLista;

    @Getter
    @Setter
    private String mensaje;

    /**
     * <b>método .</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 10/07/2017]
     * </p>
     *
     */
    public PartesRespuesta() {
        //vacio
    }

}
