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
 *   Este pojo define la respuesta del método getTransaccionesxBodega del ws.
 * </b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>[$Author: fsalazarn@iess.gob.ec $, $Date: 30/09/2016]</p>
 */

public class ResponsablexKardexSalida implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;
    @Getter
    @Setter
    private String codUnmeAS400;
    @Getter
    @Setter
    private String codDepAS400;
    @Getter
    @Setter
    private String codBodegaAS400;
    @Getter
    @Setter
    private String estadoBodegaAS400;
    @Getter
    @Setter
    private String responsableKardex;
    @Getter
    @Setter
    private String nombreRespKardex;
    @Getter
    @Setter
    private String bodegaAsignadaKardex;
    @Getter
    @Setter
    private String ultimaFechaApl;
    
    public ResponsablexKardexSalida() {
    }

    public ResponsablexKardexSalida(String codUnmeAS400, String codDepAS400, String codBodegaAS400, String estadoBodegaAS400, String responsableKardex, String nombreRespKardex, String bodegaAsignadaKardex, String ultimaFechaApl) {
        this.codUnmeAS400 = codUnmeAS400;
        this.codDepAS400 = codDepAS400;
        this.codBodegaAS400 = codBodegaAS400;
        this.estadoBodegaAS400 = estadoBodegaAS400;
        this.responsableKardex = responsableKardex;
        this.nombreRespKardex = nombreRespKardex;
        this.bodegaAsignadaKardex = bodegaAsignadaKardex;
        this.ultimaFechaApl = ultimaFechaApl;
    }

}
