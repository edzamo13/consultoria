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
public class PrescripcionMedicaxHCEntrada implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;
    @Getter
    @Setter
    String unidadMedica;
    @Getter
    @Setter
    String dependencia;
    @Getter
    @Setter
    String historiaClinica;
    @Getter
    @Setter
    Integer estado;
    
    public PrescripcionMedicaxHCEntrada() {
    }
}
