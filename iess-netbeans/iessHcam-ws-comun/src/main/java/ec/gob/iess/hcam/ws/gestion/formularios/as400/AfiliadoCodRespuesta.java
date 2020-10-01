/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.gestion.formularios.as400;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>clase base para respuesta WS.</b>
 *
 * @author jsaltosb@iess.gob.ec
 * <p>
 * [Author: Gabriel Saltos, Date: 29/03/2017]
 * </p>
 */
public class AfiliadoCodRespuesta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private List<AfiliadoCodSalida> cuerpoLista;
    @Getter
    @Setter
    private String mensaje;

    /**
     * <b>método constructor vacío.</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 29/03/2017]
     * </p>
     *
     */
    public AfiliadoCodRespuesta() {
    }

}
