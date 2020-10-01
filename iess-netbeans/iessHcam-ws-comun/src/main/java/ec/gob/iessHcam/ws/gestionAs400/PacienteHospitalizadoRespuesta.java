package ec.gob.iessHcam.ws.gestionAs400;

/* 
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados 
 */


import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * <b>
 * Clase que representa la respuesta del servicio, contiene codigo, cuerpo y mensaje
 * </b>
 *
 * <p>
 * [$Author: laguirrec , $Date: 23/06/2016]</p>
 *
 * @param
 *
 * @return
 */
 
public class PacienteHospitalizadoRespuesta implements Serializable{
    private static final long serialVersionUID = 2899065495598956028L;
    
    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private List<PacienteHospitalizadoSalida> cuerpo;
    @Getter
    @Setter
    private String mensaje;

    public PacienteHospitalizadoRespuesta() {
    }
    
    
}
