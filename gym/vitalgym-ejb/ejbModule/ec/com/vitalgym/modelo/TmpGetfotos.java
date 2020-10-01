

package ec.com.vitalgym.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *  <b>
 * Incluir aqui la descripción de la clase.
 * </b>
 *
 * @author ezamora
 * <p>[$Author:  ezamora  $, $Date: 14-ago-2017]</p>
 */
@Entity
@Table(name = "tmp_getfotos", catalog = "ec_singlepymes", schema = "vitalgym")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpGetfotos.findAll", query = "SELECT t FROM TmpGetfotos t")
    , @NamedQuery(name = "TmpGetfotos.findByFId", query = "SELECT t FROM TmpGetfotos t WHERE t.fId = :fId")
    , @NamedQuery(name = "TmpGetfotos.findByFCodigo", query = "SELECT t FROM TmpGetfotos t WHERE t.fCodigo = :fCodigo")})
public class TmpGetfotos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_id", nullable = false)
    private Integer fId;
    @Size(max = 200)
    @Column(name = "f_codigo", length = 200)
    private String fCodigo;
    @Lob
    @Column(name = "ft_archivo")
    private byte[] ftArchivo;

    public TmpGetfotos() {
    }

    public TmpGetfotos(Integer fId) {
        this.fId = fId;
    }

    public Integer getFId() {
        return fId;
    }

    public void setFId(Integer fId) {
        this.fId = fId;
    }

    public String getFCodigo() {
        return fCodigo;
    }

    public void setFCodigo(String fCodigo) {
        this.fCodigo = fCodigo;
    }

    public byte[] getFtArchivo() {
        return ftArchivo;
    }

    public void setFtArchivo(byte[] ftArchivo) {
        this.ftArchivo = ftArchivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fId != null ? fId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpGetfotos)) {
            return false;
        }
        TmpGetfotos other = (TmpGetfotos) object;
        if ((this.fId == null && other.fId != null) || (this.fId != null && !this.fId.equals(other.fId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.vitalgym.gestion.modelo.TmpGetfotos[ fId=" + fId + " ]";
    }

}
