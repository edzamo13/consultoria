/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.modulo.facturacion;

import java.io.Serializable;
import java.util.List;
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
public class UmeRespuesta implements Serializable {

    private static final long serialVersionUID = 7620079719167301283L;

    @Getter
    @Setter
    private String codigo;

    @Getter
    @Setter
    private List<UmeSalida> cuerpo;

    @Getter
    @Setter
    private String mensaje;

    /**
     * <b>método .</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 28/06/2017]
     * </p>
     *
     */
    public UmeRespuesta() {
        //vacio
    }

}
