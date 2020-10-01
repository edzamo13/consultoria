/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.listaEsperaCirugia;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>
 * [$Author: Jorge Zúñiga $, $Date: 14-mar-2016]</p>
 */
public class InformacionAfiliadoEntrada implements Serializable {

    private static final long serialVersionUID = -1422461130529850817L;

    @Getter
    @Setter
    private String codUnidadMedica;
    @Getter
    @Setter
    private String numHistoria;
    @Getter
    @Setter
    private String medico;
    @Getter
    @Setter
    private String codDependencia;
    @Getter
    @Setter
    private String fechaAtencion;
    @Getter
    @Setter
    private String horaAtencion;

    public InformacionAfiliadoEntrada(String codUnidadMedica, String numHistoria, String medico, String codDependencia, String fechaAtencion, String horaAtencion) {
        this.codUnidadMedica = codUnidadMedica;
        this.numHistoria = numHistoria;
        this.medico = medico;
        this.codDependencia = codDependencia;
        this.fechaAtencion = fechaAtencion;
        this.horaAtencion = horaAtencion;
    }

    public InformacionAfiliadoEntrada() {
    }
}
