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
 *   Este pojo define la entrada del método registrarDetalle del ws.
 * </b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>[$Author: fsalazarn@iess.gob.ec $, $Date: 11/10/2016]</p>
 */

public class CabeceraKardexSalida implements Serializable {

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
    private String tipoTransaccion;
    @Getter
    @Setter
    private String codTransaccional;
    @Getter
    @Setter
    private String idTransaccion;
    @Getter
    @Setter
    private String fechaTransaccion;
    @Getter
    @Setter
    private String horaTransaccion;
    @Getter
    @Setter
    private String estadoTransaccion;
    @Getter
    @Setter
    private String responsableTransaccion;
    @Getter
    @Setter
    private String justificacionTransaccion;
    @Getter
    @Setter
    private String documentoReferencia;
    @Getter
    @Setter
    private String numeroReferencia;
    @Getter
    @Setter
    private String responsableAplicaTransaccion;
    @Getter
    @Setter
    private String fechaAS400AplicaTransaccion;
    @Getter
    @Setter
    private String horaAS400AplicaTransaccion;
    @Getter
    @Setter
    private String programaAplicaTransaccion;
    @Getter
    @Setter
    private String numeroOrdenAS400;
    @Getter
    @Setter
    private String fechaAS400Orden;
    @Getter
    @Setter
    private String codDependenciaAplicaAS400;
    @Getter
    @Setter
    private String historiaClinicaAS400;
    @Getter
    @Setter
    private String estadoFacturacion;
    @Getter
    @Setter
    private String extraA1;
    @Getter
    @Setter
    private String extraA2;
    @Getter
    @Setter
    private String extraN1;
    @Getter
    @Setter
    private String extraN2;
    @Getter
    @Setter
    private String extraStatus;
    @Getter
    @Setter
    private String usuarioCreaTransaccion;
    @Getter
    @Setter
    private String pantallaCreaTransaccion;
    @Getter
    @Setter
    private String programaCreaTransaccion;
    @Getter
    @Setter
    private String usuarioActualizaTransaccion;
    @Getter
    @Setter
    private String fechaActualizaTransaccion;
    @Getter
    @Setter
    private String horaActualizaTransaccion;
    @Getter
    @Setter
    private String pantallaActualizaTransaccion;
    @Getter
    @Setter
    private String programaActualizaTransaccion;
    
    public CabeceraKardexSalida() {
        
    }

    public CabeceraKardexSalida(String codUnmeAS400, String codDepAS400, String codBodegaAS400, String tipoTransaccion, String codTransaccional, String idTransaccion, String fechaTransaccion, String horaTransaccion, String estadoTransaccion, String responsableTransaccion, String justificacionTransaccion, String documentoReferencia, String numeroReferencia, String responsableAplicaTransaccion, String fechaAS400AplicaTransaccion, String horaAS400AplicaTransaccion, String programaAplicaTransaccion, String numeroOrdenAS400, String fechaAS400Orden, String codDependenciaAplicaAS400, String historiaClinicaAS400, String estadoFacturacion, String extraA1, String extraA2, String extraN1, String extraN2, String extraStatus, String usuarioCreaTransaccion, String pantallaCreaTransaccion, String programaCreaTransaccion, String usuarioActualizaTransaccion, String fechaActualizaTransaccion, String horaActualizaTransaccion, String pantallaActualizaTransaccion, String programaActualizaTransaccion) {
        this.codUnmeAS400 = codUnmeAS400;
        this.codDepAS400 = codDepAS400;
        this.codBodegaAS400 = codBodegaAS400;
        this.tipoTransaccion = tipoTransaccion;
        this.codTransaccional = codTransaccional;
        this.idTransaccion = idTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.horaTransaccion = horaTransaccion;
        this.estadoTransaccion = estadoTransaccion;
        this.responsableTransaccion = responsableTransaccion;
        this.justificacionTransaccion = justificacionTransaccion;
        this.documentoReferencia = documentoReferencia;
        this.numeroReferencia = numeroReferencia;
        this.responsableAplicaTransaccion = responsableAplicaTransaccion;
        this.fechaAS400AplicaTransaccion = fechaAS400AplicaTransaccion;
        this.horaAS400AplicaTransaccion = horaAS400AplicaTransaccion;
        this.programaAplicaTransaccion = programaAplicaTransaccion;
        this.numeroOrdenAS400 = numeroOrdenAS400;
        this.fechaAS400Orden = fechaAS400Orden;
        this.codDependenciaAplicaAS400 = codDependenciaAplicaAS400;
        this.historiaClinicaAS400 = historiaClinicaAS400;
        this.estadoFacturacion = estadoFacturacion;
        this.extraA1 = extraA1;
        this.extraA2 = extraA2;
        this.extraN1 = extraN1;
        this.extraN2 = extraN2;
        this.extraStatus = extraStatus;
        this.usuarioCreaTransaccion = usuarioCreaTransaccion;
        this.pantallaCreaTransaccion = pantallaCreaTransaccion;
        this.programaCreaTransaccion = programaCreaTransaccion;
        this.usuarioActualizaTransaccion = usuarioActualizaTransaccion;
        this.fechaActualizaTransaccion = fechaActualizaTransaccion;
        this.horaActualizaTransaccion = horaActualizaTransaccion;
        this.pantallaActualizaTransaccion = pantallaActualizaTransaccion;
        this.programaActualizaTransaccion = programaActualizaTransaccion;
    }

}
