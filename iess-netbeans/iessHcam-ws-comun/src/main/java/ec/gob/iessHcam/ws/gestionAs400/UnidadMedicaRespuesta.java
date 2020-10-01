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
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 *   Respuesta con la lista de unidades médicas obtenidas del as400.
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>[$Author: Jorge Zúñiga $, $Date: 30-mar-2016]</p>
 */
public class UnidadMedicaRespuesta implements Serializable {

    private static final long serialVersionUID = -4002897314076938975L;

    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private List<UnidadMedicaSalida> cuerpoLista;
    @Getter
    @Setter
    private String mensaje;

    public UnidadMedicaRespuesta() {
    }

}

