/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iessHcam.gestion.seguridad.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author HCAM
 */
@Entity
@Table(name = "ut_tipo_manilla_tbl", schema = "utilitario")
@NamedQueries({
    @NamedQuery(name = "TipoManillaTbl.OBTENER_TIPO_MANILLA", query = "SELECT t FROM TipoManillaTbl t")})
public class TipoManillaTbl implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public static final String OBTENER_TIPO_MANILLA = "TipoManillaTbl.OBTENER_TIPO_MANILLA";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ti_id_tipo_manilla")
    @Getter
    @Setter
    private Long tiIdTipoManilla;
    
    @Size(max = 20)
    @Column(name = "ti_tipo")
    @Getter
    @Setter
    private String tiTipo;
    
    @Size(max = 150)
    @Column(name = "ti_descripcion")
    @Getter
    @Setter
    private String tiDescripcion;
    
    @Column(name = "ti_estado")
    @Getter
    @Setter
    private Character tiEstado;
    
    @OneToMany(mappedBy = "tiIdTipoManilla", fetch = FetchType.LAZY)
    @Getter
    @Setter
    private List<ImpresoraTbl> impresoraTblList;

    public TipoManillaTbl() {
    }

    public TipoManillaTbl(Long tiIdTipoManilla) {
        this.tiIdTipoManilla = tiIdTipoManilla;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiIdTipoManilla != null ? tiIdTipoManilla.hashCode() : 0);
        return hash;
    }
}
