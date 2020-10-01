/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.huella.digital;

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
 * [$Author: ezamora $, $Date: 02/09/2016]</p>
 */
public class RegatencionTbl implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String OBTENER_CEDULA_ATENCION = "Regatencion.OBTENER_CEDULA_ATENCION";
    @Getter
    @Setter
    private String atidpk;
    @Getter
    @Setter
    private String atcodum;
    @Getter
    @Setter
    private String atnumhi;
    @Getter
    @Setter
    private String atfeccit;
    @Getter
    @Setter
    private String athorcit;
    @Getter
    @Setter
    private String atipusu;
    @Getter
    @Setter
    private String atopid;
    @Getter
    @Setter
    private String atnuven;
    @Getter
    @Setter
    private String atced;
    @Getter
    @Setter
    private String atobs;
    @Getter
    @Setter
    private String ataten;
    @Getter
    @Setter
    private String atcedmed;
    @Getter
    @Setter
    private String atobsmed;
    @Getter
    @Setter
    private String atatenmed;
    @Getter
    @Setter
    private String ataintpac;
    @Getter
    @Setter
    private String ataintmed;

    public RegatencionTbl() {
    }

    public RegatencionTbl(String atidpk, String atcodum, String atnumhi, String atfeccit, String athorcit, String atipusu, String atopid, String atnuven, String atced, String atobs, String ataten, String atcedmed, String atobsmed, String atatenmed, String ataintpac, String ataintmed) {
        this.atidpk = atidpk;
        this.atcodum = atcodum;
        this.atnumhi = atnumhi;
        this.atfeccit = atfeccit;
        this.athorcit = athorcit;
        this.atipusu = atipusu;
        this.atopid = atopid;
        this.atnuven = atnuven;
        this.atced = atced;
        this.atobs = atobs;
        this.ataten = ataten;
        this.atcedmed = atcedmed;
        this.atobsmed = atobsmed;
        this.atatenmed = atatenmed;
        this.ataintpac = ataintpac;
        this.ataintmed = ataintmed;
    }

}
