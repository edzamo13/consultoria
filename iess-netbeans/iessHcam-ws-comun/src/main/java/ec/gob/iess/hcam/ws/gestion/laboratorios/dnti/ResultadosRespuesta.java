/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.gestion.laboratorios.dnti;

import ec.gob.iess.hcam.ws.gestion.laboratorios.dnti.ResultadosSalida;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>Mapeo Salida Resultados DNTI</b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>
 * [Author: Felipe Salazar, Date: 13/06/2017]
 * </p>
 */
public class ResultadosRespuesta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String codigo;
    
    @Getter
    @Setter
    private List<ResultadosSalida> cuerpoLista;

    @Getter
    @Setter
    private String mensaje;

    public ResultadosRespuesta() {

    }

    public ResultadosRespuesta(String codigo, List<ResultadosSalida> cuerpoLista, String mensaje) {
        this.codigo = codigo;
        this.cuerpoLista = cuerpoLista;
        this.mensaje = mensaje;
    }

}
