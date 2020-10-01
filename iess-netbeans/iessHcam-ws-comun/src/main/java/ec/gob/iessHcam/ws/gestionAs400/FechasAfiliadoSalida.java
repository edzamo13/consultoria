/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.gestionAs400;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *  * <b>
 *  *   Incluir aqui la descripción de la clase.  * </b>
 *  *
 *  * @author user
 
 * <p>
 * [$Author: fquisiguina $, $Date: date]</p>
 
 */
public class FechasAfiliadoSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    private String fechaUltimaAtencion;
    @Getter
    @Setter
    private String fechaFallecimiento;    
    @Getter
    @Setter
    private String fechaAlta;
    @Getter
    @Setter
    private String fechaPrimeraAtencion;
    @Getter
    @Setter
    private String fechaCreacionExpediente;
    
    
    

    public FechasAfiliadoSalida(String fechaUltimaAtencion, String fechaFallecimiento, String fechaAlta, String fechaPrimeraAtencion,
            String fechaCreacionExpediente ) {
        this.fechaUltimaAtencion = fechaUltimaAtencion;
        this.fechaFallecimiento = fechaFallecimiento;
        this.fechaAlta = fechaAlta;
        this.fechaPrimeraAtencion=fechaPrimeraAtencion;
        this.fechaCreacionExpediente=fechaCreacionExpediente;
    }
    
    
   
    public FechasAfiliadoSalida() {
    }

   

}
