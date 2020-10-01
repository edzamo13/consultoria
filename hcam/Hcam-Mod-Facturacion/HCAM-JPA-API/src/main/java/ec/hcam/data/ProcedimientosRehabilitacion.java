/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.data;

import java.io.Serializable;

/**
 *
 * @author ezamora
 */
public class ProcedimientosRehabilitacion implements Serializable, Cloneable {

    private String UNIDAD_MEDICA;
    private Integer NUM_ORDEN;
    private Integer COD_SERVICIO;
    private String  HISTORIA;
    private Integer TIPO_SERVICIO;
    private Integer SUBTIPO_SERVICIO;
    private String ITEM_TARIFARIO;
    private String STS_VERIFICA;
    private Integer FE_CIT_RES;
    private Integer depe_solicita;
    private Integer medico_solicita;
    private Integer depe_realiza;
    private String DESCRIPCION;
    private Double VALOR;
    private String TipoRubro;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getUNIDAD_MEDICA() {
        return UNIDAD_MEDICA;
    }

    public void setUNIDAD_MEDICA(String UNIDAD_MEDICA) {
        this.UNIDAD_MEDICA = UNIDAD_MEDICA;
    }

    public Integer getNUM_ORDEN() {
        return NUM_ORDEN;
    }

    public void setNUM_ORDEN(Integer NUM_ORDEN) {
        this.NUM_ORDEN = NUM_ORDEN;
    }

    public Integer getCOD_SERVICIO() {
        return COD_SERVICIO;
    }

    public void setCOD_SERVICIO(Integer COD_SERVICIO) {
        this.COD_SERVICIO = COD_SERVICIO;
    }

    public String getHISTORIA() {
        return HISTORIA;
    }

    public void setHISTORIA(String HISTORIA) {
        this.HISTORIA = HISTORIA;
    }

    public Integer getTIPO_SERVICIO() {
        return TIPO_SERVICIO;
    }

    public void setTIPO_SERVICIO(Integer TIPO_SERVICIO) {
        this.TIPO_SERVICIO = TIPO_SERVICIO;
    }

    public Integer getSUBTIPO_SERVICIO() {
        return SUBTIPO_SERVICIO;
    }

    public void setSUBTIPO_SERVICIO(Integer SUBTIPO_SERVICIO) {
        this.SUBTIPO_SERVICIO = SUBTIPO_SERVICIO;
    }

    public String getITEM_TARIFARIO() {
        return ITEM_TARIFARIO;
    }

    public void setITEM_TARIFARIO(String ITEM_TARIFARIO) {
        this.ITEM_TARIFARIO = ITEM_TARIFARIO;
    }

    public String getSTS_VERIFICA() {
        return STS_VERIFICA;
    }

    public void setSTS_VERIFICA(String STS_VERIFICA) {
        this.STS_VERIFICA = STS_VERIFICA;
    }

    public Integer getFE_CIT_RES() {
        return FE_CIT_RES;
    }

    public void setFE_CIT_RES(Integer FE_CIT_RES) {
        this.FE_CIT_RES = FE_CIT_RES;
    }

    public Integer getDepe_solicita() {
        return depe_solicita;
    }

    public void setDepe_solicita(Integer depe_solicita) {
        this.depe_solicita = depe_solicita;
    }

    public Integer getMedico_solicita() {
        return medico_solicita;
    }

    public void setMedico_solicita(Integer medico_solicita) {
        this.medico_solicita = medico_solicita;
    }

    public Integer getDepe_realiza() {
        return depe_realiza;
    }

    public void setDepe_realiza(Integer depe_realiza) {
        this.depe_realiza = depe_realiza;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public Double getVALOR() {
        return VALOR;
    }

    public void setVALOR(Double VALOR) {
        this.VALOR = VALOR;
    }

    public String getTipoRubro() {
        return TipoRubro;
    }

    public void setTipoRubro(String TipoRubro) {
        this.TipoRubro = TipoRubro;
    }

}
