/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.autentificacion;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ezamora
 */
public class AplicacionSalida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String ap_id_aplicacion;
    @Getter
    @Setter
    private String ap_nombre;
    @Getter
    @Setter
    private String ap_descripcion;
    @Getter
    @Setter
    private String ap_imagen;
    @Getter
    @Setter
    private String ap_url;
    @Getter
    @Setter
    private String ap_tipo;
    @Getter
    @Setter
    private String ap_estado;
    @Getter
    @Setter
    private String de_id_dependencia;
    @Getter
    @Setter
    private String ca_id_categoria;
    @Getter
    @Setter
    private String ap_ext_img;
    @Getter
    @Setter
    private String ap_cod_aplicacion;
    @Getter
    @Setter
    private String ap_visible;
    @Getter
    @Setter
    private String ap_nom_img;
    @Getter
    @Setter
    private String ap_des_cont;

    
    
    /**
     *
     * <b>
     * Constructor de Clase.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 18/11/2016]</p>
     */
    public AplicacionSalida() {
    }
    
    
    
    /**
     *
     * <b>
     * Constructor de String.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 18/11/2016]</p>
     * @param ap_id_aplicacion
     * @param ap_nombre
     * @param ap_descripcion
     * @param ap_url
     * @param ap_imagen
     * @param ap_des_cont
     * @param ap_tipo
     * @param de_id_dependencia
     * @param ap_estado
     * @param ap_ext_img
     * @param ap_cod_aplicacion
     * @param ap_visible
     * @param ca_id_categoria
     * @param ap_nom_img
     */
    public AplicacionSalida(String ap_id_aplicacion, String ap_nombre, String ap_descripcion, String ap_imagen, String ap_url, String ap_tipo, String ap_estado, String de_id_dependencia, String ca_id_categoria, String ap_ext_img, String ap_cod_aplicacion, String ap_visible, String ap_nom_img, String ap_des_cont) {
        this.ap_id_aplicacion = ap_id_aplicacion;
        this.ap_nombre = ap_nombre;
        this.ap_descripcion = ap_descripcion;
        this.ap_imagen = ap_imagen;
        this.ap_url = ap_url;
        this.ap_tipo = ap_tipo;
        this.ap_estado = ap_estado;
        this.de_id_dependencia = de_id_dependencia;
        this.ca_id_categoria = ca_id_categoria;
        this.ap_ext_img = ap_ext_img;
        this.ap_cod_aplicacion = ap_cod_aplicacion;
        this.ap_visible = ap_visible;
        this.ap_nom_img = ap_nom_img;
        this.ap_des_cont = ap_des_cont;
    }
    
    
    
    

}
