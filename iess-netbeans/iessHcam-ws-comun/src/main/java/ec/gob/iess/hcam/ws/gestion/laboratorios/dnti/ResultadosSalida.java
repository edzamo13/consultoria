/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.gestion.laboratorios.dnti;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>Mapeo Salida Resultados DNTI</b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>
 * [Author: Felipe Salazar, Date: 13/06/2017]
 * </p>
 */
public class ResultadosSalida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String nombreUnme;
    @Getter
    @Setter
    private String codUnme;
    @Getter
    @Setter
    private String codHistoria;
    // @Getter
    // @Setter
    // private String cedula;
    // @Getter
    // @Setter
    // private String fecNacimiento;
    // @Getter
    // @Setter
    //     private String tipoAfiliado;
    // @Getter
    // @Setter
    // private String nombreAfiliado;
    // @Getter
    // @Setter
    // private String edadAfiliado;
    @Getter
    @Setter
    private String fecOrden;
    @Getter
    @Setter
    private String numOrden;
    @Getter
    @Setter
    private String grupoExamen;
    @Getter
    @Setter
    private String codItem;
    @Getter
    @Setter
    private String descripcionItem;
    @Getter
    @Setter
    private String fecResultado;
    @Getter
    @Setter
    private String codResultado;
    @Getter
    @Setter
    private String descripcionResultado;
    @Getter
    @Setter
    private String valorMinimo;
    @Getter
    @Setter
    private String valorMaximo;
    @Getter
    @Setter
    private String valorResultado;
    @Getter
    @Setter
    private String microorganismo;
    @Getter
    @Setter
    private String antibiotico;
    @Getter
    @Setter
    private String resistenciaAntibiotico;
    @Getter
    @Setter
    private String comentario;

    public ResultadosSalida() {

    }

    public ResultadosSalida(String nombreUnme, String codUnme, String codHistoria, String fecOrden, String numOrden, String grupoExamen, String codItem, String descripcionItem, String fecResultado, String codResultado, String descripcionResultado, String valorMinimo, String valorMaximo, String valorResultado, String microorganismo, String antibiotico, String resistenciaAntibiotico, String comentario) {
        this.nombreUnme = nombreUnme;
        this.codUnme = codUnme;
        this.codHistoria = codHistoria;
        this.fecOrden = fecOrden;
        this.numOrden = numOrden;
        this.grupoExamen = grupoExamen;
        this.codItem = codItem;
        this.descripcionItem = descripcionItem;
        this.fecResultado = fecResultado;
        this.codResultado = codResultado;
        this.descripcionResultado = descripcionResultado;
        this.valorMinimo = valorMinimo;
        this.valorMaximo = valorMaximo;
        this.valorResultado = valorResultado;
        this.microorganismo = microorganismo;
        this.antibiotico = antibiotico;
        this.resistenciaAntibiotico = resistenciaAntibiotico;
        this.comentario = comentario;
    }


}
