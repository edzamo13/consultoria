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
 * [Author: Gabriel Saltos, Date: 12/04/2017]
 * </p>
 */
public class ProcedimientoEntrada implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String codUME;

    @Getter
    @Setter
    private String codServicio;

    @Getter
    @Setter
    private String codSubServicio;

    @Getter
    @Setter
    private String codNivel;

    @Getter
    @Setter
    private String codProcedimiento;

    public ProcedimientoEntrada() {
    }

}
