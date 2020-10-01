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

public class SaldosxBodegaSalida implements Serializable {

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
    private String codItemAS400;
    @Getter
    @Setter
    private String descripcionItemAS400;
    @Getter
    @Setter
    private String saldos;
    
    public SaldosxBodegaSalida() {
    }

    public SaldosxBodegaSalida(String codUnmeAS400, String codDepAS400, String codBodegaAS400, String codItemAS400, String descripcionItemAS400, String saldos) {
        this.codUnmeAS400 = codUnmeAS400;
        this.codDepAS400 = codDepAS400;
        this.codBodegaAS400 = codBodegaAS400;
        this.codItemAS400 = codItemAS400;
        this.descripcionItemAS400 = descripcionItemAS400;
        this.saldos = saldos;
    }

}
