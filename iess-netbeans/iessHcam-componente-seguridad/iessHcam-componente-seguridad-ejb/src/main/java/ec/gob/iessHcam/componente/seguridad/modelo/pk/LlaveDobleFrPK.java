/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.seguridad.modelo.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * <b> Clave primaria de la tabla de aportes de Fondos de Reserva. </b>
 *
 * @author gvega
 * @version $Revision: 1.0 $
 * <p>
 * [$Author: gvega $, $Date: 22/7/2015 $]
 * </p>
 */
@Embeddable
public class LlaveDobleFrPK implements Serializable {

    private static final long serialVersionUID = -379565846642702281L;

    @Getter
    @Setter
    @Column(name = "AP_CODIGO")
    private Long codigoAporte;

    @Getter
    @Setter
    @Column(name = "AP_ORIGEN")
    private Long origen;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LlaveDobleFrPK)) {
            return false;
        }
        LlaveDobleFrPK other = (LlaveDobleFrPK) o;
        return (getCodigoAporte().equals(other.getCodigoAporte())) && (getOrigen().equals(other.getOrigen()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + getCodigoAporte().hashCode();
        hash = hash * prime + getOrigen().hashCode();

        return hash;
    }
}
