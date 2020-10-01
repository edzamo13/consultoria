package ec.hcam.entities1;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the IRSI02 database table.
 * 
 */
@Entity
@NamedQuery(name="Irsi02.findAll", query="SELECT i FROM Irsi02 i")
public class Irsi02 implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal ir2cit;

	private BigDecimal ir2com;

	private BigDecimal ir2dac;

	private BigDecimal ir2daf;

	private BigDecimal ir2dat;

	private BigDecimal ir2dep;

	private BigDecimal ir2his;

	private BigDecimal ir2hop;

	private String ir2int;

	private String ir2ite;

	private BigDecimal ir2niv;

	private String ir2pra;

	private String ir2prc;

	private String ir2prf;

	private String ir2sfa;

	private String ir2sub;

	private BigDecimal ir2tic;

	private BigDecimal ir2tif;

	private BigDecimal ir2tim;

	private BigDecimal ir2unm;

	private String ir2usc;

	private String ir2usf;

	private String ir2usr;

	private String ir2wsc;

	private String ir2wst;

	public Irsi02() {
	}

	public BigDecimal getIr2cit() {
		return this.ir2cit;
	}

	public void setIr2cit(BigDecimal ir2cit) {
		this.ir2cit = ir2cit;
	}

	public BigDecimal getIr2com() {
		return this.ir2com;
	}

	public void setIr2com(BigDecimal ir2com) {
		this.ir2com = ir2com;
	}

	public BigDecimal getIr2dac() {
		return this.ir2dac;
	}

	public void setIr2dac(BigDecimal ir2dac) {
		this.ir2dac = ir2dac;
	}

	public BigDecimal getIr2daf() {
		return this.ir2daf;
	}

	public void setIr2daf(BigDecimal ir2daf) {
		this.ir2daf = ir2daf;
	}

	public BigDecimal getIr2dat() {
		return this.ir2dat;
	}

	public void setIr2dat(BigDecimal ir2dat) {
		this.ir2dat = ir2dat;
	}

	public BigDecimal getIr2dep() {
		return this.ir2dep;
	}

	public void setIr2dep(BigDecimal ir2dep) {
		this.ir2dep = ir2dep;
	}

	public BigDecimal getIr2his() {
		return this.ir2his;
	}

	public void setIr2his(BigDecimal ir2his) {
		this.ir2his = ir2his;
	}

	public BigDecimal getIr2hop() {
		return this.ir2hop;
	}

	public void setIr2hop(BigDecimal ir2hop) {
		this.ir2hop = ir2hop;
	}

	public String getIr2int() {
		return this.ir2int;
	}

	public void setIr2int(String ir2int) {
		this.ir2int = ir2int;
	}

	public String getIr2ite() {
		return this.ir2ite;
	}

	public void setIr2ite(String ir2ite) {
		this.ir2ite = ir2ite;
	}

	public BigDecimal getIr2niv() {
		return this.ir2niv;
	}

	public void setIr2niv(BigDecimal ir2niv) {
		this.ir2niv = ir2niv;
	}

	public String getIr2pra() {
		return this.ir2pra;
	}

	public void setIr2pra(String ir2pra) {
		this.ir2pra = ir2pra;
	}

	public String getIr2prc() {
		return this.ir2prc;
	}

	public void setIr2prc(String ir2prc) {
		this.ir2prc = ir2prc;
	}

	public String getIr2prf() {
		return this.ir2prf;
	}

	public void setIr2prf(String ir2prf) {
		this.ir2prf = ir2prf;
	}

	public String getIr2sfa() {
		return this.ir2sfa;
	}

	public void setIr2sfa(String ir2sfa) {
		this.ir2sfa = ir2sfa;
	}

	public String getIr2sub() {
		return this.ir2sub;
	}

	public void setIr2sub(String ir2sub) {
		this.ir2sub = ir2sub;
	}

	public BigDecimal getIr2tic() {
		return this.ir2tic;
	}

	public void setIr2tic(BigDecimal ir2tic) {
		this.ir2tic = ir2tic;
	}

	public BigDecimal getIr2tif() {
		return this.ir2tif;
	}

	public void setIr2tif(BigDecimal ir2tif) {
		this.ir2tif = ir2tif;
	}

	public BigDecimal getIr2tim() {
		return this.ir2tim;
	}

	public void setIr2tim(BigDecimal ir2tim) {
		this.ir2tim = ir2tim;
	}

	public BigDecimal getIr2unm() {
		return this.ir2unm;
	}

	public void setIr2unm(BigDecimal ir2unm) {
		this.ir2unm = ir2unm;
	}

	public String getIr2usc() {
		return this.ir2usc;
	}

	public void setIr2usc(String ir2usc) {
		this.ir2usc = ir2usc;
	}

	public String getIr2usf() {
		return this.ir2usf;
	}

	public void setIr2usf(String ir2usf) {
		this.ir2usf = ir2usf;
	}

	public String getIr2usr() {
		return this.ir2usr;
	}

	public void setIr2usr(String ir2usr) {
		this.ir2usr = ir2usr;
	}

	public String getIr2wsc() {
		return this.ir2wsc;
	}

	public void setIr2wsc(String ir2wsc) {
		this.ir2wsc = ir2wsc;
	}

	public String getIr2wst() {
		return this.ir2wst;
	}

	public void setIr2wst(String ir2wst) {
		this.ir2wst = ir2wst;
	}

}