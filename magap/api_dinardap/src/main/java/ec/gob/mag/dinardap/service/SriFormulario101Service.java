package ec.gob.mag.dinardap.service;

import java.util.ArrayList;
import java.util.List;

import ec.gob.dinardap.interoperador.v2.wsdl.Columna;
import ec.gob.dinardap.interoperador.v2.wsdl.ConsultarFaultException;
import ec.gob.dinardap.interoperador.v2.wsdl.Entidad;
import ec.gob.dinardap.interoperador.v2.wsdl.Fila;
import ec.gob.dinardap.interoperador.v2.wsdl.Filas;
import ec.gob.mag.dinardap.dto.SriFormulario101Campos;
import ec.gob.mag.dinardap.dto.SriFormulario101DTO;
import ec.gob.mag.dinardap.enumeration.DinardapTipoPeticionEnum;
import ec.gob.mag.dinardap.interoperador.v2.ServicioDinardap;

public class SriFormulario101Service {

	private static final String DATOS = "Formulario 101 (SRI)";

	public static SriFormulario101DTO obtenerDatos(DinardapTipoPeticionEnum param, String dato)
			throws ConsultarFaultException {

		SriFormulario101DTO formulario101dto = new SriFormulario101DTO();
		formulario101dto.setSriFormulario101Campos(new ArrayList<SriFormulario101Campos>());

		List<Entidad> entidades = ServicioDinardap.getDatosDINARDAP(param.getTipoPaquete(), param.getCodigoPaquete(),
				param.getTipoIdentificacion(), dato);

		for (Entidad entidad : entidades) {
			if (entidad.getNombre().equals(DATOS)) {
				formulario101dto.setNombreEntidad(DATOS);
				formulario101dto.setSriFormulario101Campos(obtenerDatos(entidad.getFilas()));
			}
		}
		return formulario101dto;
	}

	private static List<SriFormulario101Campos> obtenerDatos(Filas filas) {
		SriFormulario101Campos formulario101Campos = new SriFormulario101Campos();
		List<SriFormulario101Campos> listFormulario101Campos = new ArrayList<SriFormulario101Campos>();
		for (Fila f : filas.getFila()) {
			for (Columna c : f.getColumnas().getColumna()) {

				if (c.getCampo().trim().equals("anioFiscal"))
					formulario101Campos.setAnioFiscal(c.getValor());

				if (c.getCampo().trim().equals("impuestoRentaPagar3680"))
					formulario101Campos.setImpuestoRentaPagar3680(c.getValor());

				if (c.getCampo().trim().equals("perdida3570"))
					formulario101Campos.setPerdida3570(c.getValor());
				
				if (c.getCampo().trim().equals("perdidaEjercicio3430"))
					formulario101Campos.setPerdidaEjercicio3430(c.getValor());
				
				if (c.getCampo().trim().equals("razonSocial"))
					formulario101Campos.setRazonSocial(c.getValor());
				
				if (c.getCampo().trim().equals("totActivoNoCorriente1077"))
					formulario101Campos.setTotActivoNoCorriente1077(c.getValor());
				
				if (c.getCampo().trim().equals("totalActivo1080"))
					formulario101Campos.setTotalActivo1080(c.getValor());
				
				if (c.getCampo().trim().equals("totalActivoCorriente470"))
					formulario101Campos.setTotalActivoCorriente470(c.getValor());
				
				if (c.getCampo().trim().equals("totalActivoCorriente470"))
					formulario101Campos.setTotalActivoCorriente470(c.getValor());
				
				if (c.getCampo().trim().equals("totalActivosDiferidos780"))
					formulario101Campos.setTotalActivosDiferidos780(c.getValor());
				
				if (c.getCampo().trim().equals("totalActivosFijos690"))
					formulario101Campos.setTotalActivosFijos690(c.getValor());
				
				if (c.getCampo().trim().equals("totalCostos3360"))
					formulario101Campos.setTotalCostos3360(c.getValor());
				
				if (c.getCampo().trim().equals("totalGastos3370"))
					formulario101Campos.setTotalGastos3370(c.getValor());
				
				if (c.getCampo().trim().equals("totalIngresos1930"))
					formulario101Campos.setTotalIngresos1930(c.getValor());
				
				if (c.getCampo().trim().equals("totalPasivoPatrimonio1790"))
					formulario101Campos.setTotalPasivoPatrimonio1790(c.getValor());
			
				if (c.getCampo().trim().equals("totalPasivos1620"))
					formulario101Campos.setTotalPasivos1620(c.getValor());
				
				if (c.getCampo().trim().equals("totalPatrimonioNeto1780"))
					formulario101Campos.setTotalPatrimonioNeto1780(c.getValor());
				
				if (c.getCampo().trim().equals("totasCostosGastos3380"))
					formulario101Campos.setTotasCostosGastos3380(c.getValor());
				
				if (c.getCampo().trim().equals("utiReinvertirCpz3580"))
					formulario101Campos.setUtiReinvertirCpz3580(c.getValor());
				
				if (c.getCampo().trim().equals("utilidadEjercicio3420"))
					formulario101Campos.setUtilidadEjercicio3420(c.getValor());
				
				if (c.getCampo().trim().equals("utilidadGravable3560"))
					formulario101Campos.setUtilidadGravable3560(c.getValor());
				
			}
			listFormulario101Campos.add(formulario101Campos);
			formulario101Campos = new SriFormulario101Campos();

		}
		return listFormulario101Campos;
	}

}
