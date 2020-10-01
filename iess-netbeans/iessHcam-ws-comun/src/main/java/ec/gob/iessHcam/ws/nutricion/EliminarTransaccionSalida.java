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
 *   Este pojo define la salida del método RegistrarKardex del ws.
 * </b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>[$Author: fsalazarn@iess.gob.ec $, $Date: 11/10/2016]</p>
 */

public class EliminarTransaccionSalida implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;

    @Getter
    @Setter
    private int numeroRegistrosAfectados;

    public EliminarTransaccionSalida() {
        
    }

    public EliminarTransaccionSalida(int numeroRegistrosAfectados) {
    
        this.numeroRegistrosAfectados = numeroRegistrosAfectados;
        
    }

}
