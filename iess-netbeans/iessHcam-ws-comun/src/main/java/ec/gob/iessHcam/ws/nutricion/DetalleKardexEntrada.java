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

public class DetalleKardexEntrada implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;
    @Getter
    @Setter
    private Double codUnmeAS400;
    @Getter
    @Setter
    private Double codDepAS400;
    @Getter
    @Setter
    private int codBodegaAS400;
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
    private String tipo;
    @Getter
    @Setter
    private String tipoItem;
    @Getter
    @Setter
    private String grupo;
    @Getter
    @Setter
    private String subgrupo;
    @Getter
    @Setter
    private String generico;
    @Getter
    @Setter
    private String comercial;
    @Getter
    @Setter
    private int cantidadxTransaccion;
    @Getter
    @Setter
    private int cantidadSolicitadaxTransaccion;
    @Getter
    @Setter
    private String estadoTransaccion;
    @Getter
    @Setter
    private Double costo;
    @Getter
    @Setter
    private Double costoTotal;
    @Getter
    @Setter
    private String responsableAplicaTransaccion;
    @Getter
    @Setter
    private int fechaAS400AplicaTransaccion;
    @Getter
    @Setter
    private int horaAS400AplicaTransaccion;
    @Getter
    @Setter
    private String programaAplicaTransaccion;
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
    private int extraN1;
    @Getter
    @Setter
    private int extraN2;
    @Getter
    @Setter
    private String extraStatus;
    @Getter
    @Setter
    private String usuarioCreaTransaccion;
    @Getter
    @Setter
    private int fechaAS400CreaTransaccion;
    @Getter
    @Setter
    private int horaAS400CreaTransaccion;
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
    private int fechaActualizaTransaccion;
    @Getter
    @Setter
    private int horaActualizaTransaccion;
    @Getter
    @Setter
    private String pantallaActualizaTransaccion;
    @Getter
    @Setter
    private String programaActualizaTransaccion;
    
    
    public DetalleKardexEntrada() {
        
    }

    public DetalleKardexEntrada(Double codUnmeAS400, Double codDepAS400, int codBodegaAS400, String tipoTransaccion, String codTransaccional, String idTransaccion, String tipo, String tipoItem, String grupo, String subgrupo, String generico, String comercial, int cantidadxTransaccion, int cantidadSolicitadaxTransaccion, String estadoTransaccion, Double costo, Double costoTotal, String responsableAplicaTransaccion, int fechaAS400AplicaTransaccion, int horaAS400AplicaTransaccion, String programaAplicaTransaccion, String estadoFacturacion, String extraA1, String extraA2, int extraN1, int extraN2, String extraStatus, String usuarioCreaTransaccion, int fechaAS400CreaTransaccion, int horaAS400CreaTransaccion, String pantallaCreaTransaccion, String programaCreaTransaccion) {
        this.codUnmeAS400 = codUnmeAS400;
        this.codDepAS400 = codDepAS400;
        this.codBodegaAS400 = codBodegaAS400;
        this.tipoTransaccion = tipoTransaccion;
        this.codTransaccional = codTransaccional;
        this.idTransaccion = idTransaccion;
        this.tipo = tipo;
        this.tipoItem = tipoItem;
        this.grupo = grupo;
        this.subgrupo = subgrupo;
        this.generico = generico;
        this.comercial = comercial;
        this.cantidadxTransaccion = cantidadxTransaccion;
        this.cantidadSolicitadaxTransaccion = cantidadSolicitadaxTransaccion;
        this.estadoTransaccion = estadoTransaccion;
        this.costo = costo;
        this.costoTotal = costoTotal;
        this.responsableAplicaTransaccion = responsableAplicaTransaccion;
        this.fechaAS400AplicaTransaccion = fechaAS400AplicaTransaccion;
        this.horaAS400AplicaTransaccion = horaAS400AplicaTransaccion;
        this.programaAplicaTransaccion = programaAplicaTransaccion;
        this.estadoFacturacion = estadoFacturacion;
        this.extraA1 = extraA1;
        this.extraA2 = extraA2;
        this.extraN1 = extraN1;
        this.extraN2 = extraN2;
        this.extraStatus = extraStatus;
        this.usuarioCreaTransaccion = usuarioCreaTransaccion;
        this.fechaAS400CreaTransaccion = fechaAS400CreaTransaccion;
        this.horaAS400CreaTransaccion = horaAS400CreaTransaccion;
        this.pantallaCreaTransaccion = pantallaCreaTransaccion;
        this.programaCreaTransaccion = programaCreaTransaccion;
    }

    public DetalleKardexEntrada(Double codUnmeAS400, Double codDepAS400, int codBodegaAS400, String tipoTransaccion, String codTransaccional, String idTransaccion, String tipo, String tipoItem, String grupo, String subgrupo, String generico, String comercial, int cantidadxTransaccion, int cantidadSolicitadaxTransaccion, String estadoTransaccion, Double costo, Double costoTotal, String responsableAplicaTransaccion, int fechaAS400AplicaTransaccion, int horaAS400AplicaTransaccion, String programaAplicaTransaccion, String estadoFacturacion, String extraA1, String extraA2, int extraN1, int extraN2, String extraStatus, String usuarioCreaTransaccion, int fechaAS400CreaTransaccion, int horaAS400CreaTransaccion, String pantallaCreaTransaccion, String programaCreaTransaccion, String usuarioActualizaTransaccion, int fechaActualizaTransaccion, int horaActualizaTransaccion, String pantallaActualizaTransaccion, String programaActualizaTransaccion) {
        this.codUnmeAS400 = codUnmeAS400;
        this.codDepAS400 = codDepAS400;
        this.codBodegaAS400 = codBodegaAS400;
        this.tipoTransaccion = tipoTransaccion;
        this.codTransaccional = codTransaccional;
        this.idTransaccion = idTransaccion;
        this.tipo = tipo;
        this.tipoItem = tipoItem;
        this.grupo = grupo;
        this.subgrupo = subgrupo;
        this.generico = generico;
        this.comercial = comercial;
        this.cantidadxTransaccion = cantidadxTransaccion;
        this.cantidadSolicitadaxTransaccion = cantidadSolicitadaxTransaccion;
        this.estadoTransaccion = estadoTransaccion;
        this.costo = costo;
        this.costoTotal = costoTotal;
        this.responsableAplicaTransaccion = responsableAplicaTransaccion;
        this.fechaAS400AplicaTransaccion = fechaAS400AplicaTransaccion;
        this.horaAS400AplicaTransaccion = horaAS400AplicaTransaccion;
        this.programaAplicaTransaccion = programaAplicaTransaccion;
        this.estadoFacturacion = estadoFacturacion;
        this.extraA1 = extraA1;
        this.extraA2 = extraA2;
        this.extraN1 = extraN1;
        this.extraN2 = extraN2;
        this.extraStatus = extraStatus;
        this.usuarioCreaTransaccion = usuarioCreaTransaccion;
        this.fechaAS400CreaTransaccion = fechaAS400CreaTransaccion;
        this.horaAS400CreaTransaccion = horaAS400CreaTransaccion;
        this.pantallaCreaTransaccion = pantallaCreaTransaccion;
        this.programaCreaTransaccion = programaCreaTransaccion;
        this.usuarioActualizaTransaccion = usuarioActualizaTransaccion;
        this.fechaActualizaTransaccion = fechaActualizaTransaccion;
        this.horaActualizaTransaccion = horaActualizaTransaccion;
        this.pantallaActualizaTransaccion = pantallaActualizaTransaccion;
        this.programaActualizaTransaccion = programaActualizaTransaccion;
    }

}
