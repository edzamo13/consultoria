/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.gestionAs400;

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
public class DependenciaSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    private String estado;
    @Getter
    @Setter
    private String unidadMedica;
    @Getter
    @Setter
    private String codDependencia;
    @Getter
    @Setter
    private String descripDependencia;
    @Getter
    @Setter
    private String tipoDependencia;

    public DependenciaSalida(String estado, String unidadMedica, String codDependencia, String descripDependencia, String tipoDependencia) {
        this.estado = estado;
        this.unidadMedica = unidadMedica;
        this.codDependencia = codDependencia;
        this.descripDependencia = descripDependencia;
        this.tipoDependencia = tipoDependencia;
    }
    
    public DependenciaSalida() {
    }

}
