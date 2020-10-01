/* 
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados 
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

/**
 * <b> Enumeracion para representar todos los tipos de manillas para impresoras. </b>
 *
 * @author fochoac
 *         <p>
 *         [$Author: jzuniga $, $Date: 01/07/2016]
 *         </p>
 * @param <T>
 */
public enum TipoManillaEnum {

    PEDIATRICO("PEDIATRICO"), ADULTO("ADULTO"), NEONATO("NEONATO"), OTRO("OTRO"), ETIQUETA_QR("ETIQUETA QR"), ETIQUETA_QR_GRANDE("ETIQUETA QR GRANDE");

    @Getter
    private String nombre;


    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: jzuniga, Date: 01/07/2016]
     * </p>
     *
     * @param nombre
     *            nombre
     */
    private TipoManillaEnum(String nombre) {
        this.nombre = nombre;
    }

}
