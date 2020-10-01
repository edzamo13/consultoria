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
public class MenuSalida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String meIdOpcion;
    @Getter
    @Setter
    private String meidOpcion_padre;
    @Getter
    @Setter
    private String apIdAplicacion;
    @Getter
    @Setter
    private String meEtiqueta;
    @Getter
    @Setter
    private String meOrden;
    @Getter
    @Setter
    private String meUrl;
    @Getter
    @Setter
    private String meNodoFinal;
    @Getter
    @Setter
    private String meAccion;
    @Getter
    @Setter
    private String meEstado;
    @Getter
    @Setter
    private String meAuditoria;

    public MenuSalida() {
    }

    /*@Override
    public String toString() {
        return "MenuSalida{" + "meIdOpcion=" + meIdOpcion + ", meidOpcion_padre=" + meidOpcion_padre + ", ap_id_aplicacion=" + apIdAplicacion + ", me_etiqueta=" + meEtiqueta + ", me_orden=" + meOrden + ", me_url=" + meUrl + ", me_nodo_final=" + meNodoFinal + ", me_accion=" + meAccion + ", me_estado=" + meEstado + ", me_auditoria=" + meAuditoria + '}';
    }*/
    
    @Override
    public String toString() {
        return meEtiqueta;
    }

    public MenuSalida(String meIdOpcion, String meidOpcion_padre, String ap_id_aplicacion, String me_etiqueta, String me_orden, String me_url, String me_nodo_final, String me_accion, String me_estado, String me_auditoria) {
        this.meIdOpcion = meIdOpcion;
        this.meidOpcion_padre = meidOpcion_padre;
        this.apIdAplicacion = ap_id_aplicacion;
        this.meEtiqueta = me_etiqueta;
        this.meOrden = me_orden;
        this.meUrl = me_url;
        this.meNodoFinal = me_nodo_final;
        this.meAccion = me_accion;
        this.meEstado = me_estado;
        this.meAuditoria = me_auditoria;
    }
    
    

}
