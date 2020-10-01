/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
 *   Pojo con el código de la unidad médica y su nombre.
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>[$Author: Jorge Zúñiga $, $Date: 15-mar-2016]</p>
 */
public class UnidadMedicaSalida implements Serializable {

    private static final long serialVersionUID = -4002897314076938975L;

    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private String nombreUnme;
    @Getter
    @Setter
    private String mensaje;

    public UnidadMedicaSalida() {
    }

    public UnidadMedicaSalida(String codigo, String nombreUnme, String mensaje) {
        this.codigo = codigo;
        this.nombreUnme = nombreUnme;
        this.mensaje = mensaje;
    }
}

