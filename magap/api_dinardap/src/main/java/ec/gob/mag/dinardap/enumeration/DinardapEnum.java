package ec.gob.mag.dinardap.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DinardapEnum {
	ADDRESS("https://interoperabilidad.dinardap.gob.ec/interoperador-v2?wsdl",1),
	USUARIO("wsmagapint",2),
	PASSWORD("Uo)oj4/83x", 3);
	
	private String value;
	private int idCredencial;
	
	
	
	
	
}
