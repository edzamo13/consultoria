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
public class MenuRespuesta implements Serializable {
    
    private static final long serialVersionUID = -7880084267722228034L;
    
    @Getter
    @Setter
    private int idMenu;
    @Getter
    @Setter
    private int estado;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private int idPadre;
    @Getter
    @Setter
    private String link;
    @Getter
    @Setter
    private String icono;
    @Getter
    @Setter
    private int orden;
    @Getter
    @Setter
    private String ancho;
    @Getter
    @Setter
    private String alto;
    @Getter
    @Setter
    private int ventana;

    public MenuRespuesta(int idMenu, int estado, String nombre, int idPadre, String link, String icono, int orden, String ancho, String alto, int ventana) {
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

