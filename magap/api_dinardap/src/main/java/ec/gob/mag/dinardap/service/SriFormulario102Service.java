package ec.gob.mag.dinardap.service;

import java.util.ArrayList;
import java.util.List;

import ec.gob.dinardap.interoperador.v2.wsdl.Columna;
import ec.gob.dinardap.interoperador.v2.wsdl.ConsultarFaultException;
import ec.gob.dinardap.interoperador.v2.wsdl.Entidad;
import ec.gob.dinardap.interoperador.v2.wsdl.Fila;
import ec.gob.dinardap.interoperador.v2.wsdl.Filas;
import ec.gob.mag.dinardap.dto.SriFormulario102Campos;
import ec.gob.mag.dinardap.dto.SriFormulario102DTO;
import ec.gob.mag.dinardap.enumeration.DinardapTipoPeticionEnum;
import ec.gob.mag.dinardap.interoperador.v2.ServicioDinardap;

public class SriFormulario102Service {

	private static final String DATOS = "Formulario 102 (SRI)";

	public static SriFormulario102DTO obtenerDatos(DinardapTipoPeticionEnum param, String dato)
			throws ConsultarFaultException {

		SriFormulario102DTO formulario102DTO = new SriFormulario102DTO();
		formulario102DTO.setSriFormulario102Campos(new ArrayList<SriFormulario102Campos>());

		List<Entidad> entidades = ServicioDinardap.getDatosDINARDAP(param.getTipoPaquete(), param.getCodigoPaquete(),
				param.getTipoIdentificacion(), dato);

		for (Entidad entidad : entidades) {
			if (entidad.getNombre().equals(DATOS)) {
				formulario102DTO.setNombreEntidad(DATOS);
				formulario102DTO.setSriFormulario102Campos(obtenerDatos(entidad.getFilas()));
			}
		}
		return formulario102DTO;
	}

	private static List<SriFormulario102Campos> obtenerDatos(Filas filas) {
		SriFormulario102Campos formulario102Campos = new SriFormulario102Campos();
		List<SriFormulario102Campos> listFormulario102Campos = new ArrayList<SriFormulario102Campos>();
		for (Fila f : filas.getFila()) {
			for (Columna c : f.getColumnas().getColumna()) {

				if (c.getCampo().trim().equals("anioFiscal"))
					formulario102Campos.setAnioFiscal(c.getValor());

				if (c.getCampo().trim().equals("perdida2980"))
					formulario102Campos.setPerdida2980(c.getValor());

				if (c.getCampo().trim().equals("perdidaEjercicio2810"))
					formulario102Campos.setPerdidaEjercicio2810(c.getValor());
				
				if (c.getCampo().trim().equals("razonSocial"))
					formulario102Campos.setRazonSocial(c.getValor());
				
				if (c.getCampo().trim().equals("totActCorriente410"))
					formulario102Campos.setTotActCorriente410(c.getValor());
				
				if (c.getCampo().trim().equals("totActivoNoCorriente812"))
					formulario102Campos.setTotActivoNoCorriente812(c.getValor());
				
				if (c.getCampo().trim().equals("totPasivoPatrimonio1340"))
					formulario102Campos.setTotPasivoPatrimonio1340(c.getValor());
				
				if (c.getCampo().trim().equals("totPatrimonioNeto1330"))
					formulario102Campos.setTotPatrimonioNeto1330(c.getValor());
				
				if (c.getCampo().trim().equals("totalActivo830"))
					formulario102Campos.setTotalActivo830(c.getValor());
				
				if (c.getCampo().trim().equals("totalActivoFijo560"))
					formulario102Campos.setTotalActivoFijo560(c.getValor());
				
				if (c.getCampo().trim().equals("totalCostos2660"))
					formulario102Campos.setTotalCostos2660(c.getValor());
				
				if (c.getCampo().trim().equals("totalCostosGastos2760"))
					formulario102Campos.setTotalCostosGastos2760(c.getValor());
				
				if (c.getCampo().trim().equals("totalGastos2750"))
					formulario102Campos.setTotalGastos2750(c.getValor());
				
				if (c.getCampo().trim().equals("totalImpuestoPagar3570"))
					formulario102Campos.setTotalImpuestoPagar3570(c.getValor());
				
				if (c.getCampo().trim().equals("totalIngresos1440"))
					formulario102Campos.setTotalIngresos1440(c.getValor());
				
				if (c.getCampo().trim().equals("totalPasivo1310"))
					formulario102Campos.setTotalPasivo1310(c.getValor());
				
				if (c.getCampo().trim().equals("utilidadGravable2970"))
					formulario102Campos.setUtilidadGravable2970(c.getValor());
				
				if (c.getCampo().trim().equals("utilidadNetaEjercicio2800"))
					formulario102Campos.setUtilidadNetaEjercicio2800(c.getValor());
							
				
			}
			listFormulario102Campos.add(formulario102Campos);
			formulario102Campos = new SriFormulario102Campos();

		}
		return listFormulario102Campos;
	}

}
