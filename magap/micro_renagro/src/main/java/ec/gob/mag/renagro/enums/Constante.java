package ec.gob.mag.renagro.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Constante {
	
	ESTADO_ACTIVO(1,"Activo"),
	ESTADO_PASIVO(0,"Pasivo"),
	ESTADO_COMPLETA(1831,"Completa"),
	ESTADO_INCOMPLETA(1830,"Incompleta"),
	ESTADO_CODIGOCERRADO(1829,"CODIGO CERRADO");
	 
	private Integer codigo;
	private String detalle;
	

	
}
