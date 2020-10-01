/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * <b> Clase que contiene los datos principales para la auditoría. </b>
 * 
 * @author gvega
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: gvega $, $Date: 8/7/2015 $]
 *          </p>
 */
public class AuditoriaDto implements Serializable {

    private static final long serialVersionUID = -4290015422890924874L;

    @Getter
    @Setter
    private String ipMaquinaAuditoria;
    @Getter
    @Setter
    private String numeroDocumento;
    @Getter
    @Setter
    private String observacion;

    /**
     * <b>
     * Constructor de la clase.
     * </b>
     * <p>[Author: fochoac, Date: 1/9/2015]</p>
     *
     */ 
    public AuditoriaDto() {
        super();
    }

    /**
     * <b>
     * Constructor de la clase.
     * </b>
     * <p>[Author: fochoac, Date: 1/9/2015]</p>
     *
     * @param auditoriaDto
     */ 
    public AuditoriaDto(AuditoriaDto auditoriaDto) {
        setIpMaquinaAuditoria(auditoriaDto.getIpMaquinaAuditoria());
        setNumeroDocumento(auditoriaDto.getNumeroDocumento());
        setObservacion(auditoriaDto.getObservacion());
    }
}