/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.modulo.enfermeria;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
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
@XmlRootElement
public class PacienteHOEnfermeriaEntrada implements Serializable {

    private static final long serialVersionUID = 5854017475620917849L;

    @Getter
    @Setter
    private String unidadMedica;
    @Getter
    @Setter
    private int tipoBusqueda;
    @Getter
    @Setter
    private String dato;

    @Getter
    @Setter
    private String numHistoria;
    @Getter
    @Setter
    private String fechaAtencion;
//    @Getter
//    @Setter
//    private String codDependencia;

    public PacienteHOEnfermeriaEntrada() {
    }

}
