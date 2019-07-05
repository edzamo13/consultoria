package ec.gob.setec.portal.web.ws.controller.oracle.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the CONSULTA_PERFILES database table.
 * 
 */

public class Detalle implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private String detalle;

	
	
	
	public Detalle() {
		super();
	}




	public Detalle(String detalle) {
		super();
		this.detalle = detalle;
	}
	
	
	
	

}