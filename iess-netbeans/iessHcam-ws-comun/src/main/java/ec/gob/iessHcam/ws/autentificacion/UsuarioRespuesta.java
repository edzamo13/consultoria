/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.autentificacion;


import java.io.Serializable;
import java.util.List;
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
public class UsuarioRespuesta implements Serializable {

    private static final long serialVersionUID = 227483449663204875L;

    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private UsuarioSalida cuerpo;
    @Getter
    @Setter
    private List<UsuarioSalida> cuerpoLista;
    @Getter
    @Setter
    private String mensaje;
}
