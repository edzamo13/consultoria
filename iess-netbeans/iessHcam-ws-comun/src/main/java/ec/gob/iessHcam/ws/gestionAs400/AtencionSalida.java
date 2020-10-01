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
 * Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author ezamora
 * <p>
 * [$Author: ezamora $, $Date: 20/01/2016]</p>
 */
public class AtencionSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    private String unidadMedica;
    @Getter
    @Setter
    private String histClinica;
    @Getter
    @Setter
    private String fechaCita;
    @Getter
    @Setter
    private String horaPropuesta;
    @Getter
    @Setter
    private String codMedico;
    @Getter
    @Setter
    private String codDependencia;

    @Getter
    @Setter
    private String codDiagnosPresu1;
    
    @Getter
    @Setter
    private String codDiagnosPresu2;
    
    @Getter
    @Setter
    private String codDiagnosPresu3;
    
    @Getter
    @Setter
    private String codDiagnosDefin1;
    
    @Getter
    @Setter
    private String codDiagnosDefin2;
    
    @Getter
    @Setter
    private String codDiagnosDefin3;
    
    @Getter
    @Setter
    private List<DiagnosticoSalida> diagnosticos;

    public AtencionSalida(String unidadMedica, String histClinica, String fechaCita, String horaPropuesta, String codMedico, String codDependencia, String codDiagnosPresu1, String codDiagnosPresu2, String codDiagnosPresu3, String codDiagnosDefin1, String codDiagnosDefin2, String codDiagnosDefin3) {
        this.unidadMedica = unidadMedica;
        this.histClinica = histClinica;
        this.fechaCita = fechaCita;
        this.horaPropuesta = horaPropuesta;
        this.codMedico = codMedico;
        this.codDependencia = codDependencia;
        this.codDiagnosPresu1 = codDiagnosPresu1;
        this.codDiagnosPresu2 = codDiagnosPresu2;
        this.codDiagnosPresu3 = codDiagnosPresu3;
        this.codDiagnosDefin1 = codDiagnosDefin1;
        this.codDiagnosDefin2 = codDiagnosDefin2;
        this.codDiagnosDefin3 = codDiagnosDefin3;
    }
    
    public AtencionSalida() {
        
    }

}
