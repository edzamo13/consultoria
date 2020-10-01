/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.gestion.formularios.as400;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>Datos entrada examenes laboratorio.</b>
 *
 * @author jsaltosb@iess.gob.ec
 * <p>
 * [Author: Gabriel Saltos, Date: 15/03/2017]
 * </p>
 */
public class ExamenesEntrada implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String codUME;

    @Getter
    @Setter
    private String numOrden;

    /**
     * <b>Método constructor.</b>
     * <p>
     * [Autor: Gabriel Saltos, Fecha: 15/03/2017]
     * </p>
     *
     */
    public ExamenesEntrada() {

    }

}
