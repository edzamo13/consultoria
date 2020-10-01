/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

/**
 * <b> Enumeracion que distingue a los sectores para el agendamiento web. </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 12/12/2015 $]
 *          </p>
 */
public enum AgendamientoSectorEnum {

    SECTOR_NORTE("01", "NORTE"), SECTOR_SUR("02", "SUR"), SECTOR_CEN("03", "CENTRO"), SECTOR_OESTE("04", "OESTE"), SECTOR_QUINCHE("05", "QUINCHE"), SECTOR_TUMBACO("06", "TUMBACO"), SECTOR_CUMBAYA("07", "CUMBAYA"), SECTOR_AMAGUANA("08", "AMAGUAÑA");
    @Getter
    private String codigo;
    @Getter
    private String sector;

    /**
     * @param codigo del sector
     * @param sector nombre
     */
    private AgendamientoSectorEnum(String codigo, String sector) {
        this.codigo = codigo;
        this.sector = sector;
    }

}
