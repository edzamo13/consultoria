/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.correo;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ezamora
 */
public class CorreoEntrada implements Serializable {

    private static final long serialVersionUID = -1422461130529850817L;

    @Getter
    @Setter
    private String para;
    @Getter
    @Setter
    private String mensaje;
    @Getter
    @Setter
    private String asunto;
    
    
    @Getter
    @Setter
    private String archivo;
    @Getter
    @Setter
    private String nombreArchivo;
    @Getter
    @Setter
    private String cc;
    
    @Getter
    @Setter
    private List<ArchivoAdjunto> archivosAdjuntos;

    /**
     *
     * <b>
     * Constructor
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 14/09/2016]</p>
     */
    public CorreoEntrada() {
    }
    
    

}
