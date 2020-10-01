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

public class EgresoItemxBodegaEntrada implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;
    @Getter
    @Setter
    private String codUnme;
    @Getter
    @Setter
    private Integer codBodega;
    @Getter
    @Setter
    private String tipoEgreso;
    @Getter
    @Setter
    private Integer codigoEgreso;
    @Getter
    @Setter
    private Integer numeroTransaccion;
    @Getter
    @Setter
    private String estadoTransaccion;
    @Getter
    @Setter
    private String estadoItem;
    
    
    public EgresoItemxBodegaEntrada() {
    }

    public EgresoItemxBodegaEntrada(String codUnme, Integer codBodega, String tipoEgreso, Integer codigoEgreso, Integer numeroTransaccion, String estadoTransaccion, String estadoItem) {
        this.codUnme = codUnme;
        this.codBodega = codBodega;
        this.tipoEgreso = tipoEgreso;
        this.codigoEgreso = codigoEgreso;
        this.numeroTransaccion = numeroTransaccion;
        this.estadoTransaccion = estadoTransaccion;
        this.estadoItem = estadoItem;
    }

}
