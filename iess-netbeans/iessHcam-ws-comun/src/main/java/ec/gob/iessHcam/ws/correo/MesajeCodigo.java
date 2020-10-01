/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.correo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ezamora
 */
public class MesajeCodigo implements Serializable {

    private static final long serialVersionUID = -1422461130529850817L;

    @Getter
    @Setter
    private String id_mensajexcodigo;
    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private String mensaje;
    @Getter
    @Setter
    private String asunto;
    @Getter
    @Setter
    private String estado;
    @Getter
    @Setter
    private String fec_creacion;
    @Getter
    @Setter
    private String us_id_usuario_creacion;
    @Getter
    @Setter
    private String fec_actuailzacion;
    @Getter
    @Setter
    private String us_id_usuario_act;

    /**
     *
     * <b>
     * Constructor
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 14/09/2016]</p>
     */
    public MesajeCodigo() {
    }

    public MesajeCodigo(String id_mensajexcodigo, String codigo, String mensaje, String asunto, String estado, String fec_creacion, String us_id_usuario_creacion, String fec_actuailzacion, String us_id_usuario_act) {
        this.id_mensajexcodigo = id_mensajexcodigo;
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.asunto = asunto;
        this.estado = estado;
        this.fec_creacion = fec_creacion;
        this.us_id_usuario_creacion = us_id_usuario_creacion;
        this.fec_actuailzacion = fec_actuailzacion;
        this.us_id_usuario_act = us_id_usuario_act;
    }

}
