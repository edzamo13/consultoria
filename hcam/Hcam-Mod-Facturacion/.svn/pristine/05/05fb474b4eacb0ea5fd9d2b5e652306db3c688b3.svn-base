/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "DETPLANTBL", catalog = "S101719R", schema = "FACWEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detplantbl.findAll", query = "SELECT d FROM Detplantbl d"),
    @NamedQuery(name = "Detplantbl.findByPlidpk", query = "SELECT d FROM Detplantbl d WHERE d.plidpk = :plidpk"),
    @NamedQuery(name = "Detplantbl.findByUnimpk", query = "SELECT d FROM Detplantbl d WHERE d.unimpk = :unimpk"),
    @NamedQuery(name = "Detplantbl.findByCpidpk", query = "SELECT d FROM Detplantbl d WHERE d.cpidpk = :cpidpk"),
    @NamedQuery(name = "Detplantbl.findByCtumidpk", query = "SELECT d FROM Detplantbl d WHERE d.ctumidpk = :ctumidpk"),
    @NamedQuery(name = "Detplantbl.findByReidpk", query = "SELECT d FROM Detplantbl d WHERE d.reidpk = :reidpk"),
    @NamedQuery(name = "Detplantbl.findByNumplad", query = "SELECT d FROM Detplantbl d WHERE d.numplad = :numplad"),
    @NamedQuery(name = "Detplantbl.findByCoditem", query = "SELECT d FROM Detplantbl d WHERE d.coditem = :coditem"),
    @NamedQuery(name = "Detplantbl.findByHistoCli", query = "SELECT d FROM Detplantbl d WHERE d.histoCli = :histoCli"),
    @NamedQuery(name = "Detplantbl.findByFechaReg", query = "SELECT d FROM Detplantbl d WHERE d.fechaReg = :fechaReg"),
    @NamedQuery(name = "Detplantbl.findByDescItem", query = "SELECT d FROM Detplantbl d WHERE d.descItem = :descItem"),
    @NamedQuery(name = "Detplantbl.findByDepRea", query = "SELECT d FROM Detplantbl d WHERE d.depRea = :depRea"),
    @NamedQuery(name = "Detplantbl.findByCoddepsol", query = "SELECT d FROM Detplantbl d WHERE d.coddepsol = :coddepsol"),
    @NamedQuery(name = "Detplantbl.findByCoddeprea", query = "SELECT d FROM Detplantbl d WHERE d.coddeprea = :coddeprea"),
    @NamedQuery(name = "Detplantbl.findByTipSer", query = "SELECT d FROM Detplantbl d WHERE d.tipSer = :tipSer"),
    @NamedQuery(name = "Detplantbl.findBySubtipser", query = "SELECT d FROM Detplantbl d WHERE d.subtipser = :subtipser"),
    @NamedQuery(name = "Detplantbl.findByCantidad", query = "SELECT d FROM Detplantbl d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Detplantbl.findByValorUnit", query = "SELECT d FROM Detplantbl d WHERE d.valorUnit = :valorUnit"),
    @NamedQuery(name = "Detplantbl.findByValorTotal", query = "SELECT d FROM Detplantbl d WHERE d.valorTotal = :valorTotal"),
    @NamedQuery(name = "Detplantbl.findByNumOrden", query = "SELECT d FROM Detplantbl d WHERE d.numOrden = :numOrden"),
    @NamedQuery(name = "Detplantbl.findByTipoRubro", query = "SELECT d FROM Detplantbl d WHERE d.tipoRubro = :tipoRubro"),
    @NamedQuery(name = "Detplantbl.findByCodMedico", query = "SELECT d FROM Detplantbl d WHERE d.codMedico = :codMedico"),
    @NamedQuery(name = "Detplantbl.findByNomMedico", query = "SELECT d FROM Detplantbl d WHERE d.nomMedico = :nomMedico"),
    @NamedQuery(name = "Detplantbl.findByDiagnostico1", query = "SELECT d FROM Detplantbl d WHERE d.diagnostico1 = :diagnostico1"),
    @NamedQuery(name = "Detplantbl.findByDiagnostico2", query = "SELECT d FROM Detplantbl d WHERE d.diagnostico2 = :diagnostico2"),
    @NamedQuery(name = "Detplantbl.findByDiagnostico3", query = "SELECT d FROM Detplantbl d WHERE d.diagnostico3 = :diagnostico3"),
    @NamedQuery(name = "Detplantbl.findByDiagnostico4", query = "SELECT d FROM Detplantbl d WHERE d.diagnostico4 = :diagnostico4"),
    @NamedQuery(name = "Detplantbl.findByDiagnostico5", query = "SELECT d FROM Detplantbl d WHERE d.diagnostico5 = :diagnostico5"),
    @NamedQuery(name = "Detplantbl.findByDiagnostico6", query = "SELECT d FROM Detplantbl d WHERE d.diagnostico6 = :diagnostico6"),
    @NamedQuery(name = "Detplantbl.findByTipoDiag1", query = "SELECT d FROM Detplantbl d WHERE d.tipoDiag1 = :tipoDiag1"),
    @NamedQuery(name = "Detplantbl.findByTipoDiag2", query = "SELECT d FROM Detplantbl d WHERE d.tipoDiag2 = :tipoDiag2"),
    @NamedQuery(name = "Detplantbl.findByTipoDiag3", query = "SELECT d FROM Detplantbl d WHERE d.tipoDiag3 = :tipoDiag3"),
    @NamedQuery(name = "Detplantbl.findByTipoDiag4", query = "SELECT d FROM Detplantbl d WHERE d.tipoDiag4 = :tipoDiag4"),
    @NamedQuery(name = "Detplantbl.findByTipoDiag5", query = "SELECT d FROM Detplantbl d WHERE d.tipoDiag5 = :tipoDiag5"),
    @NamedQuery(name = "Detplantbl.findByTipoDiag6", query = "SELECT d FROM Detplantbl d WHERE d.tipoDiag6 = :tipoDiag6"),
    @NamedQuery(name = "Detplantbl.findByTimeAntestesia", query = "SELECT d FROM Detplantbl d WHERE d.timeAntestesia = :timeAntestesia"),
    @NamedQuery(name = "Detplantbl.findByCodDerivacion", query = "SELECT d FROM Detplantbl d WHERE d.codDerivacion = :codDerivacion"),
    @NamedQuery(name = "Detplantbl.findBySecDerivacion", query = "SELECT d FROM Detplantbl d WHERE d.secDerivacion = :secDerivacion"),
    @NamedQuery(name = "Detplantbl.findByContingenCubre", query = "SELECT d FROM Detplantbl d WHERE d.contingenCubre = :contingenCubre"),
    @NamedQuery(name = "Detplantbl.findByNombreAfiliado", query = "SELECT d FROM Detplantbl d WHERE d.nombreAfiliado = :nombreAfiliado"),
    @NamedQuery(name = "Detplantbl.findByCedulaAfiliado", query = "SELECT d FROM Detplantbl d WHERE d.cedulaAfiliado = :cedulaAfiliado"),
    @NamedQuery(name = "Detplantbl.findByParentesco", query = "SELECT d FROM Detplantbl d WHERE d.parentesco = :parentesco"),
    @NamedQuery(name = "Detplantbl.findByCedulaBeneficia", query = "SELECT d FROM Detplantbl d WHERE d.cedulaBeneficia = :cedulaBeneficia"),
    @NamedQuery(name = "Detplantbl.findByNombreBeneficia", query = "SELECT d FROM Detplantbl d WHERE d.nombreBeneficia = :nombreBeneficia"),
    @NamedQuery(name = "Detplantbl.findByTipoBeneficia", query = "SELECT d FROM Detplantbl d WHERE d.tipoBeneficia = :tipoBeneficia"),
    @NamedQuery(name = "Detplantbl.findByFecNacBenef", query = "SELECT d FROM Detplantbl d WHERE d.fecNacBenef = :fecNacBenef"),
    @NamedQuery(name = "Detplantbl.findByEdadBenefic", query = "SELECT d FROM Detplantbl d WHERE d.edadBenefic = :edadBenefic"),
    @NamedQuery(name = "Detplantbl.findByGeneroBenef", query = "SELECT d FROM Detplantbl d WHERE d.generoBenef = :generoBenef"),
    @NamedQuery(name = "Detplantbl.findByDuracionAtencion", query = "SELECT d FROM Detplantbl d WHERE d.duracionAtencion = :duracionAtencion"),
    @NamedQuery(name = "Detplantbl.findByEstado", query = "SELECT d FROM Detplantbl d WHERE d.estado = :estado")})
public class Detplantbl implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)    
    @Column(name = "PLIDPK")
    private Integer plidpk;
    
    private static final long serialVersionUID = 1L;
    @Column(name = "UNIMPK")
    private Integer unimpk;   
    @Column(name = "CTUMIDPK")
    private Integer ctumidpk;
    @Column(name = "REIDPK")
    private Integer reidpk;
    @Column(name = "NUMPLAD")
    private Integer numplad;
    @Size(max = 16)
    @Column(name = "CODITEM")
    private String coditem;
    @Size(max = 13)
    @Column(name = "HISTO_CLI")
    private String histoCli;
    @Column(name = "FECHA_REG")
    @Temporal(TemporalType.DATE)
    private Date fechaReg;
    @Size(max = 1300)
    @Column(name = "DESC_ITEM")
    private String descItem;
    @Size(max = 80)
    @Column(name = "DEP_REA")
    private String depRea;
    @Column(name = "CODDEPSOL")
    private BigInteger coddepsol;
    @Column(name = "CODDEPREA")
    private BigInteger coddeprea;
    @Column(name = "TIP_SER")
    private Integer tipSer;
    @Column(name = "SUBTIPSER")
    private Integer subtipser;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR_UNIT")
    private Double valorUnit;
    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;
    @Column(name = "NUM_ORDEN")
    private Integer numOrden;
    @Size(max = 10)
    @Column(name = "TIPO_RUBRO")
    private String tipoRubro;
    @Column(name = "COD_MEDICO")
    private Integer codMedico;
    @Size(max = 40)
    @Column(name = "NOM_MEDICO")
    private String nomMedico;
    @Size(max = 6)
    @Column(name = "DIAGNOSTICO_1")
    private String diagnostico1;
    @Size(max = 6)
    @Column(name = "DIAGNOSTICO_2")
    private String diagnostico2;
    @Size(max = 6)
    @Column(name = "DIAGNOSTICO_3")
    private String diagnostico3;
    @Size(max = 6)
    @Column(name = "DIAGNOSTICO_4")
    private String diagnostico4;
    @Size(max = 6)
    @Column(name = "DIAGNOSTICO_5")
    private String diagnostico5;
    @Size(max = 6)
    @Column(name = "DIAGNOSTICO_6")
    private String diagnostico6;
    @Column(name = "TIPO_DIAG_1")
    private Character tipoDiag1;
    @Column(name = "TIPO_DIAG_2")
    private Character tipoDiag2;
    @Column(name = "TIPO_DIAG_3")
    private Character tipoDiag3;
    @Column(name = "TIPO_DIAG_4")
    private Character tipoDiag4;
    @Column(name = "TIPO_DIAG_5")
    private Character tipoDiag5;
    @Column(name = "TIPO_DIAG_6")
    private Character tipoDiag6;
    @Column(name = "TIME_ANTESTESIA")
    private Short timeAntestesia;
    @Size(max = 5)
    @Column(name = "COD_DERIVACION")
    private String codDerivacion;
    @Column(name = "SEC_DERIVACION")
    private Short secDerivacion;
    @Column(name = "CONTINGEN_CUBRE")
    private Integer contingenCubre;
    @Size(max = 40)
    @Column(name = "NOMBRE_AFILIADO")
    private String nombreAfiliado;
    @Size(max = 15)
    @Column(name = "CEDULA_AFILIADO")
    private String cedulaAfiliado;
    @Size(max = 5)
    @Column(name = "PARENTESCO")
    private String parentesco;
    @Size(max = 15)
    @Column(name = "CEDULA_BENEFICIA")
    private String cedulaBeneficia;
    @Size(max = 40)
    @Column(name = "NOMBRE_BENEFICIA")
    private String nombreBeneficia;
    @Size(max = 2)
    @Column(name = "TIPO_BENEFICIA")
    private String tipoBeneficia;
    @Column(name = "FEC_NAC_BENEF")
    @Temporal(TemporalType.DATE)
    private Date fecNacBenef;
    @Column(name = "EDAD_BENEFIC")
    private Integer edadBenefic;
    @Column(name = "GENERO_BENEF")
    private Character generoBenef;
    @Column(name = "DURACION_ATENCION")
    private Integer duracionAtencion;
    @Column(name = "ESTADO")
    private Character estado;    
    @JoinColumn(name = "CPIDPK", referencedColumnName = "CPIDPK")
    @ManyToOne
    private Cabplantbl cpidpk;

    public Detplantbl() {
    }   
    
    public Detplantbl(Integer plidpk) {
        this.plidpk = plidpk;
    }

    public Detplantbl(Integer plidpk, Integer unimpk, Integer ctumidpk, Integer reidpk, Integer numplad, String coditem, String histoCli, Date fechaReg, String descItem, String depRea, BigInteger coddepsol, BigInteger coddeprea, Integer tipSer, Integer subtipser, Integer cantidad, Double valorUnit, Double valorTotal, Integer numOrden, String tipoRubro, Integer codMedico, String nomMedico, String diagnostico1, String diagnostico2, String diagnostico3, String diagnostico4, String diagnostico5, String diagnostico6, Character tipoDiag1, Character tipoDiag2, Character tipoDiag3, Character tipoDiag4, Character tipoDiag5, Character tipoDiag6, Short timeAntestesia, String codDerivacion, Short secDerivacion, Integer contingenCubre, String nombreAfiliado, String cedulaAfiliado, String parentesco, String cedulaBeneficia, String nombreBeneficia, String tipoBeneficia, Date fecNacBenef, Integer edadBenefic, Character generoBenef, Integer duracionAtencion, Character estado) {
        this.plidpk = plidpk;
        this.unimpk = unimpk;
        this.ctumidpk = ctumidpk;
        this.reidpk = reidpk;
        this.numplad = numplad;
        this.coditem = coditem;
        this.histoCli = histoCli;
        this.fechaReg = fechaReg;
        this.descItem = descItem;
        this.depRea = depRea;
        this.coddepsol = coddepsol;
        this.coddeprea = coddeprea;
        this.tipSer = tipSer;
        this.subtipser = subtipser;
        this.cantidad = cantidad;
        this.valorUnit = valorUnit;
        this.valorTotal = valorTotal;
        this.numOrden = numOrden;
        this.tipoRubro = tipoRubro;
        this.codMedico = codMedico;
        this.nomMedico = nomMedico;
        this.diagnostico1 = diagnostico1;
        this.diagnostico2 = diagnostico2;
        this.diagnostico3 = diagnostico3;
        this.diagnostico4 = diagnostico4;
        this.diagnostico5 = diagnostico5;
        this.diagnostico6 = diagnostico6;
        this.tipoDiag1 = tipoDiag1;
        this.tipoDiag2 = tipoDiag2;
        this.tipoDiag3 = tipoDiag3;
        this.tipoDiag4 = tipoDiag4;
        this.tipoDiag5 = tipoDiag5;
        this.tipoDiag6 = tipoDiag6;
        this.timeAntestesia = timeAntestesia;
        this.codDerivacion = codDerivacion;
        this.secDerivacion = secDerivacion;
        this.contingenCubre = contingenCubre;
        this.nombreAfiliado = nombreAfiliado;
        this.cedulaAfiliado = cedulaAfiliado;
        this.parentesco = parentesco;
        this.cedulaBeneficia = cedulaBeneficia;
        this.nombreBeneficia = nombreBeneficia;
        this.tipoBeneficia = tipoBeneficia;
        this.fecNacBenef = fecNacBenef;
        this.edadBenefic = edadBenefic;
        this.generoBenef = generoBenef;
        this.duracionAtencion = duracionAtencion;
        this.estado = estado;
    }       

    public Integer getPlidpk() {
        return plidpk;
    }

    public void setPlidpk(Integer plidpk) {
        this.plidpk = plidpk;
    }

    public Integer getUnimpk() {
        return unimpk;
    }

    public void setUnimpk(Integer unimpk) {
        this.unimpk = unimpk;
    }

    public Integer getCtumidpk() {
        return ctumidpk;
    }

    public void setCtumidpk(Integer ctumidpk) {
        this.ctumidpk = ctumidpk;
    }

    public Integer getReidpk() {
        return reidpk;
    }

    public void setReidpk(Integer reidpk) {
        this.reidpk = reidpk;
    }

    public Integer getNumplad() {
        return numplad;
    }

    public void setNumplad(Integer numplad) {
        this.numplad = numplad;
    }

    public String getCoditem() {
        return coditem;
    }

    public void setCoditem(String coditem) {
        this.coditem = coditem;
    }

    public String getHistoCli() {
        return histoCli;
    }

    public void setHistoCli(String histoCli) {
        this.histoCli = histoCli;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public String getDescItem() {
        return descItem;
    }

    public void setDescItem(String descItem) {
        this.descItem = descItem;
    }

    public String getDepRea() {
        return depRea;
    }

    public void setDepRea(String depRea) {
        this.depRea = depRea;
    }

    public BigInteger getCoddepsol() {
        return coddepsol;
    }

    public void setCoddepsol(BigInteger coddepsol) {
        this.coddepsol = coddepsol;
    }

    public BigInteger getCoddeprea() {
        return coddeprea;
    }

    public void setCoddeprea(BigInteger coddeprea) {
        this.coddeprea = coddeprea;
    }

    public Integer getTipSer() {
        return tipSer;
    }

    public void setTipSer(Integer tipSer) {
        this.tipSer = tipSer;
    }

    public Integer getSubtipser() {
        return subtipser;
    }

    public void setSubtipser(Integer subtipser) {
        this.subtipser = subtipser;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(Double valorUnit) {
        this.valorUnit = valorUnit;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(Integer numOrden) {
        this.numOrden = numOrden;
    }

    public String getTipoRubro() {
        return tipoRubro;
    }

    public void setTipoRubro(String tipoRubro) {
        this.tipoRubro = tipoRubro;
    }

    public Integer getCodMedico() {
        return codMedico;
    }

    public void setCodMedico(Integer codMedico) {
        this.codMedico = codMedico;
    }

    public String getNomMedico() {
        return nomMedico;
    }

    public void setNomMedico(String nomMedico) {
        this.nomMedico = nomMedico;
    }

    public String getDiagnostico1() {
        return diagnostico1;
    }

    public void setDiagnostico1(String diagnostico1) {
        this.diagnostico1 = diagnostico1;
    }

    public String getDiagnostico2() {
        return diagnostico2;
    }

    public void setDiagnostico2(String diagnostico2) {
        this.diagnostico2 = diagnostico2;
    }

    public String getDiagnostico3() {
        return diagnostico3;
    }

    public void setDiagnostico3(String diagnostico3) {
        this.diagnostico3 = diagnostico3;
    }

    public String getDiagnostico4() {
        return diagnostico4;
    }

    public void setDiagnostico4(String diagnostico4) {
        this.diagnostico4 = diagnostico4;
    }

    public String getDiagnostico5() {
        return diagnostico5;
    }

    public void setDiagnostico5(String diagnostico5) {
        this.diagnostico5 = diagnostico5;
    }

    public String getDiagnostico6() {
        return diagnostico6;
    }

    public void setDiagnostico6(String diagnostico6) {
        this.diagnostico6 = diagnostico6;
    }

    public Character getTipoDiag1() {
        return tipoDiag1;
    }

    public void setTipoDiag1(Character tipoDiag1) {
        this.tipoDiag1 = tipoDiag1;
    }

    public Character getTipoDiag2() {
        return tipoDiag2;
    }

    public void setTipoDiag2(Character tipoDiag2) {
        this.tipoDiag2 = tipoDiag2;
    }

    public Character getTipoDiag3() {
        return tipoDiag3;
    }

    public void setTipoDiag3(Character tipoDiag3) {
        this.tipoDiag3 = tipoDiag3;
    }

    public Character getTipoDiag4() {
        return tipoDiag4;
    }

    public void setTipoDiag4(Character tipoDiag4) {
        this.tipoDiag4 = tipoDiag4;
    }

    public Character getTipoDiag5() {
        return tipoDiag5;
    }

    public void setTipoDiag5(Character tipoDiag5) {
        this.tipoDiag5 = tipoDiag5;
    }

    public Character getTipoDiag6() {
        return tipoDiag6;
    }

    public void setTipoDiag6(Character tipoDiag6) {
        this.tipoDiag6 = tipoDiag6;
    }

    public Short getTimeAntestesia() {
        return timeAntestesia;
    }

    public void setTimeAntestesia(Short timeAntestesia) {
        this.timeAntestesia = timeAntestesia;
    }

    public String getCodDerivacion() {
        return codDerivacion;
    }

    public void setCodDerivacion(String codDerivacion) {
        this.codDerivacion = codDerivacion;
    }

    public Short getSecDerivacion() {
        return secDerivacion;
    }

    public void setSecDerivacion(Short secDerivacion) {
        this.secDerivacion = secDerivacion;
    }

    public Integer getContingenCubre() {
        return contingenCubre;
    }

    public void setContingenCubre(Integer contingenCubre) {
        this.contingenCubre = contingenCubre;
    }

    public String getNombreAfiliado() {
        return nombreAfiliado;
    }

    public void setNombreAfiliado(String nombreAfiliado) {
        this.nombreAfiliado = nombreAfiliado;
    }

    public String getCedulaAfiliado() {
        return cedulaAfiliado;
    }

    public void setCedulaAfiliado(String cedulaAfiliado) {
        this.cedulaAfiliado = cedulaAfiliado;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getCedulaBeneficia() {
        return cedulaBeneficia;
    }

    public void setCedulaBeneficia(String cedulaBeneficia) {
        this.cedulaBeneficia = cedulaBeneficia;
    }

    public String getNombreBeneficia() {
        return nombreBeneficia;
    }

    public void setNombreBeneficia(String nombreBeneficia) {
        this.nombreBeneficia = nombreBeneficia;
    }

    public String getTipoBeneficia() {
        return tipoBeneficia;
    }

    public void setTipoBeneficia(String tipoBeneficia) {
        this.tipoBeneficia = tipoBeneficia;
    }

    public Date getFecNacBenef() {
        return fecNacBenef;
    }

    public void setFecNacBenef(Date fecNacBenef) {
        this.fecNacBenef = fecNacBenef;
    }

    public Integer getEdadBenefic() {
        return edadBenefic;
    }

    public void setEdadBenefic(Integer edadBenefic) {
        this.edadBenefic = edadBenefic;
    }

    public Character getGeneroBenef() {
        return generoBenef;
    }

    public void setGeneroBenef(Character generoBenef) {
        this.generoBenef = generoBenef;
    }

    public Integer getDuracionAtencion() {
        return duracionAtencion;
    }

    public void setDuracionAtencion(Integer duracionAtencion) {
        this.duracionAtencion = duracionAtencion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Cabplantbl getCpidpk() {
        return cpidpk;
    }

    public void setCpidpk(Cabplantbl cpidpk) {
        this.cpidpk = cpidpk;
    }   
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plidpk != null ? plidpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detplantbl)) {
            return false;
        }
        Detplantbl other = (Detplantbl) object;
        if ((this.plidpk == null && other.plidpk != null) || (this.plidpk != null && !this.plidpk.equals(other.plidpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entity.Detplantbl[ plidpk=" + plidpk + " ]";
    }
    
}
