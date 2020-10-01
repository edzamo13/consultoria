/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
 *   Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>[$Author: Jorge Zúñiga $, $Date: 14-mar-2016]</p>
 */
public class UltimaAtencion implements Serializable {

    private static final long serialVersionUID = -1422461130529850817L;

    @Getter
    @Setter
    private String codDiagPresunt1;
    @Getter
    @Setter
    private String codDiagPresunt2;
    @Getter
    @Setter
    private String codDiagPresunt3;
    @Getter
    @Setter
    private String codDiagDefinit1;
    @Getter
    @Setter
    private String codDiagDefinit2;
    @Getter
    @Setter
    private String codDiagDefinit3;
    

    public UltimaAtencion() {
    }

    public UltimaAtencion(String codDiagPresunt1, String codDiagPresunt2, String codDiagPresunt3, String codDiagDefinit1, String codDiagDefinit2, String codDiagDefinit3) {
        this.codDiagPresunt1 = codDiagPresunt1;
        this.codDiagPresunt2 = codDiagPresunt2;
        this.codDiagPresunt3 = codDiagPresunt3;
        this.codDiagDefinit1 = codDiagDefinit1;
        this.codDiagDefinit2 = codDiagDefinit2;
        this.codDiagDefinit3 = codDiagDefinit3;
    }
    
}

