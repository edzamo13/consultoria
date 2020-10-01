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
 *   Este pojo define la entrada del método RegistrarKardex del ws.
 * </b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>[$Author: fsalazarn@iess.gob.ec $, $Date: 11/10/2016]</p>
 */

public class RegistrarKardexEntrada implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;
    @Getter
    @Setter
    private CabeceraKardexEntrada cabeceraKardexEntrada;
    @Getter
    @Setter
    private List<DetalleKardexEntrada> detalleKardexEntrada;

    public RegistrarKardexEntrada(CabeceraKardexEntrada cabeceraKardexEntrada, List<DetalleKardexEntrada> detalleKardexEntrada) {
        this.cabeceraKardexEntrada = cabeceraKardexEntrada;
        this.detalleKardexEntrada = detalleKardexEntrada;
    }
    
    public RegistrarKardexEntrada() {
    }
    
}
