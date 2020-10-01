package ec.gob.iessHcam.ws.nutricion;

/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * <b>
 *   Este pojo define la entrada del método ConsultarTransaccion del ws.
 * </b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>[$Author: fsalazarn@iess.gob.ec $, $Date: 11/10/2016]</p>
 */

public class ConsultarTransaccionSalida implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;
    @Getter
    @Setter
    private CabeceraKardexSalida cabeceraKardexSalida;
    @Getter
    @Setter
    private List<DetalleKardexSalida> detalleKardexSalida;

    public ConsultarTransaccionSalida(CabeceraKardexSalida cabeceraKardexSalida, List<DetalleKardexSalida> detalleKardexSalida) {
        this.cabeceraKardexSalida = cabeceraKardexSalida;
        this.detalleKardexSalida = detalleKardexSalida;
    }
    
    public ConsultarTransaccionSalida() {
    }
    
}
