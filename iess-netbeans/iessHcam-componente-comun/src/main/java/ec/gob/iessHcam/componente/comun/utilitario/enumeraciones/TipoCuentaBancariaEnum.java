/* 
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

/**
 * <b> Enumeracion para definir el tipo de cuenta bancaria. </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 19/8/2015 $]
 *          </p>
 */
public enum TipoCuentaBancariaEnum {

    AHORROS("02", "AHO", "AHORROS"), CORRIENTE("01", "COR", "CORRIENTE");

    /**
     * Se hace referencia al codigo 01 para Corriente y 02 para ahorros
     */
    @Getter
    private String codigo;

    /**
     * se hace referencia a AHO o COR
     */
    @Getter
    private String sigla;

    /**
     * Se hace referencia a la descripcion de la cuenta
     */
    @Getter
    private String descripcion;

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 10/9/2015]
     * </p>
     *
     * @param codigo
     *            de la cuenta
     * @param sigla
     *            de la cuenta
     * @param descripcion
     *            de la cuenta
     */
    private TipoCuentaBancariaEnum(String codigo, String sigla, String descripcion) {
        this.codigo = codigo;
        this.sigla = sigla;
        this.descripcion = descripcion;
    }

}
