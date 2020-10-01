/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorgeluis
 */
@Entity
@Table(name = "TARIFAFTBL", catalog = "S101719R", schema = "FACWEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarifaftbl.findAll", query = "SELECT t FROM Tarifaftbl t"),
    @NamedQuery(name = "Tarifaftbl.findByTaidpk", query = "SELECT t FROM Tarifaftbl t WHERE t.taidpk = :taidpk"),
    @NamedQuery(name = "Tarifaftbl.findByTacodigo", query = "SELECT t FROM Tarifaftbl t WHERE t.tacodigo = :tacodigo"),
    @NamedQuery(name = "Tarifaftbl.findByTadescripc", query = "SELECT t FROM Tarifaftbl t WHERE t.tadescripc = :tadescripc"),
    @NamedQuery(name = "Tarifaftbl.findByTafechaini", query = "SELECT t FROM Tarifaftbl t WHERE t.tafechaini = :tafechaini"),
    @NamedQuery(name = "Tarifaftbl.findByTafechafin", query = "SELECT t FROM Tarifaftbl t WHERE t.tafechafin = :tafechafin"),
    @NamedQuery(name = "Tarifaftbl.findByTavalor", query = "SELECT t FROM Tarifaftbl t WHERE t.tavalor = :tavalor"),
    @NamedQuery(name = "Tarifaftbl.findByTauvr", query = "SELECT t FROM Tarifaftbl t WHERE t.tauvr = :tauvr"),
    @NamedQuery(name = "Tarifaftbl.findByTaobservac", query = "SELECT t FROM Tarifaftbl t WHERE t.taobservac = :taobservac"),
    @NamedQuery(name = "Tarifaftbl.findByTafcm", query = "SELECT t FROM Tarifaftbl t WHERE t.tafcm = :tafcm"),
    @NamedQuery(name = "Tarifaftbl.findByUvrAnes", query = "SELECT t FROM Tarifaftbl t WHERE t.uvrAnes = :uvrAnes"),
    @NamedQuery(name = "Tarifaftbl.findByFcmAnes", query = "SELECT t FROM Tarifaftbl t WHERE t.fcmAnes = :fcmAnes"),
    @NamedQuery(name = "Tarifaftbl.findByValorAnes", query = "SELECT t FROM Tarifaftbl t WHERE t.valorAnes = :valorAnes"),
    @NamedQuery(name = "Tarifaftbl.findByTatipo", query = "SELECT t FROM Tarifaftbl t WHERE t.tatipo = :tatipo"),
    @NamedQuery(name = "Tarifaftbl.findByTaestado", query = "SELECT t FROM Tarifaftbl t WHERE t.taestado = :taestado"),
    @NamedQuery(name = "Tarifaftbl.findByIncrementoCosta", query = "SELECT t FROM Tarifaftbl t WHERE t.incrementoCosta = :incrementoCosta"),
    @NamedQuery(name = "Tarifaftbl.findByIncrementoInsular", query = "SELECT t FROM Tarifaftbl t WHERE t.incrementoInsular = :incrementoInsular"),
    @NamedQuery(name = "Tarifaftbl.findByBilateral", query = "SELECT t FROM Tarifaftbl t WHERE t.bilateral = :bilateral"),
    @NamedQuery(name = "Tarifaftbl.findByModificador", query = "SELECT t FROM Tarifaftbl t WHERE t.modificador = :modificador"),
    @NamedQuery(name = "Tarifaftbl.findByTimeCiruini", query = "SELECT t FROM Tarifaftbl t WHERE t.timeCiruini = :timeCiruini"),
    @NamedQuery(name = "Tarifaftbl.findByTimeCirufin", query = "SELECT t FROM Tarifaftbl t WHERE t.timeCirufin = :timeCirufin")})
public class Tarifaftbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TAIDPK")
    private Integer taidpk;
    @Column(name = "TACODIGO")
    private String tacodigo;
    @Column(name = "TADESCRIPC")
    private String tadescripc;
    @Column(name = "TAFECHAINI")
    @Temporal(TemporalType.DATE)
    private Date tafechaini;
    @Column(name = "TAFECHAFIN")
    @Temporal(TemporalType.DATE)
    private Date tafechafin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TAVALOR")
    private Float tavalor;
    @Column(name = "TAUVR")
    private Float tauvr;
    @Column(name = "TAOBSERVAC")
    private String taobservac;
    @Basic(optional = false)
    @Column(name = "TAFCM")
    private float tafcm;
    @Column(name = "UVR_ANES")
    private Float uvrAnes;
    @Basic(optional = false)
    @Column(name = "FCM_ANES")
    private float fcmAnes;
    @Basic(optional = false)
    @Column(name = "VALOR_ANES")
    private float valorAnes;
    @Basic(optional = false)
    @Column(name = "TATIPO")
    private String tatipo;
    @Basic(optional = false)
    @Column(name = "TAESTADO")
    private String taestado;
    @Basic(optional = false)
    @Column(name = "INCREMENTO_COSTA")
    private String incrementoCosta;
    @Basic(optional = false)
    @Column(name = "INCREMENTO_INSULAR")
    private String incrementoInsular;
    @Basic(optional = false)
    @Column(name = "BILATERAL")
    private String bilateral;
    @Basic(optional = false)
    @Column(name = "MODIFICADOR")
    private String modificador;
    @Basic(optional = false)
    @Column(name = "TIME_CIRUINI")
    private int timeCiruini;
    @Basic(optional = false)
    @Column(name = "TIME_CIRUFIN")
    private int timeCirufin;
    @JoinColumn(name = "CTIDPK", referencedColumnName = "CTIDPK")
    @ManyToOne
    private Cabtaritbl ctidpk;

    public Tarifaftbl() {
    }

    public Tarifaftbl(Integer taidpk) {
        this.taidpk = taidpk;
    }

    public Tarifaftbl(Integer taidpk, float tafcm, float fcmAnes, float valorAnes, String tatipo, String taestado, String incrementoCosta, String incrementoInsular, String bilateral, String modificador, int timeCiruini, int timeCirufin) {
        this.taidpk = taidpk;
        this.tafcm = tafcm;
        this.fcmAnes = fcmAnes;
        this.valorAnes = valorAnes;
        this.tatipo = tatipo;
        this.taestado = taestado;
        this.incrementoCosta = incrementoCosta;
        this.incrementoInsular = incrementoInsular;
        this.bilateral = bilateral;
        this.modificador = modificador;
        this.timeCiruini = timeCiruini;
        this.timeCirufin = timeCirufin;
    }

    public Integer getTaidpk() {
        return taidpk;
    }

    public void setTaidpk(Integer taidpk) {
        this.taidpk = taidpk;
    }

    public String getTacodigo() {
        return tacodigo;
    }

    public void setTacodigo(String tacodigo) {
        this.tacodigo = tacodigo;
    }

    public String getTadescripc() {
        return tadescripc;
    }

    public void setTadescripc(String tadescripc) {
        this.tadescripc = tadescripc;
    }

    public Date getTafechaini() {
        return tafechaini;
    }

    public void setTafechaini(Date tafechaini) {
        this.tafechaini = tafechaini;
    }

    public Date getTafechafin() {
        return tafechafin;
    }

    public void setTafechafin(Date tafechafin) {
        this.tafechafin = tafechafin;
    }

    public Float getTavalor() {
        return tavalor;
    }

    public void setTavalor(Float tavalor) {
        this.tavalor = tavalor;
    }

    public Float getTauvr() {
        return tauvr;
    }

    public void setTauvr(Float tauvr) {
        this.tauvr = tauvr;
    }

    public String getTaobservac() {
        return taobservac;
    }

    public void setTaobservac(String taobservac) {
        this.taobservac = taobservac;
    }

    public float getTafcm() {
        return tafcm;
    }

    public void setTafcm(float tafcm) {
        this.tafcm = tafcm;
    }

    public Float getUvrAnes() {
        return uvrAnes;
    }

    public void setUvrAnes(Float uvrAnes) {
        this.uvrAnes = uvrAnes;
    }

    public float getFcmAnes() {
        return fcmAnes;
    }

    public void setFcmAnes(float fcmAnes) {
        this.fcmAnes = fcmAnes;
    }

    public float getValorAnes() {
        return valorAnes;
    }

    public void setValorAnes(float valorAnes) {
        this.valorAnes = valorAnes;
    }

    public String getTatipo() {
        return tatipo;
    }

    public void setTatipo(String tatipo) {
        this.tatipo = tatipo;
    }

    public String getTaestado() {
        return taestado;
    }

    public void setTaestado(String taestado) {
        this.taestado = taestado;
    }

    public String getIncrementoCosta() {
        return incrementoCosta;
    }

    public void setIncrementoCosta(String incrementoCosta) {
        this.incrementoCosta = incrementoCosta;
    }

    public String getIncrementoInsular() {
        return incrementoInsular;
    }

    public void setIncrementoInsular(String incrementoInsular) {
        this.incrementoInsular = incrementoInsular;
    }

    public String getBilateral() {
        return bilateral;
    }

    public void setBilateral(String bilateral) {
        this.bilateral = bilateral;
    }

    public String getModificador() {
        return modificador;
    }

    public void setModificador(String modificador) {
        this.modificador = modificador;
    }

    public int getTimeCiruini() {
        return timeCiruini;
    }

    public void setTimeCiruini(int timeCiruini) {
        this.timeCiruini = timeCiruini;
    }

    public int getTimeCirufin() {
        return timeCirufin;
    }

    public void setTimeCirufin(int timeCirufin) {
        this.timeCirufin = timeCirufin;
    }

    public Cabtaritbl getCtidpk() {
        return ctidpk;
    }

    public void setCtidpk(Cabtaritbl ctidpk) {
        this.ctidpk = ctidpk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taidpk != null ? taidpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarifaftbl)) {
            return false;
        }
        Tarifaftbl other = (Tarifaftbl) object;
        if ((this.taidpk == null && other.taidpk != null) || (this.taidpk != null && !this.taidpk.equals(other.taidpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entities.Tarifaftbl[ taidpk=" + taidpk + " ]";
    }
    
}
