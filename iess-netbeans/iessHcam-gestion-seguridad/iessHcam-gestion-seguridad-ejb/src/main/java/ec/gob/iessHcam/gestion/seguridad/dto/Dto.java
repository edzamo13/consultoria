/* 
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR.
 * Todos los derechos reservados.
 */
package ec.gob.iessHcam.gestion.seguridad.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * <b> Funcionalidad el DTO. </b>
 *
 * @author jpatino
 * <p>
 * [$Author: jpatino $, $Date: 02/09/2015 $]
 * </p>
 */
public class Dto implements Serializable {

    private static final long serialVersionUID = 8702945663795203275L;

    @Getter
    @Setter
    private String campo;
}
