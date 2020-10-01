/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.listaEsperaCirugia;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>Incluir aquí la descripción de la clase.</b>
 *
 * @author dtapiam@iess.gob.ec
 * @version 1.0 (Revisión)
 * @since 1.0
 * <p>
 * [Author: Daniel Tapia, Date: 30/11/2016]
 * </p>
 */
public class TarifarioRespuesta implements Serializable {

    private static final long serialVersionUID = -4002897311597548975L;

    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private List<TarifarioSalida> cuerpoLista;
    @Getter
    @Setter
    private String mensaje;

    public TarifarioRespuesta() {
    }

}
