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
public class DietaxTomaSalida implements Serializable {

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
    private String nombreDependencia;
    @Getter
    @Setter
    private String historiaClinica;
    @Getter
    @Setter
    private String paciente;
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
    private String estadoDieta;
    @Getter
    @Setter
    private String estadoDetDieta;
    @Getter
    @Setter
    private String estadoObsDieta;

    public DietaxTomaSalida() {
    }

    public DietaxTomaSalida(String idDieta, String idDetDieta, String idObsDieta, String unidadMedica, String dependencia, String nombreDependencia, String historiaClinica, String paciente, String cama, String funcion, String fechaObservacion, String horaObservacion, String toma, String fechaDieta, String codDieta, String descripcion, String observacionDieta, String estadoDieta, String estadoDetDieta, String estadoObsDieta) {
        this.idDieta = idDieta;
        this.idDetDieta = idDetDieta;
        this.idObsDieta = idObsDieta;
        this.unidadMedica = unidadMedica;
        this.dependencia = dependencia;
        this.nombreDependencia = nombreDependencia;
        this.historiaClinica = historiaClinica;
        this.paciente = paciente;
        this.cama = cama;
        this.funcion = funcion;
        this.fechaObservacion = fechaObservacion;
        this.horaObservacion = horaObservacion;
        this.toma = toma;
        this.fechaDieta = fechaDieta;
        this.codDieta = codDieta;
        this.descripcion = descripcion;
        this.observacionDieta = observacionDieta;
        this.estadoDieta = estadoDieta;
        this.estadoDetDieta = estadoDetDieta;
        this.estadoObsDieta = estadoObsDieta;
    }
   
}
