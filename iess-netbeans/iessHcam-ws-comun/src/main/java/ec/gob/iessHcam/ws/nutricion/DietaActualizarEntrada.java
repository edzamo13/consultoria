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
public class DietaActualizarEntrada implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;
    @Getter
    @Setter
    String historiaClinica; 
    @Getter
    @Setter
    java.sql.Date fechaActualizacion;
    @Getter
    @Setter
    Integer toma;
    @Getter
    @Setter
    String dependenciaFisica;
    @Getter
    @Setter
    String nombreDependenciaFisica;
    @Getter
    @Setter
    String suspencion;
    @Getter
    @Setter
    String usuario;
    @Getter
    @Setter
    int estadoDieta; 
    @Getter
    @Setter
    int estadoEntregaDieta; 
    @Getter
    @Setter
    int estadoHabilitado; 
    @Getter
    @Setter
    int estadoDeshabilitado; 
    
    @Getter
    @Setter
    int idDieta; 
    @Getter
    @Setter
    int idDetDieta; 
    
    public DietaActualizarEntrada() {
    }
}
