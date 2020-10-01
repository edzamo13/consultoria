/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.gestion.laboratorios.dnti;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>Parámetros de entrada para obtención de Resultados AS400 - DNTI</b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>
 * [Author: Felipe Salazar, Date: 13/06/2017]
 * </p>
 */
public class ResultadosEntrada implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String cedula;
    @Getter
    @Setter
    private String fecNacimiento;

     public ResultadosEntrada() {

    }

    public ResultadosEntrada(String cedula, String fecNacimiento) {
        this.cedula = cedula;
        this.fecNacimiento = fecNacimiento;
    }

}
