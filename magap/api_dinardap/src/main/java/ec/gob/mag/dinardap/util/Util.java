package ec.gob.mag.dinardap.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Util {

	
	/**
	 * @category Util 
	 * @param fecha nacimeinto en formato dd/MM/yyyy
	 * @return String calculo de fecha
	 * 
	 * **/
	public static String calcularEdad(String fechaNacimeinto) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(fechaNacimeinto, fmt);
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNac, ahora);
		String edad = "";
		//edad = periodo.getYears() + ":años  " + periodo.getMonths() + ":meses " + periodo.getDays() + ":dias";
		edad = String.valueOf(periodo.getYears());
		
		return edad;

	}

}
