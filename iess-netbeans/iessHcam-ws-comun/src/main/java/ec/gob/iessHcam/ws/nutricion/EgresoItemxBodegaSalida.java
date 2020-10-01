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

public class EgresoItemxBodegaSalida implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;
    @Getter
    @Setter
    private String codUnmeAS400;
    @Getter
    @Setter
    private String codBodegaAS400;
    @Getter
    @Setter
    private String tipoEgresoAS400;
    @Getter
    @Setter
    private String codEgresoAS400;
    @Getter
    @Setter
    private String numeroTransaccionAS400;
    @Getter
    @Setter
    private String itemTarroAS400;
    @Getter
    @Setter
    private String cantAS400;
    @Getter
    @Setter
    private String cantPedidaAS400;
    @Getter
    @Setter
    private String estadoTransaccionAS400;
    @Getter
    @Setter
    private String costoIndividualItemAS400;
    @Getter
    @Setter
    private String costoTotalItemAS400;
    @Getter
    @Setter
    private String descripcionAS400;
    @Getter
    @Setter
    private String presentacionAS400;
    
    public EgresoItemxBodegaSalida() {
    }

    public EgresoItemxBodegaSalida(String codUnmeAS400, String codBodegaAS400, String tipoEgresoAS400, String codEgresoAS400, String numeroTransaccionAS400, String itemTarroAS400, String cantAS400, String cantPedidaAS400, String estadoTransaccionAS400, String costoIndividualItemAS400, String costoTotalItemAS400, String descripcionAS400, String presentacionAS400) {
        this.codUnmeAS400 = codUnmeAS400;
        this.codBodegaAS400 = codBodegaAS400;
        this.tipoEgresoAS400 = tipoEgresoAS400;
        this.codEgresoAS400 = codEgresoAS400;
        this.numeroTransaccionAS400 = numeroTransaccionAS400;
        this.itemTarroAS400 = itemTarroAS400;
        this.cantAS400 = cantAS400;
        this.cantPedidaAS400 = cantPedidaAS400;
        this.estadoTransaccionAS400 = estadoTransaccionAS400;
        this.costoIndividualItemAS400 = costoIndividualItemAS400;
        this.costoTotalItemAS400 = costoTotalItemAS400;
        this.descripcionAS400 = descripcionAS400;
        this.presentacionAS400 = presentacionAS400;
    }

}
