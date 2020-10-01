package ec.gob.iessHcam.transformaciones;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transformacion {
	
	public static String formatoFecha(Date fecha, String formato){
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		return sdf.format(fecha);
	}
	
	public static Date fechaAs400ToDate(String valor){
		System.out.println(valor);
		if(valor!=null){
			if(valor.length()==8){
				try{
					String anio = (valor.substring(0, 4));
					String mes = (valor.substring(4, 6));
					String dia = (valor.substring(6, 8));
					String sfecha = anio + "-" + mes + "-" + dia;
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date fecha;
					try {
						fecha = sdf.parse(sfecha);
						return fecha;
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						return null;
					}
				}catch(Exception e){
					e.printStackTrace();
					return  null;
				}
				
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	
	
	
	
	
}
