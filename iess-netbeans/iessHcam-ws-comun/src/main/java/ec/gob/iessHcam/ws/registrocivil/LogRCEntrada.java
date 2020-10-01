package ec.gob.iessHcam.ws.registrocivil;

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
public class LogRCEntrada implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;
    @Getter
    @Setter
    private String cedula;
    @Getter
    @Setter
    private String tramaDNTI;
    @Getter
    @Setter
    private String codigoRespuesta;
    @Getter
    @Setter
    private String tramaAS400;
    @Getter
    @Setter
    private String operacion;
    @Getter
    @Setter
    private String descripcion;
    @Getter
    @Setter
    private String usuarioCrea;
    @Getter
    @Setter
    private String programaCrea;
    @Getter
    @Setter
    private String fechaCrea;
    @Getter
    @Setter
    private String horaCrea;
    @Getter
    @Setter
    private String pantallaCrea;
    @Getter
    @Setter
    private String ipUsuarioCrea;

    public LogRCEntrada() {
    }
}
