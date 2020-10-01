/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.autentificacion;

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
 * [$Author: ezamora $, $Date: 27/04/2016]</p>
 */
public class MetodoxServicioSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    private String idMetodo;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String url;
    @Getter
    @Setter
    private String estado;
    @Getter
    @Setter
    private String idUsuarioCreacion;
    @Getter
    @Setter
    private String fechaCreacion;
    @Getter
    @Setter
    private String idUsuarioActualiza;
    @Getter
    @Setter
    private String fechaActualiza;
    @Getter
    @Setter
    private String descripcion;
    @Getter
    @Setter
    private String codigo;
    
    @Getter
    @Setter
    private String idServicioWeb;
    @Getter
    @Setter
    private String tipoMetodo;

    public MetodoxServicioSalida() {
    }

    public MetodoxServicioSalida(String idMetodo, String nombre, String url, String estado, String idUsuarioCreacion, String fechaCreacion, String idUsuarioActualiza, String fechaActualiza, String descripcion, String codigo, String idServicioWeb, String tipoMetodo) {
        this.idMetodo = idMetodo;
        this.nombre = nombre;
        this.url = url;
        this.estado = estado;
        this.idUsuarioCreacion = idUsuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.idUsuarioActualiza = idUsuarioActualiza;
        this.fechaActualiza = fechaActualiza;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.idServicioWeb = idServicioWeb;
        this.tipoMetodo = tipoMetodo;
    }

   

    
    
    
    
}
