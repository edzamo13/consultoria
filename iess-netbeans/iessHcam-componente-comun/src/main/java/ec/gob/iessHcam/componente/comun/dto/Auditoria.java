/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "seg_auditoria_tbl", catalog = "ec_iesshcam", schema = "seguridad")
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aud_id_auditoria")
    @Getter
    @Setter
    private Long audIdAuditoria;

    @Column(name = "aud_esquema")
    @Getter
    @Setter
    private String audEsquema;
    
    @Column(name = "aud_tabla")
    @Getter
    @Setter
    private String audTabla;
    
    @Column(name = "aud_usuario")
    @Getter
    @Setter
    private String audUsuario;
    
    @Column(name = "aud_codunme")
    @Getter
    @Setter
    private String audCodunme;
    
    @Column(name = "aud_id_entidad")
    @Getter
    @Setter
    private String audIdEntidad;
    
    @Column(name = "aud_tipo_transaccion")
    @Getter
    @Setter
    private String audTipoTransaccion;

    @Column(name = "aud_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date audFecha;

   
    @OneToMany(mappedBy = "auditoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<AuditoriaDetalle> lista = new ArrayList<AuditoriaDetalle>();

    public Auditoria() {
    }

    public Auditoria(Long audIdAuditoria) {
        this.audIdAuditoria = audIdAuditoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (audIdAuditoria != null ? audIdAuditoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.audIdAuditoria == null && other.audIdAuditoria != null) || (this.audIdAuditoria != null && !this.audIdAuditoria.equals(other.audIdAuditoria))) {
            return false;
        }
        return true;
    }

    /*@Override
    public String toString() {
        return "ec.gob.iessHcam.gestion.archivoClinico.modelo.Auditoria[ audIdAuditoria=" + audIdAuditoria + " ]";
    }*/

}
