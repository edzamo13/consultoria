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
public class PacienteSalida implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;
    @Getter
    @Setter
    private String HABITACION;
    @Getter
    @Setter
    private String HISTORIA;
    @Getter
    @Setter
    private String NOMBRE;
    @Getter
    @Setter
    private String DEPORIGEN;
    @Getter
    @Setter
    private String NOMBREDEPORIGEN;
    @Getter
    @Setter
    private String DEPACTUAL;
    @Getter
    @Setter
    private String NOMBREDEPACT;
    @Getter
    @Setter
    private String ESTADO;
    @Getter
    @Setter
    private String DESCESTADO;
    @Getter
    @Setter
    private String CEDULA;
    @Getter
    @Setter
    private String FECHACONSULTA;
    @Getter
    @Setter
    private String UNIDADMEDICA;
    @Getter
    @Setter
    private String FECHAINGRESO;
    @Getter
    @Setter
    private String TIPODOCUMENTO;
    

    public PacienteSalida() {
    }

    public PacienteSalida(String HABITACION, String HISTORIA, String NOMBRE, String DEPORIGEN, String NOMBREDEPORIGEN, String DEPACTUAL, String NOMBREDEPACT, String ESTADO, String DESCESTADO) {
        this.HABITACION = HABITACION;
        this.HISTORIA = HISTORIA;
        this.NOMBRE = NOMBRE;
        this.DEPORIGEN = DEPORIGEN;
        this.NOMBREDEPORIGEN = NOMBREDEPORIGEN;
        this.DEPACTUAL = DEPACTUAL;
        this.NOMBREDEPACT = NOMBREDEPACT;
        this.ESTADO = ESTADO;
        this.DESCESTADO = DESCESTADO;
    }

    public PacienteSalida(String HISTORIA, String CEDULA, String NOMBRE, String DEPACTUAL, String NOMBREDEPACT, String FECHACONSULTA) {
        this.HISTORIA = HISTORIA;
        this.CEDULA = CEDULA;
        this.NOMBRE = NOMBRE;
        this.DEPACTUAL = DEPACTUAL;
        this.NOMBREDEPACT = NOMBREDEPACT;
        this.FECHACONSULTA = FECHACONSULTA;
    }

    public PacienteSalida(String UNIDADMEDICA, String FECHAINGRESO, String HISTORIA, String TIPODOCUMENTO, String CEDULA, String NOMBRE, String DEPORIGEN, String NOMBREDEPORIGEN, String DEPACTUAL, String NOMBREDEPACT, String HABITACION, String ESTADO, String DESCESTADO) {
        this.UNIDADMEDICA = UNIDADMEDICA;
        this.FECHAINGRESO = FECHAINGRESO;
        this.HISTORIA = HISTORIA;
        this.TIPODOCUMENTO = TIPODOCUMENTO;
        this.CEDULA = CEDULA;
        this.NOMBRE = NOMBRE;
        this.DEPORIGEN = DEPORIGEN;
        this.NOMBREDEPORIGEN = NOMBREDEPORIGEN;
        this.DEPACTUAL = DEPACTUAL;
        this.NOMBREDEPACT = NOMBREDEPACT;
        this.HABITACION = HABITACION;
        this.ESTADO = ESTADO;
        this.DESCESTADO = DESCESTADO;
    }
    
}
