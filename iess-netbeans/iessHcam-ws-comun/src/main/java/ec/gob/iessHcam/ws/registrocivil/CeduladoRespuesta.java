package ec.gob.iessHcam.ws.registrocivil;

/* 
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados 
 */


import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/** 
 * <b>
 * Clase que representa la respuesta del servicio, contiene codigo y cuerpo
 * </b>
 *  
 * @author ezamoram
 * @version $Revision: 1.0 $ <p>[$Author: ezamoram $, $Date: 23/03/2016 $]</p>
*/ 
public class CeduladoRespuesta implements Serializable{
    private static final long serialVersionUID = 2899065495598956028L;
    
    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private CeduladoSalida cuerpo;
    @Getter
    @Setter
    private String mensaje;

    public CeduladoRespuesta() {
    }
    
    
}
