/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.cs.autentificacion;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Pojo MetodoxServicioRespuesta Respuesta.
 * </b>
 *
 * @author ezamora
 * <p>
 * [$Author: ezamora $, $Date: 27/04/2016]</p>
 */
public class MetodoxServicioRespuesta implements Serializable {

    private static final long serialVersionUID = 227483449663204875L;

    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private List<MetodoxServicioSalida> cuerpoLista;
    @Getter
    @Setter
    private String mensaje;

    public MetodoxServicioRespuesta() {
    }

}
