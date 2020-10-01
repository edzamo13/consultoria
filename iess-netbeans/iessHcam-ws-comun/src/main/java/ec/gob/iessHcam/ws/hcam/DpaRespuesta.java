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
public class DpaRespuesta implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    private String estado;
    @Getter
    @Setter
    private int grupo;
    @Getter
    @Setter
    private String familia;
    @Getter
    @Setter
    private String codProv;
    @Getter
    @Setter
    private String codCan;
    @Getter
    @Setter
    private String codParr;
    @Getter
    @Setter
    private String desDpa;
    
    

    public DpaRespuesta() {
        super();
    }

    public DpaRespuesta(String estado, int grupo, String familia, String codProv, String codCan, String codParr, String desDpa) {
        this.estado = estado;
        this.grupo = grupo;
        this.familia = familia;
        this.codProv = codProv;
        this.codCan = codCan;
        this.codParr = codParr;
        this.desDpa = desDpa;
    }

    

    
    
}
