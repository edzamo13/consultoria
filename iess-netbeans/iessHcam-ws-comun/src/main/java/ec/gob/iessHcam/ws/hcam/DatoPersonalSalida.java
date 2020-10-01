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
public class DatoPersonalSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;
    
    @Getter
    @Setter
    private String historiaClinica;
    @Getter
    @Setter
    private String cedula;
    @Getter
    @Setter
    private String fechaNacimiento;
    @Getter
    @Setter
    private String sexo;
    @Getter
    @Setter
    private String direccion;
    @Getter
    @Setter
    private String telefono;

    public DatoPersonalSalida() {
        super();
    }

    public DatoPersonalSalida(String historiaClinica, String cedula, String fechaNacimiento, String sexo, String direccion, String telefono) {
        this.historiaClinica = historiaClinica;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
}
