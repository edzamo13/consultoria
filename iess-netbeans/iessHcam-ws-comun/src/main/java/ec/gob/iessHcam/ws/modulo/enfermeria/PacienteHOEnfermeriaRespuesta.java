/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.modulo.enfermeria;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>Incluir aquí la descripción de la clase.</b>
 *
 * @author dtapiam@iess.gob.ec
 * @version 1.0 (Revisión)
 * @since 1.0
 * <p>
 * [Author: Daniel Tapia, Date: 23/02/2017]
 * </p>
 */
public class PacienteHOEnfermeriaRespuesta implements Serializable {

    private static final long serialVersionUID = 3813634444554138995L;

    @Getter
    @Setter
    private String codigo;

    @Getter
    @Setter
    private PacienteHOEnfermeriaSalida cuerpo;

    @Getter
    @Setter
    private String mensaje;

    public PacienteHOEnfermeriaRespuesta() {
    }

}
