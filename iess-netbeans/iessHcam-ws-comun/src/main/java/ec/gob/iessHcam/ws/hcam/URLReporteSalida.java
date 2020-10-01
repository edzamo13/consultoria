/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.hcam;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author ezamora
 * <p>
 * [$Author: ezamora $, $Date: 20/01/2016]</p>
 */
public class URLReporteSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;
    
    @Getter
    @Setter
    private String unidadMedica;
    @Getter
    @Setter
    private String secuencial;
    @Getter
    @Setter
    private String url;
    @Getter
    @Setter
    private String archivo;

    public URLReporteSalida() {
        super();
    }

    public URLReporteSalida(String unidadMedica, String secuencial, String url, String archivo) {
        this.unidadMedica = unidadMedica;
        this.secuencial = secuencial;
        this.url = url;
        this.archivo = archivo;
    }
}
