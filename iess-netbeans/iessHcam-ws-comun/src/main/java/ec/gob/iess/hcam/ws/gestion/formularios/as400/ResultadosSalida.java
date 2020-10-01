/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.gestion.formularios.as400;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>Incluir aquí la descripción de la clase.</b>
 *
 * @author jsaltosb@iess.gob.ec
 * <p>
 * [Author: Gabriel Saltos, Date: 11/04/2017]
 * </p>
 */
public class ResultadosSalida implements Serializable {

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

    @Getter
    @Setter
    private String minimo;

    @Getter
    @Setter
    private String maximo;

    @Getter
    @Setter
    private String tipoMuestra;

    @Getter
    @Setter
    private String resultado;

    @Getter
    @Setter
    private String microOrganismo;

    @Getter
    @Setter
    private String antibiotico;

    @Getter
    @Setter
    private String resulAntibio;

    @Getter
    @Setter
    private String comentario;

    /**
     * Método constructor
     */
    public ResultadosSalida() {

    }

    /**
     * Metodo constructor
     *
     * @param numOrden numero orden AS400
     * @param codigo codigo del examen
     * @param valor costo del examen
     * @param descripAs400 nombre del examen
     * @param descripTarifario nombre 2 del examen
     * @param minimo valor minimo del examen
     * @param maximo valor maximo del examen
     * @param tipoMuestra muestra del examen
     * @param resultado resultado del examen
     * @param microOrganismo del examen
     * @param antibiotico utilizado del examen
     * @param resulAntibio resultado del examen
     * @param comentario comentario del examen
     */
    public ResultadosSalida(String numOrden,String codigo, String valor, String descripAs400, String descripTarifario, String minimo, String maximo, String tipoMuestra, String resultado, String microOrganismo, String antibiotico, String resulAntibio, String comentario) {
        this.numOrden = numOrden;
        this.codigo = codigo;
        this.valor = valor;
        this.descripAs400 = descripAs400;
        this.descripTarifario = descripTarifario;
        this.minimo = minimo;
        this.maximo = maximo;
        this.tipoMuestra = tipoMuestra;
        this.resultado = resultado;
        this.microOrganismo = microOrganismo;
        this.antibiotico = antibiotico;
        this.resulAntibio = resulAntibio;
        this.comentario = comentario;
    }

}
