/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iessHcam.ws.gestionAs400Externo.actDatos;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author HCAM
 */
public class ActDatosAfiliadoRespuesta implements Serializable {

    private static final long serialVersionUID = -1422461130529850817L;
    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private List<ActDatosAfiliadoSalida> cuerpoLista;
    @Getter
    @Setter
    private String mensaje;

    public ActDatosAfiliadoRespuesta() {
    }
}
