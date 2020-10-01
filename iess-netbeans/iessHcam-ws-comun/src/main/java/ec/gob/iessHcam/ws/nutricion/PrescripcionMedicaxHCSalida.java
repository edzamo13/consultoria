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
public class PrescripcionMedicaxHCSalida implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;
    @Getter
    @Setter
    private String idPrescripcionMedica;
    @Getter
    @Setter
    private String unidadMedica;
    @Getter
    @Setter
    private String dependencia;
    @Getter
    @Setter
    private String habitacion;
    @Getter
    @Setter
    private String historiaClinica;
    @Getter
    @Setter
    private String paciente;
    @Getter
    @Setter
    private String dieta;
    @Getter
    @Setter
    private String descripcionEstado;
    
    public PrescripcionMedicaxHCSalida() {
    }

    public PrescripcionMedicaxHCSalida(String idPrescripcionMedica, String unidadMedica, String dependencia, String habitacion, String historiaClinica, String paciente, String dieta, String descripcionEstado) {
        this.idPrescripcionMedica = idPrescripcionMedica;
        this.unidadMedica = unidadMedica;
        this.dependencia = dependencia;
        this.habitacion = habitacion;
        this.historiaClinica = historiaClinica;
        this.paciente = paciente;
        this.dieta = dieta;
        this.descripcionEstado = descripcionEstado;
    }

    

}
