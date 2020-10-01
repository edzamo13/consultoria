/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.procedimiento;

import lombok.Getter;
import lombok.Setter;

/**
 * <b> Pojo para configurar los parametros a enviar a la clase: {@link ProcedimientoAlmacenadoJdbcUtil}. </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 11/8/2015 $]
 *          </p>
 */
public class ParametroProcedimiento {
    @Getter
    @Setter
    private String nombreParametro;
    @Getter
    @Setter
    private boolean entrada;
    @Getter
    @Setter
    private int tipo;
    @Getter
    @Setter
    private Object valor;

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 10/9/2015]
     * </p>
     *
     * @param nombreParametro
     *            a utilizar
     * @param entrada
     *            es de tipo entrada true o false si no lo es
     * @param tipo
     *            de dato
     * @param valor
     *            {@link Object}
     */
    public ParametroProcedimiento(String nombreParametro, boolean entrada, int tipo, Object valor) {
        this.nombreParametro = nombreParametro;
        this.entrada = entrada;
        this.tipo = tipo;
        this.valor = valor;
    }

}
