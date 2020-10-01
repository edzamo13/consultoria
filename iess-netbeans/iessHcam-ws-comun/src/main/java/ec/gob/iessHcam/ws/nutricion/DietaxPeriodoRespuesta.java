package ec.gob.iessHcam.ws.nutricion;

/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */

import java.io.Serializable;
import java.util.List;
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
public class DietaxPeriodoRespuesta implements Serializable {

    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private List<DietaxPeriodoSalida> cuerpoLista;
    @Getter
    @Setter
    private String mensaje;

    public DietaxPeriodoRespuesta() {
    }
    
    
    
}
