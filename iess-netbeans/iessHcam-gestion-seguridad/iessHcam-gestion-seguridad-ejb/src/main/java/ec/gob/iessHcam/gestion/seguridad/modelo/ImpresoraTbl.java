/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iessHcam.gestion.seguridad.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
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
@Table(name = "ut_impresora_tbl", schema = "utilitario")
@NamedQueries({
    @NamedQuery(name = ImpresoraTbl.OBTENER_IMPRESORAS_POR_UNME, query = "SELECT i FROM ImpresoraTbl i WHERE i.imCodUnme = :codUnme"),
    @NamedQuery(name = ImpresoraTbl.OBTENER_IMPRESORAS_POR_IP_TIPO, query = "SELECT i FROM ImpresoraTbl i WHERE i.imDirecIpImpre = :ipImpresora and i.imCodUnme = :codUnme and i.tiIdTipoManilla.tiIdTipoManilla = :tipoManilla")})
public class ImpresoraTbl implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public static final String OBTENER_IMPRESORAS_POR_UNME = "ImpresoraTbl.OBTENER_IMPRESORAS_POR_UNME";
    
    public static final String OBTENER_IMPRESORAS_POR_IP_TIPO = "ImpresoraTbl.OBTENER_IMPRESORAS_POR_IP_TIPO";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "im_id_impresora")
    @Getter
    @Setter
    private Long imIdImpresora;
    
    @Column(name = "im_cod_unme")
    @Getter
    @Setter
    private Long imCodUnme;
    
    @Size(max = 50)
    @Column(name = "im_direc_ip_impre")
    @Getter
    @Setter
    private String imDirecIpImpre;
    
    @Size(max = 200)
    @Column(name = "im_descripcion")
    @Getter
    @Setter
    private String imDescripcion;
    
    @Column(name = "im_fecha_crea")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date imFechaCrea;
    
    @Size(max = 10)
    @Column(name = "im_usuario_crea")
    @Getter
    @Setter
    private String imUsuarioCrea;
    
    @Column(name = "im_estado")
    @Getter
    @Setter
    private Character imEstado;
    
    @OneToMany(mappedBy = "imIdImpresora", fetch = FetchType.LAZY)
    @Getter
    @Setter
    private List<AsignacionTbl> asignacionTblList;
    
    @JoinColumn(name = "ti_id_tipo_manilla", referencedColumnName = "ti_id_tipo_manilla")
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    private TipoManillaTbl tiIdTipoManilla;

    public ImpresoraTbl() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imIdImpresora != null ? imIdImpresora.hashCode() : 0);
        return hash;
    }
}
