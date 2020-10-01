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
 * <b>clase para varios pacientes ho.</b>
 *
 * @author jsaltosbm@iess.gob.ec
 * <p>
 * [Author: Gabriel Saltos, Date: 08/05/2017]
 * </p>
 */
public class PacientesHOEnfermeriaRespuesta implements Serializable {

    private static final long serialVersionUID = 5551851178620097442L;
    @Getter
    @Setter
    private String codigo;

    @Getter
    @Setter
    private List<PacienteHOEnfermeriaSalida> cuerpo;

    @Getter
    @Setter
    private String mensaje;

    /**
     * <b>método constructor.</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 08/05/2017]
     * </p>
     *
     */
    public PacientesHOEnfermeriaRespuesta() {
    }

}
