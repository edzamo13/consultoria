package ec.gob.iessHcam.ws.nutricion;

/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Clase que determina los parámetros de entrada del Web Service.
 * </b>
 *
 * @author ezamoram
 * <p>
 * [$Author: ezamoram $, $Date: 23/03/2016]</p>
 */
@XmlRootElement
public class DietaxPacienteSalida implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;
    @Getter
    @Setter
    private String idDieta;
    @Getter
    @Setter
    private String idDetDieta;
    @Getter
    @Setter
    private String idObsDieta;
    @Getter
    @Setter
    private String unidadMedica;
    @Getter
    @Setter
    private String dependencia;
    @Getter
    @Setter
    private String historiaClinica;
    @Getter
    @Setter
    private String cama;
    @Getter
    @Setter
    private String funcion;
    @Getter
    @Setter
    private String fechaObservacion;
    @Getter
    @Setter
    private String horaObservacion;
    @Getter
    @Setter
    private String toma;
    @Getter
    @Setter
    private String fechaDieta;
    @Getter
    @Setter
    private String codDieta;
    @Getter
    @Setter
    private String descripcion;
    @Getter
    @Setter
    private String observacionDieta;
    @Getter
    @Setter
    private String estadoDetDieta;
    @Getter
    @Setter
    private String estadoObsDieta;
    @Getter
    @Setter
    private String clave;

    public DietaxPacienteSalida() {
    }

    public DietaxPacienteSalida(String idDieta, String idDetDieta, String idObsDieta, String unidadMedica, String dependencia, String historiaClinica, String cama, String funcion, String fechaObservacion, String horaObservacion, String toma, String fechaDieta, String codDieta, String descripcion, String observacionDieta, String estadoDetDieta, String estadoObsDieta, String clave) {
        this.idDieta = idDieta;
        this.idDetDieta = idDetDieta;
        this.idObsDieta = idObsDieta;
        this.unidadMedica = unidadMedica;
        this.dependencia = dependencia;
        this.historiaClinica = historiaClinica;
        this.cama = cama;
        this.funcion = funcion;
        this.fechaObservacion = fechaObservacion;
        this.horaObservacion = horaObservacion;
        this.toma = toma;
        this.fechaDieta = fechaDieta;
        this.codDieta = codDieta;
        this.descripcion = descripcion;
        this.observacionDieta = observacionDieta;
        this.estadoDetDieta = estadoDetDieta;
        this.estadoObsDieta = estadoObsDieta;
        this.clave = clave;
    }
    
}
