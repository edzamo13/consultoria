/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

/**
 * <b> Enumeracion para el negocio de pensiones en donde constan los tipos de seguro, prestacion, aportacion y prestacion adicional. </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 25/11/2015 $]
 *          </p>
 */
public enum PensionEnum {
    /**
     * Constante que muestra: CODIGO:SG, TIPO: S y Descripcion: Seguro General.
     */
    TIPO_SEGURO_GENERAL("SG", "S", "Seguro General"),
    /**
     * Constante que muestra: CODIGO:RT, TIPO: S y Riesgos del Trabajo.
     */
    TIPO_SEGURO_RIESGOS_TRABAJO("RT", "S", "Riesgos del Trabajo"),
    /**
     * Constante que muestra: CODIGO:SC, TIPO: S y Seguro Campesino.
     */
    TIPO_SEGURO_SOCIAL_CAMPESINO("SC", "S", "Seguro Campesino"),
    /**
     * Constante que muestra: CODIGO:JV, TIPO: P y Descripcion: VEJEZ.
     */
    TIPO_PRESTACION_VEJEZ("JV", "P", "VEJEZ"),
    /**
     * Constante que muestra: CODIGO:IN, TIPO: P y Descripcion: INVALIDEZ.
     */
    TIPO_PRESTACION_INVALIDEZ("IN", "P", "INVALIDEZ"),
    /**
     * Constante que muestra: CODIGO:DV, TIPO: P y Descripcion: DISCAPACIDAD.
     */
    TIPO_PRESTACION_DISCAPACIDAD("DV", "P", "DISCAPACIDAD"),
    /**
     * Constante que muestra: CODIGO:VO, TIPO: P y Descripcion: MONTEPIO.
     */
    TIPO_PRESTACION_MONTEPIO("VO", "P", "MONTEPIO"),
    /**
     * Constante que muestra: CODIGO:TE, TIPO: A y Descripcion: TELECOMUNICACIONES.
     */
    TIPO_APORTACION_TELECOMUNICACIONES("TE", "A", "TELECOMUNICACIONES"),
    /**
     * Constante que muestra: CODIGO:SG, TIPO: A y Descripcion: GENERAL.
     */
    TIPO_APORTACION_GENERAL("GE", "A", "GENERAL"),
    /**
     * Constante que muestra: CODIGO:GR, TIPO: A y Descripcion: GRAFICOS.
     */
    TIPO_APORTACION_GRAFICOS("GR", "A", "GRAFICOS"),
    /**
     * Constante que muestra: CODIGO:ZF, TIPO: A y Descripcion: ZAFRA.
     */
    TIPO_APORTACION_ZAFRA("ZF", "A", "ZAFRA"),
    /**
     * Constante que muestra: CODIGO:AM, TIPO: P-ADIC y Descripcion: MAGISTERIO IVM.
     */
    TIPO_PRESTACION_ADICIONAL_MAGISTERIO_IVM("AM", "P-ADIC", "MAGISTERIO IVM"),
    /**
     * Constante que muestra: CODIGO:ME, TIPO: P-ADIC y Descripcion: MAGISTERIO RES CD. 448.
     */
    TIPO_PRESTACION_ADICIONAL_MAGISTERIO_CD448("ME", "P-ADIC", "MAGISTERIO RES CD. 448"),
    /**
     * Constante que muestra: CODIGO:GR, TIPO: P-ADIC y Descripcion: GRÁFICOS.
     */
    TIPO_PRESTACION_ADICIONAL_GRAFICOS("GR", "P-ADIC", "GRÁFICOS"),
    /**
     * Constante que muestra: CODIGO:ZR, TIPO: P-ADIC y Descripcion: ZAFREROS.
     */
    TIPO_PRESTACION_ADICIONAL_ZAFREROS("ZR", "P-ADIC", "ZAFREROS"),
    /**
     * Constante que muestra: CODIGO:FE, TIPO: P-ADIC y Descripcion: FERROCARRILES.
     */
    TIPO_PRESTACION_ADICIONAL_FERROCARRILES("FE", "P-ADIC", "FERROCARRILES"),
    /**
     * Constante que muestra: CODIGO:TNRH, TIPO: A y Descripcion: AMAS DE CASA.
     */
    TIPO_APORTACION_AMAS_CASA("TNRH", "A", "AMAS DE CASA"),
    /**
     * Constante que muestra: CODIGO:JI, TIPO: P y Descripcion: SUBSIDIO TRANSITORIO.
     */
    TIPO_PRESTACION_SUBSIDIO_TRANSITORIO("JI", "P", "SUBSIDIO TRANSITORIO"),
    /**
    * 
    */
    TIPO_PRESTACION_PERMANENTE_PARCIAL("PP", "P", "PERMANENTE PARCIAL"),
    /**
    * 
    */
    TIPO_PRESTACION_PERMANENTE_TOTAL("PT", "P", "PERMANENTE TOTAL"),
    /**
    * 
    */
    TIPO_PRESTACION_PERMANENTE_ABSOLUTA("PA", "P", "PERMANENTE ABSOLUTA"),
    /**
    * 
    */
    TIPO_PRESTACION_FONDO_MORTUORIO("FM", "P", "FONDO MORTUORIO"),
    /**
    * 
    */
    TIPO_PRESTACION_AUXILIO_FUNERAL("AF", "P", "AUXILIO FUNERAL"),

    ;

    @Getter
    private String codigo;
    @Getter
    private String tipo;
    @Getter
    private String descripcion;

    /**
     * @param codigo
     *            del catalogo
     * @param tipo
     *            de item - APORTACION(A), SEGURO(S),PRESTACION(P),PRESTACION_ADICIONAL(P-ADIC)
     * 
     * @param descripcion
     *            del item
     */
    private PensionEnum(String codigo, String tipo, String descripcion) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

}
