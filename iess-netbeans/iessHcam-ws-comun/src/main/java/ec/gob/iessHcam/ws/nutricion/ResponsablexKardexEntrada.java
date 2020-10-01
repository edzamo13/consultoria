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
 *   Este pojo define la entrada del método getSaldosxBodega del ws.
 * </b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>[$Author: fsalazarn@iess.gob.ec $, $Date: 30/09/2016]</p>
 */

public class ResponsablexKardexEntrada implements Serializable {

    private static final long serialVersionUID = 111518189642740343L;
    @Getter
    @Setter
    private String codUnmeAS400;
    @Getter
    @Setter
    private String codDepAS400;
    @Getter
    @Setter
    private String estadoBodegaAS400;
    @Getter
    @Setter
    private String cedulaUsuarioAS400;
    @Getter
    @Setter
    private String estadoUsuarioNutricionAS400;
    
    public ResponsablexKardexEntrada() {
    }

    public ResponsablexKardexEntrada(String codUnmeAS400, String codDepAS400, String codBodegaAS400, String estadoBodegaAS400, String cedulaUsuarioAS400, String estadoUsuarioNutricionAS400) {
        this.codUnmeAS400 = codUnmeAS400;
        this.codDepAS400 = codDepAS400;
        this.estadoBodegaAS400 = estadoBodegaAS400;
        this.cedulaUsuarioAS400 = cedulaUsuarioAS400;
        this.estadoUsuarioNutricionAS400 = estadoUsuarioNutricionAS400;
    }

   

    
}
