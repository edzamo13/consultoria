/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.hcam;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author ezamora
 * <p>
 * [$Author: ezamora $, $Date: 20/01/2016]</p>
 */
public class UnidadMedicaSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;
    
    @Getter
    @Setter
    private String grupo;
    @Getter
    @Setter
    private String unidadmedica;
    @Getter
    @Setter
    private String codunidadmedica;
    @Getter
    @Setter
    private String codprov;
    @Getter
    @Setter
    private String codcan;
    @Getter
    @Setter
    private String codparr;
    
    public UnidadMedicaSalida() {
        super();
    }

    public UnidadMedicaSalida(String grupo, String unidadmedica, String codunidadmedica, String codprov, String codcan, String codparr) {
        this.grupo = grupo;
        this.unidadmedica = unidadmedica;
        this.codunidadmedica = codunidadmedica;
        this.codprov = codprov;
        this.codcan = codcan;
        this.codparr = codparr;
    }

   
}
