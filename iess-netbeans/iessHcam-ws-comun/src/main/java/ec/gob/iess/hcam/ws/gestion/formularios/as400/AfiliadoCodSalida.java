/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.gestion.formularios.as400;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>clase base para objeto tipo Afiliado con codigos DPA.</b>
 *
 * @author jsaltosb@iess.gob.ec
 * <p>
 * [Author: Gabriel Saltos, Date: 29/03/2017]
 * </p>
 */
public class AfiliadoCodSalida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String cedula;
    @Getter
    @Setter
    private String apellidoPaterno;
    @Getter
    @Setter
    private String apellidoMaterno;
    @Getter
    @Setter
    private String primerNombre;
    @Getter
    @Setter
    private String segundoNombre;
    @Getter
    @Setter
    private String nombreCompleto;
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
    private String codProvincia;
    @Getter
    @Setter
    private String canton;
    @Getter
    @Setter
    private String codCanton;
    @Getter
    @Setter
    private String parroquia;
    @Getter
    @Setter
    private String codParroquia;
    @Getter
    @Setter
    private String pais;
    @Getter
    @Setter
    private String codPais;
    @Getter
    @Setter
    private String nacionalidad;
    @Getter
    @Setter
    private String estado;
    @Getter
    @Setter
    private String direccion;
    @Getter
    @Setter
    private String telefono;

    /**
     * <b>método constructor de la clase.</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 18/04/2017]
     * </p>
     *
     * @param cedula identificacion
     * @param apellidoPaterno apellido paterno
     * @param apellidoMaterno apellido Materno
     * @param primerNombre primer Nombre
     * @param segundoNombre segundo Nombre
     * @param nombreCompleto nombre Completo
     * @param fechaNacimiento fecha de Nacimiento
     * @param sexo sexo
     * @param historiClinica historia Clinica
     * @param seguroSalud seguro de Salud
     * @param estadoCivil estado Civil
     * @param numAfiliacion numero de Afiliacion
     * @param instruccion instruccion
     * @param empresaTrabaja empresa donde Trabaja
     * @param codigoUnme codigo Unidad medica
     * @param unidadMedica nombre unidad Medica
     * @param provincia provincia
     * @param codProvincia codigo de Provincia
     * @param canton canton
     * @param codCanton codigo de Canton
     * @param parroquia parroquia
     * @param codParroquia codigo de Parroquia
     * @param pais pais
     * @param codPais codigo de Pais
     * @param nacionalidad nacionalidad
     * @param estado estado
     * @param direccion direccion
     * @param telefono telefono
     */
    public AfiliadoCodSalida(String cedula, String apellidoPaterno, String apellidoMaterno, String primerNombre, String segundoNombre, String nombreCompleto, String fechaNacimiento, String sexo, String historiClinica, String seguroSalud, String estadoCivil, String numAfiliacion, String instruccion, String empresaTrabaja, String codigoUnme, String unidadMedica, String provincia, String codProvincia, String canton, String codCanton, String parroquia, String codParroquia, String pais, String codPais, String nacionalidad, String estado, String direccion, String telefono) {
        this.cedula = cedula;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.nombreCompleto = nombreCompleto;
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
        this.codProvincia = codProvincia;
        this.canton = canton;
        this.codCanton = codCanton;
        this.parroquia = parroquia;
        this.codParroquia = codParroquia;
        this.pais = pais;
        this.codPais = codPais;
        this.nacionalidad = nacionalidad;
        this.estado = estado;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * <b>método constructor vacío.</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 18/04/2017]
     * </p>
     *
     */
    public AfiliadoCodSalida() {
    }

}
