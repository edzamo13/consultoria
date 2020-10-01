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
 * <b>Incluir aquí la descripción de la clase.</b>
 *
 * @author jsaltosb@iess.gob.ec
 * <p>
 * [Author: Gabriel Saltos, Date: 12/04/2017]
 * </p>
 */
public class ProcedimientoRespuesta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String codigo;

    @Getter
    @Setter
    private List<ProcedimientoSalida> cuerpoLista;

    @Getter
    @Setter
    private String mensaje;

    public ProcedimientoRespuesta() {
    }

}
