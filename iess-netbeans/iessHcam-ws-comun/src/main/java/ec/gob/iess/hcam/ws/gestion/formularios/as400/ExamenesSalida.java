/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.gestion.formularios.as400;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>Pojo con los datos de la consulta del servicio.</b>
 *
 * @author jsaltosb@iess.gob.ec
 * <p>
 * [Author: Gabriel Saltos, Date: 15/03/2017]
 * </p>
 */
public class ExamenesSalida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String numOrden;

    @Getter
    @Setter
    private String codigo;

    @Getter
    @Setter
    private String valor;

    @Getter
    @Setter
    private String descripAs400;

    @Getter
    @Setter
    private String descripTarifario;

    /**
     * <b>Método constructor vacio.</b>
     * <p>
     * [Autor: Gabriel Saltos, Fecha: 15/03/2017]
     * </p>
     *
     */
    public ExamenesSalida() {

    }

    /**
     * <b>Método constructor.</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 15/03/2017]
     * </p>
     *
     * @param numOrden numero orden AS-400
     * @param codigo código examen
     * @param valor costo en tarifario examen
     * @param descripAs400 nombre examen AS400
     * @param descripTarifario nombre examen tarifario
     */
    public ExamenesSalida(String numOrden, String codigo, String valor, String descripAs400, String descripTarifario) {
        this.numOrden = numOrden;
        this.codigo = codigo;
        this.valor = valor;
        this.descripAs400 = descripAs400;
        this.descripTarifario = descripTarifario;
    }
}
