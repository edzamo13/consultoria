/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *  * <b>
 *  *   Incluir aqui la descripción de la clase.  * </b>
 *  *
 *  * @author fquisiguina
 
 * <p>
 * [$Author: fquisiguina $, $Date: 20/06/2016]</p>
 
 */
@Entity
@Table(name = "seg_auditoria_detalle_tbl", catalog = "ec_iesshcam", schema = "seguridad")
public class AuditoriaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "adt_id_auditoria_detalle")
    @Getter
    @Setter
    private Long adtIdAuditoriaDetalle;

    @Column(name = "adt_campo_afectado")
    @Getter
    @Setter
    private String adtCampoAfectado;
    
    @Column(name = "adt_valor_anterior")
    @Getter
    @Setter
    private String adtValorAnterior;
    
    @Column(name = "adt_valor_actual")
    @Getter
    @Setter
    private String adtValorActual;
    
    
    @Getter
    @Setter
    @JoinColumn(name = "aud_id_auditoria", referencedColumnName = "aud_id_auditoria")
    @ManyToOne(fetch = FetchType.LAZY)
    private Auditoria auditoria;
   

    public AuditoriaDetalle() {
    }

    public AuditoriaDetalle(Long adtIdAuditoriaDetalle) {
        this.adtIdAuditoriaDetalle = adtIdAuditoriaDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adtIdAuditoriaDetalle != null ? adtIdAuditoriaDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuditoriaDetalle)) {
            return false;
        }
        AuditoriaDetalle other = (AuditoriaDetalle) object;
        if ((this.adtIdAuditoriaDetalle == null && other.adtIdAuditoriaDetalle != null) || (this.adtIdAuditoriaDetalle != null && !this.adtIdAuditoriaDetalle.equals(other.adtIdAuditoriaDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.iessHcam.gestion.archivoClinico.modelo.AuditoriaDetalle[ adtIdAuditoriaDetalle=" + adtIdAuditoriaDetalle + " ]";
    }

}
