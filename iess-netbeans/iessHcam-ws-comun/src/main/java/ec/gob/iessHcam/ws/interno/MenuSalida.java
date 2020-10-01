/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/
package ec.gob.iessHcam.ws.interno;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LENIN
 * <p>[$Author: LENIN $, $Date: 04-mar-2016]</p>
 */
public class MenuSalida implements Serializable {
    
    private static final long serialVersionUID = -7880084267722228034L;
    
    @Getter
    @Setter
    private String idMenu;
    @Getter
    @Setter
    private String estado;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String idPadre;
    @Getter
    @Setter
    private String link;
    @Getter
    @Setter
    private String icono;
    @Getter
    @Setter
    private String orden;
    @Getter
    @Setter
    private String ancho;
    @Getter
    @Setter
    private String alto;
    @Getter
    @Setter
    private String ventana;

    public MenuSalida(String idMenu, String estado, String nombre, String idPadre, String link, String icono, String orden, String ancho, String alto, String ventana) {
        this.idMenu = idMenu;
        this.estado = estado;
        this.nombre = nombre;
        this.idPadre = idPadre;
        this.link = link;
        this.icono = icono;
        this.orden = orden;
        this.ancho = ancho;
        this.alto = alto;
        this.ventana = ventana;
    }

    
    
    
}

