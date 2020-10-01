/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.hcam;

import java.io.Serializable;
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
public class CertReposoSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;
    
    @Getter
    @Setter
    private String fechaAlta;
    @Getter
    @Setter
    private String dependencia;
    @Getter
    @Setter
    private String medico;
    @Getter
    @Setter
    private String paciente;
    @Getter
    @Setter
    private String cedula;
    @Getter
    @Setter
    private String tipoAfiliado;
    @Getter
    @Setter
    private String historiaClinica;  
    @Getter
    @Setter
    private String unidadMedica;
    @Getter
    @Setter
    private String tipo;
    
    
    public CertReposoSalida() {
        super();
    }

    public CertReposoSalida(String fechaAlta, String dependencia, String medico, String paciente, String cedula, String tipoAfiliado, String historiaClinica) {
        this.fechaAlta = fechaAlta;
        this.dependencia = dependencia;
        this.medico = medico;
        this.paciente = paciente;
        this.cedula = cedula;
        this.tipoAfiliado = tipoAfiliado;
        this.historiaClinica = historiaClinica;
    }

    public CertReposoSalida(String fechaAlta, String dependencia, String medico, String paciente, String cedula, String tipoAfiliado, String historiaClinica, String unidadMedica, String tipo) {
        this.fechaAlta = fechaAlta;
        this.dependencia = dependencia;
        this.medico = medico;
        this.paciente = paciente;
        this.cedula = cedula;
        this.tipoAfiliado = tipoAfiliado;
        this.historiaClinica = historiaClinica;
        this.unidadMedica = unidadMedica;
        this.tipo = tipo;
    }

    

    
    
    
}
