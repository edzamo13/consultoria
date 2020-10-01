package ec.gob.iessHcam.ws.nutricion;

/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 *   Este pojo define la respuesta del método getMaxIdTransaccion del ws.
 * </b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>[$Author: fsalazarn@iess.gob.ec $, $Date: 11/10/2016]</p>
 */

public class MaximaTransaccionRespuesta implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;

    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private List<MaximaTransaccionSalida> cuerpo;
    @Getter
    @Setter
    private String mensaje;

    public MaximaTransaccionRespuesta() {
        
    }

    public MaximaTransaccionRespuesta(String codigo, List<MaximaTransaccionSalida> cuerpo, String mensaje) {
        this.codigo = codigo;
        this.cuerpo = cuerpo;
        this.mensaje = mensaje;
    }

}
