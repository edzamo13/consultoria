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

public class EgresoxBodegaSalida implements Serializable {

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
    private String fechaTransaccionAS400;
    @Getter
    @Setter
    private String horaTransaccionAS400;
    @Getter
    @Setter
    private String estadoTransaccionAS400;
    @Getter
    @Setter
    private String responsableTransaccionAS400;
    @Getter
    @Setter
    private String justificacionTransaccionAS400;
    @Getter
    @Setter
    private String docReferenciaAS400;
    @Getter
    @Setter
    private String numeroReferenciaAS400;
    @Getter
    @Setter
    private String depAplAS400;
    @Getter
    @Setter
    private String responsableAplAS400;
    @Getter
    @Setter
    private String fechaAplAS400;
    @Getter
    @Setter
    private String horaAplAS400;
    @Getter
    @Setter
    private String usuarioResponsable;
    @Getter
    @Setter
    private String claveEgreso;
    
    public EgresoxBodegaSalida() {
    }

    public EgresoxBodegaSalida(String codUnmeAS400, String codBodegaAS400, String tipoEgresoAS400, String codEgresoAS400, String numeroTransaccionAS400, String fechaTransaccionAS400, String horaTransaccionAS400, String estadoTransaccionAS400, String responsableTransaccionAS400, String justificacionTransaccionAS400, String docReferenciaAS400, String numeroReferenciaAS400, String depAplAS400, String responsableAplAS400, String fechaAplAS400, String horaAplAS400, String usuarioResponsable, String clave) {
        this.codUnmeAS400 = codUnmeAS400;
        this.codBodegaAS400 = codBodegaAS400;
        this.tipoEgresoAS400 = tipoEgresoAS400;
        this.codEgresoAS400 = codEgresoAS400;
        this.numeroTransaccionAS400 = numeroTransaccionAS400;
        this.fechaTransaccionAS400 = fechaTransaccionAS400;
        this.horaTransaccionAS400 = horaTransaccionAS400;
        this.estadoTransaccionAS400 = estadoTransaccionAS400;
        this.responsableTransaccionAS400 = responsableTransaccionAS400;
        this.justificacionTransaccionAS400 = justificacionTransaccionAS400;
        this.docReferenciaAS400 = docReferenciaAS400;
        this.numeroReferenciaAS400 = numeroReferenciaAS400;
        this.depAplAS400 = depAplAS400;
        this.responsableAplAS400 = responsableAplAS400;
        this.fechaAplAS400 = fechaAplAS400;
        this.horaAplAS400 = horaAplAS400;
        this.usuarioResponsable = usuarioResponsable;
        this.claveEgreso = clave;
    }

    

}
