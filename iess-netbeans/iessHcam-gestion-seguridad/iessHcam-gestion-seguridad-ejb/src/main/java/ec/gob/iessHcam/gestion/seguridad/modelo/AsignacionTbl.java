/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iessHcam.gestion.seguridad.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author HCAM
 */
@Entity
@Table(name = "ut_asignacion_tbl", schema = "utilitario")
@NamedQueries({
    @NamedQuery(name = AsignacionTbl.OBTENER_IMPRESORAS_ASIGNADAS_POR_UNME_IP_USUARIO_IP_IMPRESORA, query = "SELECT a FROM AsignacionTbl a where a.imIdImpresora.imCodUnme = :codUnme and a.asDirecIpUsua = :ipUsuario and a.imIdImpresora.imDirecIpImpre = :ipImpresora and a.imIdImpresora.tiIdTipoManilla.tiIdTipoManilla = :idTipoManilla")})
public class AsignacionTbl implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public static final String OBTENER_IMPRESORAS_ASIGNADAS_POR_UNME_IP_USUARIO_IP_IMPRESORA = "AsignacionTbl.OBTENER_IMPRESORAS_ASIGNADAS_POR_UNME_IP_USUARIO_IP_IMPRESORA";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "as_id_asignacion")
    @Getter
    @Setter
    private Long asIdAsignacion;
    
    @Size(max = 50)
    @Column(name = "as_direc_ip_usua")
    @Getter
    @Setter
    private String asDirecIpUsua;
    
    @Size(max = 150)
    @Column(name = "as_descripcion")
    @Getter
    @Setter
    private String asDescripcion;
    
    @Column(name = "as_fecha_crea")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date asFechaCrea;
    
    @Size(max = 10)
    @Column(name = "as_usuario_crea")
    @Getter
    @Setter
    private String asUsuarioCrea;
    
    @Column(name = "as_estado")
    @Getter
    @Setter
    private Character asEstado;
    
    @JoinColumn(name = "im_id_impresora", referencedColumnName = "im_id_impresora")
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    private ImpresoraTbl imIdImpresora;

    public AsignacionTbl() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asIdAsignacion != null ? asIdAsignacion.hashCode() : 0);
        return hash;
    }
}
