/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.gestion.formularios.as400;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>Incluir aquí la descripción de la clase.</b>
 *
 * @author jsaltosb@iess.gob.ec
 * <p>
 * [Author: Gabriel Saltos, Date: 21/03/2017]
 * </p>
 */
public class DiagnosticoLabListaSalida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String codigo;

    @Getter
    @Setter
    private String descripcion;

    @Getter
    @Setter
    private String condicion;

    public DiagnosticoLabListaSalida(String codigo, String descripcion, String condicion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.condicion = condicion;
    }

    public DiagnosticoLabListaSalida() {
    }

}
