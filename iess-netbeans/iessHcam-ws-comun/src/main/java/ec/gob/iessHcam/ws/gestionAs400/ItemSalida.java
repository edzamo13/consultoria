/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.gestionAs400;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author ezamora
 * <p>
 * [$Author: ezamora $, $Date: 02-jun-2016]</p>
 */
public class ItemSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    private String codiUnme;
    @Getter
    @Setter
    private String codGenerico;
    @Getter
    @Setter
    private String codComercial;
    @Getter
    @Setter
    private String estadoItem;
    @Getter
    @Setter
    private String descComercial;
    @Getter
    @Setter
    private String descGenerico;
    @Getter
    @Setter
    private String presentacion;

    public ItemSalida(String codiUnme, String codGenerico, String codComercial, String estadoItem, String descComercial, String descGenerico, String presentacion) {
        this.codiUnme = codiUnme;
        this.codGenerico = codGenerico;
        this.codComercial = codComercial;
        this.estadoItem = estadoItem;
        this.descComercial = descComercial;
        this.descGenerico = descGenerico;
        this.presentacion = presentacion;
    }
    
    public ItemSalida() {
    }
}
