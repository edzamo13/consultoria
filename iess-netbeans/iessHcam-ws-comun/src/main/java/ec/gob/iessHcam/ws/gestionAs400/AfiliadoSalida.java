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
    private String nombre;
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
    private String numAfiliacion;
    @Getter
    @Setter
    private String instruccion;
    @Getter
    @Setter
    private String empresaTrabaja;
    @Getter
    @Setter
    private String codigoUnme;
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
    @Getter
    @Setter
    private String nacionalidad;
    
    @Getter
    @Setter
    private String estado;

    public AfiliadoSalida(String cedula, String nombre, String fechaNacimiento, String sexo, String historiClinica, String seguroSalud, String estadoCivil, String numAfiliacion, String instruccion, String empresaTrabaja, String codigoUnme, String unidadMedica, String provincia, String canton, String parroquia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.historiClinica = historiClinica;
        this.seguroSalud = seguroSalud;
        this.estadoCivil = estadoCivil;
        this.numAfiliacion = numAfiliacion;
        this.instruccion = instruccion;
        this.empresaTrabaja = empresaTrabaja;
        this.codigoUnme = codigoUnme;
        this.unidadMedica = unidadMedica;
        this.provincia = provincia;
        this.canton = canton;
        this.parroquia = parroquia;
    }
    
    public AfiliadoSalida(String cedula, String nombre, String fechaNacimiento, String sexo, String historiClinica, String seguroSalud, String estadoCivil, String numAfiliacion, String instruccion, String empresaTrabaja, String codigoUnme, String unidadMedica, String provincia, String canton, String parroquia, String nacionalidad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.historiClinica = historiClinica;
        this.seguroSalud = seguroSalud;
        this.estadoCivil = estadoCivil;
        this.numAfiliacion = numAfiliacion;
        this.instruccion = instruccion;
        this.empresaTrabaja = empresaTrabaja;
        this.codigoUnme = codigoUnme;
        this.unidadMedica = unidadMedica;
        this.provincia = provincia;
        this.canton = canton;
        this.parroquia = parroquia;
        this.nacionalidad = nacionalidad;
    }

    public AfiliadoSalida(String cedula, String nombre, String fechaNacimiento, String sexo, String historiClinica, String seguroSalud, String estadoCivil, String numAfiliacion, String instruccion, String empresaTrabaja, String codigoUnme, String unidadMedica, String provincia, String canton, String parroquia, String nacionalidad, String estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.historiClinica = historiClinica;
        this.seguroSalud = seguroSalud;
        this.estadoCivil = estadoCivil;
        this.numAfiliacion = numAfiliacion;
        this.instruccion = instruccion;
        this.empresaTrabaja = empresaTrabaja;
        this.codigoUnme = codigoUnme;
        this.unidadMedica = unidadMedica;
        this.provincia = provincia;
        this.canton = canton;
        this.parroquia = parroquia;
        this.nacionalidad = nacionalidad;
        this.estado = estado;
    }

    public AfiliadoSalida() {
    }

   

}
