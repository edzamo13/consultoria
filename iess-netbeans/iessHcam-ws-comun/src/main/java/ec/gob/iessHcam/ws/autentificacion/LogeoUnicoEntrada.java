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
 * [$Author: ezamora $, $Date: 20/01/2016]</p>
 */
public class LogeoUnicoEntrada implements Serializable {

    private static final long serialVersionUID = 935634762152302131L;

    @Getter
    @Setter
    private String usuario;
    @Getter
    @Setter
    private String tipoEvento;
    @Getter
    @Setter
    private String direccionIp;
    @Getter
    @Setter
    private String navegador;
}
