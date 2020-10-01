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
public class ObsDietaEntrada implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;
    @Getter
    @Setter
    String historiaClinica;
    @Getter
    @Setter
    java.sql.Date fechaDieta;
    @Getter
    @Setter
    int toma;
    @Getter
    @Setter
    int estadoDieta;
    @Getter
    @Setter
    String observacion;
    @Getter
    @Setter
    String suspencion;
    @Getter
    @Setter
    java.sql.Date fechaSistema;
    @Getter
    @Setter
    java.sql.Time horaSistema;
    @Getter
    @Setter
    String usuario;
    @Getter
    @Setter
    int estadoActivo;
    
    public ObsDietaEntrada() {
    }
}
