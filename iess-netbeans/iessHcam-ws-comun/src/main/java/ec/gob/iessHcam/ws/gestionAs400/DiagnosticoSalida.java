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
 *   Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author Desarrollo
 * <p>[$Author: Desarrollo $, $Date: 06-may-2016]</p>
 */
public class DiagnosticoSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;
    
    @Getter
    @Setter
    private String codMedico;
    @Getter
    @Setter
    private String codDependencia;
    @Getter
    @Setter
    private String codDiagnostico;
    @Getter
    @Setter
    private String tipoDiagnostico;
    @Getter
    @Setter
    private String orden;
    @Getter
    @Setter
    private String descripcion;

    public DiagnosticoSalida(String codDiagnostico, String descripcion) {
        this.codDiagnostico = codDiagnostico;
        this.descripcion = descripcion;
    }

    public DiagnosticoSalida() {
    }
}

