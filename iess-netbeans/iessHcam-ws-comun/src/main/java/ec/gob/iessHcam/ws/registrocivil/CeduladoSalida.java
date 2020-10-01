package ec.gob.iessHcam.ws.registrocivil;

/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Clase que determina los parámetros de salida del Web Service.
 * </b>
 *
 * @author ezamoram
 * <p>
 * [$Author: ezamoram $, $Date: 23/03/2016]</p>
 */
public class CeduladoSalida implements Serializable {

    private static final long serialVersionUID = -1912979416331865052L;

    @Getter
    @Setter
    private String cedulaConyugue;
    @Getter
    @Setter
    private String cedulaMadre;
    @Getter
    @Setter
    private String cedulaMagna;
    @Getter
    @Setter
    private String cedulaPadre;
    @Getter
    @Setter
    private String codigoCondicionCedulado;
    @Getter
    @Setter
    private String codigoDomicilio;
    @Getter
    @Setter
    private String codigoEstadoCivil;
    @Getter
    @Setter
    private String codigoInstruccion;
    @Getter
    @Setter
    private String codigoLugarFallecimiento;
    @Getter
    @Setter
    private String codigoLugarInscripcionDefuncion;
    @Getter
    @Setter
    private String codigoLugarMatrimonio;
    @Getter
    @Setter
    private String codigoLugarNacimiento;
    @Getter
    @Setter
    private String codigoNacionalidad;
    @Getter
    @Setter
    private String codigoNacionalidadMadre;
    @Getter
    @Setter
    private String codigoNacionalidadPadre;
    @Getter
    @Setter
    private String codigoProfesion;
    @Getter
    @Setter
    private String codigoRespuesta;
    @Getter
    @Setter
    private String codigoSexo;
    @Getter
    @Setter
    private String fechaActualizacionCedula;
    @Getter
    @Setter
    private String fechaFallecimiento;
    @Getter
    @Setter
    private String fechaInscripcionDefuncion;
    @Getter
    @Setter
    private String fechaMatrimonio;
    @Getter
    @Setter
    private String fechaNacimiento;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String nombreCalle;
    @Getter
    @Setter
    private String nombreConyuge;
    @Getter
    @Setter
    private String nombreMadre;
    @Getter
    @Setter
    private String nombrePadre;
    @Getter
    @Setter
    private String numeroCasa;
    @Getter
    @Setter
    private String observacion;
    @Getter
    @Setter
    private String cedula;

    /**
     *
     * <b>
     * Constructor de la clase.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 01/07/2016]</p>
     */
    public CeduladoSalida() {
    }

    public CeduladoSalida(String cedulaConyugue, String cedulaMadre, String cedulaMagna, String cedulaPadre, String codigoCondicionCedulado, String codigoDomicilio, String codigoEstadoCivil, String codigoInstruccion, String codigoLugarFallecimiento, String codigoLugarInscripcionDefuncion, String codigoLugarMatrimonio, String codigoLugarNacimiento, String codigoNacionalidad, String codigoNacionalidadMadre, String codigoNacionalidadPadre, String codigoProfesion, String codigoRespuesta, String codigoSexo, String fechaActualizacionCedula, String fechaFallecimiento, String fechaInscripcionDefuncion, String fechaMatrimonio, String fechaNacimiento, String nombre, String nombreCalle, String nombreConyuge, String nombreMadre, String nombrePadre, String numeroCasa, String observacion, String cedula) {
        this.cedulaConyugue = cedulaConyugue;
        this.cedulaMadre = cedulaMadre;
        this.cedulaMagna = cedulaMagna;
        this.cedulaPadre = cedulaPadre;
        this.codigoCondicionCedulado = codigoCondicionCedulado;
        this.codigoDomicilio = codigoDomicilio;
        this.codigoEstadoCivil = codigoEstadoCivil;
        this.codigoInstruccion = codigoInstruccion;
        this.codigoLugarFallecimiento = codigoLugarFallecimiento;
        this.codigoLugarInscripcionDefuncion = codigoLugarInscripcionDefuncion;
        this.codigoLugarMatrimonio = codigoLugarMatrimonio;
        this.codigoLugarNacimiento = codigoLugarNacimiento;
        this.codigoNacionalidad = codigoNacionalidad;
        this.codigoNacionalidadMadre = codigoNacionalidadMadre;
        this.codigoNacionalidadPadre = codigoNacionalidadPadre;
        this.codigoProfesion = codigoProfesion;
        this.codigoRespuesta = codigoRespuesta;
        this.codigoSexo = codigoSexo;
        this.fechaActualizacionCedula = fechaActualizacionCedula;
        this.fechaFallecimiento = fechaFallecimiento;
        this.fechaInscripcionDefuncion = fechaInscripcionDefuncion;
        this.fechaMatrimonio = fechaMatrimonio;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.nombreCalle = nombreCalle;
        this.nombreConyuge = nombreConyuge;
        this.nombreMadre = nombreMadre;
        this.nombrePadre = nombrePadre;
        this.numeroCasa = numeroCasa;
        this.observacion = observacion;
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "CeduladoSalida{" + "cedulaConyugue=" + cedulaConyugue + ", cedulaMadre=" + cedulaMadre + ", cedulaMagna=" + cedulaMagna + ", cedulaPadre=" + cedulaPadre + ", codigoCondicionCedulado=" + codigoCondicionCedulado + ", codigoDomicilio=" + codigoDomicilio + ", codigoEstadoCivil=" + codigoEstadoCivil + ", codigoInstruccion=" + codigoInstruccion + ", codigoLugarFallecimiento=" + codigoLugarFallecimiento + ", codigoLugarInscripcionDefuncion=" + codigoLugarInscripcionDefuncion + ", codigoLugarMatrimonio=" + codigoLugarMatrimonio + ", codigoLugarNacimiento=" + codigoLugarNacimiento + ", codigoNacionalidad=" + codigoNacionalidad + ", codigoNacionalidadMadre=" + codigoNacionalidadMadre + ", codigoNacionalidadPadre=" + codigoNacionalidadPadre + ", codigoProfesion=" + codigoProfesion + ", codigoRespuesta=" + codigoRespuesta + ", codigoSexo=" + codigoSexo + ", fechaActualizacionCedula=" + fechaActualizacionCedula + ", fechaFallecimiento=" + fechaFallecimiento + ", fechaInscripcionDefuncion=" + fechaInscripcionDefuncion + ", fechaMatrimonio=" + fechaMatrimonio + ", fechaNacimiento=" + fechaNacimiento + ", nombre=" + nombre + ", nombreCalle=" + nombreCalle + ", nombreConyuge=" + nombreConyuge + ", nombreMadre=" + nombreMadre + ", nombrePadre=" + nombrePadre + ", numeroCasa=" + numeroCasa + ", observacion=" + observacion + ", cedula=" + cedula + '}';
    }
    
    
    
}
