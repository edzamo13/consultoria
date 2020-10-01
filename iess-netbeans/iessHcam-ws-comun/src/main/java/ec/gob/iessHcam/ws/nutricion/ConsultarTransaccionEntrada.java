package ec.gob.iessHcam.ws.nutricion;

/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 *   Este pojo define la entrada del método ConsultarTransaccion del ws.
 * </b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>[$Author: fsalazarn@iess.gob.ec $, $Date: 11/10/2016]</p>
 */

public class ConsultarTransaccionEntrada implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;
    @Getter
    @Setter
    private Double codUnmeAS400;
    @Getter
    @Setter
    private Double codDepAS400;
    @Getter
    @Setter
    private int codBodegaAS400;
    @Getter
    @Setter
    private String idTransaccion;

    public ConsultarTransaccionEntrada(Double codUnmeAS400, Double codDepAS400, int codBodegaAS400, String idTransaccion) {
        this.codUnmeAS400 = codUnmeAS400;
        this.codDepAS400 = codDepAS400;
        this.codBodegaAS400 = codBodegaAS400;
        this.idTransaccion = idTransaccion;
    }

    public ConsultarTransaccionEntrada() {
        
    }
 
}
