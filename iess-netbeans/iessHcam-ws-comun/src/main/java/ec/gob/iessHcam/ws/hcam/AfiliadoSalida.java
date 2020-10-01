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
public class AfiliadoSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    private String cedula;
    @Getter
    @Setter
    private String nombres;
    @Getter
    @Setter
    private String fechaNacimiento;
    @Getter
    @Setter
    private String sexo;
    @Getter
    @Setter
    private String historiClinica;
    @Getter
    @Setter
    private String seguroSalud;
    @Getter
    @Setter
    private String estadoCivil;
    @Getter
    @Setter
    private String instruccion;
    @Getter
    @Setter
    private String empresaTrabaja;
    @Getter
    @Setter
    private String unidadMedica;
    @Getter
    @Setter
    private String provincia;
    @Getter
    @Setter
    private String canton;
    @Getter
    @Setter
    private String parroquia;

    public AfiliadoSalida() {
        super();
    }
    
    
    public AfiliadoSalida(String cedula, String nombres, String fechaNacimiento, String sexo, String historiClinica, String seguroSalud, String estadoCivil, String instruccion, String empresaTrabaja, String unidadMedica, String provincia, String canton, String parroquia) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.historiClinica = historiClinica;
        this.seguroSalud = seguroSalud;
        this.estadoCivil = estadoCivil;
        this.instruccion = instruccion;
        this.empresaTrabaja = empresaTrabaja;
        this.unidadMedica = unidadMedica;
        this.provincia = provincia;
        this.canton = canton;
        this.parroquia = parroquia;
    }

    @Override
    public String toString() {
        return "AfiliadoxCiSalida{" + "cedula=" + cedula + ", nombres=" + nombres + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", historiClinica=" + historiClinica + ", seguroSalud=" + seguroSalud + ", estadoCivil=" + estadoCivil + ", instruccion=" + instruccion + ", empresaTrabaja=" + empresaTrabaja + ", unidadMedica=" + unidadMedica + ", provincia=" + provincia + ", canton=" + canton + ", parroquia=" + parroquia + '}';
    }

   

}
