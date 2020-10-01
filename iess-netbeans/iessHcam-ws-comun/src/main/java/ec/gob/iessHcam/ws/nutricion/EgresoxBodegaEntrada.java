package ec.gob.iessHcam.ws.nutricion;

/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 *   Este pojo define la entrada del método getSaldosxBodega del ws.
 * </b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>[$Author: fsalazarn@iess.gob.ec $, $Date: 30/09/2016]</p>
 */

public class EgresoxBodegaEntrada implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;
    @Getter
    @Setter
    private String codUnmeAS400;
    @Getter
    @Setter
    private String codDepAS400;
    @Getter
    @Setter
    private String tipoEgreso;
    @Getter
    @Setter
    private String estadoApl;
    @Getter
    @Setter
    private String bodegaAsignada;
    @Getter
    @Setter
    private String ultimaFechaApl;
    
    public EgresoxBodegaEntrada() {
    }

    public EgresoxBodegaEntrada(String codUnmeAS400, String codDepAS400, String tipoEgreso, String estadoApl, String bodegaAsignada, String ultimaFechaApl) {
        this.codUnmeAS400 = codUnmeAS400;
        this.codDepAS400 = codDepAS400;
        this.tipoEgreso = tipoEgreso;
        this.estadoApl = estadoApl;
        this.bodegaAsignada = bodegaAsignada;
        this.ultimaFechaApl = ultimaFechaApl;
    }
    
}
