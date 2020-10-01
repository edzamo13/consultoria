/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/
package ec.gob.iessHcam.ws.laboratorios;

import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 *   Incluir aqui la descripción de la clase.
 * </b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>[$Author: fsalazarn@iess.gob.ec $, $Date: 11/04/2016]</p>
 */
public class LabAccesoSalida {

    @Getter
    @Setter
    private int ac_id_acceso;
    
    @Getter
    @Setter
    private String ac_ip;
    
    @Getter
    @Setter
    private String ac_mascara;
    
    @Getter
    @Setter
    private String ac_codigo_unme;
    
    @Getter
    @Setter
    private String ac_observacion;

    public LabAccesoSalida(int ac_id_acceso, String ac_ip, String ac_mascara, String ac_codigo_unme, String ac_observacion) {
        
        this.ac_id_acceso = ac_id_acceso;
        this.ac_ip = ac_ip;
        this.ac_mascara = ac_mascara;
        this.ac_codigo_unme = ac_codigo_unme;
        this.ac_observacion = ac_observacion;
        
    }
    
    public LabAccesoSalida(String ac_ip, String ac_mascara, String ac_codigo_unme, String ac_observacion) {

        this.ac_ip = ac_ip;
        this.ac_mascara = ac_mascara;
        this.ac_codigo_unme = ac_codigo_unme;
        this.ac_observacion = ac_observacion;
        
    }
    
    public LabAccesoSalida() {

    }
}
