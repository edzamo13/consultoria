/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.listaEsperaCirugia;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>Incluir aquí la descripción de la clase.</b>
 *
 * @author dtapiam@iess.gob.ec
 * @version 1.0 (Revisión)
 * @since 1.0
 * <p>
 * [Author: Daniel Tapia, Date: 30/11/2016]
 * </p>
 */
public class TarifarioEntrada implements Serializable {

    private static final long serialVersionUID = -1422461356522387117L;

    @Getter
    @Setter
    private String codUnidadMedica;

    public TarifarioEntrada(String codUnidadMedica) {
        this.codUnidadMedica = codUnidadMedica;
    }

    public TarifarioEntrada() {
    }
}
