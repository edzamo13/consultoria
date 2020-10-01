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
public class CirugiaSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    private String cedula;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String fechaOperacion;
    @Getter
    @Setter
    private String horaOperacion;
    @Getter
    @Setter
    private String tiempoCirugia;
    @Getter
    @Setter
    private String estado;
    @Getter
    @Setter
    private String horaFinCirugia;
    @Getter
    @Setter
    private String desEstadoRecuperacion;
    @Getter
    @Setter
    private String desEstadoTraslado;
    @Getter
    @Setter
    private String circulante;
    
    public CirugiaSalida() {
        super();
    }

    public CirugiaSalida(String cedula, String nombre, String fechaOperacion, String horaOperacion, String tiempoCirugia, String estado, String horaFinCirugia, String desEstadoRecuperacion, String desEstadoTraslado, String circulante) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaOperacion = fechaOperacion;
        this.horaOperacion = horaOperacion;
        this.tiempoCirugia = tiempoCirugia;
        this.estado = estado;
        this.horaFinCirugia = horaFinCirugia;
        this.desEstadoRecuperacion = desEstadoRecuperacion;
        this.desEstadoTraslado = desEstadoTraslado;
        this.circulante = circulante;
    }
    
}
