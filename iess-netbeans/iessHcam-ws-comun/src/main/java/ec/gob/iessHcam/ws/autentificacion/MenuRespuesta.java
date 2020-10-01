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
 *
 * @author ezamora
 */
public class MenuRespuesta implements Serializable {

    private static final long serialVersionUID = -4002897314076938975L;

    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private List<MenuSalida> cuerpoLista;
    @Getter
    @Setter
    private String mensaje;

    public MenuRespuesta() {
    }

}
